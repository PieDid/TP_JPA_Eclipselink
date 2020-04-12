package com.intiformation.tpjpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe entité.
 * Classe fille de Cargaison.
 * @author IN-DF-028
 *
 */

@Entity(name = "routiere")
@DiscriminatorValue("Routiere")
public class CargaisonRoutiere extends Cargaison{

	/*_________________ props ________________*/
	
	@Column(name = "temperature_conservation")
	private double temperatureConservation;
	
	/*_________________ ctors ________________*/
	
	/**
	 * ctor vide
	 */
	public CargaisonRoutiere() {
		super();
	}

	public CargaisonRoutiere(String nomCargaison, double distance, String dateLivraison, double temperatureConservation) {
		super(nomCargaison, distance, dateLivraison);
		this.temperatureConservation = temperatureConservation;
	}

	/*_________________ meths ________________*/
	
	@Override
	public String toString() {
		return "CargaisonRoutiere [ "+ super.toString() + ", temperatureConservation=" + temperatureConservation + "]";
	}


	/*__________________ G/S _________________*/
	
	
	/**
	 * @return the temperatureConservation
	 */
	public double getTemperatureConservation() {
		return temperatureConservation;
	}

	/**
	 * @param temperatureConservation the temperatureConservation to set
	 */
	public void setTemperatureConservation(double temperatureConservation) {
		this.temperatureConservation = temperatureConservation;
	}
	
}
