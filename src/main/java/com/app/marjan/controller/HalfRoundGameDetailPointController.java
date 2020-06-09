package com.app.marjan.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.marjan.entity.PlayerResultPoint;
import com.app.marjan.entity.User;
import com.app.marjan.form.PlayerResultPointForm;
import com.app.marjan.service.PlayerResultPointService;
import com.app.marjan.service.UserService;

@Controller
public class HalfRoundGameDetailPointController {

	@Autowired
	public PlayerResultPointService playerResultPointService;
	@Autowired
	public UserService userService;

	/** 定数値 */
	// レート
	private static Integer tipRate = 50;
	// 返し点
	private static int backPoint = 30000;
	// 1位レート
	private static Integer rankPoint1 = 20;
	// 2位レート
	private static Integer rankPoint2 = 10;
	// 3位レート
	private static Integer rankPoint3 = -10;
	// 4位レート
	private static Integer rankPoint4 = -20;


	/**
	 * 点数登録の入力画面
	 * @param model モデル
	 * @param groupId グループID
	 * @param playDate プレイ日
	 * @return
	 */
	@RequestMapping("/halfRoundGameDetailPointInput" )
	public String playerResultPointInput(Model model
										, @ModelAttribute("groupId") String groupId
										, @ModelAttribute("playDate") String playDate) {
		model.addAttribute("pointForm", new PlayerResultPointForm());
		model.addAttribute("groupId", groupId);
		model.addAttribute("playDate", playDate);

		return "halfRoundGameDetailPoint";
	}

	/**
	 * 半荘の結果を新規登録
	 * @param model モデル
	 * @param pointForm form情報
	 * @param groupId グループID
	 * @param playDate プレイ日
	 * @return
	 */
	@RequestMapping("/createPointInpitDisp")
    public String createPointInpitDisp(Model model
							    	, @ModelAttribute("pointForm") PlayerResultPointForm pointForm
							    	, @ModelAttribute("groupId") String groupId
							    	, @ModelAttribute("playDate") String playDate) {

		// プレイヤー1を登録
		PlayerResultPoint playerResultPoint1 = setPointResult(pointForm, groupId, playDate, pointForm.point1, pointForm.userId1, pointForm.seatWind1);
		playerResultPointService.save(playerResultPoint1);

		// プレイヤー2を登録
		PlayerResultPoint playerResultPoint2 = setPointResult(pointForm, groupId, playDate, pointForm.point2, pointForm.userId2, pointForm.seatWind2);
		playerResultPointService.save(playerResultPoint2);

		// プレイヤー3を登録
		PlayerResultPoint playerResultPoint3 = setPointResult(pointForm, groupId, playDate, pointForm.point3, pointForm.userId3, pointForm.seatWind3);
		playerResultPointService.save(playerResultPoint3);

		// プレイヤー4を登録
		PlayerResultPoint playerResultPoint4 = setPointResult(pointForm, groupId, playDate, pointForm.point4, pointForm.userId4, pointForm.seatWind4);
		playerResultPointService.save(playerResultPoint4);

		model.addAttribute("groupId", groupId);
		model.addAttribute("playDate", playDate);

        return "harfRoundGameKyokuList";
    }

	/**
	 * fromに詰め込まれたパラメータをEntityにセットする
	 * @param pointForm form情報
	 * @param groupId グループID
	 * @param playDate プレイ日
	 * @param point 得点
	 * @param userId ユーザーID
	 * @param seatWind 自風
	 * @return
	 */
	public PlayerResultPoint setPointResult(PlayerResultPointForm pointForm
											, String groupId
											, String playDate
											, int point
											, String userId
											, String seatWind) {

    	PlayerResultPoint playerResultPoint = new PlayerResultPoint();

    	// 共通情報
    	playerResultPoint.groupId = groupId;
    	playerResultPoint.no = getNo();
    	playerResultPoint.hanso = getHanso(playerResultPoint.no);

    	// プレイヤー情報
    	playerResultPoint.seatWind = seatWind;
    	playerResultPoint.userId = userId;
    	playerResultPoint.userName = this.getUserName(userId);

    	// 得点と金額
    	playerResultPoint.rank = getRank(pointForm, point);
    	playerResultPoint.point = point;
    	playerResultPoint.score = getScore(playerResultPoint.point, playerResultPoint.rank);
    	playerResultPoint.tipMoney = tipRate;
    	playerResultPoint.money = point/1000*tipRate;

    	// 役満
    	// TODO 役満の扱いについて考える
//    	playerResultPoint.yakumanFlag = pointForm.yakumanFlag1;
    	playerResultPoint.yakumanFlag = null;

    	// プレイ日付
    	playerResultPoint.playDate = playDate;

    	// 飛び賞
    	// TODO とび賞の扱いについて考える
//    	playerResultPoint.hakoFlag = 0;
//    	playerResultPoint.hakoFromPlayer = "narimasu";
    	playerResultPoint.hakoFlag = 0;
    	playerResultPoint.hakoFromPlayer = null;

    	// 定常処理
    	playerResultPoint.registrationDate = new Date();
    	playerResultPoint.updateDate = new Date();
    	playerResultPoint.deleteDate = null;
    	playerResultPoint.deleteFlag = 0;

    	return playerResultPoint;
    }

	/**
	 * ユーザー名を取得する
	 * @param pointForm form情報
	 * @param point 得点
	 * @return
	 */
	private String getUserName(String userId) {
		User user =userService.findByUserId(userId);
		return user.getUserName();
	}

	/**
	 * 登録済みのデータ数からインクリメント数を取得
	 * @return 番号
	 */
	private Integer getNo() {
		return playerResultPointService.findAll().size();
	}

	/**
	 * 登録済みのデータ数から半荘数を取得
	 * @param no 番号
	 * @return 半荘数
	 */
	private Integer getHanso(Integer no) {
		return no/4;
	}

	/**
	 * スコアを取得
	 * @param point 得点
	 * @param rank 順位
	 * @return スコア
	 */
	private Integer getScore(Integer point, Integer rank) {
		int scorePoint = 0;
		switch (rank) {
			case 1:
				scorePoint = rankPoint1;
				break;
			case 2:
				scorePoint = rankPoint2;
				break;
			case 3:
				scorePoint = rankPoint3;
				break;
			case 4:
				scorePoint = rankPoint4;
				break;
		}
		return (point - backPoint) / 1000 + scorePoint;
	}

	/**
	 * 順位情報を取得する
	 * @param pointForm form情報
	 * @param point 得点
	 * @return 順位
	 */
	private int getRank(PlayerResultPointForm pointForm, int point) {
		// 処理
		int rank = 1;
		int result[] = { pointForm.point1, pointForm.point2, pointForm.point3, pointForm.point4 };

		// ランク付け計算
		for(int i=0; i<result.length;i++) {
			// ponitよりも点数が高い場合、順位を1つ下げる
			if(point > result[i]) {
				rank++;
			}
		}
		return rank;
	}
}