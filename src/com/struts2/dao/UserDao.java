package com.struts2.dao;

import java.util.List;

import com.struts2.model.User;

public interface UserDao {
	void saveUser(User user);
	List<User> getUserList();
	boolean loginUser(String userName,String password);
}
