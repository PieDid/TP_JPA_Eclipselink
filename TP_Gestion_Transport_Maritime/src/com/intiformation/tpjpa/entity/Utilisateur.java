package com.intiformation.tpjpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * classe entité de l'utilisateur. 
 * @author IN-DF-028
 *
 */

@Entity(name="utilisateur")
@Table(name="utilisateurs")
@NamedQueries({@NamedQuery(name="Utilisateur.isExists", query="SELECT COUNT(u.idUtilisateur) FROM utilisateur u WHERE u.mail = ?1 AND u.mdp = ?2")})

public class Utilisateur implements Serializable{

	/*_________________ props ________________*/
	@Id
	@Column(name = "id_utilisateur")
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
	private Long idUtilisateur;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "mail")
	private String mail;
	
	@Column(name = "mot_de_passe")
	private String mdp;

	/*_________________ ctors ________________*/
	
	/**
	 * ctor vide
	 */
	public Utilisateur() {}

	/**
	 * ctor sans id 
	 * @param nom : nom de l'utilisateur
	 * @param prenom : prénom de l'utilisateur
	 * @param mail : mail de l'utilisateur
	 * @param mdp : mot de passe de l'utilisateur
	 */
	public Utilisateur(String nom, String prenom, String mail, String mdp) {
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
	}

	/*_________________ meths ________________*/
	
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail
				+ ", mdp=" + mdp + "]";
	}

	/*__________________ G/S _________________*/
	
	
	/**
	 * @return the idUtilisateur
	 */
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * @param idUtilisateur the idUtilisateur to set
	 */
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
}
