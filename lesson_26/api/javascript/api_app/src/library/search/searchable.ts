import { SearchCriteria } from './search_criteria';

export interface Searchable {
  /**
   * Indicates whether an item matches the search criteria.
   *
   * @param query The query to search for.
   * @return The items that match the query.
   */
  matches(query: SearchCriteria): boolean;
}
