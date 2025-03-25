# Lesson 09: Data Types ([Slides](https://code-differently.github.io/code-differently-25-q1/slides/#/lesson_09))

## Pre-work

Please review the following resources before lecture:

* [Learn Java Primitive Data Types in 5 Minutes (Video)](https://www.youtube.com/watch?v=cgp5ulbsdJ0)
* [Java Classes & Objects (Video)](https://www.youtube.com/watch?v=IUqKuGNasdM)
* [TypeScript Tutorial #12 - Classes (Video)](https://www.youtube.com/watch?v=OsFwOzr3_sE)

## Homework

- [ ] Complete [data types exercise](#choosing-the-right-data-types).

### Choosing the Right Data Types

For this exercise, you will use your knowledge of data types to identify the appropriate type to store and process data. You will run a program to generate a unique file with sample data, then write code to provide the correct data type of each column.

1. Execute the app providing a unique provider name.

```bash
cd lesson_09/types
./gradlew bootRun --args="yourprovidername" # Substitute with your own value
```
2. Examine the file that was created for you in the [resources/data][resources-folder] folder. The file will be formatted using the [JSON][json-link] data format.
3. Next, you will create a `DataProvider` implementation that will provide information about the data types for the columns in the file (e.g. `column1`, `column2`, etc.). You can view the example [AnthonyMaysProvider.java][example-file] file.
4. Customize the data types map by choosing the closest appropriate data type of each column. Each data type should only be used **once**.
5. Make sure to apply the formatter and run the tests to confirm that you've implemented everything correctly.
```bash
./gradlew spotlessApply
./gradlew check
```
6. You are to submit a PR with your `DataProvider` implementation and the generated `.json` file that was produced for you. All build checks must pass in order to receive full credit.

[json-link]: https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Objects/JSON
[resources-folder]: ./types/types_app/src/main/resources/data/
[example-file]: ./types/types_app/src/main/java/com/codedifferently/lesson9/dataprovider/AnthonyMaysProvider.java
