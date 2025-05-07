import { LibraryDataLoader } from '../data/library_data_loader';
import { CheckoutModel, LibraryDataModel } from '../models';
import { Librarian } from './librarian';
import { LibraryService } from './library.service';
import { LibraryGuest } from './library_guest';
import { MediaItem } from './media_item';

export class LibraryFactory {
  /**
   * Create a Library object with a LibraryDataLoader object.
   *
   * @param loader A LibraryDataLoader object.
   * @return A Library object.
   * @throws IOException
   */
  static async createWithLoader(
    loader: LibraryDataLoader,
  ): Promise<LibraryService> {
    const library = new LibraryService('main-library');

    // Load library data.
    const data: LibraryDataModel = await loader.loadData();

    // Add guests to the library.
    const guests: LibraryGuest[] = data.getGuests();
    this.addLibraryGuests(library, guests);

    // Add library items using the first librarian.
    const firstLibrarian: Librarian = this.findFirstLibrarian(guests);
    const mediaItems: MediaItem[] = data.getMediaItems();
    this.addLibraryItems(library, mediaItems, firstLibrarian);

    // Check out items from the library.
    const checkoutsByEmail: Map<string, CheckoutModel[]> =
      data.getCheckoutsByEmail();
    const mediaItemById: Map<string, MediaItem> =
      this.getMediaItemsById(mediaItems);
    const guestsByEmail: Map<string, LibraryGuest> =
      this.getGuestsByEmail(guests);
    this.checkOutItems(library, checkoutsByEmail, guestsByEmail, mediaItemById);

    return library;
  }

  private static getMediaItemsById(
    mediaItems: MediaItem[],
  ): Map<string, MediaItem> {
    const mediaItemById = new Map<string, MediaItem>();
    for (const mediaItem of mediaItems) {
      mediaItemById.set(mediaItem.getId(), mediaItem);
    }
    return mediaItemById;
  }

  private static findFirstLibrarian(guests: LibraryGuest[]): Librarian {
    let firstLibrarian: Librarian = null;
    for (const guest of guests) {
      if (guest instanceof Librarian) {
        firstLibrarian = guest;
        break;
      }
    }
    return firstLibrarian;
  }

  private static addLibraryGuests(
    library: LibraryService,
    guests: LibraryGuest[],
  ): void {
    for (const guest of guests) {
      library.addLibraryGuest(guest);
    }
  }

  private static addLibraryItems(
    library: LibraryService,
    mediaItems: MediaItem[],
    firstLibrarian: Librarian,
  ): void {
    for (const mediaItem of mediaItems) {
      library.addMediaItem(mediaItem, firstLibrarian);
    }
  }

  private static getGuestsByEmail(
    guests: LibraryGuest[],
  ): Map<string, LibraryGuest> {
    const guestByEmail = new Map<string, LibraryGuest>();
    for (const guest of guests) {
      guestByEmail.set(guest.getEmail(), guest);
    }
    return guestByEmail;
  }

  private static checkOutItems(
    library: LibraryService,
    checkoutsByEmail: Map<string, CheckoutModel[]>,
    guestByEmail: Map<string, LibraryGuest>,
    mediaItemById: Map<string, MediaItem>,
  ): void {
    for (const [email, checkouts] of checkoutsByEmail.entries()) {
      const guest = guestByEmail.get(email);
      for (const checkout of checkouts) {
        const mediaItem = mediaItemById.get(checkout.itemId);
        library.checkOutMediaItem(mediaItem, guest);
      }
    }
  }
}
