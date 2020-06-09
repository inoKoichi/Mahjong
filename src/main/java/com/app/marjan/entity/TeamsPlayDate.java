package com.app.marjan.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
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

}
