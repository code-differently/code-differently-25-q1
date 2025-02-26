import htm from "htm";
import { createElement } from "react";
import { DemoSlide, Lesson } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson03() {
    return html`
        <${Lesson} title="How Computers Work" lessonId="lesson_03" subtitle="Lesson 3">
            <section>
                <p>So, what is a <em>computer</em>?</p>
            </section>
            <section style=${{"text-align": "left", "font-size": "1.2em"}}>
                <p>A <em>computer</em> is a machine that <span class="fragment"><i>transforms</i> <em>input</em> data to <em>output</em> data</span> <span class="fragment">using <i>automatically executed</i>, pre-programmed <em>instructions</em>.</span></p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide68.png" alt="Slide 68" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide69.png" alt="Slide 69" />
            </section>
            <section>
                <p>How does it work?</p>
            </section>
            <section>
                <p>The <em><i>motherboard</i></em> transforms the steady signal of power from the <em>power supply</em> into a binary signal of 1s and 0s.</p>
            </section>
            <section>
                <p>The <em><i>central processing unit (CPU)</i></em> performs <i>mathematical operations</i>, computing everything from letters and numbers, to the color of each screen pixel</p>
            </section>
            <section>
                <p>Everything is <em><i>numbers</i></em>, and numbers <em><i>are everything</i></em></p>
            </section>
            <section>
                <p>CPU loads pre-programmed instructions <em><i>(software)</i></em> from the <em><i>hard drive</i></em> and keeps track of calculations using <em><i>random access memory (RAM)</i></em></p>
            </section>
            <section>
                <p>CPU uses the motherboard to direct other input/output devices <em><i>(peripherals)</i></em> like the keyboard and mouse, the monitor, webcams, game controllers, WiFi and bluetooth adapters.</p>
            </section>
            <section>
                <p>Modern computers leverage the <em><i>graphical processing unit (GPU)</i></em> for handling intensive number-crunching for graphics.</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide77.png" alt="Slide 77" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide78.png" alt="Slide 78" />
            </section>
            <section class="ml-bullet-slide">
                <h3>The desk analogy</h3>
                <ul style=${{"font-size": ".9em"}}>
                    <li class="fragment">Desk as the motherboard</li>
                    <li class="fragment">Draws are like the hard drives</li>
                    <li class="fragment">Desktop, paper, sticky notes models RAM</li>
                    <li class="fragment">Calculator is the CPU</li>
                    <li class="fragment">The power strip is like the power supply?</li>
                    <li class="fragment">You are the software</li>
                </ul>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide80.png" alt="Slide 80" />
            </section>
            <section class="ml-bullet-slide">
                <h3>The body analogy</h3>
                <ul style=${{"font-size": ".9em"}}>
                    <li class="fragment">Central nervous system is the motherboard</li>
                    <li class="fragment">Brain's long term memory is the hard drive</li>
                    <li class="fragment">Brain's short term memory is the RAM</li>
                    <li class="fragment">Brain is the CPU</li>
                    <li class="fragment">Heart is like the power supply</li>
                </ul>
            </section>
            <${DemoSlide} />
        <//>`;
}

export default Lesson03;