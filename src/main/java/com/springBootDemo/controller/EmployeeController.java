package com.springBootDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springBootDemo.dao.EmployeeDao;
import com.springBootDemo.model.Employee;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDao eDao;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/logincheck")
	public String input() {
		return "input";
	}
	
	@RequestMapping(value = "/saveUser",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Employee user) {
		eDao.save(user);
		ModelAndView modview= new ModelAndView();
		modview.setViewName("user_info");
		modview.addObject("user", user);
		return modview;
	}
	/*
	@RequestMapping(value = "/logincheck",method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute Employee user) {
		ModelAndView modview= new ModelAndView();
		modview.setViewName("user_info");
		modview.addObject("User", user);
		return modview;
	}*/
	
}
