package com.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.model.Ligne;

public class LigneDao implements InterfaceDao<Ligne, Integer> {
	
	public LigneDao() {
	}

	Session currentSession;
	
	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
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
	
	
	public void closeCurrentSession(){
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction(){
		currentTransaction.commit();
		currentSession.close();
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	Transaction currentTransaction;

	@Override
	public void persist(Ligne entity) {
		getCurrentSession().save(entity);
	}

	@Override
	public void update(Ligne entity) {
		getCurrentSession().update(entity);
		
	}

	@Override
	public Ligne findById(Integer id) {
		Ligne ligne = (Ligne) getCurrentSession().get(Ligne.class,id);
		return ligne;
	}

	@Override
	public void delete(Ligne entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ligne> findAll() {
		
		List<Ligne> lignes = (List<Ligne>) getCurrentSession().createQuery("From Ligne").list();
		return lignes;
	}

	@Override
	public void deleteAll() {
		List<Ligne> lignes = findAll();
		for (Ligne ligne : lignes) {
			delete(ligne);
		}
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
	
}
