# Lesson 06: Statements and Variables ([Slides](https://code-differently.github.io/code-differently-24-q4/slides/#/lesson_06))

## Pre-work

Please review the following resources before lecture:

* [Typescript for Beginners - Starter Lesson (Video)](https://www.youtube.com/watch?v=MOO5vrtTUTE&list=PL0Zuz27SZ-6NS8GXt5nPrcYpust89zq_b&index=1)

## Homework

- [ ] Complete the [Expression Calculator](#expression-calculator) exercise.
- [ ] Read article entitled [3 Questions That Will Make You A Phenomenal Rubber Duck][article-link]
- [ ] Do pre-work for [lesson 07](/lesson_07/).

### Expression Calculator

For this assignment, you will need to implement the functions and logic required to calculate a mathematical expression. After implementing the `add`, `divide`, and `multiply` functions, you will combine these functions to compute the final result.

1. Update the [.env.test][env-file] file to configure the correct homework version.
```bash
# Example config for students assigned to homework "D".
HW_VERSION=D
```
2. Run the program to determine the expression you must implement.
```bash
npm install
npm run compile
npm start
```
1. Update the code in the [expression_calculator.ts][calculator-file] file.
2. To check your work, you can run the application using the first command below and run the tests using the second one.
```bash
npm start
```
1. As usual, make sure that you format your code and run the check command before creating your pull request.
```bash
npm run check
```
1. You must only submit changes to the `expression_calculator.ts` file to receive full credit.

[article-link]: https://blog.danslimmon.com/2024/01/18/3-questions-that-will-make-you-a-phenomenal-rubber-duck/
[calculator-file]: ./expression/src/expression_calculator.ts
[env-file]: ./expression/.env.test