package com.vianney.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.vianney.Session;

public class SessionDao extends Dao {
	
	public static List<Session> findByNbStagiaire(int nbStagiaires, EntityManager em, boolean closeConnection) {
		TypedQuery<Session> query=  em.createQuery(
				"SELECT ss FROM Session ss JOIN ss.stagiaires student "
				+ "GROUP BY nbPlaces HAVING count(student) > :qty ", Session.class);
		query.setParameter("qty", (long) nbStagiaires);
		List<Session> result= query.getResultList();
		if(closeConnection) {
			em.close();
		}
		return result;
	}
	
	public static Set<Session> findByDate(Date date, EntityManager em) {
		TypedQuery<Session> query=  em.createQuery(
				"SELECT ss FROM Session ss, Formation F WHERE :date BETWEEN ss.date AND ADDDATE(ss.date, F.duree)", Session.class);
		query.setParameter("date", date);
		Set<Session> result= new HashSet<>();
		result.addAll(query.getResultList());

		return result;
	}
}
