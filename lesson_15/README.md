# Lesson 15: Test Driven Development ([Slides](https://code-differently.github.io/code-differently-25-q1/slides/#/lesson_15))

## Pre-work

Please review the following resources before lecture:

* [Test-Driven Development (TDD): A Time-Tested Recipe for Quality Software (Article)](https://semaphoreci.com/blog/test-driven-development)
* [Test-Driven Development explained in 3 minutes (Video)](https://www.youtube.com/watch?v=amkDB_oPix0)

## Homework

- [ ] Complete [Unit Testing](#unit-testing) assignment.
- [ ] Do pre-work for [lesson 16](/lesson_16/).

### Unit Testing

For the code in the Lesson 15 app, you will write tests in the [unit tests project][unit-tests-link]. You must achieve a code coverage of 80% or more. The coverage report can be viewed at [./tdd/tdd_app/build/reports/jacoco/test/html/index.html][coverage-report] after running `./gradlew check` or `./gradlew jacocoTestReport`.

In addition to writing unit tests, you will need to implement a new method on the `Employee` class called `getDetails` that returns a string describing the employee using the Test-Driven Development methodology.

[coverage-report]: ./tdd/tdd_app/build/reports/jacoco/test/html/index.html
[unit-tests-link]: ./tdd/tdd_app/src/test/java/com/codedifferently/lesson15/