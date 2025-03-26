import { beforeAll, describe, expect, it } from '@jest/globals';
import { Test, TestingModule } from '@nestjs/testing';
import { AppModule } from './app.module.js';
import { Loader } from './loaders/loader.js';
import { Loaders } from './loaders/loaders.module.js';

const IGNORE_LOADER = 'anthonymays';

describe('Lesson10Test', () => {
  let moduleFixture: TestingModule;
  let loaders: Loader[];

  beforeAll(async () => {
    moduleFixture = await Test.createTestingModule({
      imports: [AppModule],
    }).compile();

    loaders = moduleFixture.get(Loaders);
  });

  it('loads loaders that load all items', async () => {
    for (const loader of loaders) {
      if (loader.getLoaderName() === IGNORE_LOADER) {
        continue;
      }
      const items = await loader.loadData();
      expect(items.length).toBe(200);
    }
  });

  it('loads all properties correctly', async () => {
    for (const loader of loaders) {
      if (loader.getLoaderName() === IGNORE_LOADER) {
        continue;
      }

      const items = await loader.loadData();

      const itemsByType = items.reduce((acc, item) => {
        const count = acc.get(item.getType()) || 0;
        acc.set(item.getType(), count + 1);
        return acc;
      }, new Map());

      expect(itemsByType.get('movie')).toBe(68);
      expect(itemsByType.get('tv_show')).toBe(66);
      expect(itemsByType.get('documentary')).toBe(66);

      expect(items.every((i) => i.getId() !== undefined)).toBe(true);
      expect(items.every((i) => i.getReleaseYear() !== undefined)).toBe(true);
      expect(items.every((i) => i.getTitle() !== undefined)).toBe(true);
      expect(items.every((i) => i.getType() !== undefined)).toBe(true);
    }
  });

  const maybeIt = process.env.LOADER_NAME ? it : it.skip;

  maybeIt('loads credits correctly', async () => {
    for (const loader of loaders) {
      if (loader.getLoaderName() !== process.env.LOADER_NAME) {
        continue;
      }
      const items = await loader.loadData();
      expect(items.filter((i) => i.getCredits().length).length).toBe(100);

      // Every item that has credits should have the right credits.
      const itemsWithCredits = items.filter((i) => i.getCredits().length);
      expect(
        itemsWithCredits.every((i) =>
          i.getCredits().every((c) => c.getMediaItemId() === i.getId()),
        ),
      ).toBe(true);
    }
  });
});
