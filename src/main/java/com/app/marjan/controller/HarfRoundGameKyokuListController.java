package com.app.marjan.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import com.app.marjan.common.CommonUtility;
import com.app.marjan.constant.CommonConstant;
import com.app.marjan.dto.ParticipantHeaderInfoDto;
import com.app.marjan.dto.PlayRuleSettingDto;
import com.app.marjan.dto.PlayUserDto;
import com.app.marjan.dto.PlayerPlayResultDto;
import com.app.marjan.entity.PlayUser;
import com.app.marjan.entity.PlayerResultPoint;
import com.app.marjan.entity.TeamsPlayDate;
import com.app.marjan.entity.User;
import com.app.marjan.form.PlayRuleSettingForm;
import com.app.marjan.service.PlayRuleSettingService;
import com.app.marjan.service.PlayUserService;
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
public class HarfRoundGameKyokuListController {

	/** Serviceクラスの定義 */
	@Autowired
	public UserService userService;
	@Autowired
	public TeamsService groupService;
	@Autowired
	public TeamsPlayDateService teamsPlayDateService;
	@Autowired
	public PlayUserService playUSerService;
	@Autowired
 	public PlayerResultPointService playerResultPointService;
	@Autowired
	public PlayRuleSettingService playRuleSettingService;

	/** 変数定義 */
	List<PlayerResultPoint>  pointList;
	TeamsPlayDate teamsPlayDate ;

	@SuppressWarnings("rawtypes")
	@RequestMapping("/harfRoundGameTotal")
	public String harfRoundGameKyokuList(Model model,
										 @ModelAttribute("playRuleSettingForm") PlayRuleSettingForm playRuleSettingForm,
										 @ModelAttribute("groupId") String groupId,
										 @ModelAttribute("playDate") String playDate) {

		// 遷移元画面の判定
		boolean dispFlag = StringUtils.isEmpty(playDate)? true : false;
		// 新規半荘を開始
		if (dispFlag) {
			// dtoに設定
			PlayRuleSettingDto playRuleSettingDto = this.setPlayRuleSettingDto(playRuleSettingForm, groupId, playDate);
			// playDateを新規登録
			teamsPlayDateService.save(playRuleSettingDto);
			// PlayUserを新規登録
			PlayUserDto playUserDto = this.setPlayUserList(playRuleSettingForm, playRuleSettingDto);
			playUSerService.save(playUserDto);
			// playRuleSettingを新規登録
			// 各種パラメーターの値を初期化
			playRuleSettingService.save(playRuleSettingDto);

		} else {
			// 既に開催された半荘情報を取得
		}


		// user情報を取得
		List<User> userList = userService.findAll();

		// user情報が無かったらExceptionを発生
		if (userList == null || userList.size() == 0) {
			// エラー画面に遷移
		}
		model.addAttribute("userList", userList);

		// グループ実施日を取得
		if (StringUtils.isEmpty(playDate)) {
			teamsPlayDate = teamsPlayDateService.findByGroupIdAndPlayDate(groupId, playDate);
			// groupPlayDate情報が無かったらExceptionを発生
			if (teamsPlayDate == null) {
				// エラー画面に遷移
			}
			// グループ実施日のゲーム情報を取得
//			pointList = playerResultPointService.findByGroupIdAndPlayDate(groupId, groupPlayDate.playDate);
		} else {
			pointList = playerResultPointService.findByGroupIdAndPlayDate(groupId, playDate);
		}

		// 各半荘の合計を取得
		List<PlayerPlayResultDto> playerPlayResultList = getTotalScoreList(pointList, userList);

		// 全半荘の詳細情報を取得
		Map<Integer, List> hantyanTotalResultMap = getHantyanTotalResult(pointList);
		model.addAttribute("hantyanTotalResultMap", hantyanTotalResultMap);

		// 画面情報を設定
		Map<Integer, List> pointMap = sortUserList(pointList);
		model.addAttribute("pointMap", pointMap);

		// 点数レコードを取得できない場合パラメータは設定しない
		if(!pointList.isEmpty()) {
			model.addAttribute("playerPlayResultList", playerPlayResultList);
			model.addAttribute("playerPlayResultList", playerPlayResultList);
			model.addAttribute("hantyanTotalResultMap", hantyanTotalResultMap);
		}

		return "mobile/harfRoundGameKyokuList";
	}

	/**
	 *  各半荘の合計を取得する
	 * @param pointList 各半荘情報
	 * @param userList 半荘参加者情報
	 * @return
	 */
	private List<PlayerPlayResultDto> getTotalScoreList(List<PlayerResultPoint> pointList, List<User> userList) {

		List<PlayerPlayResultDto> playerPlayResultDtoList = new ArrayList<PlayerPlayResultDto>();
		List<User> userList2  = new ArrayList<User>();
		List<String> userIdListTmp = new ArrayList<String>();

		//***********************************************************************************
		// 参加者情報の取得方法は後で変更する start
		//***********************************************************************************

		// 参加者情報を取得
		for (PlayerResultPoint playerResultPoint : pointList) {
			userIdListTmp.add(playerResultPoint.userId);
		}
		List<String> userIdList = userIdListTmp.stream().distinct().collect(Collectors.toList());

		for (User user : userList) {
			for (String userId :userIdList) {
				if (userId.equals(user.userId)) {
					User userTmp = new User();
					userTmp.userId = user.userId;
					userTmp.userName = user.userName;
					userList2.add(userTmp);
				}
			}
		}
		//***********************************************************************************
		// 参加者情報の取得方法は後で変更する end
		//***********************************************************************************

		// 各半荘の合計を設定する
		for (User user : userList2) {
			// 各半荘の合計情報
			PlayerPlayResultDto playerResultPointDto = new PlayerPlayResultDto();
			// 各半荘の合計を参加者毎に集計
			for (PlayerResultPoint playerResultPoint : pointList) {
				if (user.userId.equals(playerResultPoint.userId)) {
					playerResultPointDto.point = playerResultPointDto.point + playerResultPoint.point;  // ポイント
					playerResultPointDto.money = playerResultPointDto.money +  playerResultPoint.money;  // 金額
				}
			}
			playerResultPointDto.userName = user.userName;
			playerPlayResultDtoList.add(playerResultPointDto);
		}
		// 順位を設定
		setTotalRank(playerPlayResultDtoList);

		return playerPlayResultDtoList;

	}

	/**
	 *  各半荘の合計点数を元に順位を設定
	 * @param playerPlayResultDtoList
	 */
	private void setTotalRank(List<PlayerPlayResultDto> playerPlayResultDtoList) {
		for (PlayerPlayResultDto resutlDto : playerPlayResultDtoList) {
			for (PlayerPlayResultDto compareDto : playerPlayResultDtoList) {
				// 自分よりも高い点数の人がいたらインクリメントする
				if (resutlDto.money <= compareDto.money) {
					resutlDto.rank++;
				}
			}
		}
	}

	/**
	 * 各半荘の情報をMapにまとめて取得する
	 * @param pointList
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Map<Integer, List> getHantyanTotalResult(List<PlayerResultPoint> pointList){
		// 各半荘の情報を格納するMap
		Map<Integer, List> hantyanTotalResultMap= new TreeMap<Integer, List>();

		// 登録されている半荘数を取得
		int hansuCount = pointList.size()/4;

		// 各半荘情報を設定
		for (int i = 1; i <= hansuCount; i++) {
			//
			List<PlayerResultPoint> resultList = new ArrayList<PlayerResultPoint>();
			for (PlayerResultPoint list: pointList) {
				if(i == list.hanso) {
					resultList.add(list);
				}
			}
			// 取得したデータを設定
			hantyanTotalResultMap.put(i, resultList);
		}
		return hantyanTotalResultMap;
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
	 * PlayerPlayResulのentity情報をsetする
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

	/**
	 * Form情報をdtoにsetする
	 * @param playRuleSettingForm
	 * @param groupId
	 * @param playDate
	 * @return
	 */
	private PlayRuleSettingDto setPlayRuleSettingDto(PlayRuleSettingForm playRuleSettingForm
											  ,String groupId
											  ,String playDate) {
		PlayRuleSettingDto dto = new PlayRuleSettingDto();
		String unixTime = String.valueOf(CommonUtility.getCurrentDateUnixTimeUTC());
		dto.settingNo = unixTime;
		dto.groupId = groupId;
		dto.playDate = playDate;
		dto.playGroupNo = playRuleSettingForm.groupId + CommonConstant.HIHUN + unixTime;
		dto.rankReward1 = Integer.valueOf(playRuleSettingForm.rankReward1);
		dto.rankReward2 = Integer.valueOf(playRuleSettingForm.rankReward2);
		dto.rankReward3 = Integer.valueOf(playRuleSettingForm.rankReward3);
		dto.rankReward4 = Integer.valueOf(playRuleSettingForm.rankReward4);
		dto.tobiReward = Integer.valueOf(playRuleSettingForm.tobiReward);
		dto.rateMoney = Integer.valueOf(playRuleSettingForm.rateMoney);
		dto.tipMoney = Integer.valueOf(playRuleSettingForm.tipMoney);
		dto.returnPoint = Integer.valueOf(playRuleSettingForm.returnPoint);
		dto.yakumanRon = Integer.valueOf(playRuleSettingForm.yakumanRon);
		dto.yakumanTsumo = Integer.valueOf(playRuleSettingForm.yakumanTsumo);
		return dto;
	}

	/**
	 * Form情報をdtoにsetする
	 * @param playRuleSettingForm
	 * @param groupId
	 * @param playDate
	 * @return
	 */
	private PlayUserDto setPlayUserList(PlayRuleSettingForm playRuleSettingForm
										, PlayRuleSettingDto playRuleSettingDto) {
		PlayUserDto playUserDto = new PlayUserDto();
		List<PlayUser> playUserList = new ArrayList<PlayUser>();

		// 入力情報 1人目
		PlayUser playUser1 = new PlayUser();
		playUser1.groupId = playRuleSettingDto.groupId;
		playUser1.playDate = playRuleSettingDto.playDate;
		playUser1.groupId = playRuleSettingForm.playerUserId1;
		playUserList.add(playUser1);

		// 入力情報 2人目
		PlayUser playUser2 = new PlayUser();
		playUser2.groupId = playRuleSettingDto.groupId;
		playUser2.playDate = playRuleSettingDto.playDate;
		playUser2.groupId = playRuleSettingForm.playerUserId2;
		playUserList.add(playUser2);

		// 入力情報 3人目
		PlayUser playUser3 = new PlayUser();
		playUser3.groupId = playRuleSettingDto.groupId;
		playUser3.playDate = playRuleSettingDto.playDate;
		playUser3.groupId = playRuleSettingForm.playerUserId3;
		playUserList.add(playUser3);

		// 入力情報 4人目
		PlayUser playUser4 = new PlayUser();
		playUser4.groupId = playRuleSettingDto.groupId;
		playUser4.playDate = playRuleSettingDto.playDate;
		playUser4.groupId = playRuleSettingForm.playerUserId4;
		playUserList.add(playUser4);

		// User情報をListに設定
		playUserDto.setPlayUserList(playUserList);

		return playUserDto;
	}

}