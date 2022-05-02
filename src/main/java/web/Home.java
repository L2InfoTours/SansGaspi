package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import data.User;
import metier.SecurityService;
import metier.UserService;
import metier.UserValidator;

@Controller 
public class Home {
	/*
	@Autowired
    private UserService userService;
	@Autowired
    private SecurityService securityService;
	@Autowired
    private UserValidator userValidator;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registration(Model mdl) {
		mdl.addAttribute("userForm", new User());return "registration";
    }
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model mdl) {
		userValidator.validate(userForm, bindingResult);if (bindingResult.hasErrors()) {
            return "registration";
        }
		userService.save(userForm);
		securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/welcome";
    }
    */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model mdl,String error, String logout) {
		if (error != null)
            mdl.addAttribute("error", "Your username and password is invalid.");
		if (logout != null)
            mdl.addAttribute("message", "You have been logged out successfully.");
		return "login.html";
	}
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	  public String submit(Model model, @ModelAttribute("loginBean") User loginBean) {
	    if (loginBean != null && loginBean.getUsername() != null & loginBean.getPassword() != null) {
	      if (loginBean.getUsername().equals("chandra") && loginBean.getPassword().equals("chandra123")) {
	        model.addAttribute("msg", loginBean.getUsername());
	        return "success";
	      } else {
	        model.addAttribute("error", "Invalid Details");
	        return "login.html";
	      }
	    } else {
	      model.addAttribute("error", "Please enter Details");
	      return "login.html";
	    }
	  }
	@RequestMapping("/")
	public String index() {
		return "index.html";
	}
}
