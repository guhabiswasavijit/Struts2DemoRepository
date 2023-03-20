package com.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.struts2.model.Role;
import com.struts2.model.User;
import com.struts2.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Set;
import org.apache.log4j.Logger;

public class RegisterUserAction extends ActionSupport{
    private static final Logger logger = Logger.getLogger(RegisterUserAction.class);
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private Set<Role> userRoles;
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String execute()	{
        userRoles = userService.loadUserRole();
        userRoles.forEach(role ->{
            logger.info("Roles loaded"+role.toString());
        });
        if(!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password)){
            logger.info("Called login action userName:"+userName);
            logger.info("Called login action password:"+password);
            String encodedPassword = passwordEncoder.encode(password);
            User user = new User();
            user.setUserName(userName);
            user.setPassword(encodedPassword);
            user.setRoles(userRoles);
            userService.saveUser(user);
            return "success";
        }
        return "addUser";
    }

    public Set<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<Role> userRoles) {
        this.userRoles = userRoles;
    }
}
