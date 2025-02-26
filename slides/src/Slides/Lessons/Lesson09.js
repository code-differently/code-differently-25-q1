import htm from "htm";
import { createElement } from "react";
import { CodeSlide, Lesson, QuestionsSlide } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson09() {
    return html`
        <${Lesson} title="Data Types" lessonId="lesson_09" subtitle="Lesson 9">
            <section>
                <img class="r-stretch" src="images/slides/Slide241.png" alt="Slide 241" />
            </section>
            <section>
                <p><span style=${{"color": "red"}}>Note</span>: We're defaulting to <em>Java</em> for this lesson, but we'll also see examples in <em>JavaScript</em> and <em>TypeScript</em></p>
            </section>
            <section>
                <p>Let's <em>review</em></p>
            </section>
            <section style=${{"text-align": "left", "font-size": "1.2em"}}>
                <p>A <em>computer</em> is a machine that <span class="fragment"><i>transforms</i> <em>input</em> data to <em>output</em> data</span> <span class="fragment">using <i>automatically executed</i>, pre-programmed <em>instructions</em>.</span></p>
            </section>
            <section style=${{"text-align": "left"}}>
                <p>The <em><i>central processing unit (CPU)</i></em> performs <i>mathematical operations</i>, computing everything from letters and numbers, to the color of each screen pixel</p>
            </section>
            <section style=${{"text-align": "left"}}>
                <p>We use <em><i>data types</i></em> to describe the <i>type of data</i> we need to store and it's size so the CPU knows how much <em><i>RAM</i></em> to use.</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Stuff we need data types for</h3>
                <ul>
                    <li class="fragment">Numbers</li>
                    <li class="fragment"><em>Strings</em> (a string of characters)</li>
                    <li class="fragment">Dates/times</li>
                    <li class="fragment">Representing <i>true</i> or <i>false</i> (<em>Booleans</em>)</li>
                    <li class="fragment">Collections of things</li>
                    <li class="fragment">Custom data types</li>
                </ul>
            </section>
            <section>
                <p>What do we mean by <em>size</em>?</p>
            </section>
            <section>
                <p>Computers "think" in just 1's and 0's, so we use the <em>binary</em> number system.</p>
            </section>
            <section>
                <p>Each bit is just a 0 or 1, so 32 bits is just a sequence of that many zeros or ones.</p>
            </section>
            <section>
                <p>8 bits = <em>1 byte</em></p>
            </section>
            <section>
                <table class="chart" style=${{"font-size": ".8em"}}>
                    <tr>
                        <th>Decimal (Base 10)</th>
                        <th>Binary (Base 2)</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>0001</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>0010</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>0011</td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>0100</td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td>0101</td>
                    </tr>
                    <tr>
                        <td>6</td>
                        <td>0110</td>
                    </tr>
                </table>
            </section>
            <section>
                <p>Something that is n bits can store 2<sup>n</sup> values.</p>
            </section>
            <section>
                <p>A 32-bit data type can store 2<sup>32</sup> values (4,294,967,296)</p>
            </section>
            <section>
                <p>Let's start with <em>numbers</em></p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Number types (no decimals)</h3>
                <table class="chart" style=${{"table-layout": "fixed", "width": "100%", "font-size": ".4em"}}>
                    <tr>
                        <th>Type</th>
                        <th>Size</th>
                        <th>Range</th>
                    </tr>
                    <tr>
                        <td>int</td>
                        <td>32-bits</td>
                        <td>-2,147,483,648 to 2,147,483,648</td>
                    </tr>
                    <tr>
                        <td>short</td>
                        <td>16-bits</td>
                        <td>-32,768 to 32,767</td>
                    </tr>
                    <tr>
                        <td>long</td>
                        <td>64-bits</td>
                        <td>-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807</td>
                    </tr>
                </table>
            </section>
            <section class="ml-bullet-slide">
                <h3>Number types (with decimals)</h3>
                <table class="chart" style=${{"table-layout": "fixed", "width": "100%", "font-size": ".4em"}}>
                    <tr>
                        <th>Type</th>
                        <th>Size</th>
                        <th>Range</th>
                    </tr>
                    <tr>
                        <td>float</td>
                        <td>32-bits</td>
                        <td>Up to about 45 decimal places</td>
                    </tr>
                    <tr>
                        <td>double</td>
                        <td>16-bits</td>
                        <td>Up to  about 438 decimal places</td>
                    </tr>
                </table>
            </section>
            <${CodeSlide} title=${html`Declaring number variables`} lang="java" badge="Java">
short age = 50;
int daysAlive = 18263;
float height = 6.4f;
double imaginaryNetWorth = 99999999999999.99d;
            <//>
            <${CodeSlide} title=${html`Declaring number variables`} lang="javascript" badge="JavaScript">
const age = 50;
const daysAlive = 18263;
const height = 6.4;
const imaginaryNetWorth = 99999999999999.99;
            <//>
            <${CodeSlide} title=${html`Declaring number variables`} lang="typescript" badge="TypeScript">
const age: number = 50;
const daysAlive: number = 18263;
const height: number = 6.4;
const imaginaryNetWorth: number = 99999999999999.99;
            <//>
            <section>
                <p>In <em>Java</em>, if no value is given, a numeric variable <i>defaults</i> to 0.</p>
            </section>
            <section>
                <p>The <em>boolean</em> type represents things that are either <em>true</em> or <em>false</em>.</p>
            </section>
            <${CodeSlide} title=${html`Declaring boolean variables`} lang="java" badge="Java">
boolean doesBlackCrack = false;
boolean isAlive = true;
boolean isDead = !isAlive;
boolean isPoor = (income ${'<='} 15060);
            <//>
            <section>
                <p>If no value is given, a <em>boolean</em> variable <i>defaults</i> to <em>false</em>.</p>
            </section>
            <section>
                <p>Strings are represented using the <em><i>String</i></em> type.</p>
            </section>
            <${CodeSlide} title=${html`Declaring a String`} lang="java" badge="Java">
String name = "Anthony";
            <//>
            <${CodeSlide} title=${html`Declaring a String`} lang="javascript" badge="JavaScript">
const name1 = "Anthony";
const name2 = 'Matthew';
            <//>
            <${CodeSlide} title=${html`Declaring a String`} lang="typescript" badge="TypeScript">
const name1: string = "Anthony";
const name2: string = 'Matthew';
            <//>
            <section>
                <p>If no value is given, a <em>String</em> variable <i>defaults</i> to <em>null</em> (we'll explain in a bit).</p>
            </section>
            <section>
                <p>Sometimes, we need to invent new, <em>custom data types</em> to represent data we need to store.</p>
            </section>
            <section>
                <p>For this, we define <em>classes</em>. We use a class to create an instance of an <em>object</em> that represents our data. We call this <em>instantiation</em>.</p>
            </section>
            <section>
                <p>Here's a class that represents a thing we're calling a <em>Person</em>…</p>
            </section>
            <${CodeSlide} lang="java" badge="Java">
public class Person { // Class name is spelled ProperCase
 private String name;

 public Person(String name) {
   this.name = name;
 }

 public String getName() {
   return name;
 }
}
            <//>
            <${CodeSlide} lang="java" badge="Java">
public class Person {
 private String name; // This variable is available to all 
                      // methods in the class

 public Person(String name) {
   this.name = name;
 }

 public String getName() {
   return name;
 }
}
            <//>
            <${CodeSlide} lang="java" badge="Java">
public class Person {
 private String name;

 /**
  * This special method is called the constructor. 
  * It configures the new object instance. Has the
  * same name as the class and no return type.
  */
 public Person(String name) {
   this.name = name;
 }

 public String getName() {
   return name;
 }
}
            <//>
            <${CodeSlide} lang="java" badge="Java">
public class Person {
 private String name;

 public Person(String name) {
   this.name = name;
 }

 /**
  * This is a instance method. You can only call it using an
  * object instance.
  */
 public String getName() {
   return name;
 }
}
            <//>
            <${CodeSlide} lang="java" badge="Java">
public class Person {
 private String name;

 public Person(String name) {
   // Instance methods can refer to it's own object 
   // instance using the this keyword...
   this.name = name;
 }

 public String getName() {
   // ...or not
   return name;
 }
}
            <//>
            <${CodeSlide} lang="typescript" badge="TypeScript">
export class Person {
 private name: string;

 constructor(name: string) {
   this.name = name;
 }

 getName(): string {
   return this.name;
 }
}
            <//>
            <${CodeSlide} title=${html`Creating our <i>Person</i> instance`} lang="java" badge="Java">
Person instructor = new Person("Anthony Mays");
System.out.println(
    "Your teacher is: " + instructor.getName());

String name = instructor.name; // Error: won't let you compile
                               // since 'name' var is PRIVATE

            <//>
            <section>
                <p>All classes themselves inherit the <em>Object</em> class from Java…</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide281.png" alt="Slide 281" />
            </section>
            <section class="ml-bullet-slide">
                <h3>Every object inherits these methods</h3>
                <ul style=${{"font-size": ".8em"}}>
                    <li class="fragment"><em><i>toString()</i></em> - Gets a string representation of the object</li>
                    <li class="fragment"><em><i>hashCode()</i></em> - Get a unique int value for the instance</li>
                    <li class="fragment"><em><i>equals(Object obj)</i></em> - Returns whether or not this object is equal to another instance (uses hashCode() to figure it out)</li>
                </ul>
            </section>
            <section>
                <p>All variables that store objects can be set to <em>null</em> as a way to say that the variable <i>doesn't have anything in it</i>.</p>
            </section>
            <section>
                <p>That's why <em>String</em> variables are <em>null</em> by default. Strings are <em>objects</em>!</p>
            </section>
            <section>
                <p><span style=${{"color": "red"}}>IMPORTANT</span>!<br />In <em>Java</em>, the number and boolean types we saw earlier are NOT OBJECTS. They are <em>primitives</em> and cannot be <em>null</em>.</p>
            </section>
            <section>
                <p>However, they DO have object equivalents…</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Equivalent Objects for Primitives</h3>
                <table class="chart" style=${{"table-layout": "fixed", "width": "100%", "font-size": ".5em"}}>
                    <tr>
                        <th>Primitive</th>
                        <th>Object class</th>
                    </tr>
                    <tr>
                        <td>int</td>
                        <td>Integer</td>
                    </tr>
                    <tr>
                        <td>long</td>
                        <td>Long</td>
                    </tr>
                    <tr>
                        <td>float</td>
                        <td>Float</td>
                    </tr>
                    <tr>
                        <td>double</td>
                        <td>Double</td>
                    </tr>
                    <tr>
                        <td>boolean</td>
                        <td>Boolean</td>
                    </tr>
                </table>
            </section>
            <${CodeSlide} title=${html`Comparing primitive vs object`} lang="java" badge="Java">
int age = 18;
Integer ageObj = age; // "Wraps" the value in an object.
                      // We call this boxing.

ageObj = null; // This is fine
age = null;    // This will NOT LET YOU COMPILE
            <//>
            <section>
                <p>A quick note on using <em>var</em></p>
            </section>
            <section>
                <p><span style=${{"color": "red"}}>IMPORTANT!</span><br />The rule of <em>var</em>: only use if the type name is clear on the <i>right side</i> of the equal sign.</p> 
            </section>
            <${CodeSlide} title=${html`Using <em>var</em>`} lang="java" badge="Java">
var number = 18;                 // We know this is an 'int'
var name = "Anthony";            // We know this is a 'String'
var list = new ArrayList${'<'}int${'>'}(); // We know this is 'ArrayList'
var football = getFootball();    // BAD!! We can't see the type
            <//>
            <${QuestionsSlide}/>
        <//>`;
}

export default Lesson09;