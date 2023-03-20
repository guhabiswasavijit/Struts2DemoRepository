package com.struts2.action;

import java.util.ArrayList;
import java.util.List;

import com.struts2.model.User;
import com.struts2.service.UserService;
import com.struts2.utils.CommonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import com.struts2.bean.UserBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class UserAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserBean userBean;
	@Autowired
	private UserService userService;
	private List<UserBean> users;

	public String execute()	{
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