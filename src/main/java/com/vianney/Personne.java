package com.vianney;

import static javax.persistence.EnumType.STRING;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.vianney.enumeration.Genre;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name="type_personne")
public abstract class Personne extends DbObject {
	private static final long serialVersionUID = 1L;
	
//	@Column(nullable=false)
	private String nom;
	private String prenom;
//	@Basic(optional = false)
	@Enumerated(STRING)
	private Genre genre;
	
	public Personne() {
		super();
	}

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	/* ******************************
	 * ******GETTER / SETTERS********
	 * ******************************/
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", genre=" + genre + "]";
	}
}
