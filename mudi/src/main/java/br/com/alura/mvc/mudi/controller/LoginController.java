package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/login")
public class LoginController {
	
	//@GetMapping
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	//@GetMapping
	//@RequestMapping(value = "/logout", method=RequestMethod.POST)
//	@RequestMapping("/logout")
//	public String logout() {
//		return "login";
//	}

}
