package com.app.marjan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.marjan.entity.Teams;
import com.app.marjan.service.TeamsService;

@Controller
public class TeamsRegistInputController {

	@Autowired
	public TeamsService groupService;

	@RequestMapping("/teamsRegistInput" )
	public String main(Model model) {
		// グループリストを取得
		List<Teams> teamsInfo = groupService.findAll();
		model.addAttribute("teamsInfo", teamsInfo);
		return "teamsRegistInput";
	}

}