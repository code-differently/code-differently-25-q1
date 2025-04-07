/**
 * Provide the solution to LeetCode 3146 here:
 * https://leetcode.com/problems/permutation-difference-between-two-strings
 */
export function findPermutationDifference(s: string, t: string): number {
 const indexMap = new Map <string, number>();
  for (let i = 0; i < s.length; i++) {
      indexMap.set(s[i], i);
  
    }
    let difference = 0;
     for (let i = 0; i < t.length; i++) {
      const originalIndex = indexMap.get(t[i]);
      //used chat to help check if it's undefined
     if (originalIndex !== undefined) {
       difference += Math.abs(originalIndex - i);
     }

    }
    return difference;
    
}

console.log(findPermutationDifference('abc', 'bac')); 
console.log(findPermutationDifference('abcde', 'edbac')); 