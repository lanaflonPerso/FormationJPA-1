package com.vianney;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table
public class Session extends DbObject {
	private static final long serialVersionUID = 1L;
	
	@Column(name="lieu", length=50, nullable=false)
	private String lieu;
	@Column(name="date_session", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date;
//	@Transient
	private int nbPlaces;
	@Transient
	private int nbPlacesMaxi;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	private Formation formation;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	private Formateur formateur;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	private List<Stagiaire> stagiaires= new ArrayList<>();
	
	public Session() {
		super();
	}

	public Session(String lieu, Date date, Formation formation) {
		super();
		this.lieu = lieu;
		this.date = date;
		this.formation = formation;
	}

	/* ******************************
	 * ******METHODES****************
	 * ******************************/
	public void ajoutStagiaire(Stagiaire stagiaire) {
		stagiaires.add(stagiaire);
	}
	
	/* ******************************
	 * ******GETTER / SETTERS********
	 * ******************************/
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = Capitalize(lieu);
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNbPlaces() {
		return nbPlaces;
	}
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	public int getNbPlacesMaxi() {
		return nbPlacesMaxi;
	}
	public void setNbPlacesMaxi(int nbPlacesMaxi) {
		this.nbPlacesMaxi = nbPlacesMaxi;
	}
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}	
	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	private String Capitalize(String value) {
		StringBuilder sb= new StringBuilder();
		String[] tab= value.split(" ");
		for (int i = 0; i < tab.length; i++) {
			sb.append(tab[i].substring(0, 1).toUpperCase()+tab[i].substring(1));
			if(i != tab.length-1) {
				sb.append(" ");
			}
			
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return "Session [lieu=" + lieu + ", date=" + date + ", nbPlaces=" + nbPlaces + ", nbPlacesMaxi=" + nbPlacesMaxi
				+ ", formation=" + formation + ", formateur=" + formateur + ", stagiaires=" + stagiaires + "]";
	}
}
