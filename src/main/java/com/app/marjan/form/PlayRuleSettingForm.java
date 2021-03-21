package com.app.marjan.form;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 設定画面のFormクラス
 * @author inokoichi
 */
@Getter
@Setter
@Data
public class PlayRuleSettingForm implements Serializable {

	/** プレイ日付 */
	public String playDate;

	/** グループID */
	public String groupId;

	/** ユーザーID（1人目） */
	public String playerUserId1;

	/** ユーザーID（2人目） */
	public String playerUserId2;

	/** ユーザーID（3人目） */
	public String playerUserId3;

	/** ユーザーID（4人目） */
	public String playerUserId4;

	/** レート金 */
	public String rateMoney;

	/** チップ金 */
	public String tipMoney;

	/** おか */
	public String returnPoint;

	/** 順位報酬(1位) */
	public String rankReward1;

	/** 順位報酬(2位) */
	public String rankReward2;

	/** 順位報酬(3位) */
	public String rankReward3;

	/** 順位報酬(4位) */
	public String rankReward4;

	/** 飛び報酬 */
	public String tobiReward;

	/** 役満ロン */
	public String yakumanRon;

	/** 役満ツモ */
	public String yakumanTsumo;
}