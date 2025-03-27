import { Module } from '@nestjs/common';
import { LoadersModule } from '../loaders/loaders.module.js';
import { MediaCollectionApp } from './media_collection_app.js';

@Module({
  providers: [MediaCollectionApp],
  imports: [LoadersModule],
  exports: [MediaCollectionApp],
})
export class CliModule {}
