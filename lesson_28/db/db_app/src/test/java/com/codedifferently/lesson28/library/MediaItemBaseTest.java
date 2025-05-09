package com.codedifferently.lesson28.library;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.codedifferently.lesson28.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson28.library.exceptions.WrongLibraryException;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MediaItemBaseTest {
  private MediaItemBase mediaItem;
  private static final UUID ITEM_ID = UUID.fromString("af71ac38-7628-415f-a2cd-bcaf7e001b97");

  class MockMediaItem extends MediaItemBase {
    public MockMediaItem(UUID id, String title) {
      super(id, title);
    }

    @Override
    public String getType() {
      return "mock";
    }
  }

  @BeforeEach
  void setUp() {
    mediaItem = new MockMediaItem(ITEM_ID, "Sample Title");
  }

  @Test
  void getId() {
    assertEquals(ITEM_ID, mediaItem.getId());
  }

  @Test
  void getTitle() {
    assertEquals("Sample Title", mediaItem.getTitle());
  }

  @Test
  void setLibrary_withWrongLibraryException() {
    Library library = mock(Library.class);
    when(library.getId()).thenReturn("compton-library");
    when(library.hasMediaItem(mediaItem)).thenReturn(false);
    assertThatThrownBy(() -> mediaItem.setLibrary(library))
        .isInstanceOf(WrongLibraryException.class)
        .hasMessage(
            "Media item af71ac38-7628-415f-a2cd-bcaf7e001b97 is not in library compton-library");
  }

  @Test
  void isCheckedOut() throws LibraryNotSetException {
    Library library = mock(Library.class);
    when(library.hasMediaItem(mediaItem)).thenReturn(true);
    when(library.isCheckedOut(mediaItem)).thenReturn(true);
    mediaItem.setLibrary(library);
    assertTrue(mediaItem.isCheckedOut());
  }

  @Test
  void isCheckedOut_withLibraryNotSetException() {
    assertThatThrownBy(() -> mediaItem.isCheckedOut())
        .isInstanceOf(LibraryNotSetException.class)
        .hasMessage("Library not set for item af71ac38-7628-415f-a2cd-bcaf7e001b97");
  }

  @Test
  void canCheckOut() {
    assertTrue(mediaItem.canCheckOut());
  }

  @Test
  void equals() {
    MediaItemBase mediaItem2 = new MockMediaItem(ITEM_ID, "Sample Title");
    assertEquals(mediaItem, mediaItem2);
  }

  @Test
  void hashCodeTest() {
    MediaItemBase mediaItem2 = new MockMediaItem(ITEM_ID, "Sample Title");
    assertEquals(mediaItem.hashCode(), mediaItem2.hashCode());
  }

  @Test
  void toStringTest() {
    String expected = "MediaItem{id='af71ac38-7628-415f-a2cd-bcaf7e001b97', title='Sample Title'}";
    assertEquals(expected, mediaItem.toString());
  }
}
