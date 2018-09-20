package com.vianney;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.query.criteria.internal.FromImplementor;

@MappedSuperclass
public abstract class DbObject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Version
	@Column(columnDefinition="integer default 0")
	private int version;
	@Temporal(TemporalType.TIMESTAMP)
	private Date firstUpdate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	
	@PrePersist
	public void prePersist() {
		firstUpdate= new Date();
	}
	
	@PreUpdate
	public void preUpdate() {
		lastUpdate= new Date();
		if(firstUpdate == null) {
			firstUpdate= lastUpdate;
		}
	}
	
	public DbObject() {
		super();
	}
	
	/* ******************************
	 * ******GETTER / SETTERS********
	 * ******************************/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
}
