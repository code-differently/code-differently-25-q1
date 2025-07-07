import htm from "htm";
import { createElement } from "react";
import * as lessons from "./Lessons/index.js";

const html = htm.bind(createElement);

function Slides() {
  return html`
    <div class="slides">
        <section>
            <img class="r-stretch" src="images/slides/Slide1.png" alt="Slide 1" />
        </section>
        <section>
            <img class="r-stretch" src="images/slides/Slide2.png" alt="Slide 2" />
        </section>
        <${lessons.Lesson00} />
        <${lessons.Lesson01} />
        <${lessons.Lesson02} />
        <${lessons.Lesson03} />
        <${lessons.Lesson04} />
        <${lessons.Lesson05} />
        <${lessons.Lesson06} />
        <${lessons.Lesson07} />
        <${lessons.Lesson08} />
        <${lessons.Lesson09} />
        <${lessons.Lesson10} />
        <${lessons.Lesson11} />
        <${lessons.Lesson12} />
        <${lessons.Lesson13} />
        <${lessons.Lesson14} />
        <${lessons.Lesson15} />
        <${lessons.Lesson16} />
        <${lessons.Lesson17} />
        <${lessons.Lesson21} />
        <${lessons.Lesson22} />
        <${lessons.Lesson23} />
        <${lessons.Lesson24} />
        <${lessons.Lesson25} />
        <${lessons.Lesson26} />
        <${lessons.Lesson27} />
        <${lessons.Lesson28} />
        <${lessons.Supplemental1} />
        <${lessons.Supplemental2} />
    </div>`;
}

export default Slides;
