package com.app.marjan.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER_RESULT_POINT")
public class PlayerResultPoint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no")
	public String no;

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

	/**
	 * プレイ実施日を取得
	 * @return
	 */
	public String getPlayDate() {
		return playDate;
	}

	/**
	 * プレイ実施日を設定
	 * @param playDate
	 */
	public void setPlayDate(String playDate) {
		this.playDate = playDate;
	}

	/**
	 *
	 * @return
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 *
	 * @param groupId
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 *
	 * @return
	 */
	public Integer getHanso() {
		return hanso;
	}

	/**
	 *
	 * @param hanso
	 */
	public void setHanso(Integer hanso) {
		this.hanso = hanso;
	}

	public String getUserId() {
		return userId;
	}

	/**
	 *
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 *
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 *
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 *
	 * @return
	 */
	public Integer getPoint() {
		return point;
	}

	/**
	 *
	 * @param point
	 */
	public void setPoint(Integer point) {
		this.point = point;
	}

	/**
	 *
	 * @return
	 */
	public Integer getTipMoney() {
		return tipMoney;
	}

	/**
	 *
	 * @param tipMoney
	 */
	public void setTipMoney(Integer tipMoney) {
		this.tipMoney = tipMoney;
	}

	/**
	 *
	 * @return
	 */
	public Integer getMoney() {
		return money;
	}

	/**
	 *
	 * @param money
	 */
	public void setMoney(Integer money) {
		this.money = money;
	}

	/**
	 *
	 * @return
	 */
	public Integer getRank() {
		return rank;
	}

	/**
	 *
	 * @param rank
	 */
	public void setRank(Integer rank) {
		this.rank = rank;
	}

	/**
	 *
	 * @return
	 */
	public String getSeatWind() {
		return seatWind;
	}

	/**
	 *
	 * @param seatWind
	 */
	public void setSeatWind(String seatWind) {
		this.seatWind = seatWind;
	}

	/**
	 *
	 * @return
	 */
	public Integer getHakoFlag() {
		return hakoFlag;
	}

	/**
	 *
	 * @param hakoFlag
	 */
	public void setHakoFlag(Integer hakoFlag) {
		this.hakoFlag = hakoFlag;
	}

	/**
	 *
	 * @return
	 */
	public Integer getHakoFromFlag() {
		return hakoFromPlayer;
	}

	/**
	 *
	 * @param hakoFromPlayer
	 */
	public void setHakoFromFlag(Integer hakoFromPlayer) {
		this.hakoFromPlayer = hakoFromPlayer;
	}

	/**
	 *
	 * @return
	 */
	public String getYakumanFlag() {
		return yakumanFlag;
	}

	/**
	 *
	 * @param yakumanFlag
	 */
	public void setYakumanFlag(String yakumanFlag) {
		this.yakumanFlag = yakumanFlag;
	}

	/**
	 *
	 * @return
	 */
	public Date getRegistrationDate() {
		return registrationDate;
	}

	/**
	 *
	 * @param registrationDate
	 */
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	/**
	 *
	 * @return
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 *
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 *
	 * @return
	 */
	public Date getDeleteDate() {
		return deleteDate;
	}

	/**
	 *
	 * @param deleteDate
	 */
	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	/**
	 *
	 * @return
	 */
	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 *
	 * @param deleteFlag
	 */
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 *
	 * @return
	 */
	public String getNo() {
		return no;
	}

	/**
	 *
	 * @param no
	 */
	public void setNo(String no) {
		this.no = no;
	}

	/**
	 *
	 * @return
	 */
	public Integer getHakoFromPlayer() {
		return hakoFromPlayer;
	}

	/**
	 *
	 * @param hakoFromPlayer
	 */
	public void setHakoFromPlayer(Integer hakoFromPlayer) {
		this.hakoFromPlayer = hakoFromPlayer;
	}

	/**
	 *
	 * @return
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 *
	 * @param score
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

}
