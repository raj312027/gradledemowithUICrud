package com.demogradle.gradledemo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@ModelAttribute
	public void setCountry(Model model) {
		List<String> countryList = new ArrayList<>();
		countryList.add("India");
		countryList.add("NZ");
		countryList.add("South Africa");
		countryList.add("England");
		model.addAttribute("countryList", countryList);
	}

	@PostMapping("/createUserInfo")
	public ModelAndView createUser(@Valid @ModelAttribute("userinfo") UserInfo user, BindingResult br, Model model) {
		if (!br.hasErrors())
			model.addAttribute("msg", env.getProperty("msg_er"));
		return new ModelAndView("home", "userinfo", user);
	}

	@GetMapping("/getList/{sel}")
	public ResponseEntity<List<String>> getListOfModels(@PathVariable("sel") String s) {

		Map<String, List<String>> map = new HashMap<>();
		List<String> stateList = new ArrayList<>();
		stateList.add("MP");
		stateList.add("MH");
		stateList.add("DL");
		stateList.add("GJ");
		stateList.add("RJ");
		map.put("India", stateList);

		return ResponseEntity.ok().body(map.get(s));

		// return stateList;
	}

}
