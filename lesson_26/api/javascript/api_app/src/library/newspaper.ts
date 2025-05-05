import { MediaItemBase } from './media_item_base';
import { MediaType } from './media_type';

export class Newspaper extends MediaItemBase {
  constructor(id: string, title: string) {
    super(id, title);
  }

  getType(): MediaType {
    return MediaType.NEWSPAPER;
  }

  canCheckOut(): boolean {
    return false;
  }

  toString(): string {
    return `Newspaper{id='${this.getId()}', title='${this.getTitle()}'}`;
  }
}
