import { Module } from '@nestjs/common';
import { LibraryModule } from '../library';
import { MediaItemsController } from './media_items.controller';

@Module({
  imports: [LibraryModule],
  controllers: [MediaItemsController],
})
export class WebModule {}
