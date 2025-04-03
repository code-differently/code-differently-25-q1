/**
 * Provide the solution to LeetCode 3146 here:
 * https://leetcode.com/problems/permutation-difference-between-two-strings
 */
export function findPermutationDifference(s: string, t: string): number {
  let ans: number = 0;
let indices: number[] = new Array(26).fill(0);

for (let i = 0; i < s.length; ++i){
  indices[s.charCodeAt(i) - 'a'.charCodeAt(0)] = i;
}

for (let i = 0; i < t.length; ++i){
  ans += Math.abs(indices[t.charCodeAt(i) - 'a'.charCodeAt(0)] - i);
}
return ans;
}
