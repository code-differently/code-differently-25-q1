import htm from "htm";
import { createElement } from "react";
import { CodeSlide, Lesson } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson23() {
    return html`
        <${Lesson} title="Intro to HTML, CSS, and JS" lessonId="lesson_23" subtitle="Lesson 23" titleFontSize="1.3em">
            <section>
                <p>Quick review…</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Anatomy of an Application</h3>
                <ul>
                    <li class="fragment custom em no-em">User interface</li>
                    <li class="fragment custom em no-em">Services</li>
                    <li class="fragment custom em no-em">Storage</li>
                    <li class="fragment custom em">Configuration</li>
                </ul>
            </section>
            <section>
                <p>Many applications we use on the internet involve <em>downloading code</em> (HTML, CSS, and JavaScript) from a <em>web server</em></p>
            </section>
            <section>
                <p>That code then runs <em>in a browser</em> on our machine. We call these <em>web applications</em></p>
            </section>
            <section>
                <p>Let's explore web application user interfaces built using <em>HTML</em>, <em>CSS</em>, and <em>JavaScript</em></p>
            </section>
            <section>
                <p>To make modern UIs, we need <em>structure</em>, <em>style</em>, and <em>behavior</em></p>
            </section>
            <section>
                <p>
                    Structure <em>=</em> the elements that appear<br/>
                    Style <em>=</em> how they look<br/>
                    Behavior <em>=</em> how they act
                </p>
            </section>
            <section class="ml-columns-slide">
                <style>
                    .image-column-1 {
                        background-image: url("images/house-frame.jpeg");
                    }

                    .image-column-2 {
                        background-image: url("images/painting.jpeg");
                    }

                    .image-column-3 {
                        background-image: url("images/switches.jpeg");
                    }
                </style>
                <div class="columns r-stretch">
                    <div class="background-image image-column-1 fragment" data-fragment-index=1>
                        <span class="fragment custom background-fade" data-fragment-index=4>HTML</span>
                    </div>
                    <div class="background-image image-column-2 fragment" data-fragment-index=2>
                        <span class="fragment custom background-fade" data-fragment-index=5>CSS</span>
                    </div>
                    <div class="background-image image-column-3 fragment" data-fragment-index=3>
                        <span class="fragment custom background-fade" data-fragment-index=6>JS</span>
                    </div>
                </div>
            </section>
            <section>
                <p>HTML (<em>HyperText Markup Language</em>) defines the <em>content</em> and visual <em>structure</em> visual elements on a web page.</p>
            </section>
            <section>
                <p>We also use HTML to <em>import things</em> we need in order to present data and interact with the user</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide754.png" alt="Slide 754" />
            </section>
            <section class="ml-bullet-slide">
                <h3>Things we use HTML for</h3>
                <ul style=${{ "font-size": ".9em" }}>
                    <li class="fragment">Displaying text and multimedia (images, video, audio)</li>
                    <li class="fragment">Rendering input controls (text box, buttons, forms)</li>
                    <li class="fragment">Describing meta information (page title, author, update date, search engine stuff…)</li>
                </ul>
            </section>
            <${CodeSlide} lang="html" fontSize=".7em">
${`
<tag attributeName="value">
    <!-- This is a comment -->
    Text or other tags go here.
</tag>
`}
            <//>
            <${CodeSlide} lang="html" lineNumbers="true" fontSize=".38em">
${`
<!doctype html>
<html lang="en">    <!-- Can only have one HTML tag -->
 <head>             <!-- Can only have one HEAD tag -->
   <title>My Website</title>
   <link rel="stylesheet" href="styles.css" />
   <script src="scripts.js" defer></script>
 </head>
 <body>             <!-- Can only have one BODY tag -->
   <style>
     .main {
       font-size: 2em;
     }
   </style>
   <div class="main">
     Welcome to my web page!
   </div>
 </body>
</html>
`}
            <//>
            <${CodeSlide} lang="html" lineNumbers="true" fontSize=".38em">
${`
<!doctype html>
<html lang="en">
 <head>
   <title>My Website</title>
   <link rel="stylesheet" href="styles.css" />  <!-- Can import CSS -->
   <script src="scripts.js" defer></script>     <!-- Can import JS -->
 </head>
 <body>
   <style>       <!-- Can just throw CSS styles directly -->
     .main {
       font-size: 2em;
     }
   </style>
   <div class="main">
     Welcome to my web page!
   </div>
 </body>
</html>
`}
            <//>
            <section class="ml-bullet-slide">
                <h3>Things we use CSS for</h3>
                <ul>
                    <li class="fragment">Adding the style to HTML elements</li>
                    <li class="fragment">Performing animation</li>
                </ul>
            </section>
            <${CodeSlide} lang="css" fontSize=".5em">
${`
.some-selector {  /* <-- This is a selector  */
    setting-name: setting-value;
    another-setting-name: 10px;
}
`}
            <//>
            <${CodeSlide} lang="html" fontSize=".38em">
${`
<div class="home">    <!-- .home (class selector) -->
 <h1 class="title">Search for a movie</h1>
 <form class="search-form">

   <label class="search-label"
          for="search">
     Title
   </label>

   <!-- input (element selector) -->
   <input class="search-input"
          type="text"
          id="search"
          placeholder="Star Wars" />     <!-- #search (id selector) -->

   <input class="search-button"
          type="button">Search</button>  <!-- type["button"] -->
 </form>
</div>
`}
            <//>
            <section class="ml-bullet-slide">
                <h3>Clutch Tip:</h3>
                <p style=${{"font-size": ".8em"}}>
                    Use Chrome Dev Tools console and type <br />
                    <pre style=${{"font-size": ".76em"}}><code class="lang-javascript">${`document.querySelectorAll('<your selector>')`}</code></pre>
                    to test different selectors</p>
            </section>
            <section>
                <p>Once we have <em>structure</em> (HTML) and <em>style</em> (CSS), we want <em>behavior</em> (JavaScript)</p>
            </section>
            <section>
                <p>In the browser, we rely on <em>event-driven programming</em> to respond to user interactions</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Common events</h3>
                <ul>
                    <li class="fragment">Page loaded</li>
                    <li class="fragment">Button clicked or hovered</li>
                    <li class="fragment">Text typed</li>
                    <li class="fragment">Form submitted</li>
                    <li class="fragment">Browser location changed</li>
                </ul>
            </section>
            <section class="ml-bullet-slide">
                <h3>How we implement JS</h3>
                <ul>
                    <li class="fragment">Write some JavaScript functions that handle some events.</li>
                    <li class="fragment">Wire up functions to HTML element events</li>
                </ul>
            </section>
            <${CodeSlide} lang="html" fontSize=".4em">
${`
<script src="myApp.js"></script>

<script>
 function sayHello() {
   alert("Hello World");
 }
</script>

<!-- We can use the \`onclick\` attribute -->
<input class="hello-button"
      type="button"
      onclick="sayHello()">
      Search
</input>
`}
            <//>
            <${CodeSlide} lang="html" fontSize=".4em">
${`
<script src="myApp.js"></script>

<script>
 function sayHello() {
   alert("Hello World");
 }
 // Or, we can use \`addEventListener\`
 document.querySelector('.hello-button')
     .addEventListener('click', sayHello);
</script>

<input class="hello-button"
      type="button">
      Search
</input>
`}
            <//>
            <${CodeSlide} title="Java vs JavaScript" lang="java">
${`
package com.codedifferently.lesson16;

// Java
public class Lesson16 {
 public static void main(String[] args) {
   String message = "Hello, world!";
   System.out.println("Hello world!");
 }
}
`}
            <//>
            <${CodeSlide} title="Java vs JavaScript" lang="javascript">
${`
// JavaScript
function sayHello() {
  const message = "Hello, World!";
  console.log(message);
}

sayHello();
`}
            <//>
            <section>
                <p>We don't always <i>like</i> working directly with HTML, CSS, and JavaScript</p>
            </section>
            <section>
                <p>Instead, we use <em>frameworks</em> and <em>libraries</em> that help us to more easily build web user interfaces</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide774.png" alt="Slide 774" />
            </section>
            <section>
                <p>In the next lesson, we'll learn about how we tie everything together using JavaScript</p>
            </section>
        <//>`;
}

export default Lesson23;