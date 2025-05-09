package com.codedifferently.lesson26.web;

import com.codedifferently.lesson26.library.Librarian;
import com.codedifferently.lesson26.library.Library;
import com.codedifferently.lesson26.library.MediaItem;
import com.codedifferently.lesson26.library.search.SearchCriteria;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
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
  public ResponseEntity<MediaItemResponse> getItemById(@PathVariable String id) {
    try {
      Set<MediaItem> items = library.search(SearchCriteria.builder().id(id).build());
      if (items.isEmpty()) {
        return ResponseEntity.notFound().build();
      }
      MediaItemResponse response = MediaItemResponse.from(items.iterator().next());
      return ResponseEntity.ok(response);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/items")
  public ResponseEntity<CreateMediaItemResponse> createItem(
      @Valid @RequestBody CreateMediaItemRequest request) {
    try {
      MediaItem item = MediaItemRequest.asMediaItem(request.getItem());
      library.addMediaItem(item, librarian);
      var response = CreateMediaItemResponse.builder().item(MediaItemResponse.from(item)).build();
      return ResponseEntity.ok(response);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().build();
    }
  }

  @DeleteMapping("/items/{id}")
  public ResponseEntity<Void> deleteItemById(@PathVariable String id) {
    try {
      UUID uuid = UUID.fromString(id);
      Set<MediaItem> items = library.search(SearchCriteria.builder().id(id).build());
      if (items.isEmpty()) {
        return ResponseEntity.notFound().build();
      }
      library.removeMediaItem(uuid, librarian);
      return ResponseEntity.noContent().build();
    } catch (IllegalArgumentException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, List<String>>> handleValidationErrors(
      MethodArgumentNotValidException ex) {
    List<String> errors =
        ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
    return ResponseEntity.badRequest().body(Map.of("errors", errors));
  }
}
