
/**
* Provide the solution to LeetCode 1929 here:
* https://leetcode.com/problems/concatenation-of-array
*/
export function getConcatenation(nums: number[]): number[] {
 const n = nums.length; //Creates a variable named n that is the length of nums
 const ans: number[] = new Array(2 * n); //Creates a new array that is double the size of n


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
 const elListo: number[] = [] //creates a new array named elListo


 //Runs a loop that will iterate through each character in the String.
 for (let i = 0; i < words.length; ++i) {
   if (words[i].includes(x)) { //Checks to see if the word inclues the char 'x'
     elListo.push(i); //Pushes the index of i if it is true that the word contains that character
    
   }
 } return elListo; //Will return the Array elListo
}


//Test Cases


const nums: number[] = [1, 2 , 3, 4]; //Array of numbers based on test case
const result: number[] = getConcatenation(nums);
console.log(result.join(" "))//Prints the test result out for the fet concatentaition method


const words: string[] = ["leet", "code", "hello", "world"]; //Array of strings based on test case
const x: string = 'e'; //Calls for a specific char
console.log(findWordsContaining(words, x));

