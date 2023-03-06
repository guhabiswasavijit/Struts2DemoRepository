package com.struts2.dao;

import java.util.List;

import com.struts2.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")  
public class UserDaoImpl implements UserDao {

	@Autowired  
	private SessionFactory sessionFactory;  
	
	@Override
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList() {
		return (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	@Override
	public boolean loginUser(String userName, String password) {
		Criteria cb = sessionFactory.getCurrentSession().createCriteria(User.class);
		cb.add(Restrictions.eq("userName", userName));
		cb.add(Restrictions.eq("password", password));
		return !cb.list().isEmpty();
	}

}
