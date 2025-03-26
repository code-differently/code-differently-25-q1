import csv from 'csv-parser';
import fs from 'fs';
import { Credit, MediaItem } from '../models/index.js';
import { Loader } from './loader.js';

export class EvanPhilakhongLoader implements Loader {
  getLoaderName(): string {
    return 'evanphilakhong';
  }

  async loadData(): Promise<MediaItem[]> {
    const credits = await this.loadCredits();
    const mediaItems = await this.loadMediaItems();

    console.log(
      `Loaded ${credits.length} credits and ${mediaItems.length} media items`,
    );

    return [...mediaItems.values()];
  }

  async loadMediaItems(): Promise<MediaItem[]> {
    const mediaItems = [];
    const readable = fs
      .createReadStream('data/media_items.csv', 'utf-8')
      .pipe(csv());
    for await (const row of readable) {
      const { media_item_id, title, genre, year, credits } = row;
      mediaItems.push(
        new MediaItem(media_item_id, title, genre, year, credits),
      );
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
