package com.vianney;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AdressePt {
	
	@Column(nullable=false)
	private String rue1;
	@Column(nullable=false)
	private String rue2;
	@Column(nullable=false, length= 5)
	private String zipCode;
	@Column(nullable=false)
	private String ville;
	
	/* ******************************
	 * ******GETTER / SETTERS********
	 * ******************************/
	public String getRue1() {
		return rue1;
	}
	public void setRue1(String rue1) {
		this.rue1 = rue1;
	}
	public String getRue2() {
		return rue2;
	}
	public void setRue2(String rue2) {
		this.rue2 = rue2;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
}
