package com.vianney.test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
//		Fixture.save();
		
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.YEAR, 2018);
//		cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
//		cal.set(Calendar.DAY_OF_MONTH, 19);
//		Date date= cal.getTime();

		EntityManager em= PersistenceUnitFactory.createEntityManager(args[0]);
		Fixture.view(StagiaireDao.findByNom("ll", em));
		em.close();
	}
}
