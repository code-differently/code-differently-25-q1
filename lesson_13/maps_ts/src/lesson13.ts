/**
 * Provide the solution to LeetCode 3146 here:
 * https://leetcode.com/problems/permutation-difference-between-two-strings
 */
export function findPermutationDifference(s: string, t: string): number {
  const charByIndex = new Map<string, number>();
  let difference = 0;

  for (let i = 0; i < s.length; ++i) {
    charByIndex.set(s[i], i);
  }

  for (let j = 0; j < t.length; ++j) {
    if (charByIndex.has(t[j])) {

      difference += Math.abs(charByIndex.get(t[j]) as number - j);
    }
  }
  return difference;
}
