package com.struts2.service;

import java.util.List;
import com.struts2.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
	void saveUser(User user);
	List<User> getUserList();
	boolean loginUser(String userName,String password);
	User findUserByName(String userName);

}
