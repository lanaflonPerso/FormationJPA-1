package com.vianney.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.vianney.DbObject;
import com.vianney.Formateur;

public class FormateurDao {
	public static Formateur findby(Formateur formateur, EntityManager em, boolean closeConnection) {
		Formateur result= null;
		TypedQuery<Formateur> query= em.createQuery("SELECT entity FROM Formateur entity WHERE entity.matricule= :matricule", Formateur.class);
		query.setParameter("matricule", formateur.getMatricule());
		if (query.getResultList().size() >0) {
			result= query.getResultList().get(0);
		}
		if(closeConnection) {
			em.close();
		}
		return result;
	}
}
