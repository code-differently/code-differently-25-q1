package com.codedifferently.lesson28.repository;

import org.springframework.data.repository.CrudRepository;

import com.codedifferently.lesson28.models.LibraryUserModel;

public interface LibraryUserRepository extends CrudRepository<LibraryUserModel, String> {
}
