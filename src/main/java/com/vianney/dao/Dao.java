package com.vianney.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.vianney.DbObject;

public class Dao {
	
	public <T extends DbObject> void saveOrUpdate(T item, EntityManager em, boolean closeConnection) {
		EntityTransaction tx= em.getTransaction();
		try {
			tx.begin();
			if (item.getId() == null ) {
				em.persist(item);
			} else {
				em.merge(item);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		if (closeConnection) {
			em.close();
		}
	}

	public <T extends DbObject> void delete(T item, EntityManager em, boolean closeConnection) {
		EntityTransaction tx= em.getTransaction();
		tx.begin();
		if(item.getId() != null) {
			em.remove(item);
		}
		tx.commit();
		if(closeConnection) {
			em.close();
		}
	}
	
	public <T extends DbObject> T findById(Class<T> clazz, int id, EntityManager em, boolean closeConnection) {
		T result= null;
		try {
			result=em.find(clazz, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(closeConnection) {
			em.close();
		}
		return result;
	}
	
	public <T extends DbObject> List<T> findAll(Class<T> clazz, EntityManager em, boolean closeConnection) {
		TypedQuery<T> query= em.createQuery("SELECT entity FROM "+clazz.getName()+" entity", clazz);
		List<T> result= query.getResultList();

		if(closeConnection) {
			em.close();
		}
		return result;
	}
}
