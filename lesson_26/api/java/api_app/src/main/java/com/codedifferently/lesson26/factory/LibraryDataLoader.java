package com.codedifferently.lesson26.factory;

import com.codedifferently.lesson26.models.LibraryDataModel;
import java.io.IOException;

/** An object that loads data from a source and returns a LibraryDataModel object. */
public interface LibraryDataLoader {
  /**
   * Load data from a source and return a LibraryDataModel object.
   *
   * @return A LibraryDataModel object.
   * @throws IOException if an I/O error occurs.
   */
  public LibraryDataModel loadData() throws IOException;
}
