package com.intiformation.tpjpa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe Mère de CargaisonAerienne et CargaisonRoutiere.
 * 
 * Groupement dans une seule table
 * @author IN-DF-028 : Pierrick Flaux
 */

@Entity(name = "cargaison")
@Table(name = "cargaisons") // nom de la table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // une seule table pour gérer l'héritage
@DiscriminatorColumn(name = "Type_cargaison", discriminatorType = DiscriminatorType.STRING) // colonne discriminante
public abstract class Cargaison implements Serializable{
	
	/*_________________ props ________________*/

	@Id
	@Column(name = "id_cargaison")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
	private Long idCargaison;
	
	@Column(name = "nom_cargaison")
	private String nomCargaison;
	
	@Column(name = "distance")
	private double distance;
	
	@Column(name ="date_livraison")
	private Date dateLivraison;
	
	/*============ Association Cargaison à Marchandise ========*/
	@OneToMany(mappedBy = "cargaison", cascade = CascadeType.ALL)
	private List<Marchandise> listeMarchandise;
	
	/*_________________ ctors ________________*/

	/**
	 * ctor par défaut
	 */
	public Cargaison() {
	}
	
	/**
	 * ctor sans PK
	 * @param nomCargaison
	 * @param distance
	 * @param dateLivraison
	 */
	public Cargaison(String nomCargaison, double distance, Date dateLivraison) {
		super();
		this.nomCargaison = nomCargaison;
		this.distance = distance;
		this.dateLivraison = dateLivraison;
	}


	/**
	 * ctor avec paramètres
	 * @param idCargaison
	 * @param nomCargaison
	 * @param distance
	 * @param dateLivraison
	 */
	public Cargaison(Long idCargaison, String nomCargaison, double distance, Date dateLivraison) {
		this.idCargaison = idCargaison;
		this.nomCargaison = nomCargaison;
		this.distance = distance;
		this.dateLivraison = dateLivraison;
	}

	/*_________________ meths ________________*/

	/*__________________ G/S _________________*/

	/**
	 * @return the idCargaison
	 */
	public Long getIdCargaison() {
		return idCargaison;
	}

	/**
	 * @param idCargaison the idCargaison to set
	 */
	public void setIdCargaison(Long idCargaison) {
		this.idCargaison = idCargaison;
	}

	/**
	 * @return the nomCargaison
	 */
	public String getNomCargaison() {
		return nomCargaison;
	}

	/**
	 * @param nomCargaison the nomCargaison to set
	 */
	public void setNomCargaison(String nomCargaison) {
		this.nomCargaison = nomCargaison;
	}

	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * @return the dateLivraison
	 */
	public Date getDateLivraison() {
		return dateLivraison;
	}

	/**
	 * @param dateLivraison the dateLivraison to set
	 */
	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	/**
	 * @return the listeMarchandise
	 */
	public List<Marchandise> getListeMarchandise() {
		return listeMarchandise;
	}

	/**
	 * @param listeMarchandise the listeMarchandise to set
	 */
	public void setListeMarchandise(List<Marchandise> listeMarchandise) {
		this.listeMarchandise = listeMarchandise;
	}
	
}
