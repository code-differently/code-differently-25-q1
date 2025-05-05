package com.codedifferently.lesson26.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.codedifferently.lesson26.library.exceptions.MediaItemCheckedOutException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibraryTest {
  private Library classUnderTest;

  @BeforeEach
  void setUp() {
    classUnderTest = new Library("compton-library");
  }

  @Test
  void testLibrary_canAddItems() {
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
    // Act
    classUnderTest.addMediaItem(book1, librarian);
    classUnderTest.addMediaItem(book2, librarian);
    // Assert
    assertThat(classUnderTest.hasMediaItem(book1)).isTrue();
    assertThat(classUnderTest.hasMediaItem(book2)).isTrue();
  }

  @Test
  void testLibrary_canRemoveItems() {
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
    classUnderTest.addMediaItem(book1, librarian);
    classUnderTest.addMediaItem(book2, librarian);
    // Act
    classUnderTest.removeMediaItem(book1, librarian);
    classUnderTest.removeMediaItem(book2, librarian);
    // Assert
    assertThat(classUnderTest.hasMediaItem(book1)).isFalse();
    assertThat(classUnderTest.hasMediaItem(book2)).isFalse();
  }

  @Test
  void testLibrary_canAddPatrons() {
    // Arrange
    Patron patron1 = new Patron("John Doe", "john@example.com");
    Patron patron2 = new Patron("Jane Doe", "jane@example.com");
    // Act
    classUnderTest.addLibraryGuest(patron1);
    classUnderTest.addLibraryGuest(patron2);
    // Assert
    assertThat(classUnderTest.hasLibraryGuest(patron1)).isTrue();
    assertThat(classUnderTest.hasLibraryGuest(patron2)).isTrue();
  }

  @Test
  void testLibrary_canRemovePatrons() {
    // Arrange
    Patron patron1 = new Patron("John Doe", "john@example.com");
    Patron patron2 = new Patron("Jane Doe", "jane@example.com");
    classUnderTest.addLibraryGuest(patron1);
    classUnderTest.addLibraryGuest(patron2);
    // Act
    classUnderTest.removeLibraryGuest(patron1);
    classUnderTest.removeLibraryGuest(patron2);
    // Assert
    assertThat(classUnderTest.hasLibraryGuest(patron1)).isFalse();
    assertThat(classUnderTest.hasLibraryGuest(patron2)).isFalse();
  }

  @Test
  void testLibrary_allowsPatronToCheckoutBook() {
    // Arrange
    Book book =
        new Book(
            UUID.randomUUID(),
            "The Great Gatsby",
            "978-0743273565",
            List.of("F. Scott Fitzgerald"),
            180);
    Patron patron = new Patron("John Doe", "john@example.com");
    Librarian librarian = new Librarian("Anthony Mays", "anthony@example.com");
    classUnderTest.addMediaItem(book, librarian);
    classUnderTest.addLibraryGuest(patron);
    // Act
    boolean wasCheckedOut = classUnderTest.checkOutMediaItem(book, patron);
    // Assert
    assertThat(wasCheckedOut).isTrue();
    assertThat(classUnderTest.isCheckedOut(book)).isTrue();
    assertThat(patron.getCheckedOutMediaItems().contains(book)).isTrue();
  }

  @Test
  void testLibrary_allowPatronToCheckInBook() {
    // Arrange
    Book book =
        new Book(
            UUID.randomUUID(),
            "The Great Gatsby",
            "978-0743273565",
            List.of("F. Scott Fitzgerald"),
            180);
    Patron patron = new Patron("John Doe", "john@example.com");
    Librarian librarian = new Librarian("Anthony Mays", "anthony@example.com");
    classUnderTest.addMediaItem(book, librarian);
    classUnderTest.addLibraryGuest(patron);
    classUnderTest.checkOutMediaItem(book, patron);
    // Act
    boolean wasReturned = classUnderTest.checkInMediaItem(book, patron);
    // Assert
    assertThat(wasReturned).isTrue();
    assertThat(classUnderTest.isCheckedOut(book)).isFalse();
    assertThat(patron.getCheckedOutMediaItems().contains(book)).isFalse();
  }

  @Test
  void testLibrary_allowLibrarianToCheckOutBook() {
    // Arrange
    Librarian librarian = new Librarian("Anthony Mays", "anthony@example.com");
    Book book =
        new Book(
            UUID.randomUUID(),
            "The Great Gatsby",
            "978-0743273565",
            List.of("F. Scott Fitzgerald"),
            180);
    classUnderTest.addMediaItem(book, librarian);
    classUnderTest.addLibraryGuest(librarian);
    // Act
    boolean wasCheckedOut = classUnderTest.checkOutMediaItem(book, librarian);
    // Assert
    assertThat(wasCheckedOut).isTrue();
    assertThat(librarian.getCheckedOutMediaItems().contains(book)).isTrue();
  }

  @Test
  void testLibrary_allowLibrarianToCheckInBook() {
    // Arrange
    Book book =
        new Book(
            UUID.randomUUID(),
            "The Great Gatsby",
            "978-0743273565",
            List.of("F. Scott Fitzgerald"),
            180);
    Librarian librarian = new Librarian("John Doe", "john@example.com");
    classUnderTest.addMediaItem(book, librarian);
    classUnderTest.addLibraryGuest(librarian);
    classUnderTest.checkOutMediaItem(book, librarian);
    // Act
    boolean wasReturned = classUnderTest.checkInMediaItem(book, librarian);
    // Assert
    assertThat(wasReturned).isTrue();
    assertThat(classUnderTest.isCheckedOut(book)).isFalse();
    assertThat(librarian.getCheckedOutMediaItems().contains(book)).isFalse();
  }

  @Test
  void testLibrary_preventsMultipleCheckouts() {
    // Arrange
    Book book =
        new Book(
            UUID.randomUUID(),
            "The Great Gatsby",
            "978-0743273565",
            List.of("F. Scott Fitzgerald"),
            180);
    Patron patron = new Patron("John Doe", "john@example.com");
    Librarian librarian = new Librarian("Anthony Mays", "anthony@example.com");
    classUnderTest.addMediaItem(book, librarian);
    classUnderTest.addLibraryGuest(patron);
    classUnderTest.checkOutMediaItem(book, patron);
    // Act
    boolean wasCheckedOut = classUnderTest.checkOutMediaItem(book, patron);
    // Assert
    assertThat(wasCheckedOut).isFalse();
    assertThat(classUnderTest.isCheckedOut(book)).isTrue();
  }

  @Test
  void testLibrary_preventsRemovingPatronWithCheckedOutItems() {
    // Arrange
    Book book =
        new Book(
            UUID.randomUUID(),
            "The Great Gatsby",
            "978-0743273565",
            List.of("F. Scott Fitzgerald"),
            180);
    Patron patron = new Patron("John Doe", "john@example.com");
    Librarian librarian = new Librarian("Anthony Mays", "anthony@example.com");
    classUnderTest.addMediaItem(book, librarian);
    classUnderTest.addLibraryGuest(patron);
    classUnderTest.checkOutMediaItem(book, patron);
    // Act
    assertThatThrownBy(() -> classUnderTest.removeLibraryGuest(patron))
        .isInstanceOf(MediaItemCheckedOutException.class)
        .hasMessage("Cannot remove guest with checked out items.");
  }

  @Test
  void testLibrary_preventsRemovingCheckedOutItems() {
    // Arrange
    Book book =
        new Book(
            UUID.randomUUID(),
            "The Great Gatsby",
            "978-0743273565",
            List.of("F. Scott Fitzgerald"),
            180);
    Patron patron = new Patron("Jane Doe", "jane@example.com");
    Librarian librarian = new Librarian("Anthony Mays", "anthony@example.com");
    classUnderTest.addMediaItem(book, librarian);
    classUnderTest.addLibraryGuest(patron);
    classUnderTest.checkOutMediaItem(book, patron);
    // Act
    assertThatThrownBy(() -> classUnderTest.removeMediaItem(book, librarian))
        .isInstanceOf(MediaItemCheckedOutException.class)
        .hasMessage("Cannot remove checked out item.");
  }

  @Test
  void testLibrary_canAddDvd() {
    // Arrange
    Dvd dvd = new Dvd(UUID.randomUUID(), "The Great Gatsby");
    Librarian librarian = new Librarian("Anthony Mays", "anthony@example.com");
    // Act
    classUnderTest.addMediaItem(dvd, librarian);
    // Assert
    assertThat(classUnderTest.hasMediaItem(dvd)).isTrue();
  }

  @Test
  void testLibrary_canRemoveDvd() {
    // Arrange
    Dvd dvd = new Dvd(UUID.randomUUID(), "The Great Gatsby");
    Librarian librarian = new Librarian("Anthony Mays", "anthony@example.com");
    // Act
    classUnderTest.removeMediaItem(dvd, librarian);
    // Assert
    assertThat(classUnderTest.hasMediaItem(dvd)).isFalse();
  }

  @Test
  void testLibrary_allowLibrarianToCheckOutDvd() {
    // Arrange
    Librarian librarian = new Librarian("Anthony Mays", "anthony@example.com");
    Dvd dvd = new Dvd(UUID.randomUUID(), "The Great Gatsby");
    classUnderTest.addMediaItem(dvd, librarian);
    classUnderTest.addLibraryGuest(librarian);
    // Act
    boolean wasCheckedOut = classUnderTest.checkOutMediaItem(dvd, librarian);
    // Assert
    assertThat(wasCheckedOut).isTrue();
    assertThat(librarian.getCheckedOutMediaItems().contains(dvd)).isTrue();
  }

  @Test
  void testLibrary_allowPatronToCheckInDvd() {
    // Arrange
    Dvd dvd = new Dvd(UUID.randomUUID(), "The Great Gatsby");
    Patron patron = new Patron("John Doe", "john@example.com");
    Librarian librarian = new Librarian("Anthony Mays", "anthony@example.com");
    classUnderTest.addMediaItem(dvd, librarian);
    classUnderTest.addLibraryGuest(patron);
    classUnderTest.checkOutMediaItem(dvd, patron);
    // Act
    boolean wasReturned = classUnderTest.checkInMediaItem(dvd, patron);
    // Assert
    assertThat(wasReturned).isTrue();
    assertThat(classUnderTest.isCheckedOut(dvd)).isFalse();
    assertThat(patron.getCheckedOutMediaItems().contains(dvd)).isFalse();
  }

  @Test
  void testLibrary_preventsGuestFromCheckingOutMagazine() {
    // Arrange
    Patron patron = new Patron("John Doe", "john@example.com");
    Librarian librarian = new Librarian("Anthony Mays", "anthony@example.com");
    Magazine magazine = new Magazine(UUID.randomUUID(), "The Great Gatsby");
    classUnderTest.addMediaItem(magazine, librarian);
    classUnderTest.addLibraryGuest(librarian);
    classUnderTest.addLibraryGuest(patron);
    // Act
    boolean wasCheckedOut = classUnderTest.checkOutMediaItem(magazine, librarian);
    // Assert
    assertThat(wasCheckedOut).isFalse();
    assertThat(patron.getCheckedOutMediaItems().contains(magazine)).isFalse();
  }

  @Test
  void testLibrary_preventsGuestFromCheckingOutNewspaper() {
    // Arrange
    Patron patron = new Patron("John Doe", "john@example.com");
    Librarian librarian = new Librarian("Anthony Mays", "anthony@example.com");
    Newspaper newspaper = new Newspaper(UUID.randomUUID(), "LA Times");
    classUnderTest.addMediaItem(newspaper, librarian);
    classUnderTest.addLibraryGuest(librarian);
    classUnderTest.addLibraryGuest(patron);
    // Act
    boolean wasCheckedOut = classUnderTest.checkOutMediaItem(newspaper, librarian);
    // Assert
    assertThat(wasCheckedOut).isFalse();
    assertThat(patron.getCheckedOutMediaItems().contains(newspaper)).isFalse();
  }

  @Test
  void testLibrary_retrievesAllPatrons() {
    // Arrange
    Patron patron1 = new Patron("John Doe", "john@example.com");
    Patron patron2 = new Patron("Jane Doe", "jane@example.com");
    classUnderTest.addLibraryGuest(patron1);
    classUnderTest.addLibraryGuest(patron2);

    // Act
    Set<LibraryGuest> guests = classUnderTest.getPatrons();

    // Assert
    assertThat(classUnderTest.getPatrons().size()).isEqualTo(2);
  }
}
