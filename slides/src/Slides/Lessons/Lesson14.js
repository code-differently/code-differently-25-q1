import htm from "htm";
import { createElement } from "react";
import { CodeSlide, Lesson } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson14() {
    return html`
        <${Lesson} title="Exception Handling" lessonId="lesson_14" subtitle="Lesson 14">
            <section>
                <p>Let's <em>review</em></p>
            </section>
            <section style=${{ "text-align": "left" }}>
                <p>A <em>computer</em> is a machine that <i>transforms</i> <em>input</em> data to <em>output</em> data using <i>automatically executed</i>, pre-programmed <em>instructions</em>.</p>
            </section>
            <section>
                <p>So…what do you do if your input data is <em>junk</em>?</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>What could go wrong?</h3>
                <ul>
                    <li class="fragment">User puts letters in a phone number</li>
                    <li class="fragment">Developer uses a method and provides <em>null</em> instead of a real value</li>
                    <li class="fragment">H4ck3r tries to overwhelm the system with nonsense to break your app</li>
                </ul>
            </section>
            <section>
                <p><em>Murphy's Law:</em><br />Anything that can go wrong will go wrong</p>
            </section>
            <section>
                <p>Like driving, you need to be a <i>defensive</i> programmer</p>
            </section>
            <section>
                <p>When bad things happen, Java uses something called an <em><i>Exception</i></em> to alert the system that something exceptional has happened.</p>
            </section>
            <section>
                <p>An <i>Exception</i>, if not <em><i>handled</i></em>, will cause a program to end abruptly.</p>
            </section>
            <section>
                <p>Every Java exception is a regular object that extends the <em>Exception</em> class.</p>
            </section>
            <section>
                <p>You raise an exception (think of it like escalation) by <em>throwing</em> it.</p>
            </section>
            <${CodeSlide} lang="java">
${`
// This is how you throw an exception. You create an instance
// of an exception like you would any other object.
throw new RuntimeException("Something went wrong!");
`}
            <//>
            <section>
                <p>Here are some common exceptions…</p>
            </section>
            <section class="ml-bullet-slide">
                <h3><em>NullPointerException</em> (NPE)</h3>
                <p>Occurs when attempting to use a method or property on something that is NULL (empty)</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true">
${`
public class App {
   public static void main(String[] args) {
       // Probably shouldn't provide \`null\` for a student.
       double gpa = getStudentGpa(null);
       // We won't make it.         
       System.out.println("Made it!");
   }

   private static double getStudentGpa(Student student) {
		// Will blow up if student is \`null\`.
       return student.getGpa();
   }
}
`}
            <//>
            <section class="ml-bullet-slide">
                <h3><em>ArrayIndexOutOfBoundsException</em></h3>
                <p>Occurs when attempting to access an index in an array that doesn't exist.</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true">
${`
// Seven days of the week.
var daysOfTheWeek = new String[] {
   "Sun", "Mon", "Tue", "Wed", "Thurs", "Fri", "Sat"};

// Whoops, the last day is index 6, not 7 (zero-based).
System.out.println(
   "The last day of the week is " + daysOfTheWeek[7]);
`}
            <//>
            <section class="ml-bullet-slide">
                <h3><em>IllegalArgumentException</em></h3>
                <p>Occurs when providing a value to a function that is unexpected.</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true">
${`
var timer = new Timer();
timer.schedule(
   // Argument 1: Print a message when the timer expires
   new TimerTask() {
       @Override
       public void run() {
           System.out.println("Time's up!");
       }
   },
   // Argument 2: Whoops, can't schedule something in the past!!
   -1000 /* in milliseconds */);
`}
            <//>
            <section class="ml-bullet-slide">
                <h3><em>IOException</em> (input/output)</h3>
                <p>Occurs when something goes wrong when attempting to handle some input or output.</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true">
${`
public static List<String> readFile() throws Exception {
   var path = Path.of("/this/file/does/not/exist.txt");

   // This will blow up with an IOException (specifically, 
   // a FileNotFoundException).
   return Files.readLines(path.toFile(), Charsets.UTF_8);
}
`}
            <//>
            <section>
                <p><i>Exceptions</i> happen. Java gives us a way to handle exceptions.</p>
            </section>
            <section>
                <p>In fact, sometimes Java tells us that we <em>must</em> handle an exception. These are called <em><i>checked exceptions</i></em>.</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true">
${`
public static List<String> readFile() throws Exception {
   var path = Path.of("/this/file/does/not/exist.txt");

   // This will blow up with an IOException (specifically, 
   // a FileNotFoundException).
   return Files.readLines(path.toFile(), Charsets.UTF_8);
}
`}
            <//>
            <section>
                <img class="r-stretch" src="images/slides/Slide480.png" alt="Slide 480" />
            </section>
            <section class="ml-bullet-slide">
                <h3>Options for checked exceptions</h3>
                <ul>
                    <li class="fragment">Update our calling method to indicate that we too throw the exception (pass the buck).</li>
                    <li class="fragment">Handle the exception ourselves.</li>
                </ul>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true">
${`
// We're just gonna pass the buck.
public static List<String> readFile() throws Exception {
   var path = Path.of("/this/file/does/not/exist.txt");

   // This will blow up with an IOException (specifically, 
   // a FileNotFoundException).
   return Files.readLines(path.toFile(), Charsets.UTF_8);
}
`}
            <//>
            <section>
                <p>But how do we handle it?<br />Using <em>try / catch</em>.</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true">
${`
try {
    /* Run code that can explode. */
} catch (IOException e) {
    // We can "catch" the exception and do something.
    System.out.println(
        "An error occurred: " + e.getMessage());
} finally {
    // This is optional, and allows us to clean up even if
    // an exception does occur.
}
System.out.println("Nothing to see here.");
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers="true">
${`
public static List<String> readFile() {
   try {
       var path = Path.of("/this/file/does/not/exist.txt");
       return Files.readLines(path.toFile(), Charsets.UTF_8);
   } catch (Exception e) {
       System.out.println(
          "An error occurred: " + e.getMessage());
   }
   return List.of();
}
`}
            <//>
            <section>
                <p><span class="important">IMPORTANT!</span><br /><em>Never</em> swallow exceptions by catching them and doing nothing!!!</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true">
${`
public static void main(String[] args) {
   try {
       var path = Path.of("/this/file/does/not/exist.txt");
       return Files.readLines(path.toFile(), Charsets.UTF_8);
   } catch (IOException e) {
       /* No one hears your screams. No one will save you. */
   }
   return List.of();
}
`}
            <//>
            <section>
                <p>We can make our own custom exceptions pretty easily…</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="1-6,10-13" fontSize="0.42em">
${`
// Needs the \`extends Exception\` bit.
public class TeacherIsAJerkException extends Exception {
   public TeacherBeingAJerkException(String message) {
       super(message);
   }
}

public class App {
   public static void main(String[] args) {
       if (getMyGrade() < 90) {
           throw new TeacherIsAJerkException(
               "The teacher is acting like a real jerk today!");
       }
   }
}
`}
            <//>
            <section>
                <p>Use exceptions <em><i>exceptionally</i></em>. Most times, you can avoid throwing exceptions</p>
            </section>
        <//>`;
}

export default Lesson14;