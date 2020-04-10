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
		
	}

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
	public List<Marchandise> getMarchandiseByIdCargaison() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Marchandise> criteriaQuery = cb.createQuery(Marchandise.class);

		Root<Marchandise> clauseFROM = criteriaQuery.from(Marchandise.class);

		CriteriaQuery<Marchandise> clauseSELECT = criteriaQuery.select(clauseFROM);
		
		Predicate where = cb.equal(clauseFROM.get("CargaisonId"), pIdCargaison);

		TypedQuery<Marchandise> getMarByCarQuery = em.createQuery(clauseSELECT);

		return getMarByCarQuery.getResultList(); 
		
	}
	
	
	@Override
	public Long countMarchandise() {

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Long> cq = cb.createQuery(Long.class);

		cq.select(cb.count(cq.from(Marchandise.class)));

		Query countMarchandiseQuery = em.createQuery(cq);

		return (Long) countMarchandiseQuery.getSingleResult();
		
	}//end count
	
	

}//end class
