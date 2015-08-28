package com.gft.grad.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String getLogin(Model model) {
		return "login";
	}

}
