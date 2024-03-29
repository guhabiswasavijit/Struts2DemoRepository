package com.struts2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name="users")
@Getter
@Setter
@ToString
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")
	private Long userId;
	@Column(name="username")
	private String userName;
	@Column(name="password")
	private String password;
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
}
