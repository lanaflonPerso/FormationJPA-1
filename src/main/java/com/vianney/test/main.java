package com.vianney.test;

import java.util.List;

import javax.persistence.EntityManager;

import com.vianney.Session;
import com.vianney.Stagiaire;
import com.vianney.dao.Dao;
import com.vianney.dao.SessionDao;
import com.vianney.dao.StagiaireDao;
import com.vianney.fixture.Fixture;
import com.vianney.tools.PersistenceUnitFactory;

public class main {

	public static void main(String[] args) {
		Fixture.save();
	
		EntityManager em= PersistenceUnitFactory.createEntityManager(args[0]);
		List<Stagiaire> stagiaires= StagiaireDao.findBySociete("HarrySociete", em, false); //dao.findAll(Stagiaire.class, em, false);
		
		Fixture.view(stagiaires);
		em.close();
	}
}
