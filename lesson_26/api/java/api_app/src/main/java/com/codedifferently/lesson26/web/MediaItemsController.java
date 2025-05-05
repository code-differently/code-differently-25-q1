package com.codedifferently.lesson26.web;

import com.codedifferently.lesson26.library.Librarian;
import com.codedifferently.lesson26.library.Library;
import com.codedifferently.lesson26.library.MediaItem;
import com.codedifferently.lesson26.library.exceptions.MediaItemCheckedOutException;
import com.codedifferently.lesson26.library.search.SearchCriteria;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.List;
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
  public ResponseEntity<CreateMediaItemResponse> createItem(
      @Valid @RequestBody CreateMediaItemRequest createRequest) {
    MediaItemRequest itemRequest = createRequest.getItem();
    MediaItem newItem = MediaItemRequest.asMediaItem(itemRequest);
    library.addMediaItem(newItem, this.librarian);
    MediaItemResponse itemResponse = MediaItemResponse.from(newItem);
    CreateMediaItemResponse response = CreateMediaItemResponse.builder().item(itemResponse).build();
    return ResponseEntity.ok(response);
  }

  @GetMapping("/items/{id}")
  public ResponseEntity<MediaItemResponse> getItemById(@PathVariable UUID id) {
    Set<MediaItem> items = library.search(SearchCriteria.builder().build());
    MediaItem foundItem =
        items.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    if (foundItem != null) {
      MediaItemResponse itemResponse = MediaItemResponse.from(foundItem);
      return ResponseEntity.ok(itemResponse);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/items/{id}")
  public ResponseEntity<Void> deleteItem(@PathVariable String id) { // Takes String id
    UUID itemUuid;

    try {
      itemUuid = UUID.fromString(id);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().build();
    }

    Set<MediaItem> items = library.search(SearchCriteria.builder().build());
    MediaItem foundItem =
        items.stream().filter(item -> item.getId().equals(itemUuid)).findFirst().orElse(null);

    if (foundItem == null) {
      return ResponseEntity.notFound().build();
    }

    try {
      library.removeMediaItem(itemUuid, this.librarian);
      return ResponseEntity.noContent().build();
    } catch (MediaItemCheckedOutException ex) {
      return ResponseEntity.status(HttpStatus.CONFLICT).build();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
