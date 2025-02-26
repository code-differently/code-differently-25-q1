import htm from "htm";
import { createElement } from "react";
import { Lesson, QuestionsSlide } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson05() {
    return html`
        <${Lesson} title="Software Dev Life Cycle" lessonId="lesson_05" subtitle="Lesson 5">
            <section>
                <p>The <em><i>software development lifecycle (SDLC)</i></em> is the process by which software progresses from ideation to reality.</p>
            </section>
            <section>
                <p>Let's start with <em>Waterfall</em></p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Waterfall</h3>
                <ul>
                    <li class="fragment">Functional requirements</li>
                    <li class="fragment">Design</li>
                    <li class="fragment">Implementation</li>
                    <li class="fragment">Testing/QA</li>
                    <li class="fragment">Deployment</li>
                </ul>
            </section>
            <section>
                <p>Functional requirements are about defining what the <em>user</em> wants</p>
            </section>
            <section>
                <p>Design is about <em>how we build</em> what users want</p>
            </section>
            <section>
                <p>Implementation is when we <em>build it</em></p>
            </section>
            <section>
                <p>Testing/QA is how we <em>make sure</em> we built what users want</p>
            </section>
            <section>
                <p>Deployment is how we put what we built <em>into the hands</em> of our users (without breaking stuff)</p>
            </section>
            <section>
                <img class="r-stretch" src="images/waterfalls.gif" alt="Chasing waterfalls" />
            </section>
            <section>
                <p>Waterfall sounds great, but had some <em>problems…</em></p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Problems with Waterfall</h3>
                <ul>
                    <li class="fragment">Users don't know what they want</li>
                    <li class="fragment">It's hard to execute each step completely for a software system</li>
                    <li class="fragment">Everything is always delivered late</li>
                    <li class="fragment">By the time you deliver it, users already hate it</li>
                </ul>
            </section>
            <section>
                <p>But what if just deliver <em>parts of the system</em> at a time and adjust as we go?</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide120.png" alt="Slide 120" />
            </section>
            <section>
                <p>A <em>day in the life</em> of a software engineer (in screenshots)</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide122.png" alt="Slide 122" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide123.png" alt="Slide 123" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide124.png" alt="Slide 124" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide125.png" alt="Slide 125" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide126.png" alt="Slide 126" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide127.png" alt="Slide 127" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide128.png" alt="Slide 128" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide129.png" alt="Slide 129" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide130.png" alt="Slide 130" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide131.png" alt="Slide 131" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide132.png" alt="Slide 132" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide133.png" alt="Slide 133" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide134.png" alt="Slide 134" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide135.png" alt="Slide 135" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide136.png" alt="Slide 136" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide137.png" alt="Slide 137" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide138.png" alt="Slide 138" />
            </section>
            <section>
                <p><i>Phew!</i></p>
            </section>
            <${QuestionsSlide}/>
        <//>`;
}

export default Lesson05;