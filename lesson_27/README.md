# Lesson 27: Integrating with Backend APIs ([Slides](https://code-differently.github.io/code-differently-25-q1/slides/#/lesson_27))

## Pre-work

Please review the following resources before lecture:

### Required
* [Learn Fetch API In 6 Minutes (Video)](https://www.youtube.com/watch?v=cuEtnrL9-H0)
* [Using Promises - MDN (Article)](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Using_promises)

### Recommended
* [How To Make API Call In React... (Video)](https://www.youtube.com/watch?v=ZRFwuGpiLl4)

## Homework

- [ ] Complete the [Using an API](#using-an-api) assignment.
- [ ] Do pre-work for [lesson 28](/lesson_28/).

### Using an API
This exercise will give you hands-on experience with the React framework and supporting tools to enhance a dynamic front-end application that communicates with a backend API.

#### Starting the servers

1. Copy the React [template](./template/) folder to your own unique folder. Make necessary code changes in your folder only. 
2. Install the [API server](./api/) using `npm install` and then run it using the `npm run dev` command. 
3. Install the React web server in your copy using `npm install` and then run it using the `npm run dev` command.

#### Updating the ProgramList components
4. Modify the `ProgramList` component so that it calls the API to generate a list of programs using the returned data instead of the fake data. The needed HTML and CSS has already been provided for you.
  - You can reference the types/interfaces used in the API by importing from the `@code-differently/types` package. 

#### Create a page for adding new programs
4. Create a new page (similar to the Home page component) that allows you to provide a new title and description and then use the API to add it to the existing list of programs.
5. Add a link to the new page in the [Header](./template/src/components/header/Header.tsx) component that navigates to the new page.

> [!NOTE]
> You can use the [React Router tutorial](https://reactrouter.com/en/main/start/tutorial#updating-contacts-with-formdata) to learn how to handle form submissions. You can also use the [React Query guide](https://tanstack.com/query/latest/docs/framework/react/guides/mutations) to learn how leverage mutation to post to an API. 

[react-query-link]: https://tanstack.com/query/latest/docs/framework/react/quick-start
[react-router-link]: https://reactrouter.com/en/main/start/tutorial