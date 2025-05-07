import { LibraryGuestBase } from './library_guest_base';

/** Represents a patron of a library. */
export class Patron extends LibraryGuestBase {
  constructor(name: string, email: string) {
    super(name, email);
  }

  toString(): string {
    return `Patron{id='${this.getEmail()}', name='${this.getName()}'}`;
  }
}
