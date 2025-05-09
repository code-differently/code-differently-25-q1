package com.codedifferently.lesson28.repository;

import com.codedifferently.lesson28.models.MediaItemModel;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.codedifferently.lesson28.models.LibraryUsersModel;

public interface LibraryUsersRepository extends CrudRepository<LibraryUsersModel, UUID> {
  @Override
  List<LibraryUsersModel> findAll();
}