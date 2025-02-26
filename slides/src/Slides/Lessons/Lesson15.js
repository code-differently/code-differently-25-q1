import htm from "htm";
import { createElement } from "react";
import { CodeSlide, Lesson } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson15() {
    return html`
        <${Lesson} title="Test-Driven Development" lessonId="lesson_15" subtitle="Lesson 15" titleFontSize="1.4em">
            <section>
                <p>For the next two weeks, you will learn how to <em>design</em> code that solves problems for your users</p>
            </section>
            <section>
                <p>Remember, design is about <em>how we build</em> what users want</p>
            </section>
            <section>
                <p><em><i>Test-driven development (TDD)</i></em> is an approach for designing and writing code that meets some set of specifications.</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Steps for <em>TDD</em></h3>
                <ul>
                    <li class="fragment">Write a test that describes some requirement.</li>
                    <li class="fragment">Run the test and watch it <span style=${{"color": "#ea9999"}}>fail</span>.</li>
                    <li class="fragment">Implement minimal code needed to make the test <span style=${{"color": "#b7d7a8"}}>pass</span>.</li>
                    <li class="fragment">Repeat a bunch more times.</li>
                </ul>
            </section>
            <section>
                <p>What does it mean to <em>write a test</em>?</p>
            </section>
            <section>
                <p>A <em><i>unit test</i></em> is code that executes a function with example input and asserts that the output matches what is expected.</p>
            </section>
            <section>
                <p>There are other kinds of tests too <i>(integration, black box, smoke, etc)</i>, but we rely on <em>unit</em> or <em>integration tests</em> for TDD.</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>How to write a good unit test</h3>
                <ul style=${{"font-size": ".85em"}}>
                    <li class="fragment">Understand how you expect the code to be used.</li>
                    <li class="fragment">Think of a single input scenario and its associated output.</li>
                    <li class="fragment">Test a single method at a time.</li>
                    <li class="fragment">Make your test as small and simple as possible.</li>
                </ul>
            </section>
            <section>
                <p>OK, let's do <em>TDD</em>!</p>
            </section>
            <section>
                <p>Step 1: Write a test</p>
            </section>
            <${CodeSlide} lang="java" fontSize=".35em">
${`
package com.codedifferently;  // Same package as the class you're testing

// Import the JUnit types and functions
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

class AppTest {
   @Test // <-- Mark with the @Test annotation
   void testSort_ordersElements() {
       // Arrange
       var items = new int[] { 3, 2, 1 };

       // Act
       var actual = App.sort(items);

       // Assert
       assertArrayEquals(new int[] { 1, 2, 3 }, actual);
   }
}
`}
            <//>
            <section>
                <p>Hey, what is an <em>annotation</em>?</p>
            </section>
            <section>
                <p>An <em>annotation</em> is just a data type that can be used to decorate methods and classes (use "@" followed by the name of the annotation type).</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide507.png" alt="Slide 507" />
            </section>
            <section>
                <p>Step 2: Run the test, watch it fail</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide509.png" alt="Slide 509" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide510.png" alt="Slide 510" />
            </section>
            <section>
                <p>You can create code automatically using refactoring tools in VS Code (and any modern IDE)</p>
            </section>
            <section>
                <p><em>Refactoring</em> is just a fancy word for moving code around without breaking functionality</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide513.png" alt="Slide 513" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide514.png" alt="Slide 514" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide515.png" alt="Slide 515" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide516.png" alt="Slide 516" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide517.png" alt="Slide 517" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide518.png" alt="Slide 518" />
            </section>
            <section>
                <p>Step 3: Now write code to make the test pass</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide520.png" alt="Slide 520" />
            </section>
            <section class="ml-bullet-slide">
                <h3>Additional things to test</h3>
                <ul style=${{"font-size": ".85em"}}>
                    <li class="fragment">Does it work with <em>null</em> input?</li>
                    <li class="fragment">What about empty arrays?</li>
                    <li class="fragment">Should we support more than just ints?</li>
                    <li class="fragment">Do we need to support different orderings (ascending vs descending)?</li>
                </ul>
            </section>
            <section>
                <p>A quick note on writing unit tests…</p>
            </section>
            <section>
                <p>We usually want our code to be <em>DRY</em>, but prefer to be <em>DAMP</em> in your <i>unit tests</i> (Descriptive and Meaningful Phrases).</p>
            </section>
            <section>
                <p>Some duplication may be preferred in unit tests if it makes the tests more clear and less complicated.</p>
            </section>
        <//>`;
}

export default Lesson15;