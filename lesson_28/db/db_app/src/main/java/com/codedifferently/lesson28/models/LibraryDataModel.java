package com.codedifferently.lesson28.models;

import com.codedifferently.lesson28.library.Book;
import com.codedifferently.lesson28.library.Dvd;
import com.codedifferently.lesson28.library.Librarian;
import com.codedifferently.lesson28.library.LibraryGuest;
import com.codedifferently.lesson28.library.Magazine;
import com.codedifferently.lesson28.library.MediaItem;
import com.codedifferently.lesson28.library.Newspaper;
import com.codedifferently.lesson28.library.Patron;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryDataModel {
  public List<MediaItemModel> mediaItems;
  public List<LibraryGuestModel> guests;

  public List<MediaItem> getMediaItems() {
    List<MediaItem> results = new ArrayList<>();
    for (MediaItemModel mediaItemModel : mediaItems) {
      switch (mediaItemModel.type) {
        case "book" ->
            results.add(
                new Book(
                    mediaItemModel.id,
                    mediaItemModel.title,
                    mediaItemModel.isbn,
                    mediaItemModel.authors,
                    mediaItemModel.pages));
        case "dvd" -> results.add(new Dvd(mediaItemModel.id, mediaItemModel.title));
        case "magazine" -> results.add(new Magazine(mediaItemModel.id, mediaItemModel.title));
        case "newspaper" -> results.add(new Newspaper(mediaItemModel.id, mediaItemModel.title));
        default ->
            throw new IllegalArgumentException("Unknown media item type: " + mediaItemModel.type);
      }
    }
    return results;
  }

  public List<LibraryGuest> getGuests() {
    List<LibraryGuest> results = new ArrayList<>();
    for (LibraryGuestModel guestModel : this.guests) {
      switch (guestModel.type) {
        case "librarian" -> results.add(new Librarian(guestModel.name, guestModel.email));
        case "patron" -> results.add(new Patron(guestModel.name, guestModel.email));
        default -> throw new AssertionError();
      }
    }
    return results;
  }

  public Map<String, List<CheckoutModel>> getCheckoutsByEmail() {
    Map<String, List<CheckoutModel>> results = new HashMap<>();
    for (LibraryGuestModel guest : this.guests) {
      results.put(guest.email, guest.checkedOutItems);
    }
    return results;
  }
}
