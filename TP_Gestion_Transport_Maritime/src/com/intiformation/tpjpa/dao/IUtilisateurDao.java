package com.intiformation.tpjpa.dao;

import com.intiformation.tpjpa.entity.Utilisateur;

/**
 * DAO de l'utilisateur
 * @author IN-DF-028
 *
 */
public interface IUtilisateurDao {
	
	public void addUtilisateur(Utilisateur utilisateur);
	
	public boolean isUtilisateurExists(String mail, String mdp);
	
	public Utilisateur getUtilisateurById(Long idUtilisateur);
	
	public Utilisateur getUtilisateurByMail(String mail);

}
