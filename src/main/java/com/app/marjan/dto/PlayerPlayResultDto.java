package com.app.marjan.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * harfRoundGameKyokuList.jsp（半荘一覧）に表示するときの点数情報を保持する
 * @author inokoichi
 *
 */
@Getter
@Setter
public class  PlayerPlayResultDto {

	/**
	 * 順位
	 */
	public Integer rank = 0;

	/**
	 * 点数
	 */
	public Integer score;

	/**
	 * 得点
	 */
	public Integer point = 0;

	/**
	 * ユーザーID
	 */
	public String userId;

	/**
	 * ユーザー名
	 */
	public String userName;

	/**
	 * グループID
	 */
	public String groupId;

	/**
	 * プレイ日
	 */
	public String playDate;

	/**
	 * 席風
	 */
	public String seatWind;

	/**
	 * 箱下フラグ
	 */
	public Boolean hakoFlag;

	/**
	 *
	 */
	public Integer hakoFromPlayer = 0;

	/**
	 *
	 */
	public String yakumanFlag;

	/**
	 * 金額
	 */
	public Integer money = 0;
}
