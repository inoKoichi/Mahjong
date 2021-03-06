package com.app.marjan.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "PLAY_USER")
public class  PlayUser {

	@Id
	@Column(name = "user_id")
	public String userId;

	@Column(name = "group_id")
	public String groupId;

	@Column(name = "play_date")
	public String playDate;

	@Column(name = "user_name")
	public String userName;

	@Column(name = "registration_date")
	public Date registrationDate;

	@Column(name = "update_date")
	public Date updateDate;

	@Column(name = "delete_date")
	public Date deleteDate;

	@Column(name = "delete_flag")
	public Boolean deleteFlag;

}
