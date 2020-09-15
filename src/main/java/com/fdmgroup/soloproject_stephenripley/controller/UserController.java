package com.fdmgroup.soloproject_stephenripley.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.soloproject_stephenripley.model.User;
import com.fdmgroup.soloproject_stephenripley.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("BuyBasket")
	public ModelAndView buyBasket(@ModelAttribute("id") Long user_id, ModelMap model, HttpSession session) {
		User user = userService.findById(user_id);
		userService.buyBasket(user);
		if (user.getBasket().isEmpty()) {
			User userPurchase = (User) session.getAttribute("USER");
			return new ModelAndView("WEB-INF/purchased.jsp", "user", userPurchase);
		}
		model.addAttribute("errorMessage", "One or more items is out of stock");
		return new ModelAndView("WEB-INF/basket.jsp", "user", user);
	}

	@GetMapping("Return")
	public ModelAndView returnToBasket(HttpSession session, ModelMap model) {
		User user = (User) session.getAttribute("USER");
		Long userId = user.getUser_id();
		user = userService.findById(userId);
		return new ModelAndView("WEB-INF/basket.jsp", "user", user);
	}
}
