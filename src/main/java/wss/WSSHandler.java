package wss;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WSSHandler extends TextWebSocketHandler {
	List<WebSocketSession> webSocketSessions = Collections.synchronizedList(new ArrayList());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        webSocketSessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        webSocketSessions.remove(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        super.handleMessage(session, message);
        String msg = message.getPayload().toString();
        for (WebSocketSession webSocketSession : webSocketSessions) {
            webSocketSession.sendMessage(message);
        }
    }
    public void send(String content) throws IOException {
    	WebSocketMessage<?> message = new TextMessage(content);
    	for (WebSocketSession webSocketSession : webSocketSessions) {
            webSocketSession.sendMessage(message);
        }
    }
    public void update(String attribute,Object value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	String str_value = "{";
    	Class<?> clazz = value.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(WSValue.class)) {
                method.setAccessible(true);
                WSValue wsv = method.getAnnotation(WSValue.class);
                String key = wsv.key();
                if(key == null)
                	key = method.getName();
                str_value += "\""+key+"\":"+method.invoke(null)+",";
            }
        }
    
    	str_value += "}";
    	String msg = "{\"attribute\":"+attribute+",\"value:\""+str_value+"}";
    	try {
			send(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    private static WSSHandler I;
    public static WSSHandler instance() {
    	if(I==null) {
    		I = new WSSHandler();
    	}
    	return I;
    }
}
