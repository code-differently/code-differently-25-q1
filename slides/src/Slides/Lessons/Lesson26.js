import htm from "htm";
import { createElement } from "react";
import { CodeSlide, DemoSlide, Lesson, QuestionsSlide } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson26() {
    return html`
        <${Lesson} title="Web APIs using REST" lessonId="lesson_26" subtitle="Lesson 26">
            <section>
                <p>Now that we’ve spent some time on the <em>frontend</em>, it’s time to switch our focus to the <em>backend</em></p>
            </section>
            <section>
                <p>But first, we need to discuss <em>APIs</em></p>
            </section>
            <section>
                <p>In modern web applications, we break up into programs that handle what the user sees (frontend)...</p>
            </section>
            <section>
                <p>…and programs that handle interacting with data and business logic (backend)</p>
            </section>
            <section>
                <p>An <em>API</em> (Application Programming Interface) is what allows these programs to talk to each other</p>
            </section>
            <section>
                <p>Most APIs rely on the <i>protocol</i> of the web, <em>HTTP</em></p>
            </section>
            <section>
                <p>A <em>client</em> will make a request to an <em>API server</em> and wait for a response containing JSON, XML, CSV, or some other data interchange format</p>
            </section>
            <section>
                <p>This style of API is known as a <em>REST</em><span style=${{color: "red", "font-weight": "bold"}}>*</span> (Representational State Transfer)</p>
            </section>
            <section>
                <img class="r-stretch" src="images/not-funny-red-bird.gif" alt="Slide 842" />
            </section>
            <section>
                <p><span style=${{color: "red", "font-weight": "bold"}}>Note:</span> Not really, hahahah. It’s really REST-like RPC, but that’s beyond the scope of this course</p>
            </section>
            <section>
                <p>In order to build a REST API, you need the following elements…</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>REST API elements</h3>
                <ul>
                    <li class="fragment">A URL scheme that identifies resources the API provides</li>
                    <li class="fragment">A set of HTTP methods you can conduct on each resource</li>
                    <li class="fragment">A consistent way to represent the resource (e.g. JSON, XML, CSV, etc)</li>
                </ul>
            </section>
            <section>
                <p>Suppose that we want to build an API for library books</p>
            </section>
            <section>
                <p>
                    On the web, we might host an API server that exposes books at the following url:<br />
                    http://codedifferently.com<em>/api/books</em>
                </p>
            </section>
            <section>
                <p>We might then support the following operations…</p>
            </section>
            <section>
                <table style=${{fontSize: ".7em"}}>
                    <tr>
                        <th>Path</th>
                        <th>HTTP Method</th>
                        <th>What it does</th>
                    </tr>
                    <tr>
                        <td>/api/books</td>
                        <td>GET</td>
                        <td>Get all books</td>
                    </tr>
                    <tr>
                        <td>/api/books</td>
                        <td>POST</td>
                        <td>Create a new book</td>
                    </tr>
                </table>
            </section>
            <section>
                <p>But what if we want to access a specific book?</p>
            </section>
            <section>
                <p>
                    We can add another path segment to the URL for the ID, like so:<br />
                    <i>/api/books/<em>{book id}</em></i>
                </p>
            </section>
            <section>
                <p>We can now support book specific operations…</p>
            </section>
            <section>
                <table style=${{fontSize: ".6em"}}>
                    <tr>
                        <th>Path</th>
                        <th>HTTP Method</th>
                        <th style=${{"width": "300px"}}>What it does</th>
                    </tr>
                    <tr>
                        <td>/api/books/{book id}</td>
                        <td>GET</td>
                        <td>Retrieve a specific book</td>
                    </tr>
                    <tr>
                        <td>/api/books/{book id}</td>
                        <td>POST</td>
                        <td>Update an existing book with the given ID</td>
                    </tr>
                    <tr>
                        <td>/api/books/{book id}</td>
                        <td>DELETE</td>
                        <td>Remove the specific book</td>
                    </tr>
                </table>
            </section>
            <section>
                <p>Now that we know where our books are and acceptable operations, we need to figure out how to <em>represent</em> a book or a list of books</p>
            </section>
            <section>
                <p>Fortunately, we have <em>JSON</em></p>
            </section>
            <${CodeSlide} lang="json">
${`
{
   "type": "book",
   "id": "e27a4e0d-9664-420d-955e-c0e295d0ce02",
   "title": "To Kill a Mockingbird",
   "isbn": "978-0061120084",
   "authors": [
       "Harper Lee"
   ],
   "pages": 336
}
`}
            <//>
            <section>
                <p>And here are a list of books…</p>
            </section>
            <${CodeSlide} lang="json" fontSize="0.45em">
${`
[
       {
           "type": "book",
           "id": "e27a4e0d-9664-420d-955e-c0e295d0ce02",
           "title": "To Kill a Mockingbird"
       },
       {
           "type": "book",
           "id": "17dd5d20-98f5-4a26-be09-449fea88a3c3",
           "title": "1984",
       }
]
`}
            <//>
            <section>
                <p>We can use languages that we’ve learned so far (Java or TypeScript) in order to implement our API</p>
            </section>
            <section>
                <p>For this lesson, we’ll use <em>TypeScript</em></p>
            </section>
            <${DemoSlide} />
            <${QuestionsSlide} />
        <//>`;
}

export default Lesson26;