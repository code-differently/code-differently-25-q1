import { MediaItemResponse } from './media_item_response';

export interface CreateMediaItemResponse {
  item?: MediaItemResponse;
  errors?: string[];
}
