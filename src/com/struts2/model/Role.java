package com.struts2.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class Role implements GrantedAuthority, Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long roleId;
    @Column(name="rolename")
    private String roleName;
    @Override
    public String getAuthority() {
        return this.roleName;
    }
}
