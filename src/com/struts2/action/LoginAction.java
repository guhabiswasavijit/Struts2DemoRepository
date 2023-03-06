package com.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.struts2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginAction extends ActionSupport{
    private String userName;
    private String password;
    @Autowired
    private UserService userService;

    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String execute()	{
        if(userService.loginUser(userName,password)){
            return "listUsers";
        }
        return null;
    }
}
