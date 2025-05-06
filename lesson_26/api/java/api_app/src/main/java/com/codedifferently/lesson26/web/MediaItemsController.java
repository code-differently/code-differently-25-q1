package com.codedifferently.lesson26.web;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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

import jakarta.validation.Valid;

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
  public ResponseEntity<CreateMediaItemResponse> postItem(@Valid @RequestBody CreateMediaItemRequest request) {
    MediaItemRequest itemRequest = request.getItem();
    MediaItem newItem = MediaItemRequest.asMediaItem(itemRequest);
    library.addMediaItem(newItem, librarian);
    MediaItemResponse itemResponse = MediaItemResponse.from(newItem);
    CreateMediaItemResponse response = CreateMediaItemResponse.builder().item(itemResponse).build();
    return ResponseEntity.ok(response);
  }

  @GetMapping("/items/{id}")
  public ResponseEntity<MediaItemResponse> getItemById(@PathVariable UUID id) {
    SearchCriteria criteria = SearchCriteria.builder().id(id.toString()).build();
    Set<MediaItem> items = library.search(criteria);

    if (!items.isEmpty()) {
      MediaItem item = items.iterator().next();
      MediaItemResponse response = MediaItemResponse.from(item);
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/items/{id}")
  public ResponseEntity<Void> deleteMediaItem(@PathVariable("id") UUID id) {
    try {
      library.removeMediaItem(id, librarian);
      return ResponseEntity.noContent().build();
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }
}
