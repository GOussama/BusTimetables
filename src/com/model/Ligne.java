package com.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the lignes database table.
 * 
 */
@Entity
@Table(name="LIGNE")
public class Ligne implements Serializable {
	
	private Integer id;
	private String libelle;
	private List<Arretshaslignes> arrets = new LinkedList<Arretshaslignes>();
	   
	 
	
	@Id
	@GenericGenerator(name="generator",strategy="increment")
	@GeneratedValue(generator ="generator")
	@Column(name="LIGNE_ID", nullable = false)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy ="pk.ligne")
	public List<Arretshaslignes> getArrets() {
		return arrets;
	}


	public void setArrets(List<Arretshaslignes> arrets) {
		this.arrets = arrets;
	}


	public Ligne() {
    }

	
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Ligne: " + this.id + ", " + this.libelle + ", " ;
	}
	
}