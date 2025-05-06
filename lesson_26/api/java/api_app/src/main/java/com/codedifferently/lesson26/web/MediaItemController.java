package com.codedifferently.lesson26.web;

import com.codedifferently.lesson26.library.Librarian;
import com.codedifferently.lesson26.library.Library;
import com.codedifferently.lesson26.library.search.SearchCriteria;
import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
@CrossOrigin
public class MediaItemController {

  private final Library library;
  private final Librarian librarian;

  public MediaItemController(Library library, Librarian librarian) {
    this.library = library;
    this.librarian = librarian;
  }

  @GetMapping
  public GetMediaItemsResponse getItems() {
    var items = library.search(SearchCriteria.builder().build());
    var responseItems = items.stream().map(MediaItemResponse::from).toList();
    return GetMediaItemsResponse.builder().items(responseItems).build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<MediaItemResponse> getItemById(@PathVariable UUID id) {
    var criteria = SearchCriteria.builder().id(id.toString()).build();
    var results = library.search(criteria);
    return results.isEmpty()
        ? ResponseEntity.notFound().build()
        : ResponseEntity.ok(MediaItemResponse.from(results.iterator().next()));
  }

  @PostMapping
  public CreateMediaItemResponse addItem(@Valid @RequestBody CreateMediaItemRequest request) {
    var item = MediaItemRequest.asMediaItem(request.getItem());
    library.addMediaItem(item, librarian);
    var response = getItemById(item.getId()).getBody();
    return CreateMediaItemResponse.builder().item(response).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteItem(@PathVariable UUID id) {
    var criteria = SearchCriteria.builder().id(id.toString()).build();
    var results = library.search(criteria);
    if (results.isEmpty()) return ResponseEntity.notFound().build();

    library.removeMediaItem(results.iterator().next(), librarian);
    return ResponseEntity.noContent().build();
  }
}
