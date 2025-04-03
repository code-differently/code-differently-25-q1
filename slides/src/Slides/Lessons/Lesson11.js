import htm from "htm";
import { createElement } from "react";
import { CodeSlide, Lesson, QuestionsSlide } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson11() {
    return html`
        <${Lesson} title="Data Structures: Strings & Arrays" lessonId="lesson_11" subtitle="Lesson 11" titleFontSize="1.08em">
            <section>
                <p>A <em><i>data structure</i></em> is just a way to organize data for certain purposes.</p>
            </section>
            <section>
                <p>For instance, some help us to organize data in <em>sorted order</em> while others help us to <em>find a specific thing</em> quickly.</p>
            </section>
            <section>
                <p>Consider the differences between a <em>Table of Contents</em> versus an <em>Index</em> in a book.</p>
            </section>
            <section>
                <p>You've already been introduced to the concept of an <em><i>array</i></em>….</p>
            </section>
            <section>
                <p>A <em>String</em> is an array (or series) of characters</p>
            </section>
            <${CodeSlide} lang="java" badge="Java" lineNumbers=true>
var name = "Anthony";
char[] characters = name.toCharArray();

// Prints "Your name ends with the letter: y"
System.out.println(
    "Your name ends with the letter: " + 
    characters[characters.length - 1]);
            <//>
            <${CodeSlide} lang="java" badge="Java" lineNumbers=true lineNumbers="2,7">
var name = "Anthony";
char[] characters = name.toCharArray();

// Prints "Your name ends with the letter: y"
System.out.println(
    "Your name ends with the letter: " + 
    characters[characters.length - 1]);
            <//>
            <${CodeSlide} lang="java" badge="Java">
var name = "Anthony";

// A simpler version that uses the built in 'charAt' method.
System.out.println(
   "Your name ends with the letter: " +
   name.charAt(name.length() - 1);
            <//>
            <section class="ml-bullet-slide">
                <h3>Things an array can represent…</h3>
                <ul>
                    <li class="fragment">A list of phone numbers</li>
                    <li class="fragment">A deck of cards</li>
                    <li class="fragment">An enrolled list of students</li>
                    <li class="fragment">A sequence of genes</li>
                    <li class="fragment">The ages of your kids</li>
                </ul>
            </section>
            <section class="ml-bullet-slide">
                <h3>Things we like to do with arrays…</h3>
                <ul style=${{"font-size": ".9em"}}>
                    <li class="fragment">Get a specific element at any random index (<em>random access</em>) instantly</li>
                    <li class="fragment">Retrieve the count of items</li>
                    <li class="fragment">Get a subset of items</li>
                    <li class="fragment">Search for items</li>
                    <li class="fragment">Combine arrays</li>
                </ul>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide329.png" alt="Slide 329" />
            </section>
            <section>
                <p style=${{"font-size": ".9em"}}>For arrays, we use <em>square brackets</em> ("[]") to access a specific item by it's zero-based index (1st element at index 0, second element at index 1, etc)</p>
            </section>
            <${CodeSlide} lang="java" fontSize=".38em" lineNumbers="7-13">
package com.codedifferently;

import java.util.Arrays;

public class App {
   public static void main(String[] args) {
       int[] agesOfKids = new int[] { 5, 9, 13, 15 };
       agesOfKids[1] = 16;      // Updates the second kid's age
                                // (Not 1st! Remember, this is 0-based!)
       int oldestAge = ages[3]; // Gets the 4th age 
                                // (Not 3rd! Remember, this is 0-based!)
       int numberOfKids = ages.length;
       int sumOfAges = Arrays.stream(ages).sum();
   }
}
            <//>
            <section>
                <p><span style=${{"color": "red"}}>IMPORTANT!</span><br />Arrays are <em>IMMUTABLE</em>. That means that once they're made, they <em>CANNOT</em> be made bigger or smaller.</p>
            </section>
            <section>
                <p>If you want a <em>bigger</em> or <em>smaller</em> array, you have to make a new one, then <em>copy</em> the old stuff to the new array.</p>
            </section>
            <${CodeSlide} lang="java" fontSize=".38em" lineNumbers=true>
int[] agesOfKids = new int[] { 5, 9, 13, 15 };

// Adopting a kid, so need more room.
int[] agesOfKidsWithNewlyAdopted = new int[5];
for (int i = 0; i ${'<'} agesOfKids.length; ++i) {
    agesOfKidsWithNewlyAdopted[i] = agesOfKids[i];
}

// Add the new age at the end.
agesOfKidsWithNewlyAdopted[4] = 40;
            <//>
            <${CodeSlide} lang="java" fontSize=".38em" lineNumbers="4">
int[] agesOfKids = new int[] { 5, 9, 13, 15 };

// Adopting a kid, so need more room.
int[] agesOfKidsWithNewlyAdopted = new int[5];
for (int i = 0; i ${'<'} agesOfKids.length; ++i) {
    agesOfKidsWithNewlyAdopted[i] = agesOfKids[i];
}

// Add the new age at the end.
agesOfKidsWithNewlyAdopted[4] = 40;
            <//>
            <section>
                <p>?????</p>
            </section>
            <section>
                <p>There's a better way. It's called <em>ArrayList</em></p>
            </section>
            <${CodeSlide} lang="java" fontSize=".38em" lineNumbers=true fontSize=".5em">
${`
var agesOfKids = new ArrayList<Integer>();
agesOfKids.add(5);
agesOfKids.add(9);
agesOfKids.add(13);
agesOfKids.add(15);

// Adding a new kid's age is trivial now.
agesOfKids.add(40);

// We can remove too!
agesOfKids.remove(5);
`}
            <//>
            <section>
                <img class="r-stretch" src="images/slides/Slide338.png" alt="Slide 338" />
            </section>
            <section>
                <p>The <em>ArrayList</em> is just one of several <em><i>collections</i></em> in Java that are useful for managing data.</p>
            </section>
            <section>
                <p>In computer science, we refer to these collections as <em><i>data structures</i></em>.</p>
            </section>
            <section>
                <p>They allow you to <em>get</em> (retrieve), <em>search</em>, <em>add</em>, or <em>remove</em> an item in a collection.</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers=true>
${`
// Manages lists of things.
var agesOfKids = new ArrayList<Integer>();

// Good for keeping track of unique values.
var driverLicenseNumbers = new HashSet<String>();

// Keeps things in priority order.        
var emergencyRoomPatients = new PriorityQueue<Patient>();

// Always retrieves the last thing that was added. 
var undoRedoStack = new Stack<Operation>();
`}
            <//>
            <section>
                <p>Collections can store a list of collections…</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers=true>
${`
var scifiBooks = new ArrayList<Book>();
var nonfictionBooks = new ArrayList<Book>();

var library = new ArrayList<ArrayList<Book>>();
library.add(scifiBooks);
library.add(nonfictionBooks);
`}
            <//>
            <section>
                <p>Arrays can also store other arrays, though the syntax is a bit different</p>
            </section>
            <${CodeSlide} lang="java" fontSize=".4em" lineNumbers=true>
// A 5x5 bingo card of numbers.
var bingoCard = new int[5][5];

// An 8x8 board of chess pieces.
var chessBoard = new ChessPiece[8][8];

// An image that is 1920x1080 (1080 HD resolution).
var highDefImage = new Pixel[1920][1080];

// Works, but CANNOT use generics. Not typically used this way.
var library = new ArrayList[2];
            <//>
            <section>
                <p>Let's visualize a 2D array representing a bingo card</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide348.png" alt="Slide 348" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide349.png" alt="Slide 349" />
            </section>
            <${CodeSlide} lang="java" fontSize=".4em" lineNumbers=true>
// A 5x5 bingo card of numbers.
var bingoCard = new int[5][5];

// Update the array at index 2 (the 3rd row), setting the 
// element at index 3 (the 4th column). 
bingoCard[2][3] = 56;

// Update the array at index 4 (the 5th row), setting the 
// element at index 2 (the 3rd column). 
bingoCard[4][2] = 8;
            <//>
            <section>
                <img class="r-stretch" src="images/slides/Slide351.png" alt="Slide 351" />
            </section>
            <section>
                <p>Frequently, we need to iterate through arrays and collections to read data. That's what loops are <em>for</em>.</p>
            </section>
            <${CodeSlide} lang="java" fontSize=".4em" lineNumbers=true>
${`
var names = new String[] { "Sally", "Jesse", "Raphael" };

// We compare i to the length of the array to know when to stop.
for (var i = 0; i < names.length; ++i) {
   // Then, we use 'i' to grab the element at that index.
   String name = names[i];
   System.out.print("The name is " + name);
}
`}
            <//>
            <${CodeSlide} lang="java" fontSize=".4em" lineNumbers="3-6">
${`
var names = new String[] { "Sally", "Jesse", "Raphael" };

// We compare i to the length of the array to know when to stop.
for (var i = 0; i < names.length; ++i) {
   // Then, we use 'i' to grab the element at that index.
   String name = names[i];
   System.out.print("The name is " + name);
}
`}
            <//>
            <${CodeSlide} lang="java" fontSize=".4em" lineNumbers=true>
${`
var names = new ArrayList<String>(
    List.of("Sally", "Jesse", "Raphael"));
// WATCH OUT! 'size' is the method we need, not 'length'.
for (var i = 0; i < names.size(); ++i) {
   String name = names.get(i);  // Use 'get' method to see a 
                                // value at some index.
   System.out.print("The name is " + name);
}
`}
            <//>
            <${CodeSlide} lang="java" fontSize=".4em" lineNumbers="3-6">
${`
var names = new ArrayList<String>(
    List.of("Sally", "Jesse", "Raphael"));
// WATCH OUT! 'size' is the method we need, not 'length'.
for (var i = 0; i < names.size(); ++i) {
   String name = names.get(i);  // Use 'get' method to see a 
                                // value at some index.
   System.out.print("The name is " + name);
}
`}
            <//>
            <section>
                <p>What about <em>Strings</em>, since they're arrays too?</p>
            </section>
            <${CodeSlide} lang="java" fontSize=".4em" lineNumbers=true>
${`
var name = "Anthony";
var characters = name.toCharArray();

for (var i = 0; i < characters.length; ++i) {
   Char letter = characters[i];
   System.out.print("The next letter is " + letter);
}
`}
            <//>
            <${CodeSlide} lang="java" fontSize=".4em" lineNumbers=true>
${`
var name = "Anthony";

// Here's a shorter version. Note the 'length' METHOD, not property.
for (var i = 0; i < name.length(); ++i) {
   Char letter = names.charAt(i);  // Use 'charAt' to get a 
                                   // single character.
   System.out.print("The next letter is " + letter);
}
`}
            <//>
            <section>
                <p>We iterate collections so often that there's a shortcut we prefer</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers=true>
var names = new String[] { "Sally", "Jesse", "Raphael" };
for (String name : names) { // Called a for-each loop.
   System.out.print("The name is " + name);
}
            <//>
            <section>
                <p>And it works for collections too</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers=true>
${`
var names = new ArrayList<String>(
    List.of("Sally", "Jesse", "Raphael"));
for (String name : names) { // Snazzy
   System.out.print("The name is " + name);
}

var colors = new HashSet<Color>(
    List.of(Color.RED, Color.GREEN));
for (Color color : colors) {
   System.out.print("The color is " + color.toString());
}
`}
            <//>
            <section>
                <p>Can you guess how we iterate through 2D arrays?</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers=true fontSize=".4em">
${`
var timesTable = new int[][] {
   new int[] {0, 0, 0, 0, 0 },
   new int[] {0, 1, 2, 3, 4 },
   new int[] {0, 2, 4, 6, 8 },
   new int[] {0, 3, 6, 9, 12 }
};

for (var i = 0; i < timesTable.length; ++i) {
 for (var j = 0; j < timesTable[i].length; ++j) { // We like 'j'.
   int cell = timesTable[i][j];
 }
}
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers=true fontSize=".4em">
${`
var timesTable = new int[][] {
   new int[] {0, 0, 0, 0, 0 },
   new int[] {0, 1, 2, 3, 4 },
   new int[] {0, 2, 4, 6, 8 },
   new int[] {0, 3, 6, 9, 12 }
};

for (var i = 0; i < timesTable.length; ++i) {
 int[] row = timesTable[i];             // Clear variable names make
 for (var j = 0; j < row.length; ++j) { // the loop simpler to
   int cell = row[j];                   // understand.
 }
}
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers=true fontSize=".4em">
${`
var timesTable = new int[][] {
  new int[] {0, 0, 0, 0, 0 },
  new int[] {0, 1, 2, 3, 4 },
  new int[] {0, 2, 4, 6, 8 },
  new int[] {0, 3, 6, 9, 12 }
};

for (int[] row : timesTable) { // For-each FTW!
  for (int cell : row) {
    /* Do something with cell */
  }
}
`}
            <//>
            <section>
                <p>If you need to loop and you <em>don't care</em> about the index, use <em>for-each</em>.</p>
            </section>
            <section>
                <p>Now. What about <em>TypeScript</em>?</p>
            </section>
            <section>
                <p>Fortunately, arrays in TypeScript work a lot like <em>ArrayList</em> out the box...</p>
            </section>
            <${CodeSlide} lang="typescript" badge="TypeScript" lineNumbers=true fontSize=".35em">
${`
const agesOfKids: number[] = []; // or, const ageOfKids = new Array<number>();
agesOfKids.push(5);
agesOfKids.push(9);
agesOfKids.push(13);
agesOfKids.push(15);

// Adding a new kid's age is trivial now.
agesOfKids.push(40);

agesOfKids.pop(); // Remove the last item (40)
agesOfKids.slice(0, 1); // Remove 1 item starting at index 0 (5)

console.log("The size of the array is: " + 
    agesOfKids.length);
`}
            <//>
            <${CodeSlide} lang="typescript" badge="TypeScript" lineNumbers=true>
${`
function printCharacters() {
   const name = "Anthony";

   for (let i = 0; i < name.length; ++i) {
       const letter = name[i];
       console.log("The next letter is " + letter);
   }
}
`}
            <//>
            <${CodeSlide} lang="typescript" badge="TypeScript" lineNumbers=true>
${`
function printCharacters() {
   const name = "Anthony";

   for (const letter of name) {
       console.log("The next letter is " + letter);
   }
}
`}
            <//>
            <section>
                <p>And TypeScript lets you do some funky stuff pretty easily…</p>
            </section>
            <${CodeSlide} lang="typescript" badge="TypeScript" lineNumbers=true>
${`
const array = [1, 2, 3, 4, 5];
const newArray = [...array, 6]; // Spread operator

// This is called "destructuring".
const [val1, val2, ...rest] = newArray; 

console.log(newArray); // [1, 2, 3, 4, 5, 6]
console.log(val1); // 1
console.log(val2); // 2
console.log(rest); // [3, 4, 5, 6]
`}
            <//>
            <${CodeSlide} lang="typescript" badge="TypeScript" lineNumbers="2,4-5">
${`
const array = [1, 2, 3, 4, 5];
const newArray = [...array, 6]; // Spread operator

// This is called "destructuring".
const [val1, val2, ...rest] = newArray; 

console.log(newArray); // [1, 2, 3, 4, 5, 6]
console.log(val1); // 1
console.log(val2); // 2
console.log(rest); // [3, 4, 5, 6]
`}
            <//>
            <${QuestionsSlide}/>
        <//>`;
}

export default Lesson11;