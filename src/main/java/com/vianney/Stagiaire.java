package com.vianney;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.vianney.enumeration.PriseEnCharge;

@Entity
@Table
//@DiscriminatorValue("mon_stagiaire")
public class Stagiaire extends Personne {
	private static final long serialVersionUID = 1L;
	
	private String societe;
	@Column(name="prise_en_charge")
	private PriseEnCharge PeC;
//	@ManyToMany(mappedBy="stagiaires")
//	private List<Session> sessions= new ArrayList<>();
	
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
	
//	public void setSession(Session session) {
//		if(sessions.contains(session)) {
//			sessions.add(session);
//		}
//	}
	
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
	@Override
	public String toString() {
		return "Stagiaire [societe=" + societe + ", PeC=" + PeC + ", getNom()=" + getNom() + ", getPrenom()="
				+ getPrenom() + ", getGenre()=" + getGenre() + ", getId()=" + getId() + "]";
	}
}
