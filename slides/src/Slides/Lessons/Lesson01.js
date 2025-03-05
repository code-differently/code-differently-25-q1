import htm from "htm";
import { createElement } from "react";
import { DemoSlide, Lesson } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson01() {
    return html`
        <${Lesson} title="Getting to Know the IDE" lessonId="lesson_01" subtitle="Lesson 1">
            <section>
                <p>"This is my <em>rifle</em>. There are many like it, but <em>this one</em> is mine."</p>
            </section>
            <section>
                <p>"My rifle is my best friend. It is my life. I must <em>master it</em> as I must master <em>my life.</em>"</p>
            </section>
            <section>
                <p>"My rifle, without me, <em>is useless</em>. Without my rifle, I am useless…"</p>
                <p>—Marine's Rifle Creed</p>
            </section>
            <section>
                <p>Yeah, it's like that</p>
            </section>
            <section>
                <p>What is an <em>IDE</em>?</p>
            </section>
            <section>
                <p>An <em><i>Integrated Development Environment (IDE)</i></em> is software used to manage the developer workflow from writing and testing code to deploying.</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Why we use <em>IDEs</em></h3>
                <ul>
                    <li class="fragment">Editing and refactoring code</li>
                    <li class="fragment">Browsing code</li>
                    <li class="fragment">Debugging</li>
                    <li class="fragment">Testing</li>
                    <li class="fragment">Managing source control</li>
                    <li class="fragment">Issue tracking</li>
                </ul>
            </section>
            <section class="ml-bullet-slide">
                <h3>Popular IDEs</h3>
                <ul>
                    <li class="fragment">VS Code & Visual Studio <em>(multi-lang)</em></li>
                    <li class="fragment">JetBrains Intellij IDEA <em>(Java)</em></li>
                    <li class="fragment">Eclipse <em>(multi-lang)</em></li>
                    <li class="fragment">NetBeans <em>(Java)</em></li>
                    <li class="fragment">XCode <em>(MacOS)</em></li>
                </ul>
            </section>
            <section class="ml-bullet-slide">
                <h3>How to <em>choose</em> one</h3>
                <ul>
                    <li class="fragment">Language support</li>
                    <li class="fragment">Extensibility</li>
                    <li class="fragment">Refactoring support</li>
                </ul>
            </section>
            <section class="ml-bullet-slide">
                <h3>How to <em>choose</em> one</h3>
                <ul>
                    <li style=${{'text-decoration': 'line-through', 'opacity': '.3'}}>Language support</li>
                    <li style=${{'text-decoration': 'line-through', 'opacity': '.3'}}>Extensibility</li>
                    <li style=${{'text-decoration': 'line-through', 'opacity': '.3'}}>Refactoring support</li>
                    <li>Whatever your boss tells you to use</li>
                </ul>
            </section>
            <section>
                <p>For our class, we're using <em>VS Code</em></p>
            </section>
            <section>
                <p>We're also leveraging <em>Dev Containers</em>, a feature that lets us work from the same <i>pre-configured</i> environment.</p>
            </section>
            <${DemoSlide} />
        <//>`;
}

export default Lesson01;