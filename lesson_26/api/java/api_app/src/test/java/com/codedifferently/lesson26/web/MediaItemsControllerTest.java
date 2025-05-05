package com.codedifferently.lesson26.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.codedifferently.lesson26.Lesson26;
import com.codedifferently.lesson26.library.Book;
import com.codedifferently.lesson26.library.Library;
import com.codedifferently.lesson26.library.MediaItem;
import com.codedifferently.lesson26.library.search.SearchCriteria;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@ContextConfiguration(classes = Lesson26.class)
class MediaItemsControllerTest {
  private static MockMvc mockMvc;
  @Autowired private Library library;

  @BeforeAll
  static void setUp(WebApplicationContext wac) {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  void testController_getsAllItems() throws Exception {
    mockMvc
        .perform(get("/items").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.items").isArray())
        .andExpect(jsonPath("$.items.length()").value(31));
  }

  @Test
  void testController_getsAnItem() throws Exception {
    mockMvc
        .perform(
            get("/items/31616162-3831-3832-2d34-3334352d3465")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void testController_returnsNotFoundOnGetItem() throws Exception {
    mockMvc
        .perform(
            get("/items/00000000-0000-0000-0000-000000000000")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  void testController_reportsBadRequestOnAddItem() throws Exception {
    String json = "{}";

    mockMvc
        .perform(post("/items").contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.errors").isArray())
        .andExpect(jsonPath("$.errors.length()").value(1));
  }

  @Test
  void testController_addsItem() throws Exception {
    String json =
        """
        {
          "item": {
            "id": "e27a4e0d-9664-420d-955e-c0e295d0ce02",
            "type": "BOOK",
            "title": "Becoming",
            "isbn": "9781524763138",
            "authors": ["Michelle Obama"],
            "pages": 448
          }
        }
        """;

    mockMvc
        .perform(post("/items").contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.item.id").value("e27a4e0d-9664-420d-955e-c0e295d0ce02"));

    Set<MediaItem> items =
        library.search(SearchCriteria.builder().id("e27a4e0d-9664-420d-955e-c0e295d0ce02").build());
    assertThat(items).hasSize(1);
    var item = items.iterator().next();
    assertThat(item).isInstanceOf(Book.class);
    assertThat(item.getTitle()).isEqualTo("Becoming");
  }

  @Test
  void testController_returnsNotFoundOnDeleteItem() throws Exception {
    mockMvc
        .perform(
            delete("/items/00000000-0000-0000-0000-000000000000")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  void testController_deletesItem() throws Exception {
    mockMvc
        .perform(
            delete("/items/32623932-6566-3364-2d62-3232342d3435")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());

    Set<MediaItem> items =
        library.search(SearchCriteria.builder().id("32623932-6566-3364-2d62-3232342d3435").build());
    assertThat(items).hasSize(0);
  }
}
