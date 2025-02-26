import htm from "htm";
import { createElement } from "react";
import { Lesson, QuestionsSlide } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson06() {
    return html`
        <${Lesson} title="Statements and Variables" lessonId="lesson_06" subtitle="Lesson 6" titleFontSize="1.4em">
            <section>
                <p>It's time to talk about <em>writing code</em></p>
            </section>
            <section>
                <p>We write code from top to bottom, one <em>statement</em> at a time</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide144.png" alt="Slide 144" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide145.png" alt="Slide 145" />
            </section>
            <section class="ml-bullet-slide">
                <h3>Types of statements</h3>
                <ul style=${{"font-size": ".8em"}}>
                    <li class="fragment"><em><i>Declaration</i></em> (making a new variable, function, data type)</li>
                    <li class="fragment"><em><i>Function</i></em> call (run or execute a function)</li>
                    <li class="fragment"><em><i>Expression</i></em> (storing something)</li>
                    <li class="fragment"><em><i>Control flow</i></em> (determine what code runs when)</li>
                    <li class="fragment"><em><i>Return</i></em> (return a result from a function)</li>
                    <li class="fragment"><em><i>Import</i></em> (bring data types from other places)</li>
                </ul>
            </section>
            <section class="ml-bullet-slide">
                <h3>Types of statements</h3>
                <ul style=${{"font-size": ".8em"}}>
                    <li><em><i>Declaration</i></em> (making a new variable, function, data type)</li>
                    <li><em><i>Function</i></em> call (run or execute a function)</li>
                    <li><em><i>Expression</i></em> (storing something)</li>
                    <li style=${{"opacity": ".3"}}><em><i>Control flow</i></em> (determine what code runs when)</li>
                    <li style=${{"opacity": ".3"}}><em><i>Return</i></em> (return a result from a function)</li>
                    <li style=${{"opacity": ".3"}}><em><i>Import</i></em> (bring data types from other places)</li>
                </ul>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide148.png" alt="Slide 148" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide149.png" alt="Slide 149" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide150.png" alt="Slide 150" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide151.png" alt="Slide 151" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide152.png" alt="Slide 152" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide153.png" alt="Slide 153" />
            </section>
            <section>
                <p>The <em><i>function signature</i></em> identifies the inputs and outputs of a method</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide155.png" alt="Slide 155" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide156.png" alt="Slide 156" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide157.png" alt="Slide 157" />
            </section>
            <section>
                <p>Express yourself</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide159.png" alt="Slide 159" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide160.png" alt="Slide 160" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide161.png" alt="Slide 161" />
            </section>
            <${QuestionsSlide}/>
        <//>`;
}

export default Lesson06;