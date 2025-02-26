import htm from "htm";
import { createElement } from "react";
import { CodeBlock, CodeSlide, Lesson, QuestionsSlide } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson12() {
    return html`
        <${Lesson} title="Data Structures: Stacks & Queues" lessonId="lesson_12" subtitle="Lesson 12" titleFontSize="1.08em">
            <section>
                <p>A quick <em>review</em></p>
            </section>
            <section>
                <p>A <em>data structure</em> is just a way to organize data for certain purposes.</p>
            </section>
            <section>
                <p>For instance, some help us to organize data in <em>sorted order</em> while others help us to <em>find a specific thin</em>g quickly.</p>
            </section>
            <section>
                <p>When we say <i>quick</i>, we usually mean optimal in terms of <em><i>Big O</i></em> time or space complexity.</p>
            </section>
            <section>
                <p><em>Big O</em> measures the performance of code <em><i>relative to the size of its input</i></em> in the <em>worst case</em></p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Worst Case Scenarios</h3>
                <p>
                    <i>Searching for something?</i><br />
                    <em>Thing not found in the collection</em>
                </p>
                <p>
                    <i>Sorting items?</i><br />
                    <em>Everything sorted in wrong order</em>
                </p>
            </section>
            <section>
                <p>A <em>data structure</em> helps us organize our data so that our code is still <i>optimal</i> even in the worst case scenario</p>
            </section>
            <section>
                <p>Remember how arrays are <em>immutable</em>?</p>
            </section>
            <section class="ml-bullet-slide">
                <h3 style=${{ "font-size": ".9em" }}>Making your array bigger (or smaller)</h3>
                <ol style=${{ "font-size": ".9em" }}>
                    <li class="fragment">Make a <em>new array</em> with the new size</li>
                    <li class="fragment"><em>Copy everything</em> from the old array to the new one</li>
                </ol>
            </section>
            <section>
                <p>Consequently, it costs you <em>O(n) time</em> to insert, remove, or find anything with an array</p>
            </section>
            <section>
                <p>But what if we only care about <em>adding</em>, <em>removing</em>, or <em>accessing</em> a single thing quickly?</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Use cases</h3>
                <ol style=${{ "font-size": ".9em" }}>
                    <li class="fragment">Getting the next phone caller on hold the longest</li>
                    <li class="fragment">Undoing the last operation you just did</li>
                    <li class="fragment">Going back in browser history to last page</li>
                    <li class="fragment">Loop pictures in a photo gallery or songs in a playlist</li>
                </ol>
            </section>
            <section>
                <p>This is what <em>linked lists</em> are for</p>
            </section>
            <section>
                <p>A <em>linked list</em> chains data together one <em>node</em> at a time instead of allocating everything at once</p>
            </section>
            <section>
                <p>It's easy to <em>add</em>, <em>remove</em>, or <em>peek</em> at things at the front or back of the list.</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide391.png" alt="Slide 391" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide392.png" alt="Slide 392" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide393.png" alt="Slide 393" />
            </section>
            <section class="ml-columns-slide">
                <div class="columns">
                    <${CodeBlock} lang="java" lineNumbers=${true} fontSize=".3em">
// A custom data type that only
// works with ints
public class Node {
   public int value;
   public Node next;
  
   public Node(int value) {
       this.value = value;
   }
}
                    <//>
                    <${CodeBlock} lang="java" lineNumbers=${true} fontSize=".3em">
public class App {
   public static void main(String[] args) {
      var head = new Node(-20);
      var tail = head; // head -> -20

      // Add a node
      var newHead = new Node(24);
      newHead.next = head;
      head = newHead; // head -> 24 -> -20 

      // Remove a node
      head = head.next; head -> -20
   }
}
                    <//>
                </div>
            </section>
            <section class="ml-columns-slide">
                <div class="columns">
                    <${CodeBlock} lang="java" lineNumbers=${true} fontSize=".3em">
${`
// Using generics as a template.
// Now it works with anything!
public class Node<T> {
   public T value;
   public Node<T> next;
  
   public Node(T value) {
       this.value = value;
   }
}
`}
                    <//>
                    <${CodeBlock} lang="java" lineNumbers=${true} fontSize=".3em">
${`
public class App {
   public static void main(String[] args) {
      var head = new Node<Integer>(-20);
      var tail = head; // head -> -20

      // Add a node
      var newHead = new Node<Integer>(24);
      newHead.next = head;
      head = newHead; // head -> 24 -> -20 

      // Remove a node
      head = head.next; head -> -20
   }
}
`}
                    <//>
                </div>
            </section>
            <section>
                <p>And by the way, and linked lists can have <em>cycles</em> 🤯</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide397.png" alt="Slide 397" />
            </section>
            <section>
                <img class="r-stretch" src="images/dog-pig.gif" alt="Slide 398" />
            </section>
            <section class="ml-bullet-slide">
                <h3>Use cases</h3>
                <ul style=${{ "font-size": ".8em" }}>
                    <li style=${{"opacity": ".3"}}>Getting the next phone caller on hold the longest</li>
                    <li style=${{"opacity": ".3"}}>Undoing the last operation you just did</li>
                    <li style=${{"opacity": ".3"}}>Going back in browser history to last page</li>
                    <li>Loop pictures in a photo gallery or songs in a playlist</li>
                </ul>
            </section>
            <section>
                <p>Now that we have linked lists, we can implement <em>stacks</em> and <em>queues</em></p>
            </section>
            <section class="ml-columns-slide">
                <div class="columns">
                    <div>
                        <h3>Stack</h3>
                        <ul style=${{ "font-size": ".8em" }}>
                            <li class="fragment">Last in, first out (<em>LIFO</em>)</li>
                            <li class="fragment">Quickly get to the last thing added</li>
                            <li class="fragment"><em>push</em> to add / <em>pop</em> to remove</li>
                        </ul>
                    </div>
                    <div>
                        <h3>Queue</h3>
                        <ul style=${{ "font-size": ".8em" }}>
                            <li class="fragment">First in, first out (<em>FIFO</em>)</li>
                            <li class="fragment">Quickly get to the first thing added</li>
                            <li class="fragment"><em>enqueue</em> to add / <em>dequeue</em> to remove</li>
                        </ul>
                    </div>
                </div>
            </section>
            <section>
                <p>Need a queue? Just add new nodes to the <em>tail</em> instead of the <em>head</em></p>
            </section>
            <section class="ml-columns-slide">
                <div class="columns">
                    <${CodeBlock} lang="java" lineNumbers=${true} fontSize=".3em">
${`public class Node<T> {
   public T value;
   public Node<T> next;
  
   public Node(T value) {
       this.value = value;
   }
}
`}
                    <//>
                    <${CodeBlock} lang="java" lineNumbers=${true} fontSize=".3em">
${`public class App {
   public static void main(String[] args) {
      var head = new Node<Integer>(-20);
      var tail = head; // head -> -20

      // Add a node (enqueue)
      tail.next = new Node<Integer>(24);
      tail = tail.next; // head -> -20 -> 24

      // Remove a node (dequeue)
      head = head.next; head -> -24
   }
}
`}
                    <//>
                </div>
            </section>
            <section>
                <p>Or just use Java's pre-baked collections…</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="8-15" fontSize=".38em">
${`
package com.codedifferently;

import java.util.LinkedList;
import java.util.Queue;

public class App {
   public static void main(String[] args) {
       Queue<Integer> queue = new LinkedList<Integer>();
       queue.add(-20); // New state: head -> -20

       queue.add(24);  // New state: head -> -20 -> 24      
       System.out.println("The next value is " + queue.peek()); // -20

       queue.remove(); // New state: head -> 24
       System.out.println("The next value is " + queue.peek()); // 24
   }
}
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers="7-14" fontSize=".38em">
${`
package com.codedifferently;

import java.util.Stack;

public class App {
   public static void main(String[] args) {
       var stack = new Stack<Integer>();
       stack.push(-20); // New state: head -> -20

       stack.push(24);  // New state: head -> 24 -> -20
       System.out.println("The next value is " + stack.peek()); // 24

       stack.pop();     // New state: head -> -20
       System.out.println("The next value is " + stack.peek()); // -20
   }
}
`}
            <//>
            <section>
                <p>We can <em>iterate</em> through plain linked lists like so</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true" fontSize=".45em">
${`
Node<Integer> current = head;
while (current != null) {
   System.out.println("The next value is " + current.value);

   // Move to the next node.
   current = current.next;
}
`}
            <//>
            <section>
                <p>Or just use <em>for-each</em> with the regular Java collections</p>
            </section>
            <${CodeSlide} lang="java" fontSize=".45em">
${`
import java.util.Stack;

/* ...some other code... */

var stack = new Stack<Integer>();

// No randomly accessing any node in the list (this isn't an 
// array), but we can use a for-each loop to visit each node.
for (int value : stack) {
   System.out.println("The next value is " + value);
}
`}
            <//>
            <${CodeSlide} lang="java" fontSize=".45em">
${`
import java.util.LinkedList;
import java.util.Queue;

/* ...some other code... */

Queue<Integer> queue = new LinkedList<Integer>();

// No randomly accessing any node in the list (this isn't an 
// array), but we can use a for-each loop to visit each node.
for (int value : queue) {
   System.out.println("The next value is " + value);
}
`}
            <//>
            <${QuestionsSlide}/>
        <//>`;
}

export default Lesson12;