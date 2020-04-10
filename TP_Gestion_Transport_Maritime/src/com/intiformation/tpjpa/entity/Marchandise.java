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
	private String poids;
	
	@Column(name="volume")
	private String volume;
	
	/* Association avec Cargaison */

	@ManyToOne
	@JoinColumn(name = "cargaison_id", referencedColumnName = "idCargaison")
	private Cargaison cargaison;
	
	
	/* Constructeurs */

	public Marchandise() {
	}

	public Marchandise(String nom, String poids, String volume) {
		this.nom = nom;
		this.poids = poids;
		this.volume = volume;
	}

	public Marchandise(Long idMarchandise, String nom, String poids, String volume) {
		this.idMarchandise = idMarchandise;
		this.nom = nom;
		this.poids = poids;
		this.volume = volume;
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

	public String getPoids() {
		return poids;
	}

	public void setPoids(String poids) {
		this.poids = poids;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
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
