package com.service;

import java.util.List;

import com.dao.LigneDao;
import com.model.Ligne;

public class LigneService {
	
	
private static LigneDao lignedao;
	
	public LigneService(){
		lignedao = new LigneDao();
	}
	
	public void persist(Ligne entity){
		lignedao.openCurrentSessionwithTransaction();
		lignedao.persist(entity);
		lignedao.closeCurrentSessionwithTransaction();
	}
	
	public void update(Ligne entity){
		lignedao.openCurrentSessionwithTransaction();
		lignedao.update(entity);
		lignedao.closeCurrentSessionwithTransaction();
		
	}
	
	public Ligne finById(Integer id){
		
		lignedao.openCurrentSession();
		Ligne Ligne = lignedao.findById(id);
		lignedao.closeCurrentSession();
		return Ligne;
		
	}
	
	public void delete(Integer id){
		
		lignedao.openCurrentSessionwithTransaction();
		Ligne Ligne = lignedao.findById(id);
		lignedao.delete(Ligne);
		lignedao.closeCurrentSessionwithTransaction();
	
	}
	
	
	public List<Ligne> findAll(){
		
		lignedao.openCurrentSession();
		List<Ligne> Lignes = lignedao.findAll();
		lignedao.closeCurrentSession();
		return Lignes;
		}
	
	public void deletAll(){
		
		lignedao.openCurrentSessionwithTransaction();
		lignedao.deleteAll();
		lignedao.closeCurrentSessionwithTransaction();
		
	}
	
	public LigneDao lignedao(){
		return lignedao;
	}

}
