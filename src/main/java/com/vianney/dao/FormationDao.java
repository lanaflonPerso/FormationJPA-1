package com.vianney.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.vianney.Formation;

public class FormationDao {
	public static Formation findby(Formation formation, EntityManager em, boolean closeConnection) {
		Formation result= null;
		TypedQuery<Formation> query= em.createQuery("SELECT entity FROM Formation entity WHERE entity.code= :code", Formation.class);
		query.setParameter("code", formation.getCode());
		if (query.getResultList().size() > 0) {
			result= query.getResultList().get(0);
		}
		if(closeConnection) {
			em.close();
		}
		return result;
	}
}
