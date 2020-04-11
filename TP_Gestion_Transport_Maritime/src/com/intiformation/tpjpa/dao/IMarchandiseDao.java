package com.intiformation.tpjpa.dao;

import java.util.List;

import com.intiformation.tpjpa.entity.Cargaison;

public interface IMarchandiseDao<Marchandise> {
	

	public void addMarchandise(Marchandise marchandise);

	public void updateMarchandise(Marchandise marchandise);

	public void deleteMarchandise(Long idMarchandise);

	public Marchandise getById(Long idMarchandise);

	public List<Marchandise> getAllMarchandise();
	
	public List<Marchandise> getMarchandiseByIdCargaison(Cargaison cargaison);
	
	public Long countMarchandise();
	
	public double poidsTotal(Long idCargaison);
	
	public double volumeTotal(Long idCargaison);

	
	
	
}//end interface
