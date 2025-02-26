import htm from "htm";
import { createElement } from "react";
import { CodeSlide, Lesson, QuestionsSlide } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson13() {
    return html`
        <${Lesson} title="Data Structures: Maps & Sets" lessonId="lesson_13" subtitle="Lesson 13" titleFontSize="1.2em">
            <section>
                <p>In the last lesson, we discussed <em>linked lists</em>, <em>stacks</em>, and <em>queues</em></p>
            </section>
            <section>
                <p>Although they are great for accessing things at the <em>front</em> or <em>back</em> of a list, you can't get to just <em>any element</em> quickly like you can with arrays.</p>
            </section>
            <section>
                <p>And even with arrays, you can't get to anything quickly if you <em>don't know where it is</em>.</p>
            </section>
            <section>
                <p>We need a data structure that lets us find a specific thing easily</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Use cases</h3>
                <ul>
                    <li class="fragment">Find a user by their email address</li>
                    <li class="fragment">Find an order by the order ID</li>
                    <li class="fragment">Get a car by its license plate number</li>
                    <li class="fragment">Lookup a product by a specific SKU</li>
                </ul>
            </section>
            <section>
                <p>Introducing, the <em>HashMap</em></p>
            </section>
            <section>
                <p>A <em><i>HashMap</i></em> (aka Map or Dictionary) stores each <em>value</em> in the collection along with a <em>key</em> that uniquely identifies it.</p>
            </section>
            <section>
                <p>All the keys <em>must be unique</em>, so that if you know a key, you can get its value quickly.</p>
            </section>
            <section>
                <p>Each key is <em>hashed</em> to an integer number, and that number is mapped to an index in an array.</p>
            </section>
            <section>
                <img class="r-stretch" src="images/hashmap_illustration_1.png" alt="HashMap illustration 1" />
            </section>
            <section>
                <img class="r-stretch" src="images/hashmap_illustration_2.png" alt="HashMap illustration 1" />
            </section>
            <section>
                <img class="r-stretch" src="images/hashmap_illustration_3.png" alt="HashMap illustration 1" />
            </section>
            <section>
                <img class="r-stretch" src="images/hashmap_illustration_4.png" alt="HashMap illustration 1" />
            </section>
            <section>
                <p>Hash functions are usually pretty good, so we don't worry about hash key <em>collisions</em></p>
            </section>
            <section>
                <p>We use HashMaps so often, that this is why every Java object has a <em>hashCode()</em> function</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide426.png" alt="Slide 426" />
            </section>
            <${CodeSlide} lang="java" lineNumbers="true">
${`
import java.util.HashMap;

/* ...some other code... */

var phoneByEmail = new HashMap<String, String>();

phoneByEmail.put("student1@example.com", "555-123-4567");
phoneByEmail.put("student2@example.com", "555-987-6543");

System.out.println("Student 1's phone number is:  " + 
phoneByEmail.get("student1@example.com")); // 555-123-4567
`}
            <//>
            <section>
                <p>Loops get a little more interesting…</p>
            </section>
            <${CodeSlide} lang="java">
${`
for (String email : phoneByEmail.keySet()) {
   String phoneNumber = phoneByEmail.get(email);
}
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers="true">
${`
import java.util.Map.Entry;

for (Entry<String, String> kvp : phoneByEmail.entrySet()) {
   String email = kvp.getKey();
   String phoneNumber = kvp.getValue();
}
`}
            <//>
            <section>
                <p>What if we only want to keep track of unique keys?</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Use cases</h3>
                <ul>
                    <li class="fragment">Find all the unique characters or words in a string</li>
                    <li class="fragment">Dedupe a list of email addresses</li>
                    <li class="fragment">Compare two lists to figure out what's missing or what's in common</li>
                </ul>
            </section>
            <section>
                <p>HashMap - values = <em>HashSet</em></p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true">
${`
import java.util.HashSet;

/* ...some other code... */

var emailSet = new HashSet<String>();

emailSet.add("student1@example.com");
emailSet.add("student2@example.com");

System.out.println("Is student 1's email in the set?  " + 
emailSet.contains("student1@example.com")); // true
`}
            <//>
            <section>
                <p>Iterate through the HashSet like normal…</p>
            </section>
            <${CodeSlide} lang="java">
for (String email : emailSet) {
   System.out.println("The next email is: " + email);
}
            <//>
            <section>
                <p>We cannot access items in a <i>Map</i> or a <i>Set</i> <em>by index</em>. You must know the key in order to get an item. </p>
            </section>
            <section>
                <p>Let's figure out if a list of items contains duplicates…</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true">
${`
public static boolean hasDuplicates(String[] items) {
   var uniques = new HashSet<String>();
   for (String item : items) { 
       if (uniques.contains(item)) {
           // We've seen the item before, so there are dupes.
           return true;
       }
       uniques.add(item);
   }
   // We made it through the whole list, so there must not be dupes.
   return false;
}
`}
            <//>
            <section>
                <p>Let's get all the unique phone numbers…</p>
            </section>
            <${CodeSlide} lang="java">
${`
public static Set<String> getUniquePhoneNumbers(
String[] phoneNumbers) {

   var result = new HashSet<String>();

   for (String phone : phoneNumbers) {
       result.add(phone); // Sets can't contain dupes, so trying to
                          // add the same phone number has no 
                          // effect.
   }

   return result;
}
`}
            <//>
            <${CodeSlide} lang="java">
${`
public static Set<String> getUniquePhoneNumbers(
String[] phoneNumbers) {

   var result = new HashSet<String>(phoneNumbers);

   return result;
}
`}
            <//>
            <section>
                <p>Now what about TypeScript?</p>
            </section>
            <section>
                <p>TypeScript has both <em>Map</em> and <em>Set</em> that work similar to Java.</p>
            </section>
            <${CodeSlide} lang="typescript" lineNumbers="true">
${`
const map = new Map<string, string>();

map.set("key1", "value1");
map.set("key2", "value2");

console.log(map.get("key1")); // Prints "value1"
console.log(map.has("key1")); // Prints "true"
`}
            <//>
            <${CodeSlide} lang="typescript" lineNumbers="true">
${`
// Loop keys
for (const key of map.keys()) {
    console.log(map.get(key));
}

// Loop values
for (const value of map.values()) {
    console.log(value);
}

// Loop key-value entries
for (const [key, value] of map) {
    console.log(\`Key: \${key}, Value: \${value}\`);
}
`}
            <//>
            <section>
                <p>But things get interesting with objects…</p>
            </section>
            <${CodeSlide} lang="typescript" lineNumbers="true">
${`
const map: Record<string, string> = {}; // An OBJECT LITERAL

map["key1"] = "value1";
map["key2"] = "value2";

console.log(map["key1"]); // Prints "value1"
console.log(map.hasOwnProperty("key1")); // Prints "true"
console.log("key1" in map); // Prints "true", but DANGER!!!
`}
            <//>
            <${CodeSlide} lang="typescript" lineNumbers="true">
${`
// Loop keys
for (const key of Object.keys(map)) {
    console.log(map[key]);
}

// Loop values
for (const value of Object.values(map)) {
    console.log(value);
}

// Loop key-value entries
for (const [key, value] of Object.entries(map)) {
    console.log(\`Key: \${key}, Value: \${value}\`);
}
`}
            <//>
            <section>
                <p>And if you print the object, it looks like this…</p>
            </section>
            <${CodeSlide} lang="typescript">
${`
{
   "key1": "value1",
   "key2": "value2"
}
`}
            <//>
            <section>
                <p>Look familiar? That's because this is what <em><i>JSON</i></em> is based on (<em>JavaScript Object Notation</em>)!</p>
            </section>
            <section>
                <p>And you can do other weird stuff like you can do with arrays, like spread and destructuring…</p>
            </section>
            <${CodeSlide} lang="typescript" lineNumbers="true">
${`
// Spread operation.
const newMap = {
   ...map,
   key3: "value3",
   key4: "value4"
};

// Deconstructing key3 and key4 into variables.
const { key3, key4 } = newMap;
`}
            <//>
            <${QuestionsSlide}/>
        <//>`;
}

export default Lesson13;