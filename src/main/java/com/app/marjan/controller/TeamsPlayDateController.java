package com.app.marjan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.marjan.entity.TeamsPlayDate;
import com.app.marjan.service.TeamsPlayDateService;

@Controller
public class TeamsPlayDateController {

	@Autowired
	public TeamsPlayDateService groupPlayDateService;

	/**
	 *
	 * @param groupId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/playdatelist", method = RequestMethod.POST)
	public String playdatelist(@ModelAttribute("groupId") String groupId, Model model) {
		// グループ実施日を取得
		List<TeamsPlayDate> groupPlayDateList = groupPlayDateService.findByGroupId(groupId);
		model.addAttribute("groupPlayDateList", groupPlayDateList);

		return "teamsPlayData";
	}

}