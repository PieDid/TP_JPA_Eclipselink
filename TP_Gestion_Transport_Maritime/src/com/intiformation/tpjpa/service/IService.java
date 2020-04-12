package com.intiformation.tpjpa.service;

import java.util.List;

import com.intiformation.tpjpa.entity.Cargaison;
import com.intiformation.tpjpa.entity.CargaisonAerienne;
import com.intiformation.tpjpa.entity.CargaisonRoutiere;
import com.intiformation.tpjpa.entity.Marchandise;
import com.intiformation.tpjpa.entity.Utilisateur;

public interface IService {
	
	/////////////////////// UTILISATEUR //////////////////////////
	
	/**
	 * Permet d'ajouter un utilisateur
	 * @param utilisateur : l'utilisateur à ajouter
	 */
	public void ajouterUtilisateur(Utilisateur utilisateur);
	
	/**
	 * vérifie l'existence de l'utilisateur dans la BDD via son mail et son mdp
	 * @param mail : le mail de l'utilisateur dont il faut verifier l'existence
	 * @param mdp : le mdp de l'utilisateur dont il faut verifier l'existence
	 * @return : true si il existe, false sinon
	 */
	public boolean utilisateurExiste(String mail, String mdp);
	
	/**
	 * recupere l'utisisateur via son id
	 * @param idUtilisateur : l'id de l'utilisateur à retrouver
	 * @return : l'utilisateur possedant l'id idUtilisateur
	 */
	public Utilisateur recupererUtilisateurParId(Long idUtilisateur);
	
	/**
	 * recupere l'utisisateur via son mail
	 * @param mail : le mail de l'utilisateur à retrouver
	 * @return : l'utilisateur possedant le mail donné
	 */
	public Utilisateur recupererUtilisateurParMail(String mail);
	
	/////////////////////// MARCHANDISES //////////////////////////
	
	/**
	 * ajoute une marchandise
	 * @param marchandise : marchandise a ajouter
	 */
	public void ajouterMarchandise(Marchandise marchandise);
	
	/**
	 * modifie une marchandise
	 * @param marchandise : marchandise a modifier
	 */
	public void modifierMarchandise(Marchandise marchandise);
	
	/**
	 * supprime une marchandise
	 * @param idMarchandise : id de la marchandise à supprimer
	 */
	public void supprimerMarchandise(Long idMarchandise);
	
	/**
	 * recupere toutes les marchandises
	 * @return : liste des marchandises
	 */
	public List<Marchandise> recupererToutesMarchandises();
	
	/**
	 * récupère une marchandise par son id
	 * @param idMarchandise : id de la marchandise a récuperer
	 * @return : la marchandise avec l'id idMarchandise
	 */
	public Marchandise recupererMarchandiseParId(Long idMarchandise);
	
	/**
	 * retourne le poids total des marchandise d'une cargaison
	 * @param idMarchandise : l'id de la cargaison
	 * @return : le poids total de la cargaison avec l'id idCargaison
	 */
	public double poidsTotal(Cargaison cargaison);
	
	/**
	 * retourne le volume total des marchandises d'une cargaison
	 * @param idCargaison : l'id de la cargaison
	 * @return : le volume total de la cargaison avec l'id idCargaison
	 */
	public double volumeTotal(Cargaison cargaison);
	
	/**
	 * récupère la liste des marchandises d'une cargaison
	 * @param idCargaison : l'id de la cargaison 
	 * @return : la liste des marchandise de la cargaison avec l'id idCargaison
	 */
	public List<Marchandise> recupererToutesMarchandisesParIdCargaison(Cargaison cargaison);
	
	/////////////////////// CARGAISONS //////////////////////////
	
	/**
	 * ajoute une cargaison aerienne
	 * @param cargaisonAerienne : la cargaison aerienne a ajouter
	 */
	public void ajouterCargaisonAerienne(CargaisonAerienne cargaisonAerienne);
	
	/**
	 * modifie une cargaison aerienne
	 * @param cargaisonAerienne : la cargaison aerienne a modifier
	 */
	public void modifierCargaisonAerienne(CargaisonAerienne cargaisonAerienne);
	
	/**
	 * ajoute une cargaison routiere
	 * @param cargaisonRoutiere : la cargaison routiere a ajouter
	 */
	public void ajouterCargaisonRoutiere(CargaisonRoutiere cargaisonRoutiere);
	
	/**
	 * modifie une cargaison routiere
	 * @param cargaisonRoutiere : la cargaison routiere a modifier
	 */
	public void modifierCargaisonRoutiere(CargaisonRoutiere cargaisonRoutiere);
	
	/**
	 * Supprime une cargaison par son id
	 * @param idCargaison : id de la cargaison a supprimer
	 */
	public void supprimerCargaion(Long idCargaison);
	
	/**
	 * Récupère la liste des cargaisons
	 * @return : la liste de toutes les cargaisons
	 */
	public List<Cargaison> recupererToutesCargaisons();
	
	/**
	 * récupère une cargaiosn par son id
	 * @param idCargaison : l'id de la cargaison à récuperer
	 * @return : la cargaison avec l'id idCargaison
	 */
	public Cargaison recupererCargaisonParId(Long idCargaison);
	
	/**
	 * Renvoie le coût de la cargaison par son id
	 * @param idCargaison : id de la cargaison dont le cout est a évaluer
	 * @return : le cout de la cargaison avec l'id idCargaison
	 */
	public double coutCargaison(Long idCargaison);

}
