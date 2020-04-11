package com.intiformation.tpjpa.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.intiformation.tpjpa.entity.Cargaison;
import com.intiformation.tpjpa.entity.CargaisonAerienne;
import com.intiformation.tpjpa.entity.CargaisonRoutiere;
import com.intiformation.tpjpa.entity.Marchandise;
import com.intiformation.tpjpa.service.Service;

public class AppTestGestionCargaison {

	public static void main(String[] args) {


		Service service = new Service();
		
		
		// 1. Instance de l'enseignant à ajouter
		Cargaison car1 = new CargaisonAerienne ("Aero1", 140, "2020-05-15", 10000);
		Cargaison car2 = new CargaisonRoutiere ("Road1", 75, "2020-05-24", 4);
		
		Marchandise mar1 = new Marchandise ("Pomme", 1, 2, 3, car1);
		Marchandise mar2 = new Marchandise ("Poele", 2, 5, 1, car1);
		Marchandise mar3 = new Marchandise ("Fraise", 1, 1, 10, car2);

		// 2. Récupération d'une EntityManager

		service.ajouterCargaisonAerienne((CargaisonAerienne) car1);
		service.ajouterCargaisonRoutiere((CargaisonRoutiere) car2);
		
		service.ajouterMarchandise(mar1);
		service.ajouterMarchandise(mar2);
		service.ajouterMarchandise(mar3);
		
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
