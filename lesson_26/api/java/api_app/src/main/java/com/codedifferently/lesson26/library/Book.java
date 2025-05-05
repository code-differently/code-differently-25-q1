package com.codedifferently.lesson26.library;

import java.util.List;
import java.util.UUID;

/** Represents a book. */
public class Book extends MediaItemBase {
  private final String isbn;
  private final List<String> authors;
  private final int numberOfPages;

  /**
   * Create a new book with the given title, ISBN, authors, and number of pages.
   *
   * @param id The ID of the book.
   * @param title The title of the book.
   * @param isbn The ISBN of the book.
   * @param authors The authors of the book.
   * @param numberOfPages The number of pages in the book.
   */
  public Book(UUID id, String title, String isbn, List<String> authors, int numberOfPages) {
    super(id, title);
    this.isbn = isbn;
    this.authors = authors;
    this.numberOfPages = numberOfPages;
  }

  @Override
  public MediaType getType() {
    return MediaType.BOOK;
  }

  /**
   * Get the ISBN of the book.
   *
   * @return The ISBN of the book.
   */
  public String getIsbn() {
    return this.isbn;
  }

  /**
   * Get the authors of the book.
   *
   * @return The authors of the book.
   */
  public List<String> getAuthors() {
    return this.authors;
  }

  /**
   * Get the number of pages in the book.
   *
   * @return The number of pages in the book.
   */
  public int getNumberOfPages() {
    return this.numberOfPages;
  }

  @Override
  protected boolean matchesAuthor(String authorQuery) {
    if (authorQuery == null) {
      return true;
    }
    for (String author : this.getAuthors()) {
      if (author.toLowerCase().contains(authorQuery.toLowerCase())) {
        return true;
      }
    }
    return false;
  }

  @Override
  public String toString() {
    return "Book{" + "id='" + getId() + '\'' + ", title='" + getTitle() + '\'' + '}';
  }
}
