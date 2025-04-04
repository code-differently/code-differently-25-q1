/**
 * Provide the solution to LeetCode 3146 here:
 * https://leetcode.com/problems/permutation-difference-between-two-strings
 */
export function findPermutationDifference(s: string, t: string): number {
  const sIndexByLetter = new Map<string, number>();
  const tIndexByLetter = new Map<string, number>();

  for (let i = 0; i < s.length; i++) {
    sIndexByLetter.set(s.charAt(i), i);
    tIndexByLetter.set(t.charAt(i), i);
  }

  let sum = 0;
  for (const key of sIndexByLetter.keys()) {
    const sIndex = sIndexByLetter.get(key);
    const tIndex = tIndexByLetter.get(key);
    if (sIndex !== undefined && tIndex !== undefined) {
      sum += Math.abs(sIndex - tIndex);
    }
  }

  return sum;
}
