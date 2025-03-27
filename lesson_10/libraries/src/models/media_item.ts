import { Credit } from './credit.js';
import { MediaType } from './media_type.js';

export class MediaItem {
  private readonly id: string;
  private readonly title: string;
  private readonly releaseYear: number;
  private readonly credits: Credit[];
  private readonly type: MediaType;

  constructor(
    id: string,
    title: string,
    mediaType: MediaType,
    releaseYear: number,
    credits: Iterable<Credit>,
  ) {
    this.id = id;
    this.title = title;
    this.type = mediaType;
    this.releaseYear = releaseYear;
    this.credits = [...credits];
  }

  getId(): string {
    return this.id;
  }

  getTitle(): string {
    return this.title;
  }

  getReleaseYear(): number {
    return this.releaseYear;
  }

  getCredits(): readonly Credit[] {
    return [...this.credits];
  }

  addCredit(credit: Credit): void {
    this.credits.push(credit);
  }

  getType(): MediaType {
    return this.type;
  }
}
