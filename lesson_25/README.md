# Lesson 25: Intro to React ([Slides](https://code-differently.github.io/code-differently-25-q1/slides/#/lesson_25))

## Pre-work

Please review the following resources before lecture:

### Required

* [React JS Explained In 10 Minutes (Video)](https://www.youtube.com/watch?v=s2skans2dP4)
* [World's shortest UI/UX design course (Video)](https://www.youtube.com/watch?v=wIuVvCuiJhU)

### Recommended

* [React Router - Tutorial (Article)](https://reactrouter.com/en/main/start/tutorial)

## Homework

- [ ] Complete the [Introduction to React](#introduction-to-react) exercise.
- [ ] Do pre-work for [lesson 26](/lesson_26/).

### Introduction to React
This exercise will give you hands-on experience with the React framework and supporting tools to enhance a dynamic front-end application that communicates with a backend API.

#### Starting the servers

1. Copy the React [template](./template/) folder to your own unique folder. Make necessary code changes in your folder only. 
2. Install the React web server in your copy using `npm install` and then run it using the `npm run dev` command.

#### Create new components
3. Modify the [Home](./template/src/pages/Home/Home.tsx) component to create new `Program` and `ProgramList` components. The needed HTML and CSS has already been provided for you.
  - The `Program` component should allow you to configure the title and description to display.

#### Create a page for adding new programs

4. Create a new page (similar to the Home page component) that allows users to provide a new program title and description in a form.

> [!NOTE]
> You can use the [React Router tutorial](https://reactrouter.com/en/main/start/tutorial#updating-contacts-with-formdata) to learn how to handle form submissions.

[react-router-link]: https://reactrouter.com/en/main/start/tutorial