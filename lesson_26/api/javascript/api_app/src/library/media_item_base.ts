import { Library } from './library';
import { MediaItem } from './media_item';
import { MediaType } from './media_type';
import { SearchCriteria } from './search/search_criteria';

export abstract class MediaItemBase implements MediaItem {
  private library: Library | null = null;
  private readonly id: string;
  private readonly title: string;

  constructor(id: string, title: string) {
    this.id = id;
    this.title = title;
  }

  getId(): string {
    return this.id;
  }

  getTitle(): string {
    return this.title;
  }

  setLibrary(library: Library): void {
    if (library && !library.hasMediaItem(this)) {
      throw new Error(
        `Media item ${this.getId()} is not in library ${library.getId()}`,
      );
    }
    this.library = library;
  }

  isCheckedOut(): boolean {
    if (!this.library) {
      throw new Error(`Library not set for item ${this.getId()}`);
    }
    return this.library.isCheckedOut(this);
  }

  canCheckOut(): boolean {
    return true;
  }

  protected matchesAuthor(author: string): boolean {
    return false;
  }

  matches(query: SearchCriteria): boolean {
    if (query.id && this.getId() !== query.id) {
      return false;
    }
    if (
      query.title &&
      !this.getTitle().toLowerCase().includes(query.title.toLowerCase())
    ) {
      return false;
    }
    if (query.type && !this.getType().includes(query.type.toLowerCase())) {
      return false;
    }
    return !query.author || this.matchesAuthor(query.author);
  }

  toString(): string {
    return `MediaItem{id='${this.getId()}', title='${this.getTitle()}'}`;
  }

  abstract getType(): MediaType;
}
