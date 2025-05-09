import { MediaItemBase } from './media_item_base';
import { MediaType } from './media_type';

export class Dvd extends MediaItemBase {
  constructor(id: string, title: string) {
    super(id, title);
  }

  getType(): MediaType {
    return MediaType.DVD;
  }

  toString(): string {
    return `Dvd{id='${this.getId()}', title='${this.getTitle()}'}`;
  }
}
