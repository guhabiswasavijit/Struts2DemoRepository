package com.struts2.service;

import com.struts2.dao.UserDao;
import com.struts2.model.Role;
import com.struts2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	public UserServiceImpl(UserDao i_userDao){
		this.userDao = i_userDao;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		final User user = userDao.findUserByName(userName);
		if (user == null) {
			throw new UsernameNotFoundException(userName);
		}
		UserDetails userDtls = org.springframework.security.core.userdetails.User.withUsername(user.getUserName())
				               .password(user.getPassword())
				               .authorities(user.getRoles())
				               .build();
		return userDtls;
	}

	@Override
	public Set<Role> loadUserRole() {
		final Set<Role> roleSet = new HashSet<Role>();
		List<Role> roles = userDao.loadRole();
		roles.forEach(role -> roleSet.add(role));
		return roleSet;
	}
}
