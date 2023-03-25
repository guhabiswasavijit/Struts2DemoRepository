package com.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;

@Slf4j
public class LoginAction extends ActionSupport{
    private String userName;
    private String password;
    private DaoAuthenticationProvider authenticationProvider;

    public LoginAction(DaoAuthenticationProvider i_authenticationProvider){
        this.authenticationProvider = i_authenticationProvider;
    }

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
        log.info("Called login action userName:{}",userName);
        log.info("Called login action password:{}",password);
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userName,password);
        Authentication authToken = authenticationProvider.authenticate(auth);
        if(authToken.isAuthenticated()){
            log.info("Successfully authenticated");
            return "success";
        }else{
            log.info("Authentication failed");
            throw new RuntimeException("Login Failed");
        }
    }
}
