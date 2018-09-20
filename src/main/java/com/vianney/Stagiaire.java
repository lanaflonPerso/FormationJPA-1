package com.vianney;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.vianney.enumeration.PriseEnCharge;

@Entity
@Table
//@DiscriminatorValue("mon_stagiaire")
public class Stagiaire extends Personne {
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG= Logger.getLogger(Stagiaire.class.getName());
	{
		try {
			FileHandler handler= new FileHandler("stagiaire.log");
			handler.setFormatter(new SimpleFormatter());
			LOG.addHandler(handler);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String societe;
	@Column(name="prise_en_charge")
	private PriseEnCharge PeC;
	@ManyToMany(mappedBy="stagiaires")
	private List<Session> sessions= new ArrayList<>();
	@Embedded
	private AdressePt adresse;
	
	@Embedded
		@AttributeOverrides({
			@AttributeOverride(name="rue1", column= @Column(name= "rue1_pro")),
			@AttributeOverride(name="rue2", column= @Column(name= "rue2_pro")),
			@AttributeOverride(name="zipCode", column= @Column(name= "zipCode_pro")),
			@AttributeOverride(name="ville", column= @Column(name= "ville_pro"))
		})
	private AdressePt adressePro;
	
	public Stagiaire() {
		super();
	}
	public Stagiaire(String nom, String prenom) {
		super(nom, prenom);
	}
	
	public Stagiaire(String nom, String prenom, String societe) {
		super(nom, prenom);
		this.societe = societe;
	}
	
	public void setSession(Session session) {
		if(!sessions.contains(session)) {
			sessions.add(session);
		}
	}
	
	@PrePersist
	private void prePresist() {
		LOG.log(Level.INFO, "PERISIT de "+this);
	}
	
	@PostLoad
	private void postLoad() {
		LOG.log(Level.INFO, "PERISIT de "+this);
	}
	
	/* ******************************
	 * ******GETTER / SETTERS********
	 * ******************************/
	public String getSociete() {
		return societe;
	}
	public void setSociete(String societe) {
		this.societe = societe;
	}
	public PriseEnCharge getPeC() {
		return PeC;
	}
	public void setPeC(PriseEnCharge peC) {
		PeC = peC;
	}
//	public List<Session> getSessions() {
//		return sessions;
//	}
//	public void setSessions(List<Session> sessions) {
//		this.sessions = sessions;
//	}
	public AdressePt getAdresse() {
		return adresse;
	}
	public void setAdresse(AdressePt adresse) {
		this.adresse = adresse;
	}
	
	@Override
	public String toString() {
		return "Stagiaire [societe=" + societe + ", PeC=" + PeC + ", getNom()=" + getNom() + ", getPrenom()="
				+ getPrenom() + ", getGenre()=" + getGenre() + ", getId()=" + getId() + "]";
	}
}
