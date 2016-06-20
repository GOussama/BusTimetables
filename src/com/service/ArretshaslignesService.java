package com.service;


import java.util.List;


import com.dao.ArretshaslignesDao;
import com.model.Arretshaslignes;

public class ArretshaslignesService {
	
	
	
	private static ArretshaslignesDao arrethaslignedao;
	
	public ArretshaslignesService(){
		arrethaslignedao = new ArretshaslignesDao();
	}
	
	public void persist(Arretshaslignes entity){
		arrethaslignedao.openCurrentSessionwithTransaction() ;
		arrethaslignedao.persist(entity);
		arrethaslignedao.closeCurrentSessionWithTransaction();
	}
	
	public void update(Arretshaslignes entity){
		arrethaslignedao.openCurrentSessionwithTransaction();
		arrethaslignedao.update(entity);
		arrethaslignedao.closeCurrentSessionWithTransaction();
		
	}
	
	public Arretshaslignes finById(Integer id){
		arrethaslignedao.openCurrentSession();
		Arretshaslignes arretligne = arrethaslignedao.findById(id);
		arrethaslignedao.closeCurrentSession();
		return arretligne;		
	}
	
	public void delete(Integer id){
		arrethaslignedao.openCurrentSessionwithTransaction();
		Arretshaslignes arretligne = arrethaslignedao.findById(id);
		arrethaslignedao.delete(arretligne);
		arrethaslignedao.closeCurrentSessionWithTransaction();
	}
	
	
	public List<Arretshaslignes> findAll(){
		arrethaslignedao.openCurrentSession();
		List<Arretshaslignes> arretslignes = arrethaslignedao.findAll();
		arrethaslignedao.closeCurrentSession();
		return arretslignes;
		}
	
	public void deletAll(){		
		arrethaslignedao.openCurrentSessionwithTransaction();
		arrethaslignedao.deleteAll();
		arrethaslignedao.closeCurrentSessionWithTransaction();	
	}
	
	public ArretshaslignesDao arretDao(){
		return arrethaslignedao;
	}
	
	
	
	

}
