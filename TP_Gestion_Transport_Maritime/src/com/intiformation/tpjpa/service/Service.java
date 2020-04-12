package com.intiformation.tpjpa.service;

import java.util.List;

import com.intiformation.tpjpa.dao.CargaisonAerienneDaoImpl;
import com.intiformation.tpjpa.dao.CargaisonDaoImpl;
import com.intiformation.tpjpa.dao.CargaisonRoutiereDaoImpl;
import com.intiformation.tpjpa.dao.ICargaisonDao;
import com.intiformation.tpjpa.dao.IMarchandiseDao;
import com.intiformation.tpjpa.dao.IUtilisateurDao;
import com.intiformation.tpjpa.dao.MarchandiseDaoImpl;
import com.intiformation.tpjpa.dao.UtilisateurDaoImpl;
import com.intiformation.tpjpa.entity.Cargaison;
import com.intiformation.tpjpa.entity.CargaisonAerienne;
import com.intiformation.tpjpa.entity.CargaisonRoutiere;
import com.intiformation.tpjpa.entity.Marchandise;
import com.intiformation.tpjpa.entity.Utilisateur;

public class Service implements IService {

	/* ___________________ DAOs _____________________________ */
	
	IUtilisateurDao utilisateurDao = new UtilisateurDaoImpl();
	IMarchandiseDao<Marchandise> marchandiseDao = new MarchandiseDaoImpl();
	ICargaisonDao cargaisonDao = new CargaisonDaoImpl();
	CargaisonAerienneDaoImpl cargaisonAerienneDao = new CargaisonAerienneDaoImpl();
	CargaisonRoutiereDaoImpl CargaisonRoutiereDao = new CargaisonRoutiereDaoImpl();
	
	/* ___________________ Méthodes _____________________________ */

	/////////////////////// UTILISATEUR //////////////////////////
	
	/**
	 * Permet d'ajouter un utilisateur
	 * @param utilisateur : l'utilisateur à ajouter
	 */
	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		utilisateurDao.addUtilisateur(utilisateur);
	}
	
	/**
	 * vérifie l'existence de l'utilisateur dans la BDD via son mail et son mdp
	 * @param mail : le mail de l'utilisateur dont il faut verifier l'existence
	 * @param mdp : le mdp de l'utilisateur dont il faut verifier l'existence
	 * @return : true si il existe, false sinon
	 */
	@Override
	public boolean utilisateurExiste(String mail, String mdp) {
		return utilisateurDao.isUtilisateurExists(mail, mdp);
	}

	/**
	 * recupere l'utisisateur via son id
	 * @param idUtilisateur : l'id de l'utilisateur à retrouver
	 * @return : l'utilisateur possedant l'id idUtilisateur
	 */
	@Override
	public Utilisateur recupererUtilisateurParId(Long idUtilisateur) {
		return utilisateurDao.getUtilisateurById(idUtilisateur);
	}

	/**
	 * recupere l'utisisateur via son mail
	 * @param mail : le mail de l'utilisateur à retrouver
	 * @return : l'utilisateur possedant le mail donné
	 */
	@Override
	public Utilisateur recupererUtilisateurParMail(String mail) {
		return utilisateurDao.getUtilisateurByMail(mail);
	}
	
	/////////////////////// MARCHANDISES //////////////////////////
	
	/**
	 * ajoute une marchandise
	 * @param marchandise : marchandise a ajouter
	 */
	@Override
	public void ajouterMarchandise(Marchandise marchandise) {
		marchandiseDao.addMarchandise(marchandise);
	}
	
	/**
	 * modifie une marchandise
	 * @param marchandise : marchandise a modifier
	 */
	@Override
	public void modifierMarchandise(Marchandise marchandise) {
		marchandiseDao.updateMarchandise(marchandise);
	}
	
	/**
	 * supprime une marchandise
	 * @param idMarchandise : id de la marchandise à supprimer
	 */
	@Override
	public void supprimerMarchandise(Long idMarchandise) {
		marchandiseDao.deleteMarchandise(idMarchandise);
	}
	
	/**
	 * recupere toutes les marchandises
	 * @return : liste des marchandises
	 */
	@Override
	public List<Marchandise> recupererToutesMarchandises() {
		return marchandiseDao.getAllMarchandise();
	}
	
	/**
	 * récupère une marchandise par son id
	 * @param idMarchandise : id de la marchandise a récuperer
	 * @return : la marchandise avec l'id idMarchandise
	 */
	@Override
	public Marchandise recupererMarchandiseParId(Long idMarchandise) {
		return marchandiseDao.getById(idMarchandise);
	}
	
	/**
	 * retourne le poids total des marchandise d'une cargaison
	 * @param idMarchandise : l'id de la cargaison
	 * @return : le poids total de la cargaison avec l'id idCargaison
	 */
	@Override
	public double poidsTotal(Cargaison cargaison) {
		return marchandiseDao.poidsTotal(cargaison);
	}
	
	/**
	 * retourne le volume total des marchandises d'une cargaison
	 * @param idCargaison : l'id de la cargaison
	 * @return : le volume total de la cargaison avec l'id idCargaison
	 */
	@Override
	public double volumeTotal(Cargaison cargaison) {
		return marchandiseDao.volumeTotal(cargaison);
	}
	
	/**
	 * récupère la liste des marchandises d'une cargaison
	 * @param idCargaison : l'id de la cargaison 
	 * @return : la liste des marchandise de la cargaison avec l'id idCargaison
	 */
	@Override
	public List<Marchandise> recupererToutesMarchandisesParIdCargaison(Cargaison cargaison) {
		return marchandiseDao.getMarchandiseByIdCargaison(cargaison);
	}
	
	/////////////////////// CARGAISONS //////////////////////////
	
	/**
	 * ajoute une cargaison aerienne
	 * @param cargaisonAerienne : la cargaison aerienne a ajouter
	 */
	@Override
	public void ajouterCargaisonAerienne(CargaisonAerienne cargaisonAerienne) {
		cargaisonAerienneDao.addCargaisonAerienne(cargaisonAerienne);
	}
	
	/**
	 * modifie une cargaison aerienne
	 * @param cargaisonAerienne : la cargaison aerienne a modifier
	 */
	@Override
	public void modifierCargaisonAerienne(CargaisonAerienne cargaisonAerienne) {
		cargaisonAerienneDao.updateCargaisonAerienne(cargaisonAerienne);
	}
	
	/**
	 * ajoute une cargaison routiere
	 * @param cargaisonRoutiere : la cargaison routiere a ajouter
	 */
	@Override
	public void ajouterCargaisonRoutiere(CargaisonRoutiere cargaisonRoutiere) {
		CargaisonRoutiereDao.addCargaisonRoutiere(cargaisonRoutiere);
	}
	
	/**
	 * modifie une cargaison routiere
	 * @param cargaisonRoutiere : la cargaison routiere a modifier
	 */
	@Override
	public void modifierCargaisonRoutiere(CargaisonRoutiere cargaisonRoutiere) {
		CargaisonRoutiereDao.updateCargaisonRoutiere(cargaisonRoutiere);
	}
	
	/**
	 * Supprime une cargaison par son id
	 * @param idCargaison : id de la cargaison a supprimer
	 */
	@Override
	public void supprimerCargaion(Long idCargaison) {
		cargaisonDao.deleteCargaison(idCargaison);
	}
	
	/**
	 * Récupère la liste des cargaisons
	 * @return : la liste de toutes les cargaisons
	 */
	@Override
	public List<Cargaison> recupererToutesCargaisons() {
		return cargaisonDao.getAllCargaison();
	}
	
	/**
	 * récupère une cargaiosn par son id
	 * @param idCargaison : l'id de la cargaison à récuperer
	 * @return : la cargaison avec l'id idCargaison
	 */
	@Override
	public Cargaison recupererCargaisonParId(Long idCargaison) {
		return cargaisonDao.getById(idCargaison);
	}
	
	/**
	 * Renvoie le coût de la cargaison par son id
	 * @param idCargaison : id de la cargaison dont le cout est a évaluer
	 * @return : le cout de la cargaison avec l'id idCargaison
	 */
	@Override
	public double coutCargaison(Long idCargaison) {
		
		// récupération de la cargaison
		Cargaison cargaison = cargaisonDao.getById(idCargaison);
		
		// cout = a * distance * poids_marchandise
		double cout = cargaison.getDistance() * poidsTotal(cargaison);
		
		
		if(cargaison.getClass().equals(CargaisonRoutiere.class)){
	
			// --> la cargaison est une cargaiosn routiere
			
			// test du volume de la cargaison
			if(volumeTotal(cargaison) < 380000) {
				// V < 380000 => a = 4
				cout *= 4.0;	
			} else {
				// V >= 380000 => a = 6
				cout *= 6.0;
			}
			
		}
		else {
			
			// --> la cargaison est une cargaison aerienne
			
			// test du volume de la cargaison
			if(volumeTotal(cargaison) < 80000) {
				// V < 80000 => a = 10
				cout *= 10.0;	
			} else {
				// V >= 80000 => a = 12
				cout *= 12.0;
			}
		}
		
		// on retourne le cout
		return cout;
	}

	

}
