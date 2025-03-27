import csv from 'csv-parser';
import fs from 'fs';
import { Credit, MediaItem } from '../models/index.js';
import { Loader } from './loader.js';

export class DylanLaffertysLoader implements Loader {
  getLoaderName(): string {
    return 'dylanlafferty';
  }
  async loadData(): Promise<MediaItem[]> {
    const credits = await this.loadCredits(); //loads credits from the csv file
    const mediaItems = await this.loadMediaItems(); //loads media items from csv file

    //Creates a map where the key is a string and the value is MediaItem Object
    const mapIndex = new Map<string, MediaItem>();

    //Loops through the CSV file and gets the id of the mediaItem that is specified.
    for (const mediaItem of mediaItems) {
      mapIndex.set(mediaItem.getId(), mediaItem);

    }

    for (const credit of credits) {
      const mediaItem = mapIndex.get(credit.getMediaItemId()); //Finds the media item by getting media ID
      if (mediaItem) {
        mediaItem.addCredit(credit);
      }
    }

    console.log(
      `Loaded ${credits.length} credits and ${mediaItems.length} media items`,
    );
    //Returns a newly created array by converting the map values
    return Array.from(mapIndex.values());
  }

  async loadMediaItems(): Promise<MediaItem[]> {
    const mediaItem = [];
    const readable = fs
      .createReadStream('data/media_items.csv', 'utf-8')
      .pipe(csv());

    for await (const row of readable) {
      const { id, title, type, year } = row;
      mediaItem.push(new MediaItem(id, title, type, year, []));
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
