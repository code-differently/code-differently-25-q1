import { Injectable, Logger } from '@nestjs/common';
import { Librarian } from './librarian';
import { LibraryGuest } from './library_guest';
import { MediaItem } from './media_item';
import { CatalogSearcher } from './search/catalog_searcher';
import { SearchCriteria } from './search/search_criteria';

@Injectable()
export class LibraryService {
  private readonly itemsById: Map<string, MediaItem> = new Map();
  private readonly checkedOutItemIds: Set<string> = new Set();
  private readonly checkedOutItemsByGuest: Map<string, Set<MediaItem>> =
    new Map();
  private readonly guestsById: Map<string, LibraryGuest> = new Map();
  private readonly id: string;
  private readonly searcher: CatalogSearcher<MediaItem>;
  private readonly logger: Logger = new Logger(LibraryService.name);

  constructor(id: string) {
    this.id = id;
    this.searcher = new CatalogSearcher(this.itemsById);
  }

  getId(): string {
    return this.id;
  }

  addMediaItem(item: MediaItem, librarian: Librarian): void {
    this.itemsById.set(item.getId(), item);
    item.setLibrary(this);
  }

  removeMediaItem(item: MediaItem, librarian: Librarian): void {
    if (this.isCheckedOut(item)) {
      throw new Error('Cannot remove checked out item.');
    }
    this.itemsById.delete(item.getId());
    item.setLibrary(null);
  }

  removeMediaItemById(id: string, librarian: Librarian): void {
    const item = this.itemsById.get(id);
    if (item) {
      this.removeMediaItem(item, librarian);
    }
  }

  addLibraryGuest(guest: LibraryGuest): void {
    this.guestsById.set(guest.getId(), guest);
    this.checkedOutItemsByGuest.set(guest.getId(), new Set());
    guest.setLibrary(this);
  }

  removeLibraryGuestById(id: string): void {
    const guest = this.guestsById.get(id);
    if (guest && this.checkedOutItemsByGuest.get(guest.getId())?.size === 0) {
      this.guestsById.delete(guest.getId());
      this.checkedOutItemsByGuest.delete(guest.getId());
      guest.setLibrary(null);
    } else {
      throw new Error('Cannot remove guest with checked out items.');
    }
  }

  removeLibraryGuest(guest: LibraryGuest): void {
    this.removeLibraryGuestById(guest.getId());
  }

  getLibrarians(): Set<Librarian> {
    return new Set(
      Array.from(this.guestsById.values()).filter(
        (g): g is Librarian => g instanceof Librarian,
      ),
    );
  }

  getPatrons(): Set<LibraryGuest> {
    return new Set(this.guestsById.values());
  }

  checkOutMediaItem(item: MediaItem, guest: LibraryGuest): boolean {
    if (!this.canCheckOutMediaItem(item, guest)) {
      return false;
    }
    this.checkedOutItemIds.add(item.getId());
    this.checkedOutItemsByGuest.get(guest.getId())?.add(item);
    return true;
  }

  private canCheckOutMediaItem(item: MediaItem, guest: LibraryGuest): boolean {
    return (
      item.canCheckOut() &&
      this.hasMediaItem(item) &&
      !this.isCheckedOut(item) &&
      this.hasLibraryGuest(guest)
    );
  }

  hasMediaItem(item: MediaItem): boolean {
    return this.itemsById.has(item.getId());
  }

  hasMediaItemById(id: string): boolean {
    return this.itemsById.has(id);
  }

  isCheckedOut(item: MediaItem): boolean {
    return this.checkedOutItemIds.has(item.getId());
  }

  hasLibraryGuest(guest: LibraryGuest): boolean {
    return this.guestsById.has(guest.getId());
  }

  hasLibraryGuestById(id: string): boolean {
    return this.guestsById.has(id);
  }

  hasLibraryGuestByEmail(emailAddress: string): boolean {
    return Array.from(this.guestsById.values()).some(
      (g) => g.getEmail().toLowerCase() === emailAddress.toLowerCase(),
    );
  }

  checkInMediaItem(item: MediaItem, guest: LibraryGuest): boolean {
    if (!this.hasMediaItem(item)) {
      return false;
    }
    this.checkedOutItemIds.delete(item.getId());
    this.checkedOutItemsByGuest.get(guest.getId())?.delete(item);
    return true;
  }

  getCheckedOutByGuest(guest: LibraryGuest): Set<MediaItem> {
    return this.checkedOutItemsByGuest.get(guest.getId()) || new Set();
  }

  /**
   * Search the library for items matching the given query.
   *
   * @param query The query to search for.
   * @return The items matching the query.
   */
  search(query: SearchCriteria): ReadonlySet<MediaItem> {
    return new Set(this.searcher.search(query));
  }

  toString(): string {
    return `Library{itemsById=${Array.from(this.itemsById.entries())}, checkedOutItemIds=${Array.from(
      this.checkedOutItemIds,
    )}, checkedOutItemsByGuest=${Array.from(this.checkedOutItemsByGuest.entries())}, guestsById=${Array.from(
      this.guestsById.entries(),
    )}}`;
  }
}
