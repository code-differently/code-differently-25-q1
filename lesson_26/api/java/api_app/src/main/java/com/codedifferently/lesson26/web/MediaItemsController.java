package com.codedifferently.lesson26.web;

import com.codedifferently.lesson26.library.Librarian;
import com.codedifferently.lesson26.library.Library;
import com.codedifferently.lesson26.library.MediaItem;
import com.codedifferently.lesson26.library.search.SearchCriteria;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    if (items.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    List<MediaItemResponse> responseItems = items.stream().map(MediaItemResponse::from).toList();
    var response = GetMediaItemsResponse.builder().items(responseItems).build();
    return ResponseEntity.ok(response);
  }

  @GetMapping("/items/{id}")
  public ResponseEntity<GetMediaItemsResponse> getItem(@PathVariable("id") String id) {
    Set<MediaItem> items = library.search(SearchCriteria.builder().id(id).build());
    if (items.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    MediaItemResponse responseItem = MediaItemResponse.from(items.iterator().next());
    GetMediaItemsResponse response = GetMediaItemsResponse.builder().item(responseItem).build();
    return ResponseEntity.ok(response);
  }

  @PostMapping("/items")
  public ResponseEntity<MediaItemResponse> postItem(@RequestBody CreateMediaItemRequest request) {
    MediaItemRequest item = request.getItem();
    MediaItem response = MediaItemRequest.asMediaItem(item);
    MediaItemResponse itemResponse = MediaItemResponse.from(response);
    CreateMediaItemResponse createItemResponse =
        CreateMediaItemResponse.builder().item(itemResponse).build();
    MediaItemResponse createdItem = createItemResponse.getItem();
    return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
  }

  @DeleteMapping("/items/{id}")
  public ResponseEntity<Void> deleteItem(@PathVariable("id") String id) {
    Set<MediaItem> item = library.search(SearchCriteria.builder().id(id).build());
    if (item.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    library.removeMediaItem(item.iterator().next(), librarian);
    return ResponseEntity.noContent().build();
  }
}
