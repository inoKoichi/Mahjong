package com.app.marjan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.marjan.common.CommonUtility;
import com.app.marjan.entity.User;
import com.app.marjan.service.TeamsService;
import com.app.marjan.service.UserService;

@Controller
public class PlayRuleSettingController {

	@Autowired
	public TeamsService groupService;
	@Autowired
	public UserService userService;

	@RequestMapping(value="/playRuleSetting", method = RequestMethod.GET)
	public String main(Model model, @ModelAttribute("groupId") String groupId) {
        List<User> userList = userService.findAll();
        // プレイヤー情報を設定
        model.addAttribute("groupId", groupId);
        // プレイヤー情報を設定
        model.addAttribute("userList", userList);
        // プレイ日付の取得
        model.addAttribute("playDate", CommonUtility.getCurrentDate());

		return "mobile/playRuleSetting";
	}
}