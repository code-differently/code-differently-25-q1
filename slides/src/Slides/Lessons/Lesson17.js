import htm from "htm";
import { createElement } from "react";
import { CodeSlide, Lesson } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson17() {
    return html`
        <${Lesson} title="OOP Principles, Part II" lessonId="lesson_17" subtitle="Lesson 17">
            <section>
                <p>Let's <em>review</em></p>
            </section>
            <section class="ml-bullet-slide">
                <h3>The OOP Principles</h3>
                <ul style=${{"list-style": "none"}}>
                    <li>Abstraction</li>
                    <li>Encapsulation</li>
                    <li class="opaque">Inheritance</li>
                    <li class="opaque">Polymorphism</li>
                </ul>
            </section>
            <section>
                <p><em>OOP</em> is a coding pattern that involves designing objects that model real world concepts</p>
            </section>
            <section>
                <p>In OOP land, everything is an <em>object</em></p>
            </section>
            <section>
                <p>An object is a combination of <em><i>data</i></em> and <em><i>behavior</i></em></p>
            </section>
            <section>
                <p>This process of modeling concepts as objects with data and behavior is called <em>abstraction</em></p>
            </section>
            <section>
                <p><em>Encapsulation</em> is why we encode <i>data</i> and <i>behavior</i> in <em>classes</em></p>
            </section>
            <section>
                <p>It's also why we control whether things are <em>public</em> or <em>private</em></p>
            </section>
            <section>
                <p>We control what others are able <em>to know</em> and <em>to do</em> with our classes, hiding what we need to and exposing the rest.</p>
            </section>
            <section>
                <p>What makes a good <em>class</em>?</p>
            </section>
            <section>
                <p><em>SOLID</em> principles</p>
            </section>
            <section class="ml-bullet-slide">
                <ul style=${{"list-style": "none"}}>
                    <li><em>S</em>ingle Responsibility Principle</li>
                    <li class="opaque"><em>O</em>pen/Closed Principle</li>
                    <li class="opaque"><em>L</em>iskov Substitution Principle</li>
                    <li class="opaque"><em>I</em>nterface Segregation Principle</li>
                    <li><em>D</em>ependency Inversion Principle</li>
                </ul>
            </section>
            <section>
                <p>According to the principle of <em>single responsibility</em>, a  class should only have one reason to change</p>
            </section>
            <section>
                <p>The <em>dependency inversion</em> principle suggests that we should make our class accept an <em>Engine</em> as a <i>dependency</i></p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Where we're going next</h3>
                <ul style=${{"list-style": "none"}}>
                    <li class="opaque">Abstraction</li>
                    <li class="opaque">Encapsulation</li>
                    <li>Inheritance</li>
                    <li>Polymorphism</li>
                </ul>
            </section>
            <section class="ml-bullet-slide">
                <ul style=${{"list-style": "none"}}>
                    <li class="opaque"><em>S</em>ingle Responsibility Principle</li>
                    <li><em>O</em>pen/Closed Principle</li>
                    <li><em>L</em>iskov Substitution Principle</li>
                    <li><em>I</em>nterface Segregation Principle</li>
                    <li class="opaque"><em>D</em>ependency Inversion Principle</li>
                </ul>
            </section>
            <section>
                <p>Here's where we're going…</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide598.png" alt="Slide 598" />
            </section>
            <section>
                <p>Let's go back to our simplified car example…</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true" fontSize=".45em">
${`
public class Car {
   private Engine engine;

   public Car(Engine engine) {
       this.engine = engine;
   }

   public void setEngine(Engine engine) {
       this.engine = engine;
   }

   public void turnOn() {
       this.engine.startIgnition();
   }
}
`}
            <//>
            <section>
                <p>We now want to support the concept of a <em>Truck</em></p>
            </section>
            <section>
                <p>We could just update our car to support truck functionality</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="11-19" fontSize=".32em">
${`
public class Car {
   private Engine engine;
   private boolean isTruck;
   private boolean isTailgateOpen;

   public Car(Engine engine, boolean isTruck) {
       this.engine = engine;
       this.isTruck = isTruck;
   }

   public void openTailGate() {
       if (!this.isTruck) {
           // This is weird. If not all cars are trucks, then this code 
           // might blow up if the user doesn't check the car type first.
           throw new IllegalStateException(
                "Cannot open tailgate on a non-truck car");
       }
       this.isTailgateOpen = true;
   }
}
`}
            <//>
            <${CodeSlide} lang="java">
${`
// This is a little better, but now we have another 
// problem: we've violated DRY.
public class Truck {
   private Engine engine;
   private boolean isTailgateOpen;

   public Truck(Engine engine) {
       this.engine = engine;
   }

     public void openTailGate() {
       this.isTailgateOpen = true;
   }
}
`}
            <//>
            <section>
                <p>Let's fix this using <em>inheritance</em></p>
            </section>
            <section>
                <p>With <em>inheritance</em>, we can make classes <em>extend</em> other classes so that they inherit <i>data</i> and <i>behavior</i>.</p>
            </section>
            <section>
                <p>First, some changes to the car…</p>
            </section>
            <${CodeSlide} lang="java">
${`
public class Car {
   // We'll make the engine protected instead of private so 
   // subclasses (classes that extend the car) can use it.
   protected Engine engine;

   public Car(Engine engine) {
       this.engine = engine;
   }
}
`}
            <//>
            <section>
                <p>Now let's update the truck</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true" fontSize=".40em">
${`
public class Truck extends Car {    // Notice the "extends Car" part
   private boolean isTailgateOpen;

   public Truck(Engine engine) {
      super(engine);                // We must call the Car 
                                    // constructor here
   }

   public void turnOn() {
       this.engine.startIgnition();  // This engine is inherited 
                                     // from Car, the superclass
   }

     public void openTailGate() {
       this.isTailgateOpen = true;
   }
}
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers="1|4-7|9-12" fontSize=".40em">
${`
public class Truck extends Car {    // Notice the "extends Car" part
   private boolean isTailgateOpen;

   public Truck(Engine engine) {
      super(engine);                // We must call the Car 
                                    // constructor here
   }

   public void turnOn() {
       this.engine.startIgnition();  // This engine is inherited 
                                     // from Car, the superclass
   }

     public void openTailGate() {
       this.isTailgateOpen = true;
   }
}
`}
            <//>
            <section>
                <p>The <code>Truck</code> now inherits all of the <em>public</em> and <em>protected</em> methods and variables of the superclass (<code>Car</code>)</p>
            </section>
            <section>
                <p>New functionality added to the <code>Car</code> will now automatically get picked up by the <code>Truck</code></p>
            </section>
            <section>
                <p>A few principles are at work here</p>
            </section>
            <section>
                <p>Firstly, a <code>Truck</code> is a truck, but can be treated like any other <code>Car</code> (since it is a car). This is what we call <em>polymorphism</em></p>
            </section>
            <section>
                <p><em>poly</em> = multiple, <em>morph</em> = form</p>
            </section>
            <section>
                <p>A object can take multiple forms</p>
            </section>
            <${CodeSlide} lang="java">
${`
Truck truck = new Truck("Ford", "F-150", new EcoBoostEngine());
Car car = new Truck("Nissan", "Titan Pro", new HybridEngine());
car = truck;
`}
            <//>
            <section>
                <p>Secondly, remember that we don't like to change code</p>
            </section>
            <section>
                <p>This is partly what the <em>O</em> in <em>SOLID</em> is all about. We want objects to be <em><i>open for extension</i></em>, and <em><i>closed for modification</i></em>.</p>
            </section>
            <section>
                <p>Instead of <em>modifying</em> <code>Car</code> to support Truck functionality, we made a new class for <code>Truck</code> that <em>extends</em> the <code>Car</code></p>
            </section>
            <section>
                <p>Lastly, notice that we moved the <em>openTailGate</em> from the <code>Car</code> class to the <code>Truck</code>.</p>
            </section>
            <section>
                <p>This was a good move according to the <emm>L</emm> in <em>SOLID</em> (the <i>Liskov Substitution Principle</i>)</p>
            </section>
            <section>
                <p>If all cars can't have a tailgate, then not all <em>subclasses</em> of <code>Car</code> would be substitutable for a <code>Car</code></p>
            </section>
            <section>
                <p>We wouldn't be able to make a <em><code>RaceCar</code></em> that extends a <code>Car</code> since they (usually) don't have tailgates.</p>
            </section>
            <section>
                <p>There are other tools we also have at our disposal as well</p>
            </section>
            <section>
                <p>Let's suppose that we want to support the concept of a <em>vehicle</em></p>
            </section>
            <section>
                <p>Vehicles can be anything from <i>riding lawn mowers</i> to <i>toy Jeeps</i> to <i>airplanes</i></p>
            </section>
            <section>
                <p>We can use an interface to describe the behavior of a vehicle</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true">
${`
package com.codedifferently.model;

// Note the new \`interface\` keyword
public interface Vehicle {
   // These methods don't have a body. They're just here 
   // to describe what a vehicle can do. You need a class 
   // to implement these methods
   void turnOn();
   void turnOff();
   boolean getIsOn();
   boolean getSpeed();
   boolean accelerateToMph(int speedInMph);
}
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers="3-4">
${`
package com.codedifferently.model;

// Note the new \`interface\` keyword
public interface Vehicle {
   // These methods don't have a body. They're just here 
   // to describe what a vehicle can do. You need a class 
   // to implement these methods
   void turnOn();
   void turnOff();
   boolean getIsOn();
   boolean getSpeed();
   boolean accelerateToMph(int speedInMph);
}
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers="5-12">
${`
package com.codedifferently.model;

// Note the new \`interface\` keyword
public interface Vehicle {
   // These methods don't have a body. They're just here 
   // to describe what a vehicle can do. You need a class 
   // to implement these methods
   void turnOn();
   void turnOff();
   boolean getIsOn();
   boolean getSpeed();
   boolean accelerateToMph(int speedInMph);
}
`}
            <//>
            <section>
                <p>We can now make the <code>Car</code> a <code>Vehicle</code> by <em>implementing</em> the interface</p>
            </section>
            <${CodeSlide} lineNumbers="true" lang="java">
${`
// The Car now implements the Vehicle interface by 
// adding the option after the class name and providing 
// implementation for interface methods.
public class Car implements Vehicle {
   protected Engine engine;

   public Car(Engine engine) {
       this.engine = engine;
   }

   @Override
   public void turnOn() {
       this.engine.startIgnition();
   }
}
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers="1-4,11-14">
${`
// You can implement multiple interfaces, no problem! 
// It's a way to say that an object represents multiple 
// things like in real life.
public class Car implements Vehicle {
   protected Engine engine;

   public Car(Engine engine) {
       this.engine = engine;
   }

   @Override
   public void turnOn() {
       this.engine.startIgnition();
   }
}
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers="1-3">
${`
// And since the Truck extends the Car, the Truck also 
// implements the Vehicle interface!!!
public class Truck extends Car {
   private boolean isTailgateOpen;

   public Truck(Engine engine) {
      super(engine);
   }

     public void openTailGate() {
       this.isTailgateOpen = true;
   }
}
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers="1-4">
${`
// But unlike with interfaces, you can only extend one 
// thing at a time. You can still implement other interfaces 
// though.
public class Truck extends Car {
   private boolean isTailgateOpen;

   public Truck(Engine engine) {
      super(engine);
   }

     public void openTailGate() {
       this.isTailgateOpen = true;
   }
}
`}
            <//>
            <section>
                <p>Let's keep the party going and add the concept of a Sedan…</p>
            </section>
            <${CodeSlide} lang="java">
${`
public class Sedan extends Car {
   private boolean isTrunkOpen;

   public Sedan(Engine engine) {
      super(engine);
   }

     public void popTheTrunk() {
       this.isTrunkOpen = true;
   }
}
`}
            <//>
            <section>
                <p>It's at this point that we realize that folks shouldn't be creating cars.</p>
            </section>
            <section>
                <p>They should create a <code>Sedan</code> or a <code>Truck</code>. We can adjust this easily by making the <code>Car</code> an <em><i>abstract class</i></em></p>
            </section>
            <section>
                <p>
                    <em>abstract</em> = conceptual<br />
                    <em>concrete</em> = real and usable
                </p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="1-4">
${`
// Now the Car serves as a template for other subclasses. 
// It can't be constructed itself. Think of it as a
// combination of an \`interface\` and a \`class\`.
public abstract class Car implements Vehicle {
   protected Engine engine;

   public Car(Engine engine) {
       this.engine = engine;
   }

   @Override
   public void turnOn() {
       this.engine.startIgnition();
   }
}
`}
            <//>
            <section>
                <p>Now we can do something like this…</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true">
${`
public class App {

   public static void main(String[] args) {
       var myVehicles = new ArrayList<Vehicle>();
       myVehicles.add(
          new Truck("Ford", "F-150", new EcoBoostEngine()));
       myVehicles.add(
          new Sedan("BMW", "X3", new HybridEngine()));
   }
}
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers="4-8">
${`
public class App {

   public static void main(String[] args) {
       var myVehicles = new ArrayList<Vehicle>();
       myVehicles.add(
          new Truck("Ford", "F-150", new EcoBoostEngine()));
       myVehicles.add(
          new Sedan("BMW", "X3", new HybridEngine()));
   }
}
`}
            <//>
            <section>
                <p><i>Pheww!</i></p>
            </section>
            <section class="ml-bullet-slide">
                <h3>Here's what we did…</h3>
                <ul style=${{"font-size": ".8em"}}>
                    <li class="fragment">Defined an <em>interface</em> that describes the behavior of objects.</li>
                    <li class="fragment">Made an <em>abstract class</em> that provides a base <code>Car</code> implementation of the interface.</li>
                    <li class="fragment">Defined <code>Truck</code> and <code>Sedan</code> classes that <em>extend</em> the <code>Car</code> class with concrete functionality.</li>
                </ul>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide648.png" alt="Slide 648" />
            </section>
            <section>
                <p>Here are the principles we've covered…</p>
            </section>
            <section class="ml-bullet-slide">
                <h3 style=${{"font-size": ".9em"}}>Abstract Classes</h3>
                <ol>
                    <li><em>Abstract classes</em> help us to provide base implementations for methods and variables that subclasses can use, promoting <em>DRY</em> code</li>
                </ol>
            </section>
            <section class="ml-bullet-slide">
                <h3>Single Responsibility (<em>S</em>OLID)</h3>
                <ol start="2" style=${{"font-size": ".9em"}}>
                    <li>Classes shouldn't do too much. They should only have <i>one reason to change</i>.</li>
                </ol>
            </section>
            <section class="ml-bullet-slide">
                <h3>Open/Closed (S<em>O</em>LID)</h3>
                <ol start="3" style=${{"font-size": ".9em"}}>
                    <li>Because we don't like changing code, we want our classes to be <em>open for extension</em> and <em>closed for modification</em>. It's better to add code to support new functionality than changing it.</li>
                </ol>
            </section>
            <section class="ml-bullet-slide">
                <h3>Liskov Substitution (SO<em>L</em>ID)</h3>
                <ol start="4" style=${{"font-size": ".9em"}}>
                    <li>When designing a class or interface, make sure it only has things that all subclasses will support so that all they are <em>substitutable</em> (don't add a fly() method to a Bird class if not all birds fly).</li>
                </ol>
            </section>
            <section class="ml-bullet-slide">
                <h3>Interface segregation (SOL<em>I</em>D)</h3>
                <ol start="5" style=${{"font-size": ".9em"}}>
                    <li>The interface segregation principle is like the Liskov substitution principle, but for interfaces. Basically, <em>don't put stuff</em> into interfaces that not all implementers will use or need.</li>
                </ol>
            </section>
            <section class="ml-bullet-slide">
                <h3>Dependency inversion (SOLI<em>D</em>)</h3>
                <ol start="6" style=${{"font-size": ".85em"}}>
                    <li>When creating classes, prefer to make them receive their dependencies to make it easier to swap them out. <br />
                    Ex: Make Car builders give it the engine instead of making them get cars with an Engine already in it).</li>
                </ol>
            </section>
        <//>`;
}

export default Lesson17;