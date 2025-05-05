import { Module } from '@nestjs/common';
import { LIBRARY_DATA_LOADER_PROVIDER } from './library_data_loader';
import { LibraryJsonDataLoader } from './library_json_data_loader';

@Module({
  providers: [
    {
      provide: LIBRARY_DATA_LOADER_PROVIDER,
      useClass: LibraryJsonDataLoader,
    },
  ],
  exports: [LIBRARY_DATA_LOADER_PROVIDER],
})
export class DataModule {}
