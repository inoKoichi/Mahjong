package com.app.marjan.dto;

/**
 * harfRoundGameKyokuList.jsp（半荘一覧）に表示するときのヘッダー情報を保持する
 * @author inokoichi
 *
 */
public class  ParticipantHeaderInfoDto {

//	public Integer no;

	/**
	 * ユーザーID
	 */
	public String userId;

	/**
	 * ユーザー名
	 */
	public String userName;

	/**
	 * グループID1
	 */
	public String groupId1;

	/**
	 * グループID2
	 */
	public String groupId2;

	/**
	 * グループID3
	 */
	public String groupId3;

	/**
	 * 合計金額
	 */
	public Integer totalManey = 0;

	/**
	 * 合計得点
	 */
	public Integer totalPoint = 0;

	/**
	 * レート
	 */
	public Integer rate = 0;

	/**
	 * 半荘数
	 */
	public Integer hanso = 0;

	//	public Date registrationDate;
//
//	public Date updateDate;
//
//	public Date deleteDate;
//
//	public Integer deleteFlag;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGroupId1() {
		return groupId1;
	}

	public void setGroupId1(String groupId1) {
		this.groupId1 = groupId1;
	}

	public String getGroupId2() {
		return groupId2;
	}

	public void setGroupId2(String groupId2) {
		this.groupId2 = groupId2;
	}

	public String getGroupId3() {
		return groupId3;
	}

	public void setGroupId3(String groupId3) {
		this.groupId3 = groupId3;
	}

	public Integer getHanso() {
		return hanso;
	}

	public void setHanso(Integer hanso) {
		this.hanso = hanso;
	}

//	public Date getRegistrationDate() {
//		return registrationDate;
//	}
//
//	public void setRegistrationDate(Date registrationDate) {
//		this.registrationDate = registrationDate;
//	}
//
//	public Date getUpdateDate() {
//		return updateDate;
//	}
//
//	public void setUpdateDate(Date updateDate) {
//		this.updateDate = updateDate;
//	}
//
//	public Date getDeleteDate() {
//		return deleteDate;
//	}
//
//	public void setDeleteDate(Date deleteDate) {
//		this.deleteDate = deleteDate;
//	}
//
//	public Integer getDeleteFlag() {
//		return deleteFlag;
//	}
//
//	public void setDeleteFlag(Integer deleteFlag) {
//		this.deleteFlag = deleteFlag;
//	}
}
