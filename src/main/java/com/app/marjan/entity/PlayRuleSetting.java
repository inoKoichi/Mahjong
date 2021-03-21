package com.app.marjan.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "PLAYER_RULE_SETTING")
public class PlayRuleSetting {

	/** 設定番号 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "setting_no")
	public String settingNo;

	/** グループID */
	@Column(name = "group_id")
	public String groupId;

	/** プレイ日 */
	@Column(name = "play_date")
	public String playDate;

	/** プレイヤーグループ番号 */
	@Column(name = "player_group_no")
	public String playGroupNo;

	/** 順位報酬(1位) */
	@Column(name = "rank_reward1")
	public Integer rankReward1;

	/** 順位報酬(2位) */
	@Column(name = "rank_reward2")
	public Integer rankReward2;

	/** 順位報酬(3位) */
	@Column(name = "rank_reward3")
	public Integer rankReward3;

	/** 順位報酬(4位) */
	@Column(name = "rank_reward4")
	public Integer rankReward4;

	/** 飛び報酬 */
	@Column(name = "tobi_reward")
	public Integer tobiReward;

	/** レート金 */
	@Column(name = "rate_money")
	public Integer rateMoney;

	/** チップ金 */
	@Column(name = "tip_money")
	public Integer tipMoney;

	/** おか */
	@Column(name = "return_point")
	public Integer returnPoint;

	/** 役満ロン報酬 */
	@Column(name = "yakuman_ron")
	public Integer yakumanRon;

	/** 役満ツモ報酬 */
	@Column(name = "yakuman_tsumo")
	public Integer yakumanTsumo;

	@Column(name = "registration_date")
	public Date registrationDate;

	@Column(name = "update_date")
	public Date updateDate;

	@Column(name = "delete_date")
	public Date deleteDate;

	@Column(name = "delete_flag")
	public Integer deleteFlag;

}
