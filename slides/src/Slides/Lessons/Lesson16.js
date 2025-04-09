import htm from "htm";
import { createElement } from "react";
import { CodeSlide, Lesson } from "../Layouts/index.js";

const html = htm.bind(createElement);

function Lesson16() {
    return html`
        <${Lesson} title="OOP Principles, Part I" lessonId="lesson_16" subtitle="Lesson 16">
            <section>
                <p>Remember how we said we'd come back to <em>classes</em>?</p>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide528.png" alt="Slide 528" />
            </section>
            <section>
                <p>Today is <em>the day</em></p>
            </section>
            <section>
                <p>Let's dive into code design using <em>object-oriented principles</em></p>
            </section>
            <section class="ml-bullet-slide">
                <h3>The OOP Principles</h3>
                <ul style=${{"list-style": "none"}}>
                    <li class="fragment">Abstraction</li>
                    <li class="fragment">Encapsulation</li>
                    <li class="fragment">Inheritance</li>
                    <li class="fragment">Polymorphism</li>
                </ul>
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
                <p>What is <em>Object-Oriented Programming (OOP)</em>?</p>
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
                <p><em>Data</em> = what it is / what it has<br/><em>Behavior</em> = what it does</p>
            </section>
            <section>
                <p><em>Data</em> = nouns<br/><em>Behavior</em> = verbs</p>
            </section>
            <section>
                <p>This process of modeling concepts as objects with data and behavior is called <em>abstraction</em></p>
            </section>
            <section>
                <p>How would we design a car?</p>
            </section>
            <section class="ml-columns-slide">
                <h3>What is a car?</h3>
                <div class="columns">
                    <ul>
                        <li class="fragment">Has four wheels</li>
                        <li class="fragment">An engine</li>
                        <li class="fragment">Seats</li>
                        <li class="fragment">Spark plugs</li>
                        <li class="fragment">Goes "vroom, vroom"</li>
                    </ul>
                    <ul>
                        <li class="fragment">Washer fluid</li>
                        <li class="fragment">Hub caps</li>
                        <li class="fragment">Audio receiver</li>
                        <li class="fragment">Transmission</li>
                        <li class="fragment">?????</li>
                    </ul>
                </div>
            </section>
            <section>
                <p>A real, working car is super complex.<br />But we don't need the <i>whole thing</i>.</p>
            </section>
            <section>
                <p>We just need a useful <em>abstraction</em> that serves our purpose.</p>
            </section>
            <section>
                <p>Let's build a car for a <em>simple game</em>…</p>
            </section>
            <section class="ml-bullet-slide">
                <h3>What our car <em>actually</em> needs</h3>
                <ul style=${{"font-size": ".85em"}}>
                    <li class="fragment">Make and model</li>
                    <li class="fragment">A state that represents if it's on or not</li>
                    <li class="fragment">A speed indicator and a limit</li>
                    <li class="fragment">The current gear (P, R, N, D)</li>
                    <li class="fragment">Ability to turn it on or off</li>
                    <li class="fragment">Ability to move forward or backward</li>
                    <li class="fragment">Ability to turn left or right</li>
                </ul>
            </section>
            <section>
                <img class="r-stretch" src="images/slides/Slide545.png" alt="Slide 545" />
            </section>
            <section>
                <p>Here are some tests we might write…</p>
            </section>
            <${CodeSlide} lang="java">
${`
@Test
public void testCreateCar() {
    // Act
    var car = new Car("Toyota", "Camry", 120);
    
    // Assert
    Assertions.assertFalse(car.getIsOn());
    Assertions.assertEquals(Gear.PARK, car.getGear());
}
`}
            <//>
            <${CodeSlide} lang="java">
${`
@Test
public void testTurnOn() {
    // Arrange
    var car = new Car("Toyota", "Camry", 120);
    
    // Act
    car.turnOn();

    // Assert
    assertTrue(car.getIsOn());
}
`}
            <//>
            <${CodeSlide} lang="java">
${`
@Test
public void testSetGear() {
    // Arrange
    var car = new Car("Toyota", "Camry", 120);
    car.turnOn();
    
    // Act
    car.setGear(Gear.DRIVE);

    // Assert
    assertTrue(Gear.DRIVE, car.getGear());
}
`}
            <//>
            <${CodeSlide} lang="java">
${`
@Test
public void testAcceleration() {
    // Arrange
    var car = new Car("Toyota", "Camry", 120);
    car.turnOn();
    car.setGear(Gear.DRIVE);
    
    // Act
    car.accelerateToMph(60);

    // Assert
    assertEquals(60, car.getSpeedInMph());
}
`}
            <//>
            <section>
                <p>Here's how we might implement the car class…</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true" fontSize=".25em">
${`
package com.codedifferently.model;

public class Car { // <-- Class definition, public to things outside this package
   // These variable are private to the class
   private boolean isOn;
   private int speedInMph;
   private int maxSpeedInMph;
   private Gear currentGear;

   // The below methods define behavior
   public void turnOn() {
       this.isOn = true;
   }

   public boolean getIsOn() {
       return this.isOn; // "this" refers to an instance of the class (\`new Car()\`)
   }

   public void accelerateToMph(int speedInMph) {
       if (!this.isOn) {
           throw new IllegalStateException("Car is off");
       }
       if (this.currentGear != Gear.DRIVE) {
           throw new IllegalStateException("Car is not in drive");
       }
       this.speedInMph = Math.max(speedInMph, this.maxSpeedInMph);
   }
}
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers="3" fontSize=".25em">
${`
package com.codedifferently.model;

public class Car { // <-- Class definition, public to things outside this package
   // These variable are private to the class
   private boolean isOn;
   private int speedInMph;
   private int maxSpeedInMph;
   private Gear currentGear;

   // The below methods define behavior
   public void turnOn() {
       this.isOn = true;
   }

   public boolean getIsOn() {
       return this.isOn; // "this" refers to an instance of the class (\`new Car()\`)
   }

   public void accelerateToMph(int speedInMph) {
       if (!this.isOn) {
           throw new IllegalStateException("Car is off");
       }
       if (this.currentGear != Gear.DRIVE) {
           throw new IllegalStateException("Car is not in drive");
       }
       this.speedInMph = Math.max(speedInMph, this.maxSpeedInMph);
   }
}
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers="4-8" fontSize=".25em">
${`
package com.codedifferently.model;

public class Car { // <-- Class definition, public to things outside this package
   // These variable are private to the class
   private boolean isOn;
   private int speedInMph;
   private int maxSpeedInMph;
   private Gear currentGear;

   // The below methods define behavior
   public void turnOn() {
       this.isOn = true;
   }

   public boolean getIsOn() {
       return this.isOn; // "this" refers to an instance of the class (\`new Car()\`)
   }

   public void accelerateToMph(int speedInMph) {
       if (!this.isOn) {
           throw new IllegalStateException("Car is off");
       }
       if (this.currentGear != Gear.DRIVE) {
           throw new IllegalStateException("Car is not in drive");
       }
       this.speedInMph = Math.max(speedInMph, this.maxSpeedInMph);
   }
}
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers="10-27" fontSize=".25em">
${`
package com.codedifferently.model;

public class Car { // <-- Class definition, public to things outside this package
   // These variable are private to the class
   private boolean isOn;
   private int speedInMph;
   private int maxSpeedInMph;
   private Gear currentGear;

   // The below methods define behavior
   public void turnOn() {
       this.isOn = true;
   }

   public boolean getIsOn() {
       return this.isOn; // "this" refers to an instance of the class (\`new Car()\`)
   }

   public void accelerateToMph(int speedInMph) {
       if (!this.isOn) {
           throw new IllegalStateException("Car is off");
       }
       if (this.currentGear != Gear.DRIVE) {
           throw new IllegalStateException("Car is not in drive");
       }
       this.speedInMph = Math.max(speedInMph, this.maxSpeedInMph);
   }
}
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers="12,16,20,23,26" fontSize=".25em">
${`
package com.codedifferently.model;

public class Car { // <-- Class definition, public to things outside this package
   // These variable are private to the class
   private boolean isOn;
   private int speedInMph;
   private int maxSpeedInMph;
   private Gear currentGear;

   // The below methods define behavior
   public void turnOn() {
       this.isOn = true;
   }

   public boolean getIsOn() {
       return this.isOn; // "this" refers to an instance of the class (\`new Car()\`)
   }

   public void accelerateToMph(int speedInMph) {
       if (!this.isOn) {
           throw new IllegalStateException("Car is off");
       }
       if (this.currentGear != Gear.DRIVE) {
           throw new IllegalStateException("Car is not in drive");
       }
       this.speedInMph = Math.max(speedInMph, this.maxSpeedInMph);
   }
}
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers="12,16,20,23,26" fontSize=".25em">
${`
package com.codedifferently.model;

public class Car { // <-- Class definition, public to things outside this package
   // These variable are private to the class
   private boolean isOn;
   private int speedInMph;
   private int maxSpeedInMph;
   private Gear currentGear;

   // The below methods define behavior
   public void turnOn() {
       isOn = true;
   }

   public boolean getIsOn() {
       return isOn; // "this" refers to an instance of the class (\`new Car()\`)
   }

   public void accelerateToMph(int speedInMph) {
       if (!isOn) {
           throw new IllegalStateException("Car is off");
       }
       if (currentGear != Gear.DRIVE) {
           throw new IllegalStateException("Car is not in drive");
       }
       this.speedInMph = Math.max(speedInMph, maxSpeedInMph); // Disambiguation!
   }
}
`}
            <//>
            <section>
                <p>But wait, we need to add a make and model…</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="8-11" fontSize=".25em">
${`package com.codedifferently.model;

public class Car {
   private boolean isOn;
   private int speedInMph;
   private int maxSpeedInMph;
   private Gear currentGear;
   // Add two member variables and mark them final so they don't change
   private final String make;
   private final String model;

   // Here's a new constructor function that sets up a new instance
   // Notice that it has no return type (just returns a new object instance of a car)
   public Car(String make, String model, int maxSpeedInMph) {
       this.make = make; 
       this.model = model;
       this.maxSpeedInMph = maxSpeed;
       this.isOn = false;
       this.speedInMph = 0;
       this.currentGear = Gear.PARK;
   }

   public void turnOn() {
       isOn = true;
   }
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers="12-22" fontSize=".25em">
${`package com.codedifferently.model;

public class Car {
   private boolean isOn;
   private int speedInMph;
   private int maxSpeedInMph;
   private Gear currentGear;
   // Add two member variables and mark them final so they don't change
   private final String make;
   private final String model;

   // Here's a new constructor function that sets up a new instance
   // Notice that it has no return type (just returns a new object instance of a car)
   public Car(String make, String model, int maxSpeedInMph) {
       this.make = make;     // The only time you can set the value
       this.model = model;   // for the \`make\` and \`model\`.
       this.maxSpeedInMph = maxSpeed;
       this.isOn = false;
       this.speedInMph = 0;
       this.currentGear = Gear.PARK;   // We use \`this\` to disambiguate between
                                       // the member variable and the parameter
   }

   public void turnOn() {
       isOn = true;
   }
`}
            <//>
            <section>
                <p>Let's talk about <em>encapsulation</em></p>
            </section>
            <section>
                <p><em>Encapsulation</em> is why we encode data and behavior in <em>classes</em></p>
            </section>
            <section>
                <p>It's also why we control whether things are <em>public</em> or <em>private</em></p>
            </section>
            <section>
                <p>We control what others are able <em>to know</em> and <em>to do</em> with our classes, hiding what we need to and exposing the rest.</p>
            </section>
            <section>
                <p>So, what makes a good <em>class</em>?</p>
            </section>
            <section>
                <p><em>SOLID</em> principles</p>
            </section>
            <section class="ml-bullet-slide">
                <ul style=${{"list-style": "none"}}>
                    <li class="fragment"><em>S</em>ingle Responsibility Principle</li>
                    <li class="fragment"><em>O</em>pen/Closed Principle</li>
                    <li class="fragment"><em>L</em>iskov Substitution Principle</li>
                    <li class="fragment"><em>I</em>nterface Segregation Principle</li>
                    <li class="fragment"><em>D</em>ependency Inversion Principle</li>
                </ul>
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
                <p>Why would it be bad to add a method called <em>buyFromDealer</em>? </p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true" fontSize=".4em">
${`
package com.codedifferently.model;

public class Car {

   public void turnOn() {
       this.isOn = true;
   }

   public void turnOff() {
       this.isOn = false;
   }

   public void buyFromDealer(double price) {
       // TODO: Add logic for buying from a dealer
   }
}
`}
            <//>
            <section>
                <p>According to the principle of <em>single responsibility</em>, a  class should only have one reason to change</p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true" fontSize=".35em">
${`
package com.codedifferently.model;

// This class has *two* reasons to change. You would have to modify
// this to change 1) how cars operate and 2) how cars are bought
// and sold from a dealer.
public class Car {

   public void turnOn() {
       this.isOn = true;
   }

   public void turnOff() {
       this.isOn = false;
   }

   public void buyFromDealer(double price) {
       // TODO: Add logic for buying from a dealer
   }
}
`}
            <//>
            <${CodeSlide} lang="java" lineNumbers="true">
${`
package com.codedifferently.model;

import java.util.Map;

public class CarDealership {
  private Map<String, Car> inventoryCarsByVin;

  // The method belongs here in a class responsible 
  // for managing how cars are bought and sold.
  public Car buyVehicle(String vin, double price) {
   // TODO: Add logic for buying from a dealer
    Car purchasedCar = this.inventoryCarsByVin.remove(vin);
    return purchasedCar;
  }
}
`}
            <//>
            <section>
                <p>Let's say we want to beef up our cars with an <i>engine</i></p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="true" fontSize=".35em">
${`
public class Car {
   private GasEngine engine;

   public void turnOn() {
       this.engine.startIgnition();
   }

   public boolean getIsOn() {
       return this.engine.isStarted();
   }

   public void accelerateToMph(int speedInMph) {
       this.engine.setThrottle(getThrottleForMphSpeed(speedInMph));
   }
}
`}
            <//>
            <section>
                <p>What if the car needs to support either a <i>gas</i> or <i>electric</i> engine?</p>
            </section>
            <section>
                <p>We'd need to change the code.<br/><span class="important">We don't like</span> having to change code.</p>
            </section>
            <section>
                <p>The <em>dependency inversion</em> principle suggests that we should make our class accept an <em>Engine</em> as a <i>dependency</i></p>
            </section>
            <section>
                <p>
                    <span class="fragment" data-fragment-index="1"><span class="fragment custom strikethrough" data-fragment-index="2">Class creates its own dependencies</span></span><br/>
                    <span class="fragment" data-fragment-index="2">Class receives its dependencies</span>
                </p>
            </section>
            <${CodeSlide} lang="java" lineNumbers="4-12" fontSize=".35em">
${`
public class Car {
   private Engine engine;

   // The user can construct a car with any engine...
   public Car(String make, String model, Engine engine) {
       this.engine = engine;
   }

   // ...or use this \`setter\` method to change it.
   public void setEngine(Engine engine) {
       this.engine = engine;
   }

   public void turnOn() {
       this.engine.startIgnition();
   }
}
`}
            <//>
        <//>`;
}

export default Lesson16;