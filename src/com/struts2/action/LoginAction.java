package com.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.apache.log4j.Logger;
public class LoginAction extends ActionSupport{
    private static final Logger logger = Logger.getLogger(LoginAction.class);
    private String userName;
    private String password;
    @Autowired
    private DaoAuthenticationProvider authenticationProvider;

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
        logger.info("Called login action userName:"+userName);
        logger.info("Called login action password:"+password);
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userName,password);
        Authentication authToken = authenticationProvider.authenticate(auth);
        if(authToken.isAuthenticated()){
            logger.info("Successfully authenticated");
            return "success";
        }else{
            logger.info("Authentication failed");
            throw new RuntimeException("Login Failed");
        }
    }
}
