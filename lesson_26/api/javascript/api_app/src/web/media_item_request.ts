import { randomUUID } from 'crypto';
import {
  Book,
  Dvd,
  Magazine,
  MediaItem,
  MediaType,
  Newspaper,
} from '../library';

export interface MediaItemRequest {
  id?: string;
  type: string;
  isbn?: string;
  title: string;
  authors?: string[];
  edition?: string;
  pages?: number;
  runtime?: number;
}

export function fromMediaItemRequest(request: MediaItemRequest): MediaItem {
  const id = request.id ? request.id : randomUUID();
  switch (request.type.toLowerCase()) {
    case MediaType.BOOK:
      return new Book(
        id,
        request.title,
        request.isbn,
        request.authors,
        request.pages,
      );
    case MediaType.DVD:
      return new Dvd(id, request.title);
    case MediaType.MAGAZINE:
      return new Magazine(id, request.title);
    case MediaType.NEWSPAPER:
      return new Newspaper(id, request.title);
    default:
      throw new Error(`Unknown media item type: ${request.type}`);
  }
}
