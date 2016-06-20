package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.model.Arretshaslignes;

public class ArretshaslignesDao implements InterfaceDao<Arretshaslignes, Integer> {
	
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

	public ArretshaslignesDao(){
		
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
	public void persist(Arretshaslignes entity) {
		getCurrentSession().save(entity);
		
	}

	@Override
	public void update(Arretshaslignes entity) {
		getCurrentSession().update(entity);
		
	}

	@Override
	public Arretshaslignes findById(Integer id) {
		
		Arretshaslignes arrethsligne = (Arretshaslignes) getCurrentSession().get(Arretshaslignes.class, id);
		return arrethsligne;
	}

	@Override
	public void delete(Arretshaslignes entity) {
		getCurrentSession().delete(entity);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Arretshaslignes> findAll() {
		List<Arretshaslignes> arretshasligne = (List<Arretshaslignes>) getCurrentSession().createQuery("from Arret").list();
		return arretshasligne;
	}


	@Override
	public void deleteAll() {
		
		List<Arretshaslignes> entityList = findAll();
		for(Arretshaslignes entity : entityList){
			delete(entity);
		}	
	}


	

}
