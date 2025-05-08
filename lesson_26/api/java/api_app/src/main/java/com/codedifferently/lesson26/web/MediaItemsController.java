package com.codedifferently.lesson26.web;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codedifferently.lesson26.library.Librarian;
import com.codedifferently.lesson26.library.Library;
import com.codedifferently.lesson26.library.MediaItem;
import com.codedifferently.lesson26.library.search.SearchCriteria;

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
  @PostMapping("/items")
public ResponseEntity<MediaItemResponse> createItem(@RequestBody MediaItemRequest request) {
    MediaItem newItem = MediaItemRequest.asMediaItem(request);

    Librarian librarian = new Librarian("system", "system@example.com");

    library.addMediaItem(newItem, librarian);

    return new ResponseEntity<>(MediaItemResponse.from(newItem), HttpStatus.CREATED);
}

@GetMapping("/items/{id}")
public ResponseEntity<MediaItemResponse> getItemById(@PathVariable UUID id) {
    Set<MediaItem> allItems = library.search(SearchCriteria.builder().build());

    Optional<MediaItem> itemOpt = allItems.stream()
        .filter(item -> item.getId().equals(id))
        .findFirst();

    if (itemOpt.isEmpty()) {
        return ResponseEntity.notFound().build();
    }

    MediaItemResponse response = MediaItemResponse.from(itemOpt.get());
    return ResponseEntity.ok(response);
}


@DeleteMapping("/items/{id}")
public ResponseEntity<Void> deleteItemById(@PathVariable UUID id) {
    Optional<MediaItem> itemOpt = library.search(SearchCriteria.builder().build())
        .stream()
        .filter(item -> item.getId().equals(id))
        .findFirst();

    if (itemOpt.isEmpty()) {
        return ResponseEntity.notFound().build();
    }

    MediaItem item = itemOpt.get();
    Librarian librarian = new Librarian("system", "system@example.com"); // placeholder
    library.removeMediaItem(item, librarian);

    return ResponseEntity.noContent().build(); // 204 No Content
}

}
