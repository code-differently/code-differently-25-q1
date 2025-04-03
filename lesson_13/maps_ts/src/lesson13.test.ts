import { findPermutationDifference } from './lesson13.js';

describe('Lesson13', () => {
  test('testPermutationDifference', () => {
    // Test case 1
    const s1_1 = 'abc';
    const s2_1 = 'bca';
    expect(findPermutationDifference(s1_1, s2_1)).toBe(4);

    // Test case 2
    const s1_2 = 'abc';
    const s2_2 = 'abc';
    expect(findPermutationDifference(s1_2, s2_2)).toBe(0);

    // Test case 3
    const s1_3 = 'abcd';
    const s2_3 = 'abdc';
    expect(findPermutationDifference(s1_3, s2_3)).toBe(2);

    // Test case 4
    const s1_4 = 'rwohu';
    const s2_4 = 'rwuoh';
    expect(findPermutationDifference(s1_4, s2_4)).toBe(4);
  });
});
