import { Injectable } from '@nestjs/common';
import * as LibraryJsonData from '../../resources/data.json';
import { LibraryDataModel } from '../models/library_data_model';
import { LibraryDataLoader } from './library_data_loader';

@Injectable()
export class LibraryJsonDataLoader implements LibraryDataLoader {
  async loadData() {
    const { mediaItems, guests } = LibraryJsonData;
    return new LibraryDataModel(mediaItems, guests);
  }
}
