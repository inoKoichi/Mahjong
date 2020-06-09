package com.app.marjan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.marjan.entity.Teams;
import com.app.marjan.form.TeamsForm;
import com.app.marjan.service.TeamsService;

@Controller
public class TeamsListController {

	@Autowired
	public TeamsService groupService;

	@RequestMapping(value="/", method = RequestMethod.GET)
//	@RequestMapping(value="/a", method = RequestMethod.GET)
	public String main(Model model) {
		// グループリストを取得
		List<Teams> teamsInfo = groupService.findAll();
		model.addAttribute("teamsInfo", teamsInfo);
		TeamsForm teamsForm = new TeamsForm();
		model.addAttribute("teamsForm", teamsForm);
//		model.addAttribute("groupId", teamsInfo.get(0).groupId);
		return "teamsList";
	}
}