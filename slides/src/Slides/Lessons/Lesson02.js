import htm from "htm";
import { createElement } from "react";
import { Lesson } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson02() {
    return html`
        <${Lesson} title="Exploring the Terminal" lessonId="lesson_02" subtitle="Lesson 2">
            <section>
                <p>Developers do <em>a lot</em> of typing</p>
            </section>
            <section>
                <p>And we don't like <em>switching</em> between keyboard and mouse…</p>
            </section>
            <section>
                <p>And making graphical user interfaces is <em>hard</em> and sometimes <em>ambiguous</em></p>
            </section>
            <section>
                <p>So we prefer <em>the terminal</em></p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Things we do from <em>the terminal</em></h3>
                <ul>
                    <li class="fragment">Install and run programs needed for the dev workflow</li>
                    <li class="fragment">Navigate files and source code</li>
                    <li class="fragment">Manipulate files quickly</li>
                    <li class="fragment">Automate repetitive tasks</li>
                </ul>
            </section>
            <section>
                <p>⌘ + Spacebar, "terminal"</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide49.png" alt="Slide 49" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide50.png" alt="Slide 50" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide51.png" alt="Slide 51" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide52.png" alt="Slide 52" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide53.png" alt="Slide 53" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide54.png" alt="Slide 54" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide55.png" alt="Slide 55" />
            </section>
            <section class="ml-bullet-slide">
                <h3>Navigating files & directories</h3>
                <p class="fragment"><em><i>pwd</i></em> - print working directory</p>
                <p class="fragment"><em><i>ls</i></em> - list files in directory</p>
                <p class="fragment"><em><i>cd</i></em> - change directories</p>
            </section>
            <section class="ml-bullet-slide" style=${{ "font-size": ".9em" }}>
                <h3>Adding and removing files & dirs</h3>
                <p class="fragment"><em><i>touch</i></em> - make a new file</p>
                <p class="fragment"><em><i>mkdir</i></em> - make a new directory</p>
                <p class="fragment"><em><i>mv</i></em> - moves a file or directory</p>
                <p class="fragment"><em><i>cp</i></em> - copy a file or directory</p>
                <p class="fragment"><em><i>rm</i></em> - remove a file or directory</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Finding stuff</h3>
                <p class="fragment"><em><i>find</i></em> - find files matching a pattern</p>
                <p class="fragment"><em><i>grep</i></em> - find files based on content</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Actin all powerful and stuff</h3>
                <p class="fragment"><em><i>sudo</i></em> - run something as admin</p>
                <p class="fragment"><em><i>chmod</i></em> - change permissions on file/dir</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Viewing and editing files</h3>
                <p class="fragment"><em><i>cat</i></em> - dump contents of a file</p>
                <p class="fragment"><em><i>tail</i></em> - view the last several lines of a file</p>
                <p class="fragment"><em><i>nano</i></em> - lightweight file editor</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Special operators</h3>
                <p class="fragment"><em><i>&&</i></em> - chain commands together</p>
                <p class="fragment"><em><i>|</i></em> - (pipe) feed output of one to another</p>
                <p class="fragment"><em><i>&</i></em> - run command in the background</p>
            </section>
        <//>`;
}

export default Lesson02;