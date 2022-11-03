package com.blurdel.web.thymeleaf.entities;

import java.util.ArrayList;
import java.util.List;

public class UserListDto {

	private List<UserInfo> userList = new ArrayList<>();

	
	public UserListDto() {
	}	
	
	public UserListDto(List<UserInfo> userlist) {
		this.userList = userlist;
	}

//	public void addUser(UserInfo user) {
//		userList.add(user);
//	}
	
	public List<UserInfo> getUserList() {
		return userList;
	}

	public void setUserList(List<UserInfo> userlist) {
		this.userList = userlist;
	}

	@Override
	public String toString() {
		return "UserListDto [userlist=" + userList + "]";
	}
	
}
