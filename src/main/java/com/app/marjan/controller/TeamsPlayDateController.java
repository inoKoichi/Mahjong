package com.app.marjan.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.marjan.entity.TeamsPlayDate;
import com.app.marjan.form.TeamsForm;
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
//		List<TeamsPlayDate> groupPlayDateList = groupPlayDateService.findByGroupId(groupId);
		List<TeamsPlayDate> groupPlayDateList = getTestDataTeamsPlayDateInfo(groupId);

		// データが登録できない場合、空の情報を返す
		if (groupPlayDateList == null || groupPlayDateList.size() == 0) {
			List<TeamsPlayDate> emptyGroupPlayDateList = new ArrayList<TeamsPlayDate>();
			emptyGroupPlayDateList.add(new TeamsPlayDate());
			return "teamsPlayData";
		} else {
			// データが取得できた場合、設定する
			model.addAttribute("teamsInfo", groupPlayDateList);
			TeamsForm teamsForm = new TeamsForm();
			model.addAttribute("teamsForm", teamsForm);
			model.addAttribute("groupId", groupPlayDateList.get(0).groupId);
		}
		model.addAttribute("groupPlayDateList", groupPlayDateList);

		return "teamsPlayData";
	}

	/**
	 * dummy Data
	 *  チーム実施日の情報を取得
	 */
	private List<TeamsPlayDate> getTestDataTeamsPlayDateInfo(String groupId) {
		List<TeamsPlayDate> teamlist = new ArrayList<TeamsPlayDate>();
		if (groupId.equals("001")) {
			teamlist.add(createTestTeamPlayDateInfo("001","2020/12/01"));
			teamlist.add(createTestTeamPlayDateInfo("001","2020/12/02"));
			teamlist.add(createTestTeamPlayDateInfo("001","2020/12/03"));
			teamlist.add(createTestTeamPlayDateInfo("001","2020/12/04"));
			teamlist.add(createTestTeamPlayDateInfo("001","2020/12/21"));
			teamlist.add(createTestTeamPlayDateInfo("001","2020/12/31"));
			teamlist.add(createTestTeamPlayDateInfo("001","2021/01/04"));
		} else if (groupId.equals("002")) {
			teamlist.add(createTestTeamPlayDateInfo("002","2020/12/01"));
			teamlist.add(createTestTeamPlayDateInfo("002","2020/12/02"));
			teamlist.add(createTestTeamPlayDateInfo("002","2020/12/03"));
			teamlist.add(createTestTeamPlayDateInfo("002","2020/12/04"));
			teamlist.add(createTestTeamPlayDateInfo("002","2020/12/21"));
			teamlist.add(createTestTeamPlayDateInfo("002","2020/12/31"));
			teamlist.add(createTestTeamPlayDateInfo("002","2021/01/04"));
		} else if (groupId.equals("003")) {
			teamlist.add(createTestTeamPlayDateInfo("003","2020/12/01"));
			teamlist.add(createTestTeamPlayDateInfo("003","2020/12/02"));
			teamlist.add(createTestTeamPlayDateInfo("003","2020/12/03"));
			teamlist.add(createTestTeamPlayDateInfo("003","2020/12/04"));
			teamlist.add(createTestTeamPlayDateInfo("003","2020/12/21"));
			teamlist.add(createTestTeamPlayDateInfo("003","2020/12/31"));
			teamlist.add(createTestTeamPlayDateInfo("003","2021/01/04"));
		}

		return teamlist;
	}

	/**
	 * dummy data
	 * チームの実施日を取得
	 */
	private TeamsPlayDate createTestTeamPlayDateInfo(String groupId, String playDate) {
		TeamsPlayDate teamsPlayDate = new TeamsPlayDate();
		teamsPlayDate.groupId = groupId;
		teamsPlayDate. playDate = playDate;
		teamsPlayDate.registrationDate = new Date();

		return teamsPlayDate;
	}
}