package com.codedifferently.lesson26.web;

import com.codedifferently.lesson26.library.Librarian;
import com.codedifferently.lesson26.library.Library;
import com.codedifferently.lesson26.library.MediaItem;
import com.codedifferently.lesson26.library.search.SearchCriteria;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class MediaItemsController {

  private final Library library;
  private final Librarian librarian;

  public MediaItemsController(Library library) throws IOException {
    this.library = library;
    this.librarian = library.getLibrarians().stream().findFirst().orElseThrow();
  }

  @GetMapping("/items")
  public ResponseEntity<GetMediaItemsResponse> getItems() {
    Set<MediaItem> items = library.search(SearchCriteria.builder().build());
    List<MediaItemResponse> responseItems = items.stream().map(MediaItemResponse::from).toList();
    var response = GetMediaItemsResponse.builder().items(responseItems).build();
    return ResponseEntity.ok(response);
  }

  @GetMapping("/items/{id}")
  public ResponseEntity<MediaItemResponse> getItem(@PathVariable String id) {
    MediaItem item = librarian.getItem(id);
    if (item == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(MediaItemResponse.from(item));
  }

  @PostMapping("/items")
  public ResponseEntity<?> createItem(@RequestBody CreateMediaItemRequest request) {
    if (request == null || request.getItem() == null) {
      return ResponseEntity.badRequest()
          .body(new ErrorResponse(List.of("Item details are required.")));
    }

    var item = request.getItem();
    MediaItem newItem =
        librarian.createItem(
            item.getTitle(),
            item.getType(),
            item.getGenre() != null ? item.getGenre() : "genre",
            item.getAuthor() != null ? item.getAuthor() : "author");

    return ResponseEntity.ok(CreateMediaItemResponse.from(newItem));
  }

  @DeleteMapping("/items/{id}")
  public ResponseEntity<Void> deleteItem(@PathVariable String id) {
    MediaItem item = librarian.getItem(id);
    if (item == null) {
      return ResponseEntity.notFound().build();
    }
    librarian.removeItem(id);
    return ResponseEntity.noContent().build();
  }
}
