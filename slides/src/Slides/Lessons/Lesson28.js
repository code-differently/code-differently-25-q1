import htm from "htm";
import { createElement } from "react";
import { CodeSlide, DemoSlide, Lesson, QuestionsSlide } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson28() {
    return html`
        <${Lesson} title="Intro to Databases" lessonId="lesson_28" subtitle="Lesson 28">
            <section>
                <p>Let's review</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Anatomy of an Application</h3>
                <ul style=${{"list-style": "none", "margin": 0}}>
                    <li>User interface</li>
                    <li>Services</li>
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
            <section>
                <p>When building applications, we can store data in several places</p>
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
                <h3>Types of <em>storage</em></h3>
                <ul>
                    <li>RAM (in-memory, cache)</li>
                    <li><em>Databases (sql, nosql, vector, search)</em></li>
                    <li>Files (csv, tsv, json, yaml, xml)</li>
                    <li>Cookies</li>
                </ul>
            </section>
            <section>
                <p>We like databases because they are tailor-made for storing, retrieving, and manipulating data</p>
            </section>
            <section>
                <p>Databases are organized like <i>spreadsheets</i>, having tables that store <em>columns</em> and <em>rows</em> of data.</p>
            </section>
            <section>
                <p>We can choose what data to retrieve from tables in our databases using a <em>query</em> language</p>
            </section>
            <section>
                <p>The most popular query language is <em>SQL</em> (Structured Query Language). We pronounce it "sequel"</p>
            </section>
            <section>
                <p>With <em>SQL</em>, you select the columns you want from one or more tables. Your results are returned as rows</p>
            </section>
            <${CodeSlide} lang="sql" fontSize=".6em">
${`
SELECT
 name,
 height,
 is_jedi
FROM
 star_wars_characters
WHERE
 name = 'Luke Skywalker' AND
 home_planet = 'Tatooine';
`}
            <//>
            <section>
                <p>Not only can you select data, but you can also update it…</p>
            </section>
            <${CodeSlide} lang="sql" fontSize=".6em">
${`
UPDATE
 star_wars_characters
SET
 is_jedi = TRUE
WHERE
 name = 'Luke Skywalker';
`}
            <//>
            <section>
                <p>Or delete it…</p>
            </section>
            <${CodeSlide} lang="sql" fontSize=".6em">
${`
DELETE FROM
 star_wars_characters
WHERE
 name = 'Jar Jar Binks';
`}
            <//>
            <section>
                <p>You can also create new tables easily…</p>
            </section>
            <${CodeSlide} lang="sql" fontSize=".6em">
${`
CREATE TABLE star_wars_characters (
   id SERIAL PRIMARY KEY,
   name VARCHAR(255) NOT NULL,
   height VARCHAR(255) NOT NULL,
   is_jedi BOOLEAN NOT NULL
);
`}
            <//>
            <section>
                <p>Note that table columns have <em>types</em> to define the size and format of the data being stored.</p>
            </section>
            <section>
                <p>They work a little different than Java types, but not too much</p>
            </section>
            <section>
                <p>Tables will often have a special column called a <em>primary key</em> column that uniquely identify each row</p>
            </section>
            <section>
                <p>This is super useful for querying data quickly if you know the value of the key you're looking for</p>
            </section>
            <section>
                <p>When a table uses a column that references a primary key from another table, that column is called a <em>foreign key</em></p>
            </section>
            <section>
                <p>It's useful to define relationships between tables. Databases that support this are called <em>relational databases</em></p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide909.png" alt="Slide 909" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide910.png" alt="Slide 910" />
            </section>
            <${DemoSlide} />
            <${QuestionsSlide} />
        <//>`;
}

export default Lesson28;