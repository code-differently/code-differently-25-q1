import { INestApplication } from '@nestjs/common';
import { Test, TestingModule } from '@nestjs/testing';
import * as request from 'supertest';
import { Book, LibraryService } from '../../src/library';
import { WebModule } from '../../src/web/web.module';

describe('MediaItemsController (e2e)', () => {
  let app: INestApplication;
  let library: LibraryService;

  beforeEach(async () => {
    const moduleFixture: TestingModule = await Test.createTestingModule({
      imports: [WebModule],
    }).compile();

    app = moduleFixture.createNestApplication();
    library = app.get(LibraryService);
    await app.init();
  });

  it('/items (GET)', () => {
    return request(app.getHttpServer())
      .get('/items')
      .expect(200)
      .then((res) => {
        expect(res.body.items).toHaveLength(31);
      });
  });

  it('/items/:id (GET) - gets an item', () => {
    return request(app.getHttpServer())
      .get('/items/8efcbbb2-5c1e-486c-924d-63c3503f498c')
      .expect(200);
  });

  it('/items/:id (GET) - returns not found on get item', () => {
    return request(app.getHttpServer())
      .get('/items/00000000-0000-0000-0000-000000000000')
      .expect(404);
  });

  it('/items (POST) - reports bad request on add item', () => {
    const json = {};

    return request(app.getHttpServer())
      .post('/items')
      .send(json)
      .expect(400)
      .then((res) => {
        expect(res.body.errors).toBeInstanceOf(Array);
        expect(res.body.errors.length).toBe(1);
      });
  });

  it('/items (POST) - adds an item', async () => {
    const json = {
      item: {
        id: 'e27a4e0d-9664-420d-955e-c0e295d0ce02',
        type: 'BOOK',
        title: 'Becoming',
        isbn: '9781524763138',
        authors: ['Michelle Obama'],
        pages: 448,
      },
    };

    await request(app.getHttpServer())
      .post('/items')
      .send(json)
      .expect(200)
      .then((res) => {
        expect(res.body.item.id).toBe('e27a4e0d-9664-420d-955e-c0e295d0ce02');
      });

    const items = await library.search({
      id: 'e27a4e0d-9664-420d-955e-c0e295d0ce02',
    });
    expect(items.size).toBe(1);
    const item = items.values().next().value;
    expect(item).toBeInstanceOf(Book);
    expect(item.title).toBe('Becoming');
  });

  it('/items/:id (DELETE) - returns not found on delete item', () => {
    return request(app.getHttpServer())
      .delete('/items/00000000-0000-0000-0000-000000000000')
      .expect(404);
  });

  it('/items/:id (DELETE) - deletes an item', async () => {
    await request(app.getHttpServer())
      .delete('/items/8efcbbb2-5c1e-486c-924d-63c3503f498c')
      .expect(204);

    const items = library.search({
      id: '8efcbbb2-5c1e-486c-924d-63c3503f498c',
    });
    expect(items.size).toBe(0);
  });
});
