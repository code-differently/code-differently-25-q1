import { SearchCriteria } from './search_criteria';
import { Searchable } from './searchable';

export class CatalogSearcher<T extends Searchable> {
  private catalog: ReadonlyMap<string, T>;

  constructor(catalog: ReadonlyMap<string, T>) {
    this.catalog = catalog;
  }

  search(query: SearchCriteria): T[] {
    return [...this.catalog.values()].filter((item) => item.matches(query));
  }
}
