import csv from 'csv-parser';
import fs from 'fs';
import { Credit, MediaItem } from '../models/index.js';
import { Loader } from './loader.js';

export class KhaylaSaundersLoader implements Loader {
  getLoaderName(): string {
    return 'khaylasaunders';
  }

  async loadData(): Promise<MediaItem[]> {
    const credits = await this.loadCredits();
    const mediaItems = await this.loadMediaItems();

    console.log(
      `Loaded ${credits.length} credits and ${mediaItems.length} media items`,
    );
    //Extra credit was generated with the assistance of chatGPT
    const creditsMap: Record<string, Credit[]> = {};

    for (const credit of credits) {
      const mediaItemId = credit.getMediaItemId();
      if (!creditsMap[mediaItemId]) {
        creditsMap[mediaItemId] = [];
      }
      creditsMap[mediaItemId].push(credit);
    }

    return [...mediaItems.values()];
  }

  async loadMediaItems(): Promise<MediaItem[]> {
    // TODO: Implement this method.
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
