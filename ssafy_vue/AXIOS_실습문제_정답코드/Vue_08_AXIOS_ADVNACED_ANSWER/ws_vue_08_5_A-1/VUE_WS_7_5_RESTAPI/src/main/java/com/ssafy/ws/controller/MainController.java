package com.ssafy.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@RequestMapping(value = "/form", method=RequestMethod.GET )
	public String form() {
		return "write";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.GET )
	public String login() {
		return "login";
	}
}