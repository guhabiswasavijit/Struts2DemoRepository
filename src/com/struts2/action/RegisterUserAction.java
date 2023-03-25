package com.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.struts2.model.Role;
import com.struts2.model.User;
import com.struts2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Set;

@Slf4j
public class RegisterUserAction extends ActionSupport{
    private UserService userService;
    private BCryptPasswordEncoder passwordEncoder;
    private Set<Role> userRoles;
    private String userName;
    private String password;

    public RegisterUserAction(UserService i_userService,BCryptPasswordEncoder i_passwordEncoder){
        this.userService = i_userService;
        this.passwordEncoder = i_passwordEncoder;
    }

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
            log.info("Roles loaded"+role.toString());
        });
        if(!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password)){
            log.info("Called login action userName:"+userName);
            log.info("Called login action password:"+password);
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
