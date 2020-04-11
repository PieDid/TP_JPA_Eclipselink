package com.intiformation.tpjpa.dao;

import java.util.List;

import com.intiformation.tpjpa.entity.Cargaison;

/**
 * Interface de la couche DAO de la cargaison
 * @author IN-DF-028
 *
 */
public interface ICargaisonDao {
	
	public void deleteCargaison(Long idCargaison);

	public Cargaison getById(Long idCargaison);

	public List<Cargaison> getAllCargaison();
	
}
