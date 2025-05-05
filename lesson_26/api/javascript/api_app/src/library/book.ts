import { MediaItemBase } from './media_item_base';
import { MediaType } from './media_type';

export class Book extends MediaItemBase {
  private readonly isbn: string;
  private readonly authors: string[];
  private readonly numberOfPages: number;

  constructor(
    id: string,
    title: string,
    isbn: string,
    authors: string[],
    numberOfPages: number,
  ) {
    super(id, title);
    this.isbn = isbn;
    this.authors = authors;
    this.numberOfPages = numberOfPages;
  }

  getType(): MediaType {
    return MediaType.BOOK;
  }

  getIsbn(): string {
    return this.isbn;
  }

  getAuthors(): string[] {
    return this.authors;
  }

  getNumberOfPages(): number {
    return this.numberOfPages;
  }

  protected matchesAuthor(authorQuery: string): boolean {
    if (!authorQuery) {
      return true;
    }
    for (const author of this.getAuthors()) {
      if (author.toLowerCase().includes(authorQuery.toLowerCase())) {
        return true;
      }
    }
    return false;
  }

  toString(): string {
    return `Book{id='${this.getId()}', title='${this.getTitle()}'}`;
  }
}
