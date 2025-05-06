import { Module } from '@nestjs/common';
import {
  DataModule,
  LIBRARY_DATA_LOADER_PROVIDER,
  LibraryDataLoader,
} from '../data';
import { LibraryService } from './library.service';
import { LibraryFactory } from './library_factory';

const libraryServiceProvider = {
  provide: LibraryService,
  useFactory: (loader: LibraryDataLoader) => {
    return LibraryFactory.createWithLoader(loader);
  },
  inject: [LIBRARY_DATA_LOADER_PROVIDER],
};

@Module({
  imports: [DataModule],
  providers: [libraryServiceProvider],
  exports: [LibraryService],
})
export class LibraryModule {}
