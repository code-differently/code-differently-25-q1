package com.codedifferently.lesson26.web;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedifferently.lesson26.library.Librarian;
import com.codedifferently.lesson26.library.Library;
import com.codedifferently.lesson26.library.MediaItem;
import com.codedifferently.lesson26.library.search.SearchCriteria;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

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
  public ResponseEntity<MediaItemResponse> getItemsById(@PathVariable("id") UUID id) {
    Set<MediaItem> items = library.search(SearchCriteria.builder().build());

    if (items.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    MediaItem item = items.iterator().next();
    return ResponseEntity.ok(MediaItemResponse.from(item));
  }

  @PostMapping("/items")
  public ResponseEntity<CreateMediaItemResponse> postItem(@RequestBody CreateMediaItemRequest request) {
    MediaItem newItem = MediaItemRequest.asMediaItem(request.getItem());

    library.addMediaItem(newItem, librarian);

    MediaItemResponse itemResponse = MediaItemResponse.from(newItem);
    CreateMediaItemResponse response = CreateMediaItemResponse.builder().item(itemResponse).build();
    
    return ResponseEntity.ok(response);
  }
}
