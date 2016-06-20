package com.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.model.Arret;
import com.model.Arretshaslignes;
import com.model.Ligne;
import com.service.ArretService;
import com.service.ArretshaslignesService;
import com.service.LigneService;

@ManagedBean
public class Arretshslignes implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";	

	private Integer arr;
	private Integer lign;
	
	public Integer getArr() {
		return arr;
	}
	public void setArr(Integer arr) {
		this.arr = arr;
	}
	public Integer getLign() {
		return lign;
	}
	public void setLign(Integer lign) {
		this.lign = lign;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getHorraireNormale() {
		return horraireNormale;
	}
	public void setHorraireNormale(String horraireNormale) {
		this.horraireNormale = horraireNormale;
	}
	public String getHorraireDimFer() {
		return horraireDimFer;
	}
	public void setHorraireDimFer(String horraireDimFer) {
		this.horraireDimFer = horraireDimFer;
	}
	private String direction;
	private String horraireNormale;
	private String horraireDimFer;
	
	
	public List<Arret> AllArrets(){
		ArretService arretserv = new ArretService();
		List<Arret> arrets =  arretserv.findAll();
		return arrets;	
	}
	
	public List<Ligne> AllLignes(){
		LigneService ligneserv = new LigneService();
		List<Ligne> lignes = ligneserv.findAll();
		return lignes;	
	}
	
	public String SaveArretToLigne() {
		
		String result = null;
		
		Arretshaslignes arrethsligne = new Arretshaslignes();
		
		ArretService arretserv = new ArretService();
		LigneService ligneserv = new LigneService();
		
		//System.out.println(arretserv.finById("2"));
		
		Arret arr = arretserv.finById(this.arr);
		Ligne lign = ligneserv.finById(this.lign);
		
		arrethsligne.getPk().setArret(arr);
		arrethsligne.getPk().setLigne(lign);
		arrethsligne.setDirection(this.direction);
		arrethsligne.setHorraireNormale(this.horraireNormale);
		arrethsligne.setHorraireDimFer(this.horraireDimFer);

		try {
			
		ArretshaslignesService arretligneserv = new ArretshaslignesService();
		arretligneserv.persist(arrethsligne);
		result="success";	
		} catch (Exception e) {
		result="error";	
		}
		return result;
      
    }
	}
