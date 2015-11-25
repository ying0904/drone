package com.gome.cloud.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gome.cloud.service.TestService;

@Controller
public class TestController {

	@Resource
	private TestService testService;

	@RequestMapping(value="/indexx", method=RequestMethod.GET)
	public ModelAndView index () {
		testService.test();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
}
