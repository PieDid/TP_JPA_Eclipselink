package com.intiformation.tpjpa.managedBean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.intiformation.tpjpa.entity.Utilisateur;
import com.intiformation.tpjpa.service.IService;
import com.intiformation.tpjpa.service.Service;



@ManagedBean(name = "authentificationBean")
@SessionScoped
public class AuthentificationBean implements Serializable {

	/* _______________________ props ___________________________ */

	// les propiétés pour la connection
	private String mail;
	private String mdp;
	private Utilisateur utilisateurSession;
	// la couche service
	public IService service = new Service();
	
	/* ______________________ méthodes _________________________ */

	/**
	 * Méthode qui permet au conseiller de se connecter
	 * 
	 * @return
	 */
	public String connecter() {
		
		// context de JSF pour récupérer la session, la créer et envoyer des messages
		FacesContext contextJSF = FacesContext.getCurrentInstance();

		// 1. verif si le conseiller existe dans la bdd
		if (service.utilisateurExiste(mail, mdp)) {

			// ------------------- l'utilisateur existe ---------------------//

			utilisateurSession = service.recupererUtilisateurParMail(mail);
			
			/* création de la session pour l'utilisateur => création d'un id de session */
			HttpSession session = (HttpSession) contextJSF.getExternalContext().getSession(true);
			
			/* sauvegarde du login dans la session */
			session.setAttribute("user_mail", mail);
			
			/* redirection (navigation) vers la page accueil.xhtml */
			return "accueil.xhtml";

		} else {

			// ---------------- l'utilisateur n'existe pas ------------------//
			/**
			 * Envoi d'un message vers la vue via la classe FacesMessage et le context
			 */

			// def du message via FacesMessage
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Echec de connexion",
					"Identifiant ou Mot de passe invalide");

			// envoi du message vers la vue via le context de JSF

			/**
			 * addMessage(String, FacesMessage) : - String : soit l'id du composant (
			 * message pour ce composant) ou null (message pour l'ensemble de la page )
			 */
			contextJSF.addMessage(null, message);

			/* redirection (navigation) vers la page du formulaire authentification.xhtml */
			return "authentification.xhtml";

		} // end else

	} // end connecter()

	public String deconnecter() {

		// context de JSF
		FacesContext contextJSF = FacesContext.getCurrentInstance();

		// recup de la session de l'utilisateur
		HttpSession session = (HttpSession) contextJSF.getExternalContext().getSession(false);

		// déconnection
		session.invalidate();

		/* redirection (navigation) vers la page du formulaire authentification.xhtml */
		return "authentification.xhtml";

	} // end deconnecter()

	
	/* __________________ getters/setters __________________________ */
	
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

	/**
	 * @return the utilisateurSession
	 */
	public Utilisateur getUtilisateurSession() {
		return utilisateurSession;
	}

	/**
	 * @param utilisateurSession the utilisateurSession to set
	 */
	public void setUtilisateurSession(Utilisateur utilisateurSession) {
		this.utilisateurSession = utilisateurSession;
	}

	
}