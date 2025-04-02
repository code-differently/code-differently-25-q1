
/**
* Provide the solution to LeetCode 1929 here:
* https://leetcode.com/problems/concatenation-of-array
*/
export function getConcatenation(nums: number[]): number[] {
 const n = nums.length; //Creates a variable named n that is the length of nums
 const ans = new Array(2 * n); //Creates a new array that is double the size of n

 for(let i = 0; i < n; ++i) {
   ans[i] = nums[i];
   ans[i + n] = nums[i];
 }
 return ans;
}


/**
* Provide the solution to LeetCode 2942 here:
* https://leetcode.com/problems/find-words-containing-character/
*/
export function findWordsContaining(words: string[], x: string): number[] {
 //creates a new array list names arrList
 const arrList: number[] = [] 

 //Runs a loop that will iterate through each character in the String.
 for (let i = 0; i < words.length; ++i) {
   if (words[i].includes(x)) { //Checks to see if the word inclues the char 'x'
     arrList.push(i); //Pushes the index of i if it is true that the word contains that character
   }
 } return arrList; //Will return the Array elListo
}

