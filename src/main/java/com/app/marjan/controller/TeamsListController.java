package com.app.marjan.controller;

import java.util.ArrayList;
import java.util.Date;
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

	// ****************************
	// test Data
	Teams team1 ;
	Teams team2 ;
	Teams team3 ;
	Teams team4 ;
	Teams team5 ;
	// ****************************

	@RequestMapping(value="/", method = RequestMethod.GET)
//	@RequestMapping(value="/a", method = RequestMethod.GET)
	public String main(Model model) {
	// グループリストを取得
//		List<Teams> teamsInfo = groupService.findAll();
		List<Teams> teamsInfo = getTestDataTeamsInfo();
		// データが登録できない場合、空の情報を返す
		if (teamsInfo == null || teamsInfo.size() == 0) {
			List<Teams> emptyTeamlist = new ArrayList<Teams>();
			emptyTeamlist.add(new Teams());
			return "teamsList";
		} else {
			// データが取得できた場合、設定する
			model.addAttribute("teamsInfo", teamsInfo);
			TeamsForm teamsForm = new TeamsForm();
			model.addAttribute("teamsForm", teamsForm);
			model.addAttribute("groupId", teamsInfo.get(0).groupId);
		}

		return "teamsList";
	}

	/**
	 * dummy Data
	 *  チーム一覧の情報を取得
	 */
	private List<Teams> getTestDataTeamsInfo() {
		List<Teams> teamlist = new ArrayList<Teams>();
		teamlist.add(createTestTeamInfo("001","narimasu"));
		teamlist.add(createTestTeamInfo("002","dcp1"));
		teamlist.add(createTestTeamInfo("003","dcp2"));

		return teamlist;
	}

	/**
	 * dummy data
	 * チームの情報を取得
	 */
	private Teams createTestTeamInfo(String groupId, String groupName) {
		Teams team = new Teams();
		team.groupId = groupId;
		team.groupName = groupName;
		team.registrationDate = new Date();

		return team;
	}
}