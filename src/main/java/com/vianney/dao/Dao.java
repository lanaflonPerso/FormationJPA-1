package com.vianney.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
}
