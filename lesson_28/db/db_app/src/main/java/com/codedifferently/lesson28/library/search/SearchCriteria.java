package com.codedifferently.lesson28.library.search;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {
  /** The ID to search for (exact match). */
  public String id;

  /** The title to search for. */
  public String title;

  /** The author to search for. */
  public String author;

  /** The type to search for (exact match). */
  public String type;
}
