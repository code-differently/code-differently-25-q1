import { MediaItemBase } from './media_item_base';
import { MediaType } from './media_type';

export class Magazine extends MediaItemBase {
  constructor(id: string, title: string) {
    super(id, title);
  }

  getType(): MediaType {
    return MediaType.MAGAZINE;
  }

  canCheckOut(): boolean {
    return false;
  }

  toString(): string {
    return `Magazine{id='${this.getId()}', title='${this.getTitle()}'}`;
  }
}
