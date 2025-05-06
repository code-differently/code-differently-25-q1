package com.codedifferently.lesson28.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.codedifferently.lesson28.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson28.library.exceptions.WrongLibraryException;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

  private Book classUnderTest;
  private Library library;

  @BeforeEach
  void setUp() {
    classUnderTest =
        new Book(
            UUID.fromString("2b7591dd-f418-4115-974e-45115b3bf39a"),
            "To Kill a Mockingbird",
            "978-0061120084",
            List.of("Harper Lee"),
            281);
    library = mock(Library.class);
    when(library.getId()).thenReturn("Library 1");
    when(library.hasMediaItem(classUnderTest)).thenReturn(true);
    classUnderTest.setLibrary(library);
  }

  @Test
  void testPatron_created() {
    // Assert
    assertThat(classUnderTest.getTitle()).isEqualTo("To Kill a Mockingbird");
    assertThat(classUnderTest.getIsbn()).isEqualTo("978-0061120084");
    assertThat(classUnderTest.getAuthors()).isEqualTo(List.of("Harper Lee"));
    assertThat(classUnderTest.getNumberOfPages()).isEqualTo(281);
  }

  @Test
  void testSetLibrary_WrongLibrary() {
    // Arrange
    Library otherLibrary = mock(Library.class);
    when(otherLibrary.hasMediaItem(classUnderTest)).thenReturn(false);
    when(otherLibrary.getId()).thenReturn("Library 2");

    // Act & Assert
    assertThatThrownBy(() -> classUnderTest.setLibrary(otherLibrary))
        .isInstanceOf(WrongLibraryException.class)
        .hasMessageContaining(
            "Media item 2b7591dd-f418-4115-974e-45115b3bf39a is not in library Library 2");
  }

  @Test
  void testIsCheckedOut_LibraryNotSet() {
    // Arrange
    classUnderTest.setLibrary(null);

    // Act & Assert
    assertThatThrownBy(() -> classUnderTest.isCheckedOut())
        .isInstanceOf(LibraryNotSetException.class)
        .hasMessageContaining("Library not set for item 2b7591dd-f418-4115-974e-45115b3bf39a");
  }

  @Test
  void testIsCheckedOut() {
    // Arrange
    when(library.isCheckedOut(classUnderTest)).thenReturn(true);

    // Act & Assert
    assertThat(classUnderTest.isCheckedOut()).isTrue();
  }

  @Test
  void testIsCheckedOut_whenNotCheckedOut() {
    // Arrange
    when(library.isCheckedOut(classUnderTest)).thenReturn(false);

    // Act & Assert
    assertThat(classUnderTest.isCheckedOut()).isFalse();
  }

  @Test
  void testToString() {
    // Act & Assert
    assertThat(classUnderTest.toString())
        .isEqualTo(
            "Book{id='2b7591dd-f418-4115-974e-45115b3bf39a', title='To Kill a Mockingbird'}");
  }
}
