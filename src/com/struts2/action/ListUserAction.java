package com.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.struts2.bean.UserBean;
import com.struts2.model.User;
import com.struts2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
@Slf4j
public class ListUserAction extends ActionSupport{
	private UserService userService;
	private List<UserBean> users;
	public ListUserAction(UserService i_userService){
		this.userService = i_userService;
	}

	public String execute()	{
		log.info("Executing ListUserAction");
		List<User> users = userService.getUserList();
		final List<UserBean> usrLst = new ArrayList<>();
		this.setUsers(usrLst);
		usrLst.forEach(user -> {
			UserBean usr = new UserBean();
			usrLst.add(usr);
			usr.setUserName(user.getUsername());
			user.getAuthorities().forEach(auth -> {
				usr.getRoles().add(auth.getAuthority());
			});

		});
		return "listUsers";
	}
	public List<UserBean> getUsers() {
		return users;
	}

	public void setUsers(List<UserBean> users) {
		this.users = users;
	}
	
}