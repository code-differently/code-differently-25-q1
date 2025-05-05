package com.codedifferently.lesson26.web;

import com.codedifferently.lesson26.library.Librarian;
import com.codedifferently.lesson26.library.Library;
import com.codedifferently.lesson26.library.MediaItem;
import com.codedifferently.lesson26.library.search.SearchCriteria;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

  /**
   * @param id
   * @return
   */
  @PostMapping("/items/{id}")
  public ResponseEntity<MediaItemResponse> getItemById(String id) {
    MediaItem item = librarian.getItemById(id);
    MediaItemResponse response = MediaItemResponse.from(item);
    return ResponseEntity.ok(response);
  }

  /**
   * @param id
   * @return
   */
  @DeleteMapping("/items/{id}")
  public ResponseEntity<Void> deleteItemById(String id) {
    SearchCriteria criteria = SearchCriteria.builder().id(id).build();
    Set<MediaItem> items = library.search(criteria);
    if (items.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    MediaItem item = items.iterator().next();
    
    librarian.deleteItemById(id);
    return ResponseEntity.noContent().build();

  
  }

}

