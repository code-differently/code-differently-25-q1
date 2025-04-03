import csv from 'csv-parser';
import fs from 'fs';
import { Credit, MediaItem } from '../models/index.js';
import { Loader } from './loader.js';

export class JustinEklundLoader implements Loader {
  getLoaderName(): string {
    return 'justineklund';
  }

  async loadData(): Promise<MediaItem[]> {
    const credits = await this.loadCredits();
    const mediaItems = await this.loadMediaItems();
    const mediamap = new Map<string, MediaItem>();
    mediaItems.forEach((mediaItem) => {
      mediamap.set(mediaItem.getId(), mediaItem);
    });
    for (const mediaitem of mediaItems) {
      mediamap.set(mediaitem.getId(), mediaitem);
    }
    for (const credit of credits) {
      const mediaItem = mediamap.get(credit.getMediaItemId());
      
      if (mediaItem) {
        mediaItem.addCredit(credit);
      }
    }
    console.log(
      `Loaded ${credits.length} credits and ${mediaItems.length} media items`,
    );
  

    return Array.from(mediamap.values());
  }

  async loadMediaItems(): Promise<MediaItem[]> {
    const mediaItems = [];
    const readable = fs
      .createReadStream('data/media_items.csv', 'utf-8')
      .pipe(csv());
    for await (const row of readable) {
      const { id, type, title, year } = row;
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
// got assistance from ai and copilot aswell as Meiko ,Mercedes and Dillon.
