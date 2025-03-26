import { Role } from './role.js';

export class Credit {
  private mediaItemId: string;
  private name: string;
  private role: Role;

  constructor(mediaItemId: string, name: string, role: Role) {
    this.mediaItemId = mediaItemId;
    this.name = name;
    this.role = role;
  }

  getMediaItemId(): string {
    return this.mediaItemId;
  }

  getName(): string {
    return this.name;
  }

  getRole(): Role {
    return this.role;
  }
}
