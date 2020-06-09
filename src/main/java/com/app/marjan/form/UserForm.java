package com.app.marjan.form;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.app.marjan.entity.User;

import lombok.Data;

@Data
public class UserForm implements Serializable {

	public User userList = new User();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Size(min = 1, max = 600)
	public String userName;

	@Email
	public String mailAddress;

	@NotNull
	@Size(min = 2, max = 20)
	public String password;

}