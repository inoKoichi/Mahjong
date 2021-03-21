package com.app.marjan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.marjan.dto.ParticipantHeaderInfoDto;
import com.app.marjan.dto.PlayerPlayResultDto;
import com.app.marjan.entity.PlayerResultPoint;
import com.app.marjan.entity.TeamsPlayDate;
import com.app.marjan.entity.User;
import com.app.marjan.service.PlayerResultPointService;
import com.app.marjan.service.TeamsPlayDateService;
import com.app.marjan.service.TeamsService;
import com.app.marjan.service.UserService;

/**
 * 半荘の情報を取得する
 * @author inokoichi
 *
 */
@Controller
public class HarfRoundGameTotalController {

	@Autowired
	public UserService userService;
	@Autowired
	public TeamsService groupService;
	@Autowired
	public TeamsPlayDateService groupPlayDateService;
	@Autowired
	public PlayerResultPointService playerResultPointService;

	@RequestMapping("/harfRoundGameKyokuList")
	public String harfRoundGameKyokuList(
							 @ModelAttribute("groupId") String groupId,
							 @ModelAttribute("playDate") String playDate,
							 Model model) {

		// modelに設定
		model.addAttribute("groupId", "test");
		model.addAttribute("playDate", playDate);

		// user情報を取得
		List<User> userList = userService.findAll();
		// user情報が無かったらExceptionを発生
		if (userList == null || userList.size() == 0) {
			// エラー画面に遷移
		}
		model.addAttribute("userList", userList);

		// グループ実施日を取得
		TeamsPlayDate groupPlayDate = groupPlayDateService.findByGroupIdAndPlayDate(groupId, playDate);
		// groupPlayDate情報が無かったらExceptionを発生
		if (groupPlayDate == null) {
			// エラー画面に遷移
		}

		// グループ実施日のゲーム情報を取得
		List<PlayerResultPoint>  pointList = playerResultPointService.findByGroupIdAndPlayDate(groupId, groupPlayDate.playDate);

		// 画面情報を設定
		List<ParticipantHeaderInfoDto> participantHeaderInfoList = getParticipantHeaderInfoList(pointList, userList);
//		Map<Integer, List> pointMap = sortUserList(pointList);
//		model.addAttribute("pointMap", pointMap);

		// 点数レコードを取得できない場合パラメータは設定しない
		if(!pointList.isEmpty()) {
//			model.addAttribute("participantHeaderInfoList", participantHeaderInfoList);
//			model.addAttribute("pointList", pointList);
//			model.addAttribute("testPoint", setPlayerPlayResultDto(pointList.get(0)));
		}

		return "harfRoundGameTotal";
	}

	/**
	 * 参加者情報を取得
	 * 金額と得点の合計も取得
	 * @param pointList
	 * @param userList
	 * @return
	 */
	public List<ParticipantHeaderInfoDto> getParticipantHeaderInfoList(List<PlayerResultPoint> pointList, List<User> userList) {
		List<ParticipantHeaderInfoDto> participantHeaderInfoList = new ArrayList<ParticipantHeaderInfoDto>();
		int count = 1;
		for (User user : userList) {
			// 参加者1人分の情報を格納
			ParticipantHeaderInfoDto dto = new ParticipantHeaderInfoDto();
			dto.userId = user.userId;
			dto.userName = user.userName;
			// 半荘目
			dto.hanso = count;
			for(PlayerResultPoint point : pointList) {
				// 金額と得点を保持
				if(user.userId.equals(point.userId)) {
					// 金額
					dto.totalManey = dto.totalManey + point.money;
					// 得点
					dto.totalPoint = dto.totalPoint + point.point;
				}
			}
			count++;
			participantHeaderInfoList.add(dto);
		}
		return participantHeaderInfoList;
	}

	/**
	 *  User情報を昇順にsortする
	 * @param userList
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map<Integer, List> sortUserList(List<PlayerResultPoint> playerResultPointList) {
		Map<String, PlayerResultPoint> playerResultPointMap = new TreeMap<String, PlayerResultPoint>();
		// 4人分ぴったりのデータ出ない場合エラー
		if(playerResultPointList.size()%4 != 0) {
			System.out.println("エラー発生：半荘のデータに不備があります。");
		}

		// 登録されている半荘数を取得
		int hansuCount = playerResultPointList.size()/4;

		Map<Integer, List> pointList= new TreeMap<Integer, List>();
		for (int i = 1; i <= hansuCount; i++) {
			//
			List<PlayerResultPoint> resultList = new ArrayList<PlayerResultPoint>();
			for (PlayerResultPoint list:playerResultPointList) {
				if(i == list.hanso) {
					resultList.add(list);
				}
			}
			// 取得したデータをソート
			pointList.put(i, sortPoint(resultList));
		}
		return pointList;
	}

	/**
	 * 得点で表示されたユーザー通りにソートする
	 * @param resultListBefore
	 * @return
	 */
	public List<PlayerPlayResultDto> sortPoint(List<PlayerResultPoint> resultListBefore){

		List<PlayerPlayResultDto> resultListAfter = new ArrayList<PlayerPlayResultDto>();
		List<User> userList = userService.findAll();
		// 取得したユーザー情報
		for(User user: userList) {
			for(PlayerResultPoint playerResultPoint: resultListBefore) {
				if(user.userId.equals(playerResultPoint.userId)) {
					resultListAfter.add(setPlayerPlayResultDto(playerResultPoint));
				}
			}
		}
		return resultListAfter;
	}

	/**
	 * PlayerResultPointのentity情報をsetする
	 * @param point
	 * @return
	 */
	private PlayerPlayResultDto setPlayerPlayResultDto(PlayerResultPoint point) {
		PlayerPlayResultDto dto = new PlayerPlayResultDto();
		dto.rank = point.rank;
		dto.score = point.score;
		dto.point = point.point;
		dto.userId = point.userId;
		dto.playDate = point.playDate;
		dto.seatWind = point.seatWind;
		dto.hakoFromPlayer = point.hakoFromPlayer;
		dto.yakumanFlag = point.yakumanFlag;
		return dto;
	}

}