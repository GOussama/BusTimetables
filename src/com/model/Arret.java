package com.model;


import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.LinkedList;
import java.util.List;


/**
 * The persistent class for the arrets database table.
 * 
 */
@Entity
@Table(name="ARRET")
public class Arret {	
	
	public Arret() {
    }
	
	public Arret(String libelle, String region) {
		super();
		this.libelle = libelle;
		this.region = region;
	}

	private Integer id ;
	private String libelle;	
	private String region;
	private List<Arretshaslignes> arrethslignes = new LinkedList<Arretshaslignes>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy ="pk.arret")
	public List<Arretshaslignes> getArrethslignes() {
		return arrethslignes;
	}

	public void setArrethslignes(List<Arretshaslignes> arrethslignes) {
		this.arrethslignes = arrethslignes;
	}

	@Id
	@GenericGenerator(name="generator",strategy="increment")
	@GeneratedValue(generator ="generator")
	@Column(name="ARRET_ID", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="LIBELLE")
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Column(name="REGION")
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	@Override
	public String toString() {
		return "Arret: " + this.id + ", " + this.libelle + ", " + this.region;
	}
	
}