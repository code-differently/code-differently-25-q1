import { randomUUID } from 'crypto';
import { Library } from './library';
import { LibraryGuest } from './library_guest';
import { MediaItem } from './media_item';

export class LibraryGuestBase implements LibraryGuest {
  private library: Library | null = null;
  private readonly id: string = randomUUID();
  private readonly name: string;
  private readonly email: string;

  constructor(name: string, email: string) {
    this.name = name;
    this.email = email;
  }

  public setLibrary(library: Library): void {
    if (library && !library.hasLibraryGuest(this)) {
      throw new Error(
        `Patron ${this.getEmail()} is not in library ${library.getId()}`,
      );
    }
    this.library = library;
  }

  public getName(): string {
    return this.name;
  }

  public getEmail(): string {
    return this.email;
  }

  public getId(): string {
    return this.id;
  }

  public getCheckedOutMediaItems(): ReadonlySet<MediaItem> {
    if (!this.library) {
      throw new Error(`Library not set for patron ${this.getEmail()}`);
    }
    return this.library.getCheckedOutByGuest(this);
  }

  public toString(): string {
    return `LibraryGuestBase{id='${this.getEmail()}', name='${this.getName()}'}`;
  }
}
