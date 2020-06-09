package com.app.marjan.form;

import java.io.Serializable;

import com.app.marjan.entity.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TeamsForm implements Serializable {

	public User userList = new User();

	/**
	 * グループID
	 */
	public String groupId;

	/**
	 * グループ名
	 */
	public String groupName;

}