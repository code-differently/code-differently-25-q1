package com.codedifferently.lesson26.web;

import com.codedifferently.lesson26.library.Book;
import com.codedifferently.lesson26.library.Dvd;
import com.codedifferently.lesson26.library.Magazine;
import com.codedifferently.lesson26.library.MediaItem;
import com.codedifferently.lesson26.library.Newspaper;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MediaItemRequest {

  private UUID id;
  private String type;
  private String isbn;

  @NotBlank(message = "Title is required")
  private String title;

  private String[] authors;
  private String edition;
  private int pages;
  private int runtime;

  public static MediaItem asMediaItem(MediaItemRequest request) {
    var id = request.id != null ? request.id : UUID.randomUUID();
    switch (request.type.toLowerCase()) {
      case "book" -> {
        return new Book(id, request.title, request.isbn, List.of(request.authors), request.pages);
      }
      case "dvd" -> {
        return new Dvd(id, request.title);
      }
      case "magazine" -> {
        return new Magazine(id, request.title);
      }
      case "newspaper" -> {
        return new Newspaper(id, request.title);
      }
      default -> throw new IllegalArgumentException("Unknown media item type: " + request.type);
    }
  }
}
