package com.intiformation.tpjpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "aerienne")
@DiscriminatorValue("Aerienne")
public class CargaisonAerienne extends Cargaison{

	/*_________________ props ________________*/
	
	@Column(name = "poids_maximal")
	private double poidsMaximal;
	
	/*_________________ ctors ________________*/
	
	/**
	 * ctor vide
	 */
	public CargaisonAerienne() {
		super();
	}
	
	public CargaisonAerienne(String nomCargaison, double distance, String dateLivraison, double poidsMaximal) {
		super(nomCargaison, distance, dateLivraison);
		this.poidsMaximal = poidsMaximal;
	}

	/*_________________ meths ________________*/

	@Override
	public String toString() {
		return "CargaisonAerienne [ "+super.toString() + ", poidsMaximal=" + poidsMaximal + "]";
	}

	
	/*__________________ G/S _________________*/
	
	/**
	 * @return the poidsMaximal
	 */
	public double getPoidsMaximal() {
		return poidsMaximal;
	}

	
	/**
	 * @param poidsMaximal the poidsMaximal to set
	 */
	public void setPoidsMaximal(double poidsMaximal) {
		this.poidsMaximal = poidsMaximal;
	}
	
}
