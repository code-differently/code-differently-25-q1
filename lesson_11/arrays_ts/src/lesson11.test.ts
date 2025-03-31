import { describe, expect, it } from '@jest/globals';
import { findWordsContaining, getConcatenation } from './lesson11.js';

describe('Lesson11', () => {
  describe('getConcatenation', () => {
    it('should return the correct concatenation for test case 1', () => {
      const nums1 = [1, 2, 1];
      const expected1 = [1, 2, 1, 1, 2, 1];
      const result1 = getConcatenation(nums1);
      expect(result1).toEqual(expected1);
    });

    it('should return the correct concatenation for test case 2', () => {
      const nums2 = [1, 3, 2, 1];
      const expected2 = [1, 3, 2, 1, 1, 3, 2, 1];
      const result2 = getConcatenation(nums2);
      expect(result2).toEqual(expected2);
    });

    it('should return the correct concatenation for test case 3', () => {
      const nums3: number[] = [];
      const expected3: number[] = [];
      const result3 = getConcatenation(nums3);
      expect(result3).toEqual(expected3);
    });

    it('should return the correct concatenation for test case 4', () => {
      const nums4 = [5];
      const expected4 = [5, 5];
      const result4 = getConcatenation(nums4);
      expect(result4).toEqual(expected4);
    });

    it('should return the correct concatenation for test case 5', () => {
      const nums5 = [0, 0, 0];
      const expected5 = [0, 0, 0, 0, 0, 0];
      const result5 = getConcatenation(nums5);
      expect(result5).toEqual(expected5);
    });
  });

  describe('findWordsContaining', () => {
    it('should return the correct indices for test case 1', () => {
      const ch1 = 'a';
      const words1 = ['apple', 'banana', 'cherry', 'date'];
      const expected1 = [0, 1, 3];
      const result1 = findWordsContaining(words1, ch1);
      expect(result1).toEqual(expected1);
    });

    it('should return the correct indices for test case 2', () => {
      const ch2 = 'z';
      const words2 = ['apple', 'banana', 'cherry', 'date'];
      const expected2: number[] = [];
      const result2 = findWordsContaining(words2, ch2);
      expect(result2).toEqual(expected2);
    });

    it('should return the correct indices for test case 3', () => {
      const ch3 = 'e';
      const words3 = ['apple', 'banana', 'cherry', 'date'];
      const expected3 = [0, 2, 3];
      const result3 = findWordsContaining(words3, ch3);
      expect(result3).toEqual(expected3);
    });

    it('should return the correct indices for test case 4', () => {
      const ch4 = 'a';
      const words4 = ['', ' ', 'banana'];
      const expected4 = [2];
      const result4 = findWordsContaining(words4, ch4);
      expect(result4).toEqual(expected4);
    });
  });
});
