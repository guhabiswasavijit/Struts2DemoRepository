package com.struts2.dao;

import com.struts2.model.Role;
import com.struts2.model.User;
import java.util.List;

public interface UserDao {
	void saveUser(User user);
	List<User> getUserList();
	User findUserByName(String userName);
	List<Role> loadRole();
}
