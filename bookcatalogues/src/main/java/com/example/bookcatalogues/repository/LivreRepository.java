package com.example.bookcatalogues.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.bookcatalogues.entity.Genre;
import com.example.bookcatalogues.entity.Livre;

public interface LivreRepository extends CrudRepository<Livre, Integer> {

	public Optional<Livre> findByTitre(String titre);

	public Optional<Livre> findByGenre(Genre genre);

}
