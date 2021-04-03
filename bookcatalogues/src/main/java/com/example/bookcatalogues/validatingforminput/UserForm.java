package com.example.bookcatalogues.validatingforminput;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserForm {
	@NotNull
	@Size(min=2, max=30)
	private String nom;
	@NotNull
	@Size(min=2, max=30)
	private String prenom;
	@NotNull
	@Size(min=2, max=30)
	private String email;
	@NotNull
	@Size(min=2, max=30)
	private String password;
	@NotNull
	@Size(min=2, max=30)
	private String username;
	public String getNom() {
		return this.nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return this.prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "UserForm [nom=" + this.nom + ", prenom=" + this.prenom + ", email=" + this.email + ", password=" + this.password
				+ ", username=" + this.username + "]";
	}
	
	
	
	

}
