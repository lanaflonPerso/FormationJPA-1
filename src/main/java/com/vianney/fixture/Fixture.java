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
import com.vianney.dao.FormateurDao;
import com.vianney.dao.FormationDao;
import com.vianney.enumeration.Genre;
import com.vianney.enumeration.PriseEnCharge;
import com.vianney.tools.PersistenceUnitFactory;

public class Fixture {
	
	private static EntityManager em= PersistenceUnitFactory.createEntityManager("FormationSession");
	
	public static void save() {
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

	public static Stagiaire getBallutinJoe() {
		Stagiaire stagiaire= new Stagiaire("ballutin", "joe", "megaSociete");
		stagiaire.setPeC(PriseEnCharge.FONGECIF);
		stagiaire.setGenre(Genre.MASCULIN);
		
		return stagiaire;
	}
	
	public static Stagiaire getDurantPascal() {
		Stagiaire stagiaire= new Stagiaire("durant", "pascal", "gigaSociete");
		stagiaire.setPeC(PriseEnCharge.INDIVUDUEL);
		stagiaire.setGenre(Genre.MASCULIN);
		stagiaire.setAdresse(getAdresse_1());
		return stagiaire;
	}
	
	public static Stagiaire getFerrariLaurence() {
		Stagiaire stagiaire= new Stagiaire("ferrari", "laurence", "petaSociete");
		stagiaire.setPeC(PriseEnCharge.POLE_EMPLOI);
		stagiaire.setGenre(Genre.FEMININ);
		
		return stagiaire;
	}

	public static Stagiaire getBalliuPaulette() {
		Stagiaire stagiaire= new Stagiaire("balliu", "paulette", "picoSociete");
		stagiaire.setPeC(PriseEnCharge.POLE_EMPLOI);
		stagiaire.setGenre(Genre.FEMININ);
		return stagiaire;
	}
	
	public static Stagiaire getMoutonJack() {
		Stagiaire stagiaire= new Stagiaire("mouton", "jack", "HarrySociete");
		stagiaire.setPeC(PriseEnCharge.SOCIETE);
		stagiaire.setGenre(Genre.MASCULIN);
		return stagiaire;
	}
	
	public static Stagiaire getDelagueJeanPiere() {
		Stagiaire stagiaire= new Stagiaire("delague", "jean-piere", "HarrySociete");
		stagiaire.setPeC(PriseEnCharge.SOCIETE);
		stagiaire.setGenre(Genre.MASCULIN);
		return stagiaire;
	}
	
	public static Formateur getPouletFabrice() {
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
		session.setFormateur(getPouletFabrice());
		session.setFormation(getPhp());
		session.ajoutStagiaire(getBallutinJoe());
		session.ajoutStagiaire(getDurantPascal());
		session.ajoutStagiaire(getFerrariLaurence());
		session.ajoutStagiaire(getDelagueJeanPiere());
		return session;
	}
	
	public static Session getSession_2() {
		Session session= new Session();
		session.setDate(new Date());
		session.setLieu("lille");
		session.setNbPlaces(0);
		session.setNbPlacesMaxi(20);
		Formateur formateur= FormateurDao.findby(getPouletFabrice(), em, false);
		session.setFormateur(formateur!=null? formateur : getPouletFabrice());
		Formation formation= FormationDao.findby(getJavaEE(), em, false);
		session.setFormation(formation!=null? formation : getJavaEE());
		session.ajoutStagiaire(getBalliuPaulette());
		session.ajoutStagiaire(getMoutonJack());
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
