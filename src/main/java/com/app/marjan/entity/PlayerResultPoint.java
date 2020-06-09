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
@Table(name = "PLAYER_RESULT_POINT")
public class PlayerResultPoint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no")
	public Integer no;

	@Column(name = "group_id")
	public String groupId;

	@Column(name = "play_date")
	public String playDate;

	@Column(name = "hanso")
	public Integer hanso;

	@Column(name = "user_id")
	public String userId;

	@Column(name = "user_name")
	public String userName;

	@Column(name = "point")
	public Integer point;

	@Column(name = "tip_money")
	public Integer tipMoney;

	@Column(name = "money")
	public Integer money;

	@Column(name = "rank")
	public Integer rank;

	@Column(name = "seat_wind")
	public String seatWind;

	@Column(name = "hako_flag")
	public Integer hakoFlag;

	@Column(name = "hako_from_player")
	public Integer hakoFromPlayer;

	@Column(name = "yakuman_flag")
	public String yakumanFlag;

	@Column(name = "registration_date")
	public Date registrationDate;

	@Column(name = "update_date")
	public Date updateDate;

	@Column(name = "delete_date")
	public Date deleteDate;

	@Column(name = "delete_flag")
	public Integer deleteFlag;

	@Column(name = "score")
	public Integer score;

}
