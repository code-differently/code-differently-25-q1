import csv from 'csv-parser';
import fs from 'fs';
import { Credit, MediaItem } from '../models/index.js';
import { Loader } from './loader.js';

export class ChanelHuttLoader implements Loader {
  getLoaderName(): string {
    return 'chanelhutt';
  }

  async loadData(): Promise<MediaItem[]> {
    const credits = await this.loadCredits();
    const mediaItems = await this.loadMediaItems();
    // Create a Hashmap to where the key is a string(MediaItem ID) and the value is the MediaItem object.
    const hashMapIndex = new Map<string, MediaItem>();
    // Loops through the mediaItems and adds them to the map by their ID.
    for (const mediaItem of mediaItems) {
      hashMapIndex.set(mediaItem.getId(), mediaItem);
    }
    // Loops through the credits and adds them to the mediaItem by getting the mediaItem ID.
    for (const credit of credits) {
      const mediaItem = hashMapIndex.get(credit.getMediaItemId());
      if (mediaItem) {
        mediaItem.addCredit(credit);
      }
      console.log(
        `Loaded ${credits.length} credits and ${mediaItems.length} media items`,
      );
    }
    // Returns an array of the values from the hashmap.
    return Array.from(hashMapIndex.values());
  }

  async loadMediaItems(): Promise<MediaItem[]> {
    const mediaItems = [];
    const readable = fs
      .createReadStream('data/media_items.csv', 'utf-8')
      .pipe(csv());
    for await (const row of readable) {
      const { id, title, type, year } = row;
      mediaItems.push(new MediaItem(id, title, type, year, []));
    }
    return mediaItems;
  }

  async loadCredits(): Promise<Credit[]> {
    const credits = [];
    const readable = fs
      .createReadStream('data/credits.csv', 'utf-8')
      .pipe(csv());
    for await (const row of readable) {
      const { media_item_id, role, name } = row;
      credits.push(new Credit(media_item_id, name, role));
    }
    return credits;
  }
}
