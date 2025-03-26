import csv from 'csv-parser';
import fs from 'fs';
import { Credit, MediaItem } from '../models/index.js';

export class DylanLaffertysLoader {
  getLoaderName() {
    return 'dylanlafferty';
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
    const mediaItem = [];
    const readable = fs
      .createReadStream('data/media_items.csv', 'utf-8')
      .pipe(csv());

    for await (const row of readable) {
      const { id, title, type, releaseYear } = row;
      mediaItem.push(new MediaItem(id, title, type, parseInt(releaseYear), []));
    }
    return mediaItem;
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
//# sourceMappingURL=dylan_lafferty_loaders.js.map