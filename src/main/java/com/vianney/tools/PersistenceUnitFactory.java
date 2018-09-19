package com.vianney.tools;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUnitFactory {

	public static EntityManager createEntityManager(String persistenceUnitName) {
		EntityManagerFactory eef= Persistence.createEntityManagerFactory(persistenceUnitName);
		EntityManager em= eef.createEntityManager();
		
		return em;
	}
}
