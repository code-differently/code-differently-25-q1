import { LibraryGuest } from '../library/library_guest.js';
import { MediaItem } from '../library/media_item.js';
import { CheckoutModel } from './checkout_model.js';

export class LibraryDataModel {
  public mediaItems: MediaItem[];
  public guests: LibraryGuest[];

  constructor(mediaItems: MediaItem[], guests: LibraryGuest[]) {
    this.mediaItems = mediaItems;
    this.guests = guests;
  }

  public getMediaItems(): MediaItem[] {
    return this.mediaItems;
  }

  public getGuests(): LibraryGuest[] {
    return this.guests;
  }

  public getCheckoutsByEmail(): Map<string, CheckoutModel[]> {
    const results = new Map<string, CheckoutModel[]>();
    this.guests.forEach((guest) => {
      results.set(
        guest.getEmail(),
        Array.from(guest.getCheckedOutMediaItems()).map((item: MediaItem) => ({
          mediaItemId: item.getId(),
          checkoutDate: new Date(),
          dueDate: new Date(Date.now() + 14 * 24 * 60 * 60 * 1000), // 14 days from now
        })),
      );
    });
    return results;
  }
}
