import {
  Body,
  Controller,
  Delete,
  Get,
  HttpCode,
  HttpStatus,
  Param,
  Post,
  Res,
} from '@nestjs/common';
import { Response } from 'express';
import { Librarian, LibraryService, MediaItem } from '../library';
import { CreateMediaItemRequest } from './create_media_item_request';
import { CreateMediaItemResponse } from './create_media_item_response';
import { GetMediaItemsResponse } from './get_media_items_response';
import { fromMediaItemRequest } from './media_item_request';
import { MediaItemResponse, toMediaItemResponse } from './media_item_response';

@Controller()
export class MediaItemsController {
  private readonly librarian: Librarian;

  constructor(private readonly library: LibraryService) {
    this.librarian = library.getLibrarians()[0];
  }

  @Get('items')
  getItems(): GetMediaItemsResponse {
    const items: ReadonlySet<MediaItem> = this.library.search({});
    const responseItems: MediaItemResponse[] = [...items].map(
      toMediaItemResponse,
    );
    const response = { items: responseItems };
    return response;
  }

  @Get('items/:id')
  getItem(
    @Param('id') id: string,
    @Res({ passthrough: true }) res: Response,
  ): MediaItemResponse {
    const items = this.library.search({ id });
    if (items.size === 0) {
      res.status(HttpStatus.NOT_FOUND);
    }
    const item = items.values().next().value;
    return item ? toMediaItemResponse(item) : undefined;
  }

  @Post('items')
  @HttpCode(HttpStatus.OK)
  addItem(
    @Body() body: CreateMediaItemRequest,
    @Res({ passthrough: true }) res: Response,
  ): CreateMediaItemResponse {
    if (!body.item) {
      res.status(HttpStatus.BAD_REQUEST);
      return { errors: ['Missing item'] };
    }
    const item = fromMediaItemRequest(body.item);
    this.library.addMediaItem(item, this.librarian);
    return { item: toMediaItemResponse(item) };
  }

  @Delete('items/:id')
  @HttpCode(HttpStatus.NO_CONTENT)
  deleteItem(
    @Param('id') id: string,
    @Res({ passthrough: true }) res: Response,
  ): void {
    if (!this.library.hasMediaItemById(id)) {
      res.status(HttpStatus.NOT_FOUND);
    }
    this.library.removeMediaItemById(id, this.librarian);
  }
}
