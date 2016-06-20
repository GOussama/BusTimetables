package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.model.User;

public class UserDao implements InterfaceDao<User, Integer> {
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public Session getCurrentSession() {
		return currentSession;
	}
	
	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public UserDao(){
		
	}
		
	public Session openCurrentSession(){
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}
	
	public Session openCurrentSessionwithTransaction(){
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}

	private SessionFactory getSessionFactory() {
		
		Configuration configuration = new Configuration().configure();
		/*Since SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		is deprecated in hibernate 4*/
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
				applySettings(configuration.getProperties());
		SessionFactory sessionFacory = configuration.buildSessionFactory(builder.build());
		return sessionFacory;

	}
	
	public void closeCurrentSession(){
		currentSession.close();
	}
	
	public void closeCurrentSessionWithTransaction(){
		currentTransaction.commit();
		currentSession.close();
	}


	@Override
	public void persist(User entity) {
		getCurrentSession().save(entity);
		
	}

	@Override
	public void update(User entity) {
		getCurrentSession().update(entity);
		
	}

	@Override
	public User findById(Integer id) {
		
		User User = (User) getCurrentSession().get(User.class, id);
		return User;
	}

	@Override
	public void delete(User entity) {
		getCurrentSession().delete(entity);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		List<User> Users = (List<User>) getCurrentSession().createQuery("from User").list();
		return Users;
	}


	@Override
	public void deleteAll() {
		
		List<User> entityList = findAll();
		for(User entity : entityList){
			delete(entity);
		}	
	}



}
