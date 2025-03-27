import { MediaItem } from '../models/media_item.js';

export interface Loader {
  getLoaderName(): string;
  loadData(): Promise<MediaItem[]>;
}
