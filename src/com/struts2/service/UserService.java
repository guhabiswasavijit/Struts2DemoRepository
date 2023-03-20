package com.struts2.service;

import com.struts2.model.Role;
import com.struts2.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;
import java.util.Set;


public interface UserService extends UserDetailsService {
	void saveUser(User user);
	List<User> getUserList();
	Set<Role> loadUserRole();

}
