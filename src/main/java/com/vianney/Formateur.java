package com.vianney;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
//@DiscriminatorValue("mon_formateur")
public class Formateur extends Personne {
	private static final long serialVersionUID = 1L;
	
	private boolean interne;
	private String matricule;
	@ManyToMany(cascade= CascadeType.ALL)
	private List<Formation> competences= new ArrayList<>();
	
	public Formateur() {
		super();
	}
	public Formateur(String nom, String prenom) {
		super(nom, prenom);
	}
	
	public Formateur(String nom, String prenom, boolean interne, String matricule) {
		super(nom, prenom);
		this.interne = interne;
		this.matricule = matricule;
	}
	/* ******************************
	 * ******GETTER / SETTERS PERSO**
	 * ******************************/
	public void setCompetence(Formation competence) {
		this.competences.add(competence);
	}
	/* ******************************
	 * ******GETTER / SETTERS********
	 * ******************************/
	public boolean isInterne() {
		return interne;
	}
	public void setInterne(boolean interne) {
		this.interne = interne;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public List<Formation> getCompetences() {
		return competences;
	}
	public void setCompetences(List<Formation> competences) {
		this.competences = competences;
	}
	@Override
	public String toString() {
		return "Formateur [interne=" + interne + ", matricule=" + matricule + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getGenre()=" + getGenre() + ", getId()=" + getId() + "]";
	}
}