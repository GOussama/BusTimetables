package com.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ARRET_LIGNE")
@AssociationOverrides({
@AssociationOverride(name ="pk.arret", joinColumns = @JoinColumn(name ="arret_id")),
@AssociationOverride(name ="pk.ligne", joinColumns = @JoinColumn(name ="ligne_id"))
        })
public class Arretshaslignes {

	private LigneshasarretsId pk = new LigneshasarretsId();

	@EmbeddedId
	public LigneshasarretsId getPk() {
		return pk;
	}

	public void setPk(LigneshasarretsId pk) {
		this.pk = pk;
	}
	
	
	@Transient // tell hibernate to not create the column 
	public Ligne getLigne(){
		return getPk().getLigne();
	}

	@Transient
	public Arret getArret(){
		return getPk().getArret();
	}

	
	@Column(name="DIRECTION")
	private String direction;
	
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

	@Column(name="HOR_NORM")
	private String horraireNormale;
	
	@Column(name="HOR_FER")
	private String horraireDimFer;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="ARRETID", referencedColumnName="ARRET_ID")
	private Arret arret;
	

	@ManyToOne
	@PrimaryKeyJoinColumn(name="LIGNEID", referencedColumnName="LIGNE_ID")
	private Ligne ligne;
	
	public boolean equals(Object o) {
        if (this== o) return true;
        if (o ==null|| getClass() != o.getClass()) return false;
 
        Arretshaslignes that = (Arretshaslignes) o;
 
        if (getPk() !=null?!getPk().equals(that.getPk()) : that.getPk() !=null) return false;
 
        return  true;
    }
 
    public int hashCode() {
        return (getPk() !=null? getPk().hashCode() : 0);
    }
	
    @Override
	public String toString() {
		return "Arret has ligne: " + this.pk.toString() + ", " + this.direction + ", " + this.horraireNormale + ", " + this.horraireDimFer;
	}
}
