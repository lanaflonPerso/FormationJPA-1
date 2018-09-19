package com.vianney;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Formation extends DbObject {
	private static final long serialVersionUID = 1L;
	
	private String titre;
	@Column(nullable=false)
	private String code;
	@Column(name="prix_ht", precision=6, scale=2)
	private Double prix;
	private int duree;
		
	public Formation() {
		super();
	}

	public Formation(String titre, int duree) {
		super();
		this.titre = titre;
		this.duree = duree;
	}

	/* ******************************
	 * ******GETTER / SETTERS********
	 * ******************************/
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}

	@Override
	public String toString() {
		return "Formation [titre=" + titre + ", code=" + code + ", prix=" + prix + ", duree=" + duree + "]";
	}
}
