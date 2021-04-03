package com.example.bookcatalogues.validatingforminput;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.bookcatalogues.entity.Genre;

public class LivreForm {
	@NotNull
	@Size(min=2, max=30)
	private String titre;
	@NotNull
	@Size(min=2, max=30)
	private String refeni;
	@NotNull
	@Size(min=2, max=30)
	private String auteur;
	@NotNull
	@Size(min=2, max=30)
	private String isbn;
	@NotNull
	private Boolean disponibilité;
	@ManyToOne
	private Genre genre;
	public String getTitre() {
		return this.titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getRefeni() {
		return this.refeni;
	}
	public void setRefeni(String refeni) {
		this.refeni = refeni;
	}
	public String getAuteur() {
		return this.auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getIsbn() {
		return this.isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Boolean getDisponibilité() {
		return this.disponibilité;
	}
	public void setDisponibilité(Boolean disponibilité) {
		this.disponibilité = disponibilité;
	}
	public Genre getGenre() {
		return this.genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "LivreForm [titre=" + this.titre + ", refeni=" + this.refeni + ", this.auteur=" + auteur + ", isbn=" + this.isbn
				+ ", disponibilité=" + this.disponibilité + ", genre=" + this.genre + "]";
	}
	
	
	
	
	
	

}
