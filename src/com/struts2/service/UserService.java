package com.struts2.service;

import java.util.List;
import com.struts2.model.User;


public interface UserService {
	void saveUser(User user);
	List<User> getUserList();
	boolean loginUser(String userName,String password);

}
