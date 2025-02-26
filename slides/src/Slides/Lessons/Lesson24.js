import htm from "htm";
import { createElement } from "react";
import { CodeSlide, DemoSlide, Lesson, QuestionsSlide } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson24() {
    return html`
        <${Lesson} title="JavaScript Deep Dive" lessonId="lesson_24" subtitle="Lesson 24">
            <section>
                <p>Let's build a <em>web application</em></p>
            </section>
            <section>
                <p>Its purpose is to allow users to search for stuff. Here's how it will look:</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide779.png" alt="Slide 779" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide780.png" alt="Slide 780" />
            </section>
            <section>
                <p>Let's get more technical…</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide782.png" alt="Slide 782" />
            </section>
            <section>
                <p>A <em>web server</em> is a program that "serves" content to users on the web</p>
            </section>
            <section>
                <p>We're going to use <em>NodeJS</em> to run JavaScript on the backend (where the web server is)</p>
            </section>
            <section>
                <p>We'll also use the <em>Express</em> framework to do the heavy lifting of serving our HTML, CSS, and JS</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide786.png" alt="Slide 786" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide787.png" alt="Slide 787" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide788.png" alt="Slide 788" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide789.png" alt="Slide 789" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide790.png" alt="Slide 790" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide791.png" alt="Slide 791" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide792.png" alt="Slide 792" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide793.png" alt="Slide 793" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide794.png" alt="Slide 794" />
            </section>
            <section>
                <p>We're going to start with the web server</p>
            </section>
            <section>
                <p>We have many choices for building our web server….</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Web server choices</h3>
                <ul>
                    <li class="fragment">Java + Vaadin or Thymeleaf</li>
                    <li class="fragment">C# + ASP.NET Core</li>
                    <li class="fragment">JavaScript + Node</li>
                    <li class="fragment">Ruby + Rails</li>
                    <li class="fragment">PHP + Laravel</li>
                </ul>
            </section>
            <section class="ml-bullet-slide">
                <h3>Web server choices</h3>
                <ul>
                    <li>Java + Vaadin or Thymeleaf</li>
                    <li>C# + ASP.NET Core</li>
                    <li><em>JavaScript + Node</em></li>
                    <li>Ruby + Rails</li>
                    <li>PHP + Laravel</li>
                </ul>
            </section>
            <section>
                <p>Let's get started</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide801.png" alt="Slide 800" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide801.png" alt="Slide 801" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide802.png" alt="Slide 802" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide803.png" alt="Slide 803" />
            </section>
            <${DemoSlide} />
            <${CodeSlide} lang="javascript" lineNumbers="true" fontSize=".35em" badge="index.js">
${`
const express = require("express"); // Get express
const morgan = require("morgan"); // Get morgan
const path = require("path"); // Get path
var debug = require('debug')('myapp:server'); // Get debug logger

const app = express(); // Create express app

app.use(morgan("dev")); // Setup morgan middleware
app.use(express.static(path.join(__dirname, "public"))); // Setup static files

const PORT = process.env.PORT || 3000; // Setup port

// Start the server
app.listen(PORT, () => {
 debug(\`Server listening on http://localhost:\${PORT}\`);
});
`}
            <//>
            <section>
                <img class="r-stretch" src="images/slides/Slide806.png" alt="Slide 806" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide807.png" alt="Slide 807" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide808.png" alt="Slide 808" />
            </section>
            <${DemoSlide} />
            <section>
                <img class="r-stretch" src="images/slides/Slide810.png" alt="Slide 810" />
            </section>
            <${DemoSlide} />
            <${QuestionsSlide} />
        <//>`;
}

export default Lesson24;