package com.struts2.dao;

import java.util.ArrayList;
import java.util.List;

import com.struts2.action.RegisterUserAction;
import com.struts2.model.Role;
import com.struts2.model.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.log4j.Logger;
@Repository("userDao")  
public class UserDaoImpl implements UserDao {
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Autowired  
	private SessionFactory sessionFactory;  
	
	@Override
	public void saveUser(User user) {
		try {
			logger.info("Called user dao with user"+user);
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
			logger.info("fetching all users");
			users = sessionFactory.getCurrentSession().createCriteria(User.class).list();
		}catch(HibernateException ex){
			throw new RuntimeException("Exception while fetching user");
		}
		return users;
	}
	public User findUserByName(String userName) {
		User selectedUser = new User();
		try {
			logger.info("fetching user with userName"+userName);
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
			logger.info("fetching user roles");
			Criteria cb = sessionFactory.getCurrentSession().createCriteria(Role.class);
			roles = cb.list();
		}catch(HibernateException ex){
			throw new RuntimeException("Exception while fetching roles");
		}
		return roles;
	}

}
