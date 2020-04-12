package com.intiformation.tpjpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.intiformation.tpjpa.entity.Utilisateur;
import com.intiformation.tpjpa.tool.JpaUtil;

/**
 * Implementation concrete de la DAO de l'utilisateur
 * @author IN-DF-028
 *
 */
public class UtilisateurDaoImpl implements IUtilisateurDao{

	protected EntityManager em = null;
	
	/*ctor*/
	public UtilisateurDaoImpl() {
		// récupération de l'EM
		em = JpaUtil.getEntityManager();
	}
	
	@Override
	public void addUtilisateur(Utilisateur utilisateur) {

		EntityTransaction tx = null;

		try {

			tx = em.getTransaction();
			tx.begin();
			em.persist(utilisateur);
			tx.commit();

		} catch (PersistenceException ex) {

			if (tx != null) {
				tx.rollback();
				ex.printStackTrace();
			}

		}
		
	}
	
	@Override
	public boolean isUtilisateurExists(String mail, String mdp) {

		try {
			
			//requete 
			Query query = em.createNamedQuery("Utilisateur.isExists");
			query.setParameter(1, mail);
			query.setParameter(2, mdp);
			
			// execution + récupération du résultat de la requete 
			Long isExistsVerif =  (Long) query.getSingleResult();
			
			return (isExistsVerif ==1);
			
		} catch (PersistenceException e) {
			System.out.println("... Erreur lors de la vérif de l'existance de l'utilisateur ....");
			e.printStackTrace();
		}
		
		return false;

	}

	@Override
	public Utilisateur getUtilisateurById(Long idUtilisateur) {
		return em.find(Utilisateur.class, idUtilisateur);
	}

	@Override
	public Utilisateur getUtilisateurByMail(String mail) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();			
				
		CriteriaQuery<Utilisateur> cq = cb.createQuery(Utilisateur.class);
				
		Root<Utilisateur> clauseFROM = cq.from(Utilisateur.class);
					
		CriteriaQuery<Utilisateur> clauseSELECT =  cq.select(clauseFROM);
				
		Predicate conditionClauseWHERE = cb.equal(clauseFROM.get("mail"), mail);
					
		CriteriaQuery<Utilisateur> clauseWHERE = cq.where(conditionClauseWHERE);
				
		TypedQuery<Utilisateur> getUtilisateurByIdQUERY =  em.createQuery(clauseSELECT);
						
		return (Utilisateur) getUtilisateurByIdQUERY.getSingleResult();
						
	}

	

}
