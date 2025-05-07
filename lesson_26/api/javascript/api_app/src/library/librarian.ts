import { LibraryGuestBase } from './library_guest_base';

/** Represents a librarian of a library. */
export class Librarian extends LibraryGuestBase {
  constructor(name: string, email: string) {
    super(name, email);
  }

  toString(): string {
    return `Librarian{id='${this.getEmail()}', name='${this.getName()}'}`;
  }
}
