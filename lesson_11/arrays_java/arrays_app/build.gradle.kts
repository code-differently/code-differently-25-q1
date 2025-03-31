plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    eclipse
    id("com.diffplug.spotless") version "6.25.0"
	  id("org.springframework.boot") version "3.4.0"
    id("com.adarshr.test-logger") version "4.0.0"
}

apply(plugin = "io.spring.dependency-management")

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation("com.codedifferently.instructional:instructional-lib")
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.3")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.assertj:assertj-core:3.26.3")
    testImplementation("at.favre.lib:bcrypt:0.10.2")

    // This dependency is used by the application.
    implementation("com.codedifferently.instructional:instructional-lib")
    implementation("com.google.guava:guava:33.3.1-jre")
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("org.projectlombok:lombok:1.18.30")
    implementation("org.springframework.boot:spring-boot-starter")
}

application {
    // Define the main class for the application.
    mainClass.set("com.codedifferently.lesson11.Lesson11")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}


configure<com.diffplug.gradle.spotless.SpotlessExtension> {

  format("misc", {
    // define the files to apply `misc` to
    target("*.gradle", ".gitattributes", ".gitignore")

    // define the steps to apply to those files
    trimTrailingWhitespace()
    indentWithTabs() // or spaces. Takes an integer argument if you don't like 4
    endWithNewline()
  })

  java {
    // don't need to set target, it is inferred from java

    // apply a specific flavor of google-java-format
    googleJavaFormat()
    // fix formatting of type annotations
    formatAnnotations()
  }
}
