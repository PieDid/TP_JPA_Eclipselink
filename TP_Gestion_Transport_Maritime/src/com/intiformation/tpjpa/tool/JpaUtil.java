package com.intiformation.tpjpa.tool;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class JpaUtil {
	
	private static EntityManager em;


	public static EntityManager getEntityManager() {

		if (em == null) {

			try {

				em = Persistence.createEntityManagerFactory("pu_TP_JPA")
						                   .createEntityManager();

			} catch (PersistenceException e) {
				System.out.println("La récupération de l'Entity Manager à échouée");
				e.printStackTrace();
			}

		} // end if

		return em;

}
	
}//end class
