package com.app.marjan.form;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 設定画面のFormクラス
 * @author inokoichi
 *
 */
@Getter
@Setter
@Data
public class PlayRuleSettingForm implements Serializable {

	/**
	 * シーケンスNo
	 */
	public String sequenceNo;

	/**
	 * グループID
	 */
	public String groupId;

	/**
	 * 設定No
	 */
 	public String settingNo;

	/**
	 * プレイ日
	 */
	public String playDate;

	/**
	 * ユーザーID（1人目）
	 */
	public String userId1;

	/**
	 * ユーザーID（2人目）
	 */
	public String userId2;

	/**
	 * ユーザーID（3人目）
	 */
	public String userId3;

	/**
	 * ユーザーID（4人目）
	 */
	public String userId4;

	/**
	 * ユーザーID（5人目）
	 */
	public String userId5;

	/**
	 * ユーザーID（6人目）
	 */
	public String userId6;

	/**
	 * ユーザーID（7人目）
	 */
	public String userId7;

	/**
	 * ユーザーID（8人目）
	 */
	public String userId8;

	/**
	 * ユーザーID（9人目）
	 */
	public String userId9;

	/**
	 * ユーザーID（10人目）
	 */
	public String userId10;

	/**
	 * ユーザーID（11人目）
	 */
	public String userId11;

	/**
	 * ユーザーID（12人目）
	 */
	public String userId12;

	/**
	 * レート金
	 */
	public String rateMoney;

	/**
	 * チップ金
	 */
	public String tipMoney;

	/**
	 * 丘
	 */
	public String okaPoint;

	/**
	 * 順位報酬(1位)
	 */
	public String rankReward1;

	/**
	 * 順位報酬(2位)
	 */
	public String rankReward2;

	/**
	 * 順位報酬(3位)
	 */
	public String rankReward3;

	/**
	 * 順位報酬(4位)
	 */
	public String rankReward4;

	/**
	 * 飛び報酬
	 */
	public String tobiReward;

	/**
	 * 役満ロン
	 */
	public String yakumanRon;

	/**
	 * 役満ツモ
	 */
	public String yakumanTsumo;
}