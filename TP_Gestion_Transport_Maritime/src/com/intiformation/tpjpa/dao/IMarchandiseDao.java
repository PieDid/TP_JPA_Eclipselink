package com.intiformation.tpjpa.dao;

import java.util.List;

public interface IMarchandiseDao<Marchandise> {
	

	public void addMarchandise(Marchandise marchandise);

	public void updateMarchandise(Marchandise marchandise);

	public void deleteMarchandise(Long idMarchandise);

	public Marchandise getById(Long idMarchandise);

	public List<Marchandise> getAllMarchandise();
	
	public List<Marchandise> getMarchandiseByIdCargaison();
	
	public Long countMarchandise();
	
	
}//end interface
