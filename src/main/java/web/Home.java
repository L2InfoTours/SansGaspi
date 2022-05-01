package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import data.User;

@Controller 
public class Home {
	@RequestMapping("/login")
	public String login(Model mdl,User user) {
		return "index.html";
	}
}
