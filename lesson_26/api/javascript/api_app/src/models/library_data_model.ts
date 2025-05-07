import {
  Book,
  Dvd,
  Librarian,
  LibraryGuest,
  Magazine,
  MediaItem,
  MediaType,
  Newspaper,
  Patron,
} from '../library';

export interface MediaItemModel {
  id: string;
  title: string;
  type: string;
  isbn?: string;
  authors?: string[];
  pages?: number;
}

export interface LibraryGuestModel {
  name: string;
  email: string;
  type: string;
  checkedOutItems: CheckoutModel[];
}

export interface CheckoutModel {
  itemId: string;
  dueDate?: string;
}

export class LibraryDataModel {
  public mediaItems: MediaItemModel[];
  public guests: LibraryGuestModel[];

  constructor(mediaItems: MediaItemModel[], guests: LibraryGuestModel[]) {
    this.mediaItems = mediaItems;
    this.guests = guests;
  }

  public getMediaItems(): MediaItem[] {
    return this.mediaItems.map((mediaItemModel) => {
      switch (mediaItemModel.type) {
        case MediaType.BOOK:
          return new Book(
            mediaItemModel.id,
            mediaItemModel.title,
            mediaItemModel.isbn!,
            mediaItemModel.authors!,
            mediaItemModel.pages!,
          );
        case MediaType.DVD:
          return new Dvd(mediaItemModel.id, mediaItemModel.title);
        case MediaType.MAGAZINE:
          return new Magazine(mediaItemModel.id, mediaItemModel.title);
        case MediaType.NEWSPAPER:
          return new Newspaper(mediaItemModel.id, mediaItemModel.title);
        default:
          throw new Error(`Unknown media item type: ${mediaItemModel.type}`);
      }
    });
  }

  public getGuests(): LibraryGuest[] {
    return this.guests.map((guestModel) => {
      switch (guestModel.type) {
        case 'librarian':
          return new Librarian(guestModel.name, guestModel.email);
        case 'patron':
          return new Patron(guestModel.name, guestModel.email);
        default:
          throw new Error(`Unknown guest type: ${guestModel.type}`);
      }
    });
  }

  public getCheckoutsByEmail(): Map<string, CheckoutModel[]> {
    const results = new Map<string, CheckoutModel[]>();
    this.guests.forEach((guest) => {
      results.set(guest.email, guest.checkedOutItems);
    });
    return results;
  }
}
