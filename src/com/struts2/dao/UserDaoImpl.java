package com.struts2.dao;

import com.struts2.model.Role;
import com.struts2.model.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository("userDao")
@Slf4j
public class UserDaoImpl implements UserDao{
	private SessionFactory sessionFactory;  
	public UserDaoImpl(SessionFactory i_sessionFactory){
		this.sessionFactory = i_sessionFactory;
	}
	@Override
	public void saveUser(User user) {
		try {
			log.info("Called user dao with user: {}",user);
			sessionFactory.getCurrentSession().saveOrUpdate(user);
		}catch(HibernateException ex){
			throw new RuntimeException("Exception while adding user");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList() {
		List<User> users = new ArrayList<>();
		try {
			log.info("fetching all users");
			users = sessionFactory.getCurrentSession().createCriteria(User.class).list();
		}catch(HibernateException ex){
			throw new RuntimeException("Exception while fetching user");
		}
		return users;
	}
	public User findUserByName(String userName) {
		User selectedUser = new User();
		try {
			log.info("fetching user with userName {}",userName);
			Criteria cb = sessionFactory.getCurrentSession().createCriteria(User.class);
			cb.add(Restrictions.eq("userName", userName));
			selectedUser = (User)cb.uniqueResult();
		}catch(HibernateException ex){
			throw new RuntimeException("Exception while fetching user with userName"+userName);
		}

		return selectedUser;
	}

	@Override
	public List<Role> loadRole() {
		List<Role> roles = new ArrayList<>();
		try {
			log.info("fetching user roles");
			Criteria cb = sessionFactory.getCurrentSession().createCriteria(Role.class);
			roles = cb.list();
		}catch(HibernateException ex){
			throw new RuntimeException("Exception while fetching roles");
		}
		return roles;
	}

}
