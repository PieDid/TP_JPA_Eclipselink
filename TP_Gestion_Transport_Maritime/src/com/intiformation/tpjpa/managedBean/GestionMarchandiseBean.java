package com.intiformation.tpjpa.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.intiformation.tpjpa.entity.CargaisonAerienne;
import com.intiformation.tpjpa.entity.CargaisonRoutiere;
import com.intiformation.tpjpa.entity.Marchandise;
import com.intiformation.tpjpa.service.IService;
import com.intiformation.tpjpa.service.Service;

@ManagedBean(name = "gestionMarchandise")
@SessionScoped
public class GestionMarchandiseBean implements Serializable {

	/* Propriétés */
	
	List<Marchandise> listeMarchandise;
	Marchandise marchandise;
	
	Long carAId;
	
	Long carRId;
	
	IService service;
	
	/* Constructeurs */

	public GestionMarchandiseBean() {
		service = new Service();
	}
	
	/* Méthodes */
	
	public List<Marchandise> getAllMarchandise() {
		return service.recupererToutesMarchandises();
	}
	
	public void initMarchandise(ActionEvent event) {
		setMarchandise(new Marchandise());	
	}
	

	public void setMarchandise(ActionEvent event) {
		
			UIParameter cp = (UIParameter) event.getComponent().findComponent("updateID");

			Long idMarchandise = (Long) cp.getValue();

			setMarchandise(service.recupererMarchandiseParId(idMarchandise));
	}
	
	

	
	public void addMarchandise(ActionEvent event) {
		
		FacesContext contextJsf = FacesContext.getCurrentInstance();
		
		service.ajouterMarchandise(marchandise);
			
	}
	
	public void updateMarchandise(ActionEvent event) {
		
		FacesContext contextJsf = FacesContext.getCurrentInstance();
		
		if(carAId != null) {marchandise.setCargaison(service.recupererCargaisonParId(carAId));}
		else if(carRId !=null) {marchandise.setCargaison(service.recupererCargaisonParId(carRId));}
		
		service.modifierMarchandise(marchandise);
		carAId= null;
		carRId= null;
			
	}
	
	public void deleteMarchandise(ActionEvent event) {

		UIParameter cp = (UIParameter) event.getComponent().findComponent("deleteID");

		Long idMarchandise = (long) cp.getValue();

		FacesContext contextJSF = FacesContext.getCurrentInstance();

		service.supprimerMarchandise(idMarchandise);

	} 
	
	public void deleteMarchandiseFromCargaison(Long idMarchandise) {
		FacesContext contextJSF = FacesContext.getCurrentInstance();
		marchandise = service.recupererMarchandiseParId(idMarchandise);
		marchandise.setCargaison(null);
		service.modifierMarchandise(marchandise);
	}
	
	/* Getters et Setters */
	

	public List<Marchandise> getListeMarchandise() {
		return listeMarchandise;
	}

	public void setListeMarchandise(List<Marchandise> listeMarchandise) {
		this.listeMarchandise = listeMarchandise;
	}

	public Marchandise getMarchandise() {
		return marchandise;
	}

	
	public void setMarchandise(Marchandise marchandise) {
		this.marchandise = marchandise;
	}

	/**
	 * @return the carAId
	 */
	public Long getCarAId() {
		return carAId;
	}

	/**
	 * @param carAId the carAId to set
	 */
	public void setCarAId(Long carAId) {
		this.carAId = carAId;
	}

	/**
	 * @return the carRId
	 */
	public Long getCarRId() {
		return carRId;
	}

	/**
	 * @param carRId the carRId to set
	 */
	public void setCarRId(Long carRId) {
		this.carRId = carRId;
	}

	

}
