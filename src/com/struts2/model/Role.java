package com.struts2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="roles")
@Getter
@Setter
@ToString
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
