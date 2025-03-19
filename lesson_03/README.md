# Lesson 03: How Computers Work ([Slides](https://code-differently.github.io/code-differently-25-q1/slides/#/lesson_03))

## Pre-work

Please review the following resources before lecture:

* [Exploring How Computers Work (Video)](https://www.youtube.com/watch?v=QZwneRb-zqA&list=RDCMUCmtyQOKKmrMVaKuRXz02jbQ&index=1)
* [What does what in your computer? Computer parts Explained (Video)](https://www.youtube.com/watch?v=ExxFxD4OSZ0)

## Homework

- [ ] Review [important reminders below](#important-reminders).
- [ ] Create [new quiz questions](#creating-new-quiz-questions).
- [ ] Do pre-work for [lesson 04](/lesson_04/).

### Important reminders

* Make sure to sync your fork before creating a branch in order to pull in the latest changes.
* Sync your branch often to avoid merge conflicts and execute `git pull` to bring the latest changes to your machine.
* If your branch is too far behind or you run into too many issues, feel free to delete and re-create your repository. Make sure to review the article linked at the bottom of the [lesson_00](/lesson_00/README.md) README for instructions on how to create your fork and branch properly.
* Remember, you should not reuse a branch you've used to submit a pull request. If you need to make changes, create a new branch and work from there after you've updated your fork to the latest.

### Creating new quiz questions

Now's your chance to quiz the instructor! In this assignment, you will modify the quiz project to include three quiz questions based on the content you've learned in this course so far. Feel free to choose any topic for your questions.

1. Navigate to the [quiz][quiz-folder] directory and install the required dependencies.
```bash
cd lesson_03/quiz
npm install --prefix ../../lib/javascript/codedifferently-instructional
npm install
npm start
```
2. You will create a quiz file in the [quizzes folder][quizzes-folder]. You should model yours after the example provided in [anthony_mays_quiz.ts][quiz-example]. Note that the name of the file you create should match the name of the class in the file.
3. Make sure to provide a unique provider name for your questions provider. You'll need this name to provide answers in step 5.
```typescript
  getProviderName(): string {
    return '<your unique name goes here>';
  }
```
4. Make at least three questions for your quiz and _leave them unanswered_.
5. To provide answers, you will need to update the [quiz.yaml][test-config-file] file in the test directory. You can copy the example in the file to get started, but you must provide your own answers. To generate an encrypted answer, use [bcrypt.online](https://bcrypt.online).
6. Lastly, you'll need to modify the [quizzes.module.ts][quizzes-module] file to include your quiz.
7. Before attempting to submit your quiz, make sure to run the linter on the code and run the tests to ensure that you've updated things correctly. The commands must be run from the [quiz][quiz-folder] sub-folder just like the previous assignment:
```bash
npm run check
```
8. Once everything passes, submit a PR.

**Note: If you want to check that you've encoded your answers correctly, you can update you quiz with the real answers and then run the tests using the command below. 
```bash
PROVIDER_NAME=<Your provider name here> npm run test
```

### Dealing with merge conflicts

Since everyone needs to modify the same files for this assignment, you will most certainly encounter merge conflicts. To resolve this, here are the steps:

1. Sync the main branch of your fork and ensure that it is up-to-date.
2. Use `git checkout main` and `git pull` to get the latest updates pulled down to your computer.
3. Checkout your feature branch (e.g. `git checkout feature/lesson_03`).
4. Run `git rebase main` on your feature branch to pull in the latest changes and deal with merge conflicts.
5. Use the *Source Control* view in VS Code to identify files with conflicts. Click to open them and use the *Merge Editor* to resolve conflicts.
6. Stage and commit the changed files.
7. Repeat steps 5-6 until the rebase is complete.

An alternative approach is to open the PR and manually edit the conflicting files to work out any issues. This may be easier for some of you, but it can also be tricky to do if you don't know what you're doing.

Check out [this YouTube video](https://www.youtube.com/watch?v=OXtdxHTh2oY) for a quick explaination of what's going on. 

[quizzes-folder]: ./quiz/src/quizzes/
[quiz-folder]: ./quiz/
[quiz-example]: ./quiz/src/quizzes/anthony_mays_quiz.ts
[test-config-file]: ./quiz/quiz.yaml
[quizzes-module]: ./quiz/src/quizzes/quizzes.module.ts