import htm from "htm";
import { createElement } from "react";
import { Lesson } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson00() {
    return html`
        <${Lesson} title="Git Fundamentals" subtitle="Lesson 0" lessonId="lesson_00">
            <section class="ml-bullet-slide">
                <h3 class="big-title">What we're doing</h3>
                <ul>
                    <li class="fragment">Why we need version control</li>
                    <li class="fragment">What is Git and GitHub?</li>
                    <li class="fragment">Working with forks and branches</li>
                    <li class="fragment">Learning the basic workflow</li>
                </ul>
            </section>
            <section>
                <p>Why we need <em>version control</em></p>
            </section>
            <section class="ml-bullet-slide">
                <h3 class="big-title">Why we need <em>version control</em></h3>
                <ul>
                    <li class="fragment">Track changes over time</li>
                    <li class="fragment">Collaborate with others</li>
                    <li class="fragment">Revert to previous versions</li>
                    <li class="fragment">Backup your work</li>
                </ul>
            </section>
            <section>
                <p>What is <em>Git</em> and <em>GitHub</em>?</p>
            </section>
            <section>
                <p><em>Git</em> is a distributed version control system (VCS) that works well for branching and is fast</p>
            </section>
            <section>
                <p><em>GitHub</em> is a platform for hosting Git repositories and features tools for managing software collaboration</p>
            </section>
            <section>
                <p>Working with <em>Forks</em> and <em>Branches</em></p>
            </section>
            <section>
                <p>A <em>branch</em> is a copy of the repo that allows you to make changes and merge them back later</p>
            </section>
            <section>
                <p><em>Forks</em> are just branched copies of other user's repos that you own and modify</p>
            </section>
            <section class="ml-bullet-slide">
                <h3 class="big-title">Why we <em>branch</em></h3>
                <ul>
                    <li class="fragment">Work on features or fixes without impacting work happening in other places</li>
                    <li class="fragment">Run tests or deployments</li>
                    <li class="fragment">Experiment with changes safely</li>
                </ul>
            </section>
            <section>
                <p>Learning the <em>basic workflow</em></p>
            </section>
            <section class="ml-bullet-slide">
                <h3 class="big-title">The <em>basic workflow</em></h3>
                <ol style=${{"font-size": ".9em"}}>
                    <li class="fragment">Pull the latest changes from other devs</li>
                    <li class="fragment">Change some more stuff</li>
                    <li class="fragment">Commit to git locally</li>
                    <li class="fragment">Push to server remotely (GitHub)</li>
                    <li class="fragment">Repeat 1–4 a bunch</li>
                    <li class="fragment">Create a pull request (PR) when done</li>
                </ol>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide16.png" alt="Slide 16" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide17.png" alt="Slide 17" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide18.png" alt="Slide 18" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide19.png" alt="Slide 19" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide20.png" alt="Slide 20" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide21.png" alt="Slide 21" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide22.png" alt="Slide 22" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide23.png" alt="Slide 23" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide24.png" alt="Slide 24" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide25.png" alt="Slide 25" />
            </section>
        <//>`;
}

export default Lesson00;