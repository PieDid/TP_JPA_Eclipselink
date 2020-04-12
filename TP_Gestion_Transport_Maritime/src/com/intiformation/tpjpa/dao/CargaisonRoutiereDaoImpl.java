package com.intiformation.tpjpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.intiformation.tpjpa.entity.CargaisonRoutiere;
import com.intiformation.tpjpa.tool.JpaUtil;

public class CargaisonRoutiereDaoImpl extends CargaisonDaoImpl{
	
	protected EntityManager em = null;
	
	/*ctor*/
	public CargaisonRoutiereDaoImpl() {
		// récupération de l'EM
		em = JpaUtil.getEntityManager();
	}
	
	public void addCargaisonRoutiere(CargaisonRoutiere cargaisonRoutiere) {
		
		EntityTransaction tx = null;

		try {
			// récupération et ouverture de la transaction
			tx = em.getTransaction();
			tx.begin();
			
			// ajout de la cargaison routiere
			em.persist(cargaisonRoutiere);
			
			// confirmation de la transaction
			tx.commit();

		} catch (PersistenceException ex) {

			if (tx != null) {
				// annulation de la transaction
				tx.rollback();
				System.out.println("... erreur lors de l'ajout de la cargaison Aerienne ... ");
				ex.printStackTrace();
			}

		}finally {
			em.close();
		}
	
	}

	public void updateCargaisonRoutiere(CargaisonRoutiere cargaisonRoutiere) {
		
		EntityTransaction tx = null;

		try {
			// récupération et ouverture de la transaction
			tx = em.getTransaction();
			tx.begin();
			
			// modification de la cargaison routiere
			em.merge(cargaisonRoutiere);
			
			// confirmation de la transaction
			tx.commit();

		} catch (PersistenceException ex) {

			if (tx != null) {
				// annulation de la transaction
				tx.rollback();
				System.out.println("... erreur lors de la modification de la cargaison Aerienne ... ");
				ex.printStackTrace();
			}

		}finally {
			em.close();
		}
	
	
	}

}
