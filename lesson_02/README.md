# Lesson 02: Developer Workflow: Navigating the Terminal ([Slides](https://code-differently.github.io/code-differently-25-q1/slides/#/lesson_02))

## Pre-work

Please review the following resources before lecture:

* [Absolute BEGINNER Guide to the Mac OS Terminal (Video)](https://www.youtube.com/watch?v=aKRYQsKR46I)

## Homework

- [ ] Complete [Lesson 02 quiz](#lesson-02-quiz-instructions)
- [ ] Do pre-work for [lesson 03](/lesson_03/).

### Prerequisites

To complete this assignment, you must have **Docker** and **VS Code** with the [**Dev Containers**][dev-containers-link] extension installed.

### Lesson 02 Quiz Instructions

For this assignment, you will complete a quiz by modifying a TypeScript application. Within the quiz project, there are tests that you will need to make pass in order to submit your answers. Here are the instructions for completing the assignment:

1. Make sure to sync your fork to pull in the latest changes.
2. Open the project in **VS Code** and make sure to select `Reopen in Container` when prompted.
3. Navigate to the [quiz][lesson-2-quiz-dir] directory and install the required dependencies.
```bash
cd lesson_02/quiz
npm install --prefix ../../lib/javascript/codedifferently-instructional
npm install
npm start
```
4. Open the [lesson2.ts][lesson-2-file] file located in the [quiz/src/][lesson-2-src-dir] directory.
5. Update the code to provide the correct answers to the given questions.
6. When ready to test, run the following command in the `quiz` sub-directory using the terminal:
```bash
npm run test
```
7. Once all tests pass, submit your work by creating a pull request (PR).

[dev-containers-link]: https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers
[lesson-2-quiz-dir]: quiz/
[lesson-2-file]: quiz/src/lesson2.ts
[lesson-2-src-dir]: quiz/src/
[test-report]: quiz/lesson_02_quiz/build/reports/tests/test/index.html
[spotless-link]: https://github.com/diffplug/spotless