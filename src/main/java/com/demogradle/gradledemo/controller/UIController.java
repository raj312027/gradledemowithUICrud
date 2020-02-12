package com.demogradle.gradledemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demogradle.gradledemo.ui.beans.UserInfo;

@Controller
public class UIController {

	@Autowired
	private Environment env;
	@GetMapping("/")
	public ModelAndView welcomeMsg(Model model) {

		return new ModelAndView("home", "userinfo", new UserInfo());
	}

	@PostMapping("/createUserInfo")
	public ModelAndView createUser(@ModelAttribute("userinfo") UserInfo user, Model model) {
		System.out.println(user);
		model.addAttribute("msg", env.getProperty("msg001"));
		return new ModelAndView("home", "userinfo", user);
	}

}
