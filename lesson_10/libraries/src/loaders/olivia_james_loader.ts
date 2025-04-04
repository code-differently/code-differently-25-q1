import csv from 'csv-parser';
import fs from 'fs';
import { Credit, MediaItem } from '../models/index.js';
import { Loader } from './loader.js';


export class OliviaJamesLoader implements Loader {
 getLoaderName(): string {
   return 'oliviajames';
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
   const Media = [];
   const readable = fs


     .createReadStream('data/media_items.csv', 'utf-8')
     .pipe(csv());
   for await (const row of readable) {
     const { id, title, type, year } = row;
     Media.push(new MediaItem(id, title, type, year, []));
   }
   return Media;
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
