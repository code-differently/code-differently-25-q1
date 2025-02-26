import htm from "htm";
import { createElement } from "react";
import { DemoSlide, Lesson } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson22() {
    return html`
        <${Lesson} title="Building Applications" lessonId="lesson_22" subtitle="Lesson 22">
            <section style=${{ "text-align": "left" }}>
                <p>A <em>computer</em> is a machine that <i>transforms</i> <em>input</em> data to <em>output</em> data using <i>automatically executed</i>, pre-programmed <em>instructions</em>.</p>
            </section>
            <section>
                <p>What is an <em>application</em>?</p>
            </section>
            <section>
                <p>An <em>application</em> is a program that fulfills a purpose for some user</p>
            </section>
            <section>
                <p>Software applications are usually a combination of <i>programs</i> and <i>services</i> that work together in a <em>software system</em></p>
            </section>
            <section>
                <p>Let's talk about what you need to build an <em>app</em></p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Anatomy of an Application</h3>
                <ul>
                    <li class="fragment" data-fragment-index=1><span class="fragment custom em" data-fragment-index=5>User interface</span></li>
                    <li class="fragment" data-fragment-index=2>Services</li>
                    <li class="fragment" data-fragment-index=3>Storage</li>
                    <li class="fragment" data-fragment-index=4>Configuration</li>
                </ul>
            </section>
            <section>
                <p>The <em>user interface</em> is what the user sees in order to interact with your application</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide715.png" alt="Slide 715" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide716.png" alt="Slide 716" />
            </section>
            <section class="ml-bullet-slide">
                <h3>Anatomy of an Application</h3>
                <ul>
                    <li class="fragment custom em no-em">User interface</li>
                    <li class="fragment custom em">Services</li>
                    <li>Storage</li>
                    <li>Configuration</li>
                </ul>
            </section>
            <section>
                <p>A <em>service</em> is a component of software used by other software applications.</p>
            </section>
            <section>
                <p>It can be represented as a set of <i>classes</i> and <i>functions</i> you code to provide functionality to the rest of your application.</p>
            </section>
            <section>
                <p>Some services are organized into <em>libraries</em> that offer a variety of functions in your app. Others are hosted on the web and are called <em>web services</em></p>
            </section>
            <section>
                <p>Then, there are <em>frameworks</em> that allow you to build your application using pre-built components that save you time (e.g. React, Angular, Java Spring, etc.)</p>
            </section>
            <section>
                <p>
                    Libraries and frameworks <em>=></em> in app<br />
                    Web services <em>=></em> outside app
                </p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Anatomy of an Application</h3>
                <ul>
                    <li>User interface</li>
                    <li class="fragment custom em">Services</li>
                    <li class="fragment custom em no-em">Storage</li>
                    <li>Configuration</li>
                </ul>
            </section>
            <section>
                <p>Applications almost always need to store data in order to operate</p>
            </section>
            <section class="ml-columns-slide">
                <h3>Types of <em>data</em></h3>
                <div class="columns" style=${{ "gap": 30 }}>
                    <ul style=${{ "list-style-type": "none", "margin": 0 }}>
                        <li>Names</li>
                        <li>Addresses</li>
                        <li>Characters</li>
                        <li>Orders</li>
                        <li>Posts</li>
                    </ul>
                    <ul style=${{ "list-style-type": "none", "margin": 0 }}>
                        <li>Emails</li>
                        <li>Messages</li>
                        <li>Preferences</li>
                        <li>Favorites</li>
                        <li>Songs</li>
                    </ul>
                    <ul style=${{ "list-style-type": "none", "margin": 0 }}>
                        <li>Playlist</li>
                        <li>Files</li>
                        <li>Pictures</li>
                        <li>Courses</li>
                        <li>Pokemon</li>
                    </ul>
                </div>
            </section>
            <section class="ml-bullet-slide">
                <h3>Types of <em>storage</em></h3>
                <ul>
                    <li class="fragment">RAM (in-memory, cache)</li>
                    <li class="fragment">Databases (sql, nosql, vector, search)</li>
                    <li class="fragment">Files (csv, tsv, json, yaml, xml)</li>
                    <li class="fragment">Cookies</li>
                </ul>
            </section>
            <section class="ml-bullet-slide">
                <h3>Anatomy of an Application</h3>
                <ul>
                    <li>User interface</li>
                    <li>Services</li>
                    <li class="fragment custom em no-em">Storage</li>
                    <li class="fragment custom em">Configuration</li>
                </ul>
            </section>
            <section>
                <p>A single application will often need to run in different <em>environments</em></p>
            </section>
            <section>
                <p>An <em>environment</em> can be composed of different computers, databases, and services</p>
            </section>
            <section>
                <p>An application may run in one environment that's used by real users (usually called <em>production</em>), while another environment is used only by the devs (usually called <em>development</em>)</p>
            </section>
            <section>
                <p>Instead of baking the names of computers, servers, and databases into the code, we rely on <em>configuration</em> management</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Things we <em>configure</em></h3>
                <ul>
                    <li class="fragment">App specific settings</li>
                    <li class="fragment">Database addresses</li>
                    <li class="fragment">Paths to files we need</li>
                    <li class="fragment">Url location of web services</li>
                    <li class="fragment">Security settings</li>
                    <li class="fragment">Localization languages</li>
                </ul>
            </section>
            <section>
                <p>Usually, each environment will need it's own configuration as we <em>deploy</em> our application code to that environment</p>
            </section>
            <${DemoSlide} />
        <//>`;
}

export default Lesson22;