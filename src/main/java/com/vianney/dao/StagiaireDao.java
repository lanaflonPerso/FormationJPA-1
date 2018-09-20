package com.vianney.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.vianney.Personne;
import com.vianney.Stagiaire;

public class StagiaireDao {

	@SuppressWarnings("unchecked")
	public static List<Stagiaire> findBySociete(String nom, EntityManager em, boolean closeConnection) {
		Query query = em.createQuery("SELECT st FROM Stagiaire st WHERE st.societe= :nom");
		query.setParameter("nom", nom);
		
		List<Stagiaire> stagiaires= new ArrayList<>();
		try {
			stagiaires = query.getResultList();
		} catch (PersistenceException e) {
			SQLException sqlex= (SQLException) e.getCause();
			sqlex.getErrorCode();
			e.printStackTrace();
		}
		
		// SQL
//		Query query= em.createNativeQuery("SELECT P.nom, P.prenom, P.id FROM stagiaire as S JOIN personne as P ON S.id= P.id WHERE s.societe = :nom");
//		query.setParameter("nom", nom);
//		List<Stagiaire> stagiaires= query.getResultList();
		
		
		// criteriaBuilder********************************************************
//		CriteriaBuilder cb= em.getCriteriaBuilder();
//		CriteriaQuery<Stagiaire> cq= cb.createQuery(Stagiaire.class);
//		Root<Stagiaire> entity= cq.from(Stagiaire.class);
//		cq.where(cb.equal(entity.get("societe"), cb.parameter(String.class, "nom")));
//		Query query = em.createQuery(cq);
//		query.setParameter("nom", nom);
//		List<Stagiaire> stagiaires= query.getResultList();
		
		//HQL*********************************************************************************
//		Query query = em.createQuery("SELECT st FROM Stagiaire st WHERE st.societe= :nom");
//		query.setParameter("nom", nom);
//		List<Stagiaire> stagiaires= query.getResultList();
		
		if(closeConnection) {
			em.close();
		}		
		return stagiaires;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Stagiaire> findByNom(String nom, EntityManager em) {
		Query query = em.createQuery("SELECT st FROM Stagiaire st WHERE st.nom like :nom");
		query.setParameter("nom", "%"+nom+"%");
		
		List<Stagiaire> stagiaires= new ArrayList<>();
		try {
			stagiaires = query.getResultList();
		} catch (PersistenceException e) {
			SQLException sqlex= (SQLException) e.getCause();
			sqlex.getErrorCode();
			e.printStackTrace();
		}	
		return stagiaires;
	}
}
