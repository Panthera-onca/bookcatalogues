package com.example.bookcatalogues.entity;

import com.example.bookcatalogues.entity.Genre;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Livre {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String titre;
	private String refeni;
	private String auteur;
	private String isbn;
	private Boolean disponibilité;
	@ManyToOne
	private Genre genre;
	
	
	public Livre(Integer id, String titre, String refeni, String auteur, String isbn, Boolean disponibilité,
			Genre genre) {
		super();
		this.id = id;
		this.titre = titre;
		this.refeni = refeni;
		this.auteur = auteur;
		this.isbn = isbn;
		this.disponibilité = disponibilité;
		this.genre = new Genre(id, null) {
		};
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getRefeni() {
		return refeni;
	}
	public void setRefeni(String refeni) {
		this.refeni = refeni;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Boolean getDisponibilité() {
		return disponibilité;
	}
	public void setDisponibilité(Boolean disponibilité) {
		this.disponibilité = disponibilité;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	

}
