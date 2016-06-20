package com.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import com.model.Ligne;
import com.service.LigneService;


@ManagedBean
public class LigneBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private static final String SUCCESS = "success";
	private static final String ERROR   = "error";	
	
	
	public LigneBean(){
		
	}

	public LigneBean(String libelle) {
		super();
		this.libelle = libelle;
	}

	private String libelle;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}	

	
	public String saveLigne() {
	       
		String result = null;
		Ligne ligne = new Ligne();
		ligne.setLibelle(this.libelle);
		
       
		try {
			
		LigneService ligneserv = new LigneService();
		ligneserv.persist(ligne);
		result="success";
			
		} catch (Exception e) {
		result="error";	
		}
		return result;
      
    }
}
