package com.vianney.fixture;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.vianney.AdressePt;
import com.vianney.Formateur;
import com.vianney.Formation;
import com.vianney.Session;
import com.vianney.Stagiaire;
import com.vianney.dao.Dao;
import com.vianney.enumeration.Genre;
import com.vianney.enumeration.PriseEnCharge;
import com.vianney.tools.PersistenceUnitFactory;

public class Fixture {
	
	public static void save() {
		EntityManager em= PersistenceUnitFactory.createEntityManager("FormationSession");
		Dao dao= new Dao();
		dao.saveOrUpdate(getSession_1(), em, false);
		dao.saveOrUpdate(getSession_2(), em, false);
		em.close();
	}
	
	public static AdressePt getAdresse_1() {
		AdressePt adresse= new AdressePt();
		adresse.setRue1("25 rue victor hugo");
		adresse.setZipCode("59000");
		adresse.setVille("Lille");
		return adresse;
	}

	public static Stagiaire getStagiaire_1() {
		Stagiaire stagiaire= new Stagiaire("ballutin", "joe", "megaSociete");
		stagiaire.setPeC(PriseEnCharge.FONGECIF);
		stagiaire.setGenre(Genre.MASCULIN);
		
		return stagiaire;
	}
	
	public static Stagiaire getStagiaire_2() {
		Stagiaire stagiaire= new Stagiaire("durant", "pascal", "gigaSociete");
		stagiaire.setPeC(PriseEnCharge.INDIVUDUEL);
		stagiaire.setGenre(Genre.MASCULIN);
		stagiaire.setAdresse(getAdresse_1());
		return stagiaire;
	}
	
	public static Stagiaire getStagiaire_3() {
		Stagiaire stagiaire= new Stagiaire("ferrari", "laurence", "petaSociete");
		stagiaire.setPeC(PriseEnCharge.POLE_EMPLOI);
		stagiaire.setGenre(Genre.FEMININ);
		
		return stagiaire;
	}

	public static Stagiaire getStagiaire_4() {
		Stagiaire stagiaire= new Stagiaire("balliu", "paulette", "picoSociete");
		stagiaire.setPeC(PriseEnCharge.POLE_EMPLOI);
		stagiaire.setGenre(Genre.FEMININ);
		return stagiaire;
	}
	
	public static Stagiaire getStagiaire_5() {
		Stagiaire stagiaire= new Stagiaire("mouton", "jack", "HarrySociete");
		stagiaire.setPeC(PriseEnCharge.POLE_EMPLOI);
		stagiaire.setGenre(Genre.FEMININ);
		return stagiaire;
	}
	
	public static Formateur getFormateur_1() {
		Formateur formateur= new Formateur("poulet", "fabrice", true, "559-225");
		formateur.setInterne(true);
		formateur.setGenre(Genre.MASCULIN);
		formateur.setCompetence(getJavaEE());
		return formateur;
	}
	
	public static Formateur getFormateur_2() {
		Formateur formateur= new Formateur("bakula", "franck", true, "559-212");
		formateur.setInterne(true);
		formateur.setGenre(Genre.MASCULIN);
		formateur.setCompetence(getPhp());
		formateur.setCompetence(getPhpTwig());
		return formateur;
	}
	
	public static Formation getJavaEE() {
		Formation formation= new Formation("Java EE", 150);
		formation.setCode("JAVA-EE-00356");
		formation.setPrix(2500.00);
		return formation;
	}
	
	public static Formation getPhp() {
		Formation formation= new Formation("PHP", 90);
		formation.setCode("PHP-00456");
		return formation;
	}
	
	public static Formation getPhpTwig() {
		Formation formation= new Formation("PHP / Twig", 90);
		formation.setCode("PHP-00466");
		return formation;
	}
	
	public static Formation getPython() {
		Formation formation= new Formation("Python", 120);
		formation.setCode("Python-00456");
		return formation;
	}
	
	public static Session getSession_1() {
		Session session= new Session();
		session.setDate(new Date());
		session.setLieu("pekin");
		session.setNbPlaces(4);
		session.setNbPlacesMaxi(25);
		session.setFormateur(getFormateur_1());
		session.setFormation(getJavaEE());
		session.ajoutStagiaire(getStagiaire_1());
		session.ajoutStagiaire(getStagiaire_2());
		session.ajoutStagiaire(getStagiaire_3());
		return session;
	}
	
	public static Session getSession_2() {
		Session session= new Session();
		session.setDate(new Date());
		session.setLieu("lille");
		session.setNbPlaces(0);
		session.setNbPlacesMaxi(20);
		session.setFormateur(getFormateur_1());
		session.setFormation(getJavaEE());
		session.ajoutStagiaire(getStagiaire_4());
		session.ajoutStagiaire(getStagiaire_5());
		return session;
	}
	
	public static void view(List<Stagiaire> stagiaires) {
		System.out.println("********************************************");
		for (Stagiaire stagiaire : stagiaires) {
			if(stagiaire.getNom() != null && stagiaire.getPrenom() != null) {
				System.out.println("nom= "+stagiaire.getNom()+", prenom= "+stagiaire.getPrenom()+
						", societe= "+stagiaire.getSociete());
			}
		}
		System.out.println("********************************************");
	}
}
