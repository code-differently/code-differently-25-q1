export interface SearchCriteria {
  /** The ID to search for (exact match). */
  id?: string;

  /** The title to search for. */
  title?: string;

  /** The author to search for. */
  author?: string;

  /** The type to search for (exact match). */
  type?: string;
}
