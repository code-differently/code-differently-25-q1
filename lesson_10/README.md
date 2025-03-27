# Lesson 10: Libraries and APIs ([Slides](https://code-differently.github.io/code-differently-25-q1/slides/#/lesson_10))

## Pre-work

Please review the following resources before lecture:

* [What is CSV file (overview) (Video)](https://www.youtube.com/watch?v=OGOD2Fqy5k8)
* [Typescript Guide - Lesson 96 Reading CSV Files (Video)](https://www.youtube.com/watch?v=bbvECy0ICuo)
* [How to Parse / Read CSV File | Javascript & Node.js (Video)](https://www.youtube.com/watch?v=5HGBG9AiIzo)

## Homework

- [ ] Complete [Loading the Media Collection](#loading-the-media-collection) assignment.
- [ ] Do pre-work for [lesson 11](/lesson_11/).

### Loading The Media Collection

For this assignment, you are tasked with writing code to load data from a set of CSV files.

* Use the example loader file at [libraries/src/loaders/anthony_mays_loader.ts][example-loader-file] to make your own unique copy of the loader.
* Implement the `loadMediaItems` method by loading the data from the [data/media_items.csv][media-items-file] file.

To try out the app with your loader, you can run the following command.

```bash
npm run compile
npm start -- --loader yourLoaderNameHere
```

Before submitting your work, be sure to run the tests.

```bash
npm run test
```

### Extra credit

For additional credit on this assignment, combine the credits with the media items you loaded by modifying the `loadData` method. You can test that you've loaded everything correctly by using this special command:

```bash
LOADER_NAME=yourLoaderNameHere npm run test
```

[example-loader-file]: ./libraries/src/loaders/anthony_mays_loader.ts
[media-items-file]: ./libraries/data/media_items.csv
