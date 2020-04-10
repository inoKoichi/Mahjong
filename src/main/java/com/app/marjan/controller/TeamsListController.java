package com.app.marjan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeamsListController {
	@RequestMapping("/" )
	public String helloWorld(Model model) {
//		model.addAttribute("message", "こんにちは世界");
		return "teamsList";
	}
}