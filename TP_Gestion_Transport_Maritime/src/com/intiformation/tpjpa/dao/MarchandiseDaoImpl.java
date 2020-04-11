package com.intiformation.tpjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.intiformation.tpjpa.entity.Cargaison;
import com.intiformation.tpjpa.entity.Marchandise;
import com.intiformation.tpjpa.tool.JpaUtil;

public class MarchandiseDaoImpl implements IMarchandiseDao<Marchandise> {

	
	protected EntityManager em = JpaUtil.getEntityManager();
	
	
	
	@Override
	public void addMarchandise(Marchandise marchandise) {
		
		EntityTransaction tx = null;

		try {

			tx = em.getTransaction();
			tx.begin();
			em.persist(marchandise);
			tx.commit();

		} catch (PersistenceException ex) {

			if (tx != null) {
				tx.rollback();
				ex.printStackTrace();
			}

		}
		
	}//end add

	@Override
	public void updateMarchandise(Marchandise marchandise) {
		
		EntityTransaction tx = null;

		try {

			tx = em.getTransaction();
			tx.begin();
			em.merge(marchandise);
			tx.commit();

		} catch (PersistenceException ex) {

			if (tx != null) {
				tx.rollback();
				ex.printStackTrace();
			}

		}
		
	}//end update

	@Override
	public void deleteMarchandise(Long idMarchandise) {
		
		
		EntityTransaction tx = null;

		try {

			tx = em.getTransaction();
			tx.begin();
			em.remove(getById(idMarchandise));
			tx.commit();

		} catch (PersistenceException ex) {

			if (tx != null) {
				tx.rollback();
				ex.printStackTrace();
			}

		}
		
	}//end remove

	@Override
	public Marchandise getById(Long idMarchandise) {
		
		return em.find(Marchandise.class, idMarchandise);
		
	}//end find

	@Override
	public List<Marchandise> getAllMarchandise() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Marchandise> criteriaQuery = cb.createQuery(Marchandise.class);

		Root<Marchandise> clauseFROM = criteriaQuery.from(Marchandise.class);

		CriteriaQuery<Marchandise> clauseSELECT = criteriaQuery.select(clauseFROM);

		TypedQuery<Marchandise> getAllMarchandiseQuery = em.createQuery(clauseSELECT);

		return getAllMarchandiseQuery.getResultList();
		
	}//end GetAll

	@Override
	public List<Marchandise> getMarchandiseByIdCargaison(Cargaison cargaison) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Marchandise> criteriaQuery = cb.createQuery(Marchandise.class);

		Root<Marchandise> clauseFROM = criteriaQuery.from(Marchandise.class);

		CriteriaQuery<Marchandise> clauseSELECT = criteriaQuery.select(clauseFROM);
		
		Predicate where = cb.equal(clauseFROM.get("cargaison"), cargaison);

		TypedQuery<Marchandise> getMarByCarQuery = em.createQuery(clauseSELECT);

		return getMarByCarQuery.getResultList(); 
		
	}//end getbycargaison
	
	
	@Override
	public Long countMarchandise() {

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Long> cq = cb.createQuery(Long.class);

		cq.select(cb.count(cq.from(Marchandise.class)));

		Query countMarchandiseQuery = em.createQuery(cq);

		return (Long) countMarchandiseQuery.getSingleResult();
		
	}//end count
	
	
	public double poidsTotal(Long idCargaison) {
	
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Double> cq = cb.createQuery(Double.class);
		
		Root<Marchandise> clauseFROM = cq.from(Marchandise.class);
		
		CriteriaQuery<Double> clauseSELECT = cq.select(cb.sum(cb.prod(clauseFROM.get("poids"), clauseFROM.get("quantite"))));
		
		Predicate where = cb.equal(clauseFROM.get("cargaison_id"), idCargaison);
		
		Query poidsTotal = em.createQuery(cq);
		
		return (double) poidsTotal.getSingleResult() ;
	}
	
	
	public double volumeTotal(Long idCargaison) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Double> cq = cb.createQuery(Double.class);
		
		Root<Marchandise> clauseFROM = cq.from(Marchandise.class);
		
		CriteriaQuery<Double> clauseSELECT = cq.select(cb.sum(cb.prod(clauseFROM.get("volume"), clauseFROM.get("quantite"))));
		
		Predicate where = cb.equal(clauseFROM.get("cargaison_id"), idCargaison);
		
		Query volumeTotal = em.createQuery(cq);
		
		return (double) volumeTotal.getSingleResult() ;
		
	}
	
	

}//end class
