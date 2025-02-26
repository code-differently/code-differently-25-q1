import htm from "htm";
import { createElement } from "react";
import { CodeSlide, Lesson, QuestionsSlide } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson08() {
    return html`
        <${Lesson} title="Functions" lessonId="lesson_08" subtitle="Lesson 8">
            <section>
                <p>Let's review</p>
            </section>
            <section>
                <p>The <em><i>function signature</i></em> identifies the inputs and outputs of a method</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide155.png" alt="Slide 155" />
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide156.png" alt="Slide 156" />
            </section>
            <section>
                <p>Functions always occur in a <em><i>class</i></em> <span class="fragment">(we'll talk about <em>classes</em> in a later class, and do it with class)</span></p>
            </section>
            <section>
                <p>Every Java application needs at least one <em>specific method</em> in at least one class</p>
            </section>
            <${CodeSlide} title=${html`The <em>main</em> method`} lang="java" fontSize=".6em">
public class MyProgram {
  public static void main(String[] args) {
     // let's get it started 
  }
}
            <//>
            <section>
                <p>But why <em>should</em> you use functions?</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Why functions exist</h3>
                <ul>
                    <li class="fragment">Run statements only when called</li>
                    <li class="fragment">Group statements that work together to accomplish a goal</li>
                    <li class="fragment">Perform calculations</li>
                    <li class="fragment">Reuse logic while just changing the data</li>
                </ul>
            </section>
            <section>
                <p><span style=${{"color": "red"}}>IMPORTANT!</span><br />Be <em>DRY</em>. Don't repeat yourself</p>
            </section>
            <section>
                <p>Like in mathematics, functions can take parameters</p>
            </section>
            <section>
                <p>f(x,y) = x + y</p>
            </section>
            <${CodeSlide} lang="java" fontSize=".6em">
public static double add(double x, double y) {
  return x + y;
}
            <//>
            <section>
                <p>Functions can return either a <em>single result</em> or <em><i>void</i></em> (nothing)</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide222.png" alt="Slide 222" />
            </section>
            <section>
                <p>Functions can call other functions</p>
            </section>
            <${CodeSlide} lang="java">
public boolean doVacation(Family family) throws Exception {
    family.setVacationLocation("Disney World");
    boolean wasMagicMade = maybeMakeMagic(family);
    return wasMagicMade && isHappy(family);
}
            <//>
            <section>
                <p>And functions can <i>call themselves</i>.<br />This is called <em><i>recursion</i></em></p>
            </section>
            <${CodeSlide} lang="java" fontSize=".6em">
public static void beHappy() {
    dontWorry();
    System.out.println("Be happy");
    beHappy(); // this is the RECURSIVE call 
}

public static void dontWorry() {
    System.out.println("Don't worry");
}
            <//>
            <${CodeSlide} lang="java" fontSize=".6em">
public static void beHappy(int times) {
    if (times ${'<'} 1) {
        return; // stop when times get sad :(
    }
    dontWorry();
    beHappy(times--);
}

public static void dontWorry() {
    System.out.println("Doing something");
}
            <//>
            <section>
                <pre style=${{"font-family": "'Courier New', Courier, monospace", "font-weight": "700", "box-shadow": "none"}}>
                    <span>beHappy(<em>10</em>)<br /></span>
                    ${Array.from({length: 10}).map((_, i) => 
                        html`<span class="fragment">${'->'.padStart(2 * (i+1), ' ')} beHappy(<em>${9 - i}</em>)<br /></span>`)}
                </pre>
            </section>
            <section>
                <pre style=${{"font-family": "'Courier New', Courier, monospace", "font-weight": "700", "box-shadow": "none"}}>
                    <span>beHappy(<em>10</em>) <span style=${{"color": "green"}} class="fragment" data-fragment-index=10>// return</span><br /></span>
                    ${Array.from({length: 10}).map((_, i) => 
                        html`<span class="fragment fade-out" data-fragment-index=${10 - i}>${'->'.padStart(2 * (i+1), ' ')} beHappy(<em>${9 - i}</em>) <span style=${{"color": "green"}} class="fragment" data-fragment-index=${9 - i}>// return</span><br /></span>`)}
                </pre>
            </section>
            <${QuestionsSlide}/>
        <//>`;
}

export default Lesson08;