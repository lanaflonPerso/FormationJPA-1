package com.vianney.test;

import java.util.List;

import javax.persistence.EntityManager;

import com.vianney.Stagiaire;
import com.vianney.dao.Dao;
import com.vianney.dao.StagiaireDao;
import com.vianney.fixture.Fixture;
import com.vianney.tools.PersistenceUnitFactory;

public class main {

	public static void main(String[] args) {
//		Fixture.save();
		
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR, 2018);
//		cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
//		cal.set(Calendar.DAY_OF_MONTH, 19);
//		Date date= cal.getTime();
		Dao dao= new Dao();
		EntityManager em= PersistenceUnitFactory.createEntityManager(args[0]);
		List<Stagiaire> stagiaires= StagiaireDao.findByNom("mouton", em);
		for (Stagiaire stagiaire : stagiaires) {
			stagiaire.setSociete("PicoSociete");
			dao.saveOrUpdate(stagiaire, em, false);
		}
		Fixture.view(stagiaires);
		em.close();
	}
}