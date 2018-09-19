package com.vianney.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.vianney.Stagiaire;

public class StagiaireDao {

	@SuppressWarnings("unchecked")
	public static List<Stagiaire> findBySociete(String nom, EntityManager em, boolean closeConnection) {
		Query query = em.createQuery("SELECT st FROM Stagiaire st WHERE societe= :nom");
		query.setParameter("nom", nom);
		List<Stagiaire> stagiaires= query.getResultList();
		
		if(closeConnection) {
			em.close();
		}		
		return stagiaires;
	}
}
