import { MediaItem } from './media_item.js';

export interface LibraryGuest {
  getId(): string;
  getEmail(): string;
  getName(): string;
  getCheckedOutMediaItems(): ReadonlySet<MediaItem>;
}
