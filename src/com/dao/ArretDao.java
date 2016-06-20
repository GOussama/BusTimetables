package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.model.Arret;

public class ArretDao implements InterfaceDao<Arret, Integer> {
	
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

	public ArretDao(){
		
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
	public void persist(Arret entity) {
		getCurrentSession().save(entity);
		
	}

	@Override
	public void update(Arret entity) {
		getCurrentSession().update(entity);	
	}

	@Override
	public Arret findById(Integer id) {
		Arret arret = (Arret) getCurrentSession().get(Arret.class, id);
		return arret;
	}

	@Override
	public void delete(Arret entity) {
		getCurrentSession().delete(entity);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Arret> findAll() {
		List<Arret> arrets = (List<Arret>) getCurrentSession().createQuery("from Arret").list();
		return arrets;
	}


	@Override
	public void deleteAll() {
		
		List<Arret> entityList = findAll();
		for(Arret entity : entityList){
			delete(entity);
		}	
	}


	

}
