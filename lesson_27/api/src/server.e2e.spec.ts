import {Db} from './db.js';
import {createServer} from './server.js';
import {Express} from 'express';
import request from 'supertest';

describe('Server (e2e)', () => {
  let mockDb: jest.MockedObjectDeep<Db> = jest.mocked({
    getPrograms: jest.fn(),
    getProgram: jest.fn(),
    addProgram: jest.fn(),
  });
  let app: Express = createServer(mockDb);

  it('/programs (GET)', async () => {
    // Arrange
    const programs = [
      {
        id: '12345',
        title: 'Pipeline DevShops',
        description:
          'Pipeline DevShop is a youth work-based learning program. Youth participants experience working in a real software development environment while sharpening their technology and soft skills.',
      },
    ];
    mockDb.getPrograms.mockResolvedValue(programs);

    // Act
    const result = request(app).get('/programs');

    // Assert
    await result.expect(200).then(res => {
      expect(res.body).toEqual(programs);
    });
  });

  it('/programs/:id (GET)', async () => {
    // Arrange
    const program = {
      id: 'a06f970a-03b7-4cbb-9efd-f4e99029a456',
      title: 'Platform Programs',
      description:
        'Platform programs are designed for high school graduates, college students, career changers, or professionals looking to develop the technology job readiness skills for today’s workforce.',
    };
    mockDb.getProgram.mockResolvedValue(program);

    // Act
    const result = request(app).get(
      '/programs/516190b1-89cf-4e75-858a-11e728034022'
    );

    // Assert
    await result.expect(200).then(res => {
      expect(res.body).toEqual(program);
    });
  });

  it('/programs (POST)', async () => {
    // Arrange
    const program = {
      title: 'Pipeline DevShops',
      description:
        'Pipeline DevShop is a youth work-based learning program. Youth participants experience working in a real software development environment while sharpening their technology and soft skills.',
    };
    mockDb.addProgram.mockResolvedValue();

    // Act
    const result = request(app).post('/programs').send(program);

    // Assert
    await result.expect(201).then(() => {
      expect(mockDb.addProgram).toHaveBeenCalledWith(program);
    });
  });
});
