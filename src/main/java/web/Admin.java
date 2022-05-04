package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class Admin {
	@RequestMapping(value = "/invite", method = RequestMethod.GET)
	public String invite() {
		return "index.html";
	}
	@RequestMapping(value = "/adherant", method = RequestMethod.GET)
	public String adherant() {
		return "index.html";
	}
	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	public String stats() {
		return "index.html";
	}
	@RequestMapping(value = "/database", method = RequestMethod.GET)
	public String database() {
		return "index.html";
	}
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard() {
		return "index.html";
	}

}