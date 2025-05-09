export interface MediaItem {
  getId(): string;
  getTitle(): string;
  canCheckOut(): boolean;
}
