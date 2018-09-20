package com.vianney.tools;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import com.vianney.dao.Dao;

public class AuditInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean onFlushDirty(Object entity, Serializable id
			, Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		
		if(entity instanceof Auditable) {
			Dao dao= new Dao();
			
			for (int i = 0; i < types.length; i++) {
				System.out.println("previous= "+previousState[i]);
				System.out.println("current= "+currentState[i]);
				
				if(previousState[i] != null && currentState[i] != null && !previousState[i].equals(currentState[i])) {
					EntityManager em= PersistenceUnitFactory.createEntityManager("FormationSession");
					AuditLogEntry entry= new AuditLogEntry();
					entry.setDateCreation(new Date());
					entry.setOldValue(String.valueOf(previousState[i]));
					entry.setNewValue(String.valueOf(currentState[i]));
					entry.setEntityName(entity.getClass().getName());
					entry.setField(propertyNames[i]);
					dao.saveOrUpdate(entry, em, false);
					em.close();
				}
			}
			
		}
		return true;
	}	
}
