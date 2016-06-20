package com.service;

import java.util.List;

import com.dao.ArretDao;
import com.model.Arret;

public class ArretService {
	
	private static ArretDao arretdao;
	
	public ArretService(){
		arretdao = new ArretDao();
	}
	
	public void persist(Arret entity){
		arretdao.openCurrentSessionwithTransaction();
		arretdao.persist(entity);
		arretdao.closeCurrentSessionWithTransaction();
	}
	
	public void update(Arret entity){
		arretdao.openCurrentSessionwithTransaction();
		arretdao.update(entity);
		arretdao.closeCurrentSessionWithTransaction();
		
	}
	
	public Arret finById(Integer id){
		arretdao.openCurrentSession();
		Arret arret = arretdao.findById(id);
		arretdao.closeCurrentSession();
		return arret;		
	}
	
	public void delete(Integer id){
		arretdao.openCurrentSessionwithTransaction();
		Arret arret = arretdao.findById(id);
		arretdao.delete(arret);
		arretdao.closeCurrentSessionWithTransaction();
	}
	
	
	public List<Arret> findAll(){
		arretdao.openCurrentSession();
		List<Arret> arrets = arretdao.findAll();
		arretdao.closeCurrentSession();
		return arrets;
		}
	
	public void deletAll(){		
		arretdao.openCurrentSessionwithTransaction();
		arretdao.deleteAll();
		arretdao.closeCurrentSessionWithTransaction();	
	}
	
	public ArretDao arretDao(){
		return arretdao;
	}
}
