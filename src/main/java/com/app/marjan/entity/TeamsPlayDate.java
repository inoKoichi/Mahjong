package com.app.marjan.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEAMS_PLAY_DATE")
public class TeamsPlayDate {

	@Id
	@Column(name = "group_id")
	public String groupId;

	@Column(name = "play_date")
	public String playDate;

	@Column(name = "registration_date")
	public Date registrationDate;

	@Column(name = "update_date")
	public Date updateDate;

	@Column(name = "delete_date")
	public Date deleteDate;

	@Column(name = "delete_flag")
	public Boolean deleteFlag;

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
