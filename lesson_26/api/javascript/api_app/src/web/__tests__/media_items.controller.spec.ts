import { HttpStatus } from '@nestjs/common';
import { Test, TestingModule } from '@nestjs/testing';
import { Librarian, LibraryService, MediaItem } from '../../library';
import { CreateMediaItemRequest } from '../create_media_item_request';
import { fromMediaItemRequest } from '../media_item_request';
import { toMediaItemResponse } from '../media_item_response';
import { MediaItemsController } from '../media_items.controller';

// Mock dependencies and utils
jest.mock('../media_item_request', () => ({
  fromMediaItemRequest: jest.fn(),
}));

jest.mock('../media_item_response', () => ({
  toMediaItemResponse: jest.fn(),
}));

describe('MediaItemsController', () => {
  let controller: MediaItemsController;
  let libraryService: LibraryService;
  let mockLibrarian: Librarian;
  let mockMediaItem1: MediaItem;
  let mockMediaItem2: MediaItem;

  beforeEach(async () => {
    // Create mock objects
    mockLibrarian = new Librarian('Test Librarian', 'test@example.com');

    mockMediaItem1 = {
      getId: jest.fn().mockReturnValue('123'),
      getTitle: jest.fn().mockReturnValue('Test Item 1'),
      getType: jest.fn().mockReturnValue('movie'),
      getReleaseYear: jest.fn().mockReturnValue(2020),
      getCredits: jest.fn().mockReturnValue([]),
      addCredit: jest.fn(),
    } as unknown as MediaItem;

    mockMediaItem2 = {
      getId: jest.fn().mockReturnValue('456'),
      getTitle: jest.fn().mockReturnValue('Test Item 2'),
      getType: jest.fn().mockReturnValue('book'),
      getReleaseYear: jest.fn().mockReturnValue(2021),
      getCredits: jest.fn().mockReturnValue([]),
      addCredit: jest.fn(),
    } as unknown as MediaItem;

    // Mock the library service
    const mockLibraryService = {
      getLibrarians: jest.fn().mockReturnValue([mockLibrarian]),
      search: jest.fn(),
      hasMediaItemById: jest.fn(),
      addMediaItem: jest.fn(),
      removeMediaItemById: jest.fn(),
    };

    // Create mock response transformer
    const mockMediaItemResponse1 = {
      id: '123',
      title: 'Test Item 1',
      type: 'movie',
      releaseYear: 2020,
    };

    const mockMediaItemResponse2 = {
      id: '456',
      title: 'Test Item 2',
      type: 'book',
      releaseYear: 2021,
    };

    (toMediaItemResponse as jest.Mock).mockImplementation((item: MediaItem) => {
      if (item.getId() === '123') return mockMediaItemResponse1;
      if (item.getId() === '456') return mockMediaItemResponse2;
      return null;
    });

    (fromMediaItemRequest as jest.Mock).mockImplementation((requestItem) => {
      if (requestItem.id === '123') return mockMediaItem1;
      if (requestItem.id === '456') return mockMediaItem2;
      return mockMediaItem1; // Default to first mock item
    });

    const module: TestingModule = await Test.createTestingModule({
      controllers: [MediaItemsController],
      providers: [
        {
          provide: LibraryService,
          useValue: mockLibraryService,
        },
      ],
    }).compile();

    controller = module.get<MediaItemsController>(MediaItemsController);
    libraryService = module.get<LibraryService>(LibraryService);
  });

  afterEach(() => {
    jest.clearAllMocks();
  });

  describe('getItems', () => {
    it('should return all media items', () => {
      // Arrange
      const itemsSet = new Set<MediaItem>([mockMediaItem1, mockMediaItem2]);
      (libraryService.search as jest.Mock).mockReturnValue(itemsSet);

      // Act
      const result = controller.getItems();

      // Assert
      expect(libraryService.search).toHaveBeenCalledWith({});
      expect(toMediaItemResponse).toHaveBeenCalledTimes(2);
      expect(result.items).toHaveLength(2);
      expect(result).toEqual({
        items: [
          { id: '123', title: 'Test Item 1', type: 'movie', releaseYear: 2020 },
          { id: '456', title: 'Test Item 2', type: 'book', releaseYear: 2021 },
        ],
      });
    });

    it('should return empty array when no items', () => {
      // Arrange
      const emptySet = new Set<MediaItem>([]);
      (libraryService.search as jest.Mock).mockReturnValue(emptySet);

      // Act
      const result = controller.getItems();

      // Assert
      expect(libraryService.search).toHaveBeenCalledWith({});
      expect(toMediaItemResponse).not.toHaveBeenCalled();
      expect(result.items).toHaveLength(0);
      expect(result).toEqual({ items: [] });
    });
  });

  describe('getItem', () => {
    it('should return a specific media item when found', () => {
      // Arrange
      const itemsSet = new Set<MediaItem>([mockMediaItem1]);
      (libraryService.search as jest.Mock).mockReturnValue(itemsSet);
      const mockResponse = { status: jest.fn() };

      // Act
      const result = controller.getItem('123', mockResponse as any);

      // Assert
      expect(libraryService.search).toHaveBeenCalledWith({ id: '123' });
      expect(toMediaItemResponse).toHaveBeenCalledWith(mockMediaItem1);
      expect(mockResponse.status).not.toHaveBeenCalled();
      expect(result).toEqual({
        id: '123',
        title: 'Test Item 1',
        type: 'movie',
        releaseYear: 2020,
      });
    });

    it('should return 404 when item not found', () => {
      // Arrange
      const emptySet = new Set<MediaItem>([]);
      (libraryService.search as jest.Mock).mockReturnValue(emptySet);
      const mockResponse = { status: jest.fn() };

      // Act
      const result = controller.getItem('999', mockResponse as any);

      // Assert
      expect(libraryService.search).toHaveBeenCalledWith({ id: '999' });
      expect(mockResponse.status).toHaveBeenCalledWith(HttpStatus.NOT_FOUND);
      expect(result).toBeUndefined();
    });
  });

  describe('addItem', () => {
    it('should successfully add a media item', () => {
      // Arrange
      const mockRequest: CreateMediaItemRequest = {
        item: {
          id: '123',
          title: 'Test Item 1',
          type: 'movie',
        },
      };
      const mockResponse = { status: jest.fn() };

      // Act
      const result = controller.addItem(mockRequest, mockResponse as any);

      // Assert
      expect(fromMediaItemRequest).toHaveBeenCalledWith(mockRequest.item);
      expect(libraryService.addMediaItem).toHaveBeenCalledWith(
        mockMediaItem1,
        mockLibrarian,
      );
      expect(toMediaItemResponse).toHaveBeenCalledWith(mockMediaItem1);
      expect(result).toEqual({
        item: {
          id: '123',
          title: 'Test Item 1',
          type: 'movie',
          releaseYear: 2020,
        },
      });
    });

    it('should return errors when item is missing', () => {
      // Arrange
      const mockRequest = {} as CreateMediaItemRequest;
      const mockResponse = { status: jest.fn() };

      // Act
      const result = controller.addItem(mockRequest, mockResponse as any);

      // Assert
      expect(mockResponse.status).toHaveBeenCalledWith(HttpStatus.BAD_REQUEST);
      expect(libraryService.addMediaItem).not.toHaveBeenCalled();
      expect(result).toEqual({ errors: ['Missing item'] });
    });
  });

  describe('deleteItem', () => {
    it('should successfully delete an existing media item', () => {
      // Arrange
      (libraryService.hasMediaItemById as jest.Mock).mockReturnValue(true);
      const mockResponse = { status: jest.fn() };

      // Act
      controller.deleteItem('123', mockResponse as any);

      // Assert
      expect(libraryService.hasMediaItemById).toHaveBeenCalledWith('123');
      expect(libraryService.removeMediaItemById).toHaveBeenCalledWith(
        '123',
        mockLibrarian,
      );
      expect(mockResponse.status).not.toHaveBeenCalled();
    });

    it('should return 404 when trying to delete non-existent item', () => {
      // Arrange
      (libraryService.hasMediaItemById as jest.Mock).mockReturnValue(false);
      const mockResponse = { status: jest.fn() };

      // Act
      controller.deleteItem('999', mockResponse as any);

      // Assert
      expect(libraryService.hasMediaItemById).toHaveBeenCalledWith('999');
      expect(mockResponse.status).toHaveBeenCalledWith(HttpStatus.NOT_FOUND);
      expect(libraryService.removeMediaItemById).toHaveBeenCalledWith(
        '999',
        mockLibrarian,
      );
    });
  });
});
