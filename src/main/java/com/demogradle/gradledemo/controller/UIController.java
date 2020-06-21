package com.demogradle.gradledemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
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
import org.springframework.web.servlet.ModelAndView;

import com.demogradle.gradledemo.GradledemoApplication;
import com.demogradle.gradledemo.customer.repo.PicRepo;
import com.demogradle.gradledemo.customer.service.ConstantValue;
import com.demogradle.gradledemo.customer.service.SecurityUserService;
import com.demogradle.gradledemo.model.SecurityUser;
import com.demogradle.gradledemo.ui.beans.UserInfo;

@Controller
public class UIController {

	private static Logger log=Logger.getLogger(GradledemoApplication.class);
	@Autowired
	private Environment env;

	@Autowired
	private SecurityUserService secService;
	@Autowired
	private ConstantValue nsql;


	@GetMapping("/")
	public ModelAndView welcomeMsg(Model model) {
		log.info("-----------------------------------Home page loaded");
		return new ModelAndView("home", "userinfo", new UserInfo());
	}

	@ModelAttribute
	public void setCountry(Model model) {
		List<String> countryList = new ArrayList<>();
		countryList.add("Select country");
		countryList.add("India");
		countryList.add("NZ");
		countryList.add("South Africa");
		countryList.add("England");
		model.addAttribute("countryList", countryList);
	}

	@PostMapping("/createUserInfo")
	public ModelAndView createUser(@Valid @ModelAttribute("userinfo") UserInfo user, BindingResult br, Model model) {
		if (br.hasErrors())
			model.addAttribute("msg", env.getProperty("msg_er"));

		SecurityUser su = new SecurityUser();
		su.setUserId(user.getUserid());
		su.setCust(user.getUserid());
		su.setPswd(user.getPassword());

		if (secService.createUser(su)) {
			model.addAttribute("msg", env.getProperty("msg001"));
		}
		model.addAttribute("stateList", nsql.getStateList(env.getProperty(user.getCountry().toLowerCase())));
		model.addAttribute("cityList", nsql.getCityList(env.getProperty(user.getState().toLowerCase())));
		return new ModelAndView("home", "userinfo", user);

	}

	@GetMapping("/getList/{sel}")
	public ResponseEntity<List<String>> getListOfModels(@PathVariable("sel") String s) {

		List<String> stateList = new ArrayList<>();
		if (s != null) {
			String[] stArr = s.split(" ");
			if (stArr.length > 1) {
				s = "";
				for (String str : stArr) {
					s += str;
				}
			}
		}
		stateList = nsql.getStateList(env.getProperty(s.toLowerCase()));
		return ResponseEntity.ok().body(stateList);
	}

	@GetMapping("getCityList/{selectedState}")
	public ResponseEntity<List<String>> getCities(@PathVariable("selectedState") String selectedState) {
		List<String> cityList = new ArrayList<>();
		cityList = nsql.getCityList(env.getProperty(selectedState.toLowerCase()));
		return ResponseEntity.ok().body(cityList);
	}
	
	
	

}
