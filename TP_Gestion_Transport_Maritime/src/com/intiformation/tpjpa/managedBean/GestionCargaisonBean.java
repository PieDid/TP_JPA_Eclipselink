package com.intiformation.tpjpa.managedBean;



import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.intiformation.tpjpa.entity.Cargaison;
import com.intiformation.tpjpa.entity.CargaisonAerienne;
import com.intiformation.tpjpa.entity.CargaisonRoutiere;
import com.intiformation.tpjpa.entity.Marchandise;
import com.intiformation.tpjpa.service.IService;
import com.intiformation.tpjpa.service.Service;

/**
 * managed bean pourgerer les cargaisons
 * @author IN-DF-028
 *
 */

@ManagedBean(name = "gestionCargaison")
@SessionScoped
public class GestionCargaisonBean implements Serializable{
	
	/*_________________ props ________________*/
	
	List<Cargaison> listeCargaison;
	Cargaison cargaison;

	//service
	IService service;
	
	/*_________________ ctors ________________*/

	/**
	 * ctor vide pour pouvoir instancier le bean
	 */
	public GestionCargaisonBean() {
		service = new Service();
	}
	
	/*_________________ meths ________________*/
	
	public List<Cargaison> getAllCargaisons() {
		return service.recupererToutesCargaisons();
	}
	
	public List<Marchandise> getAllMarchandiseByCargaison(Cargaison cargaison){
		return service.recupererToutesMarchandisesParIdCargaison(cargaison);
	}

	public List<Cargaison> getCargaisonsAeriennes() {
		return service.recupererCargaisonAerienne();
	}
	
	public List<Cargaison> getCargaisonsRoutieres() {
		return service.recupererCargaisonRoutiere();
	}
	
	public Double getVolumeTotal(Cargaison cargaison) {
		return service.volumeTotal(cargaison);
	}
	
	public Double getPoidsTotal(Cargaison cargaison) {
		return service.poidsTotal(cargaison);
	}
	
	public Double getCout(Long idCargaison) {
		return service.coutCargaison(idCargaison);
	}
	
	public void initialiserCargaisonAerienne(ActionEvent event) {
		setCargaison(new CargaisonAerienne());	
	}
	
	public void initialiserCargaisonRoutiere(ActionEvent event) {
		setCargaison(new CargaisonRoutiere());	
	}
	
	
	public void choisirCargaison(ActionEvent event) {
		
			UIParameter cp = (UIParameter) event.getComponent().findComponent("choixID");

			Long idCargaison = (Long) cp.getValue();

			setCargaison(service.recupererCargaisonParId(idCargaison));
	}
	
	
	////////////////////////////////////////////////////////////
	
	public void supprimerCargaison(ActionEvent event) {

		UIParameter cp = (UIParameter) event.getComponent().findComponent("deleteID");

		 Long idCargaison = (long) cp.getValue();

		FacesContext contextJSF = FacesContext.getCurrentInstance();

		service.supprimerCargaion(idCargaison);

	} // end supprimerCompte()
	
	
	public void ajouterCargaisonAerienne(ActionEvent event) {
		
		service.ajouterCargaisonAerienne((CargaisonAerienne) cargaison);
		
	}
	
	public void ajouterCargaisonRoutiere(ActionEvent event) {
		
		service.ajouterCargaisonRoutiere((CargaisonRoutiere) cargaison);
		
	}
	
	public void modifierCargaison(ActionEvent event) {
		
		
		if(cargaison.getClass().equals(CargaisonAerienne.class))
			service.modifierCargaisonAerienne((CargaisonAerienne) cargaison);
		else 
			service.modifierCargaisonRoutiere((CargaisonRoutiere) cargaison);
	}
	
	/*__________________ G/S _________________*/
	
	/**
	 * @return the listeCargaison
	 */
	public List<Cargaison> getListeCargaison() {
		return listeCargaison;
	}

	/**
	 * @param listeCargaison the listeCargaison to set
	 */
	public void setListeCargaison(List<Cargaison> listeCargaison) {
		this.listeCargaison = listeCargaison;
	}

	/**
	 * @return the cargaison
	 */
	public Cargaison getCargaison() {
		return cargaison;
	}

	/**
	 * @param cargaison the cargaison to set
	 */
	public void setCargaison(Cargaison cargaison) {
		this.cargaison = cargaison;
	}


}
