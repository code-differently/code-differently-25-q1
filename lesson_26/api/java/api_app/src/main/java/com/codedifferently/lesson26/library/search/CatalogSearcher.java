package com.codedifferently.lesson26.library.search;

import java.util.Collection;

/**
 * Searches a catalog for items that match a query.
 *
 * @param <T>
 */
public class CatalogSearcher<T extends Searchable> {
  private final Collection<T> catalog;

  /**
   * Constructor for CatalogSearcher
   *
   * @param catalog
   */
  public CatalogSearcher(Collection<T> catalog) {
    this.catalog = catalog;
  }

  /**
   * Searches the catalog for items that match the given query.
   *
   * @param query The query to search for.
   * @return The items that match the query.
   */
  public Collection<T> search(SearchCriteria query) {
    return catalog.stream().filter(item -> item.matches(query)).toList();
  }
}
