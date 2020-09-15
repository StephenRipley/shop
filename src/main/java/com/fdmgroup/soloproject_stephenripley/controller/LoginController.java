package com.fdmgroup.soloproject_stephenripley.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.soloproject_stephenripley.model.User;
import com.fdmgroup.soloproject_stephenripley.service.UserService;

@Controller
public class LoginController {
	
	public final static String SESSION_ATTRIBUTE_USER = "USER";

	@Autowired
	UserService userService;

	@GetMapping("")
	public String home() {
		return "home.jsp";
	}
	
	@GetMapping("Logout")
	public String logout() {
		return "home.jsp";
	}

	@GetMapping("basket")
	public String basket() {
		return "basket.jsp";
	}

	@PostMapping("LoginSubmit")
	public ModelAndView loginSubmit(@ModelAttribute("userid") User userid, ModelMap model, HttpSession session) {
		User user = userService.findById(userid.getUser_id());
		if (user == null) {
			model.addAttribute("errorMessage", "Incorrect user id");
			return new ModelAndView("home.jsp");
		}
		session.setAttribute(SESSION_ATTRIBUTE_USER, user);
		userService.calculateTotal(user);
		ModelAndView modelAndView = new ModelAndView("WEB-INF/basket.jsp","user", user);
		return modelAndView;
		

	}
	
	
}
