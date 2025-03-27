import { MediaItem } from './media_item.js';
import { SearchCriteria } from './search_criteria.js';

export class MediaCollection {
  private readonly items = new Map<string, MediaItem>();

  addItem(item: MediaItem): void {
    this.items.set(item.getId(), item);
  }

  removeItem(id: string): boolean {
    return this.items.delete(id);
  }

  search(criteria?: SearchCriteria): ReadonlySet<MediaItem> {
    if (criteria?.title) {
      return this.searchByTitle(criteria.title);
    }
    if (criteria?.releaseYear) {
      return this.searchByReleaseYear(criteria.releaseYear);
    }
    if (criteria?.type) {
      return this.searchByType(criteria.type);
    }
    if (criteria?.creditName) {
      return this.searchByCreditName(criteria.creditName);
    }
    return new Set(this.getItems());
  }

  searchByTitle(title: string): ReadonlySet<MediaItem> {
    return new Set(
      this.getItems().filter((item) =>
        item
          .getTitle()
          .toLowerCase()
          .includes(title?.toLowerCase() ?? ''),
      ),
    );
  }

  searchByReleaseYear(releaseYear: number): ReadonlySet<MediaItem> {
    return new Set(
      this.getItems().filter((item) => item.getReleaseYear() === releaseYear),
    );
  }

  searchByType(type: string): ReadonlySet<MediaItem> {
    return new Set(this.getItems().filter((item) => item.getType() === type));
  }

  searchByCreditName(name: string): ReadonlySet<MediaItem> {
    return new Set(
      this.getItems().filter((item) =>
        item.getCredits().some((credit) =>
          credit
            .getName()
            .toLowerCase()
            .includes(name?.toLowerCase() ?? ''),
        ),
      ),
    );
  }

  private getItems(): readonly MediaItem[] {
    return [...this.items.values()];
  }

  getInfo() {
    return {
      getItems: () => [...this.items] as readonly [string, MediaItem][],
    };
  }
}
