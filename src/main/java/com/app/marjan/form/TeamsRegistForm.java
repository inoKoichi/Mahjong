package com.app.marjan.form;

import java.io.Serializable;

import com.app.marjan.entity.User;

import lombok.Data;

@Data
public class TeamsRegistForm implements Serializable {

	public User userList = new User();

	public String groupId;

	public String groupName;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupId() {
		return groupName;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

}