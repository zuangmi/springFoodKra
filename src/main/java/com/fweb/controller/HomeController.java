package com.fweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController  {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value ={"/" , "index"}, method = RequestMethod.GET)
	public String home() throws Exception{
	
		return "index";
	}
	
}
