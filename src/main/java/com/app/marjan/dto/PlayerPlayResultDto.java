package com.app.marjan.dto;

/**
 * harfRoundGameKyokuList.jsp（半荘一覧）に表示するときの点数情報を保持する
 * @author inokoichi
 *
 */
public class  PlayerPlayResultDto {

//	public Integer no;

	/**
	 * 順位
	 */
	public Integer rank;

	/**
	 * 点数
	 */
	public Integer score;

	/**
	 * 得点
	 */
	public Integer point;

	public String userId;
	public String groupId;
	public String playDate;
	public String seatWind;
	public Boolean hakoFlag;
	public Integer hakoFromPlayer;
	public String yakumanFlag;
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getPlayDate() {
		return playDate;
	}
	public void setPlayDate(String playDate) {
		this.playDate = playDate;
	}
	public String getSeatWind() {
		return seatWind;
	}
	public void setSeatWind(String seatWind) {
		this.seatWind = seatWind;
	}
	public Boolean getHakoFlag() {
		return hakoFlag;
	}
	public void setHakoFlag(Boolean hakoFlag) {
		this.hakoFlag = hakoFlag;
	}
	public Integer getHakoFromPlayer() {
		return hakoFromPlayer;
	}
	public void setHakoFromPlayer(Integer hakoFromPlayer) {
		this.hakoFromPlayer = hakoFromPlayer;
	}
	public String getYakumanFlag() {
		return yakumanFlag;
	}
	public void setYakumanFlag(String yakumanFlag) {
		this.yakumanFlag = yakumanFlag;
	}

}
