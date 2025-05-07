package com.codedifferently.lesson28.library.search;

public interface Searchable {
  /**
   * Indicates whether an item matches the search criteria.
   *
   * @param query The query to search for.
   * @return The items that match the query.
   */
  boolean matches(SearchCriteria query);
}
