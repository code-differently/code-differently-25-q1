package com.codedifferently.lesson28.factory;

import com.codedifferently.lesson28.library.Librarian;
import com.codedifferently.lesson28.library.Library;
import com.codedifferently.lesson28.library.LibraryGuest;
import com.codedifferently.lesson28.library.MediaItem;
import com.codedifferently.lesson28.models.CheckoutModel;
import com.codedifferently.lesson28.models.LibraryDataModel;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/** A factory class that creates a Library object with a LibraryDataLoader object. */
public final class LibraryFactory {

  /**
   * Create a Library object with a LibraryDataLoader object.
   *
   * @param loader A LibraryDataLoader object.
   * @return A Library object.
   * @throws IOException
   */
  public static Library createWithLoader(LibraryDataLoader loader) throws IOException {
    Library library = new Library("main-library");

    // Load library data.
    LibraryDataModel data = loader.loadData();

    // Add guests to the library.
    List<LibraryGuest> guests = data.getGuests();
    addLibraryGuests(library, guests);

    // Add library items using the first librarian.
    Librarian firstLibrarian = findFirstLibrarian(guests);
    List<MediaItem> mediaItems = data.getMediaItems();
    addLibraryItems(library, mediaItems, firstLibrarian);

    // Check out items from the library.
    Map<String, List<CheckoutModel>> checkoutsByEmail = data.getCheckoutsByEmail();
    Map<UUID, MediaItem> mediaItemById = getMediaItemsById(mediaItems);
    Map<String, LibraryGuest> guestsByEmail = getGuestsByEmail(guests);
    checkOutItems(library, checkoutsByEmail, guestsByEmail, mediaItemById);

    return library;
  }

  private static Map<UUID, MediaItem> getMediaItemsById(List<MediaItem> mediaItems) {
    Map<UUID, MediaItem> mediaItemById = new HashMap<>();
    for (MediaItem mediaItem : mediaItems) {
      mediaItemById.put(mediaItem.getId(), mediaItem);
    }
    return mediaItemById;
  }

  private static Librarian findFirstLibrarian(List<LibraryGuest> guests) {
    Librarian firstLibrarian = null;
    for (LibraryGuest guest : guests) {
      if (guest instanceof Librarian librarian) {
        firstLibrarian = librarian;
      }
    }
    return firstLibrarian;
  }

  private static void addLibraryGuests(Library library, List<LibraryGuest> guests) {
    for (LibraryGuest guest : guests) {
      library.addLibraryGuest(guest);
    }
  }

  private static void addLibraryItems(
      Library library, List<MediaItem> mediaItems, Librarian firstLibrarian) {
    for (MediaItem mediaItem : mediaItems) {
      library.addMediaItem(mediaItem, firstLibrarian);
    }
  }

  private static Map<String, LibraryGuest> getGuestsByEmail(List<LibraryGuest> guests) {
    Map<String, LibraryGuest> guestByEmail = new HashMap<>();
    for (LibraryGuest guest : guests) {
      guestByEmail.put(guest.getEmail(), guest);
    }
    return guestByEmail;
  }

  private static void checkOutItems(
      Library library,
      Map<String, List<CheckoutModel>> checkoutsByEmail,
      Map<String, LibraryGuest> guestByEmail,
      Map<UUID, MediaItem> mediaItemById) {
    for (var entry : checkoutsByEmail.entrySet()) {
      String email = entry.getKey();
      List<CheckoutModel> checkouts = entry.getValue();
      LibraryGuest guest = guestByEmail.get(email);
      for (CheckoutModel checkout : checkouts) {
        MediaItem mediaItem = mediaItemById.get(checkout.itemId);
        library.checkOutMediaItem(mediaItem, guest);
      }
    }
  }
}
