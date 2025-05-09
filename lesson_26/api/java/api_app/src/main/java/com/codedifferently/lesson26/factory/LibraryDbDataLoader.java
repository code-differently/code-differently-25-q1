package com.codedifferently.lesson26.factory;

import com.codedifferently.lesson26.models.LibraryDataModel;
import com.codedifferently.lesson26.repository.LibraryGuestRepository;
import com.codedifferently.lesson26.repository.MediaItemRepository;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** A data loader that loads library data from a database. */
@Service
public final class LibraryDbDataLoader implements LibraryDataLoader {

  @Autowired private MediaItemRepository mediaItemsRepository;
  @Autowired private LibraryGuestRepository libraryGuestRepository;

  @Override
  public LibraryDataModel loadData() throws IOException {
    var model = new LibraryDataModel();

    model.mediaItems = mediaItemsRepository.findAll();
    model.guests = libraryGuestRepository.findAll();

    return model;
  }
}
