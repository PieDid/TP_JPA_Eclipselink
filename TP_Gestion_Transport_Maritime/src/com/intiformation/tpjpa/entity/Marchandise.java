package com.intiformation.tpjpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="marchandise")
@Table(name="marchandises")
public class Marchandise implements Serializable {
	
	/* Propriétés */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="numéro_marchandise")
	private Long idMarchandise;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name="poids")
	private double poids;
	
	@Column(name="volume")
	private double volume;
	
	@Column(name="quantité")
	private int quantite;
	
	/* Association avec Cargaison */

	@ManyToOne
	@JoinColumn(name = "cargaison_id", referencedColumnName = "idCargaison")
	private Cargaison cargaison;
	
	/* Constructeurs */

	public Marchandise() {
	}


	public Marchandise(String nom, double poids, double volume, int quantite) {
		this.nom = nom;
		this.poids = poids;
		this.volume = volume;
		this.quantite = quantite;
	}

	public Marchandise(Long idMarchandise, String nom, double poids, double volume, int quantite) {
		this.idMarchandise = idMarchandise;
		this.nom = nom;
		this.poids = poids;
		this.volume = volume;
		this.quantite = quantite;
	}
	
	
	/* Getters et Setters */

	public Long getIdMarchandise() {
		return idMarchandise;
	}

	public void setIdMarchandise(Long idMarchandise) {
		this.idMarchandise = idMarchandise;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	
	

	public Cargaison getCargaison() {
		return cargaison;
	}

	public void setCargaison(Cargaison cargaison) {
		this.cargaison = cargaison;
	}

	@Override
	public String toString() {
		return "Marchandise [idMarchandise=" + idMarchandise + ", nom=" + nom + ", poids=" + poids + ", volume="
				+ volume + "]";
	}
	
	

}//end class
