package com.intiformation.tpjpa.managedBean;



import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.intiformation.tpjpa.entity.Cargaison;
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
	

	public List<Cargaison> getCargaisonsAeriennes() {
		return service.recupererCargaisonAerienne();
	}
	
	public List<Cargaison> getCargaisonsRoutieres() {
		return service.recupererCargaisonRoutiere();
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
	

}
