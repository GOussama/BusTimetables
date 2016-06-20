package com.bean;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import com.model.Arret;
import com.model.Arretshaslignes;
import com.service.ArretService;



@ManagedBean
public class ArretBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";	

	private String libelle;	
	private String region;
	private List<Arretshaslignes> arrethslignes = new LinkedList<Arretshaslignes>();

	
	
	
	public ArretBean(String libelle, String region) {
		super();
		this.libelle = libelle;
		this.region = region;
	}
	
	public ArretBean(){
		
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public List<Arretshaslignes> getArrethslignes() {
		return arrethslignes;
	}
	public void setArrethslignes(List<Arretshaslignes> arrethslignes) {
		this.arrethslignes = arrethslignes;
	}
	
	public String saveArret() {
       
		String result = null;
		Arret arret = new Arret();
		arret.setLibelle(this.libelle);
		arret.setRegion(this.region);
       
		try {
			
		ArretService arretserv = new ArretService();
		arretserv.persist(arret);
		result="success";	
		} catch (Exception e) {
		result="error";	
		}
		return result;
      
    }
	
	


}
