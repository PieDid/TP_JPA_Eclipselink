package com.intiformation.tpjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.intiformation.tpjpa.entity.Cargaison;
import com.intiformation.tpjpa.tool.JpaUtil;

public class CargaisonDaoImpl implements ICargaisonDao {

	protected EntityManager em = null;
	
	/*ctor*/
	public CargaisonDaoImpl() {
		// récupération de l'EM
		em = JpaUtil.getEntityManager();
	}
	
	@Override
	public void deleteCargaison(Long idCargaison) {
		
		EntityTransaction tx = em.getTransaction();
		
		try {
			
			// récupération de la transaction + ouverture 
			
			tx.begin();
			
			// suppression de la cargaison avec l'id idCargaison
			em.remove(getById(idCargaison));
			
			// confirmation de la transition
			tx.commit();
			
		} catch (PersistenceException e) {
			if (tx != null) {
				// annulation de la transaction
				tx.rollback();
			}
			System.out.println("... Erreur dans la suppression d'une Cargaison ...");
			e.printStackTrace();
		}finally {
			em.close();
		}
		
	} // end deleteCargaison()

	@Override
	public Cargaison getById(Long idCargaison) {
		// cherche et retourne un objet de type Cargaison avec l'id idCargaison
		return em.find(Cargaison.class, idCargaison);
	} // end getById()

	@Override
	public List<Cargaison> getAllCargaison() {

		// recupération du Criteria Builder
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// création de la requete
		CriteriaQuery<Cargaison> criteriaQuery = cb.createQuery(Cargaison.class);

		TypedQuery<Cargaison> getAllCargaisonQuery = em.createQuery(criteriaQuery.select(criteriaQuery.from(Cargaison.class)));

		return getAllCargaisonQuery.getResultList();
	}

}
