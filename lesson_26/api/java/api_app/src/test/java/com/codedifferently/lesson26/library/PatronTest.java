package com.codedifferently.lesson26.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.codedifferently.lesson26.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson26.library.exceptions.WrongLibraryException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PatronTest {

  private Patron classUnderTest;
  private Library library;

  @BeforeEach
  void setUp() {
    classUnderTest = new Patron("John Doe", "johndoe@example.com");
    library = new Library("Library 1");
    library.addLibraryGuest(classUnderTest);
  }

  @Test
  void testPatron_created() {
    // Assert
    assertThat(classUnderTest.getName()).isEqualTo("John Doe");
    assertThat(classUnderTest.getEmail()).isEqualTo("johndoe@example.com");
  }

  @Test
  void testSetLibrary_WrongLibrary() {
    // Arrange
    Library otherLibrary = new Library("Library 2");

    // Act & Assert
    assertThatThrownBy(() -> classUnderTest.setLibrary(otherLibrary))
        .isInstanceOf(WrongLibraryException.class)
        .hasMessageContaining("Patron johndoe@example.com is not in library Library 2");
  }

  @Test
  void testGetCheckedOutBooks_LibraryNotSet() {
    // Arrange
    classUnderTest.setLibrary(null);

    // Act & Assert
    assertThatThrownBy(() -> classUnderTest.getCheckedOutMediaItems())
        .isInstanceOf(LibraryNotSetException.class)
        .hasMessageContaining("Library not set for patron johndoe@example.com");
  }

  @Test
  void testGetCheckedOutBooks() {
    // Arrange
    Book book1 =
        new Book(
            UUID.randomUUID(),
            "The Great Gatsby",
            "978-0743273565",
            List.of("F. Scott Fitzgerald"),
            180);
    Book book2 =
        new Book(
            UUID.randomUUID(),
            "To Kill a Mockingbird",
            "978-0061120084",
            List.of("Harper Lee"),
            281);
    Librarian librarian = new Librarian("Anthony Mays", "anthony@example.com");
    Set<Book> expectedBooks = new HashSet<>();
    expectedBooks.add(book1);
    expectedBooks.add(book2);

    library.addMediaItem(book1, librarian);
    library.addMediaItem(book2, librarian);
    library.checkOutMediaItem(book1, classUnderTest);
    library.checkOutMediaItem(book2, classUnderTest);

    // Act & Assert
    assertThat(classUnderTest.getCheckedOutMediaItems()).isEqualTo(expectedBooks);
  }

  @Test
  void testToString() {
    // Act & Assert
    assertThat(classUnderTest.toString())
        .isEqualTo("Patron{id='johndoe@example.com', name='John Doe'}");
  }
}
