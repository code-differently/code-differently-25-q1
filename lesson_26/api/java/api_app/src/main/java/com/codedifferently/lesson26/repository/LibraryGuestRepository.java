package com.codedifferently.lesson26.repository;

import com.codedifferently.lesson26.models.LibraryGuestModel;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface LibraryGuestRepository extends CrudRepository<LibraryGuestModel, String> {
  @Override
  List<LibraryGuestModel> findAll();
}
