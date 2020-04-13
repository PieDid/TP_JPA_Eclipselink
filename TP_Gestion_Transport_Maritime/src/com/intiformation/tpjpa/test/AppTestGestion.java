package com.intiformation.tpjpa.test;

import java.util.List;

import com.intiformation.tpjpa.entity.Cargaison;
import com.intiformation.tpjpa.entity.CargaisonAerienne;
import com.intiformation.tpjpa.entity.CargaisonRoutiere;
import com.intiformation.tpjpa.entity.Marchandise;
import com.intiformation.tpjpa.entity.Utilisateur;
import com.intiformation.tpjpa.service.Service;

public class AppTestGestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Appel de la couche service
				Service service = new Service();
				
				//1.1. Instance des utilisateurs à ajouter
				Utilisateur u1 = new Utilisateur("Harvey", "Cecil", "cecil.harvay@redwings.br", "TuEstMonFrere!");
				Utilisateur u2 = new Utilisateur("Highwind", "Kain", "kain.highwind@dragon.br", "Bipolaire!");
				
				// 1.2. Instances des cargaisons à ajouter
				Cargaison car1 = new CargaisonAerienne ("Aero1", 140, "2020-05-15", 10000);
				Cargaison car2 = new CargaisonRoutiere ("Road1", 75, "2020-05-24", 4);
				Cargaison car3 = new CargaisonAerienne ("Aero2", 2500, "2020-06-15", 15000);
				Cargaison car4 = new CargaisonRoutiere ("Road2", 400, "2020-07-12", 2.5);
				
				//1.3. Instance des marchandises
				Marchandise mar1 = new Marchandise ("Pomme", 1, 2, 3, car1);
				Marchandise mar2 = new Marchandise ("Poele", 2, 5, 1, car1);
				Marchandise mar3 = new Marchandise ("Fraise", 1, 1, 10, car2);

				// test d'ajout
				service.ajouterUtilisateur(u1);
				service.ajouterUtilisateur(u2);
				

				service.ajouterCargaisonAerienne((CargaisonAerienne) car1);
				service.ajouterCargaisonRoutiere((CargaisonRoutiere) car2);
				service.ajouterCargaisonAerienne((CargaisonAerienne) car3);
				service.ajouterCargaisonRoutiere((CargaisonRoutiere) car4);
				
				service.ajouterMarchandise(mar1);
				service.ajouterMarchandise(mar2);
				service.ajouterMarchandise(mar3); 
				
				
				// test d'existence des utilisateurs
				System.out.println("u1 existe :" + service.utilisateurExiste("cecil.harvay@redwings.br","TuEstMonFrere!"));
				System.out.println("u2 existe :" + service.utilisateurExiste("kain.highwind@dragon.br","Bipolaire!"));
				System.out.println("u3 existe :" + service.utilisateurExiste("rosa.farell@mageblanche.br","JeTaimeMoiNonPlus!"));
				
				// test de récupération des utilisateur par id et par mail
				Utilisateur urecup1 = service.recupererUtilisateurParId(1L);
				Utilisateur urecup2 = service.recupererUtilisateurParMail("kain.highwind@dragon.br");
				
				System.out.println("u1 :" + urecup1);
				System.out.println("u2 :" + urecup2);
				
				
				// test de récupération des cargaisons et des marchandises
				List<Cargaison> listeCargaison = service.recupererToutesCargaisons();
				System.out.println("Liste des cargaisons (API Criteria) ------------------------------------------------");
				for (Cargaison car : listeCargaison) {
					System.out.println("\t > " + car.getClass());
				}
				System.out.println("-------------------------------------------------------------------------------------\n\n");
				
				
				
				List<Marchandise> listeMerch = service.recupererToutesMarchandises();
				System.out.println("Liste des marchandises (API Criteria) ------------------------------------------------");
				for (Marchandise merch : listeMerch) {
					System.out.println("\t > " + merch.getIdMarchandise() + " : " + merch.getNom());
				}
				System.out.println("-------------------------------------------------------------------------------------\n\n");
				
				
				Cargaison cargaison1 = service.recupererCargaisonParId(1L);
				System.out.println("Cargaison Id = 1 " + cargaison1.getNomCargaison());
				
				Marchandise march1 = service.recupererMarchandiseParId(1L);
				System.out.println("Marchandise Id = 1 " + march1.getNom());
				
				
				List<Marchandise> listeCar1 = service.recupererToutesMarchandisesParIdCargaison(car1);
				System.out.println("Liste des marchandises de la cargaison 1 (API Criteria) ------------------------------------------------");
				for (Marchandise merch : listeCar1) {
					System.out.println("\t > " + merch.getIdMarchandise() + " : " + merch.getNom());
				}
				System.out.println("-------------------------------------------------------------------------------------\n\n");
				
				// test de récupération des poids et volumes total des marchandises des cargasons, et du cout de la cargaison
				double poids1 = service.poidsTotal(car1);
				System.out.println("Poids de la cargaison 1 : " + poids1); 
				
				double vol1 = service.volumeTotal(car1);
				System.out.println("Poides de la cargaison 1 : " + vol1); 
				
				
				double cout1 = service.coutCargaison(1L);
				System.out.println("Cout de la cargaison 1 : " + cout1); 
				
				double cout2 = service.coutCargaison(2L);
				System.out.println("Cout de la cargaison 2 : " + cout2); 

			}//end main

		}//end class