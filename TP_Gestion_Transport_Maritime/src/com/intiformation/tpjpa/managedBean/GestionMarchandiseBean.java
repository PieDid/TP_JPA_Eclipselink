package com.intiformation.tpjpa.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.intiformation.tpjpa.entity.Marchandise;
import com.intiformation.tpjpa.service.IService;
import com.intiformation.tpjpa.service.Service;

@ManagedBean(name = "gestionMarchandise")
@SessionScoped
public class GestionMarchandiseBean implements Serializable {

	/* Propriétés */
	
	List<Marchandise> listeMarchandise;
	Marchandise marchandise;
	
	IService service;
	
	/* Constructeurs */

	public GestionMarchandiseBean() {
		service = new Service();
	}
	
	/*_________________ meths ________________*/
	
	public List<Marchandise> getAllMarchandise() {
		return service.recupererToutesMarchandises();
	}
	
	public void initMarchandise(ActionEvent event) {
		setMarchandise(new Marchandise());	
	}
	

	public void setMarchandise(ActionEvent event) {
		
			UIParameter cp = (UIParameter) event.getComponent().findComponent("setID");

			Long idMarchandise = (Long) cp.getValue();

			setMarchandise(service.recupererMarchandiseParId(idMarchandise));
	}
	
	
	public void deleteMarchandise(ActionEvent event) {

		UIParameter cp = (UIParameter) event.getComponent().findComponent("deleteID");

		 Long idMarchandise = (long) cp.getValue();

		FacesContext contextJSF = FacesContext.getCurrentInstance();

		service.supprimerMarchandise(idMarchandise);

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


}
