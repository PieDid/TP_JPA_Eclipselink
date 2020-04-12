package com.intiformation.tpjpa.tool;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class JpaUtil {

	private static EntityManager em;

	/**
	 * ctor prive
	 */
	private JpaUtil() {}

	public static EntityManager getEntityManager() {

		if (em == null) {

			try {	
				em = Persistence.createEntityManagerFactory("pu_tp_jpa").createEntityManager();
				System.out.println("La recuperation de l'em a r�ussie");
			} catch (PersistenceException e) {
				System.out.println("La r�cup�ration de l'em � �chou�e");
				e.printStackTrace();
			}

		} // end if
		return em;

	}

}// end class
