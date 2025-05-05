import { LibraryDataModel } from '../models/library_data_model';

export const LIBRARY_DATA_LOADER_PROVIDER = Symbol('LibraryDataLoader');

/** An object that loads data from a source and returns a LibraryDataModel object. */
export interface LibraryDataLoader {
  /**
   * Load data from a source and return a LibraryDataModel object.
   *
   * @return A LibraryDataModel object.
   * @throws Error if an I/O error occurs.
   */
  loadData(): Promise<LibraryDataModel>;
}
