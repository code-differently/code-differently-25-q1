import { Book, MediaItem, MediaType } from '../library';

interface MediaItemResponse {
  type: MediaType;
  id: string;
  isbn?: string;
  title: string;
  authors?: string[];
  edition?: string;
  pages?: number;
  runtime?: number;
}

function toMediaItemResponse(item: MediaItem): MediaItemResponse {
  const result: MediaItemResponse = {
    id: item.getId(),
    title: item.getTitle(),
    type: item.getType(),
  };

  if (item.getType() === MediaType.BOOK) {
    const book = item as Book;
    result.isbn = book.getIsbn();
    result.authors = book.getAuthors();
    result.pages = book.getNumberOfPages();
  }

  return result;
}

export { MediaItemResponse, toMediaItemResponse };
