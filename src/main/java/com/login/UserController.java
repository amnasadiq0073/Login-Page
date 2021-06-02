package com.login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.login.models.User;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class UserController {
	@RequestMapping("/")
	public String display()
	{
		return "login";
	}	
	
	@GetMapping("/")
	public String displayLogin(Model model) {
		User us= new User();
		model.addAttribute("user",us);
		return "loginuccess";		
	}
	
}
