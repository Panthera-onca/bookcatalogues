package com.example.bookcatalogues.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.example.bookcatalogues.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public Optional<User> findUserByUsername(String username);

}
