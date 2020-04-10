package com.app.marjan.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class  User {

	@Id
	@Column(name = "user_id")
	public String userId;

	@Column(name = "user_name")
	public String userName;

	@Column(name = "group_id1")
	public String groupId1;

	@Column(name = "group_id2")
	public String groupId2;

	@Column(name = "group_id3")
	public String groupId3;

	@Column(name = "registration_date")
	public Date registrationDate;

	@Column(name = "update_date")
	public Date updateDate;

	@Column(name = "delete_date")
	public Date deleteDate;

	@Column(name = "delete_flag")
	public Boolean deleteFlag;

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

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public Boolean getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
