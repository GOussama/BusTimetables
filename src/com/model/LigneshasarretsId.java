package com.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class LigneshasarretsId implements Serializable {

	
		
	@Override
	public String toString() {
		return "LigneshasarretsId [arret=" + this.arret + ", ligne=" + this.ligne + "]";
	}

	private Arret arret;	
	private Ligne ligne;
	
	
	@ManyToOne
	public Ligne getLigne() {
		return ligne;
	}

	public void setLigne(Ligne ligne) {
		this.ligne = ligne;
	}


	
	
	@ManyToOne
	public Arret getArret(){
		return arret;
	}
	
	public void setArret(Arret arret) {
		this.arret = arret;
	}

	
	

    public boolean equals(Object o) {
        if (this== o) return true;
        if (o ==null|| getClass() != o.getClass()) return false;
 
        LigneshasarretsId that = (LigneshasarretsId) o;
 
        if (arret !=null?!arret.equals(that.arret) : that.arret !=null) return false;
        if (ligne !=null?!ligne.equals(that.ligne) : that.ligne !=null)
            return false;
 
        return true;
    }
 
    public int hashCode() {
        int result;
        result = (arret !=null? arret.hashCode() : 0);
        result =31* result + (ligne !=null? ligne.hashCode() : 0);
        return result;
    }
	 
	
	
}
