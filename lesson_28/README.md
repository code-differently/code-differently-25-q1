# Lesson 28: Introduction to Databases ([Slides](https://code-differently.github.io/code-differently-25-q1/slides/#/lesson_28))

## Pre-work

Please review the following resources before lecture:

### Required
* [Learn Basic SQL in 15 Minutes (Video)](https://www.youtube.com/watch?v=kbKty5ZVKMY)

### Recommended
* [You need to learn SQL RIGHT NOW!! (SQL Tutorial for Beginners) (Video)](https://www.youtube.com/watch?v=xiUTqnI6xk8)
* [SQLite (VS Code Extension documentation)](vscode:extension/alexcvzz.vscode-sqlite)

## Homework

- [ ] Complete [Loading the Library, Part II](#loading-the-library-part-ii) assignment.


### Loading The Library, Part II

Instead of loading our library data from JSON or CSV files as we did in [lesson_10](/lesson_10/), we now want to load data from a proper database. A new implementation of the `LibraryDbDataLoader` data loader has been provided to accomplish this task and is now the [default data loader][library-app] for the app.

To build familiarity in working with databases, you are charged with the following tasks:

* Write a `.sql` script file that queries the following data. Use a unique name for your file and store it in the [queries][queries-dir] directory of the resources folder.
    * A `SELECT` query that returns the counts of media items by type.
    * A `SELECT` query that returns the sum of total pages checked out by guests.
    * A `SELECT` query that shows all 5 guests and any corresponding records in the `checked_out_items` table.
* Add a new table called `library_users` to the [SQLite database][sqlite-db] that stores a user's id (UUID formatted string), email, first name, last name, and a password (bcrypt encoded string). Add a model and repository that loads the users into the LibraryDataModel (see `LibraryGuestModel` and `LibraryGuestRepository` as examples). Populate the database with a few users.

As before, you can run the app from the console using the following command:

```bash
./gradlew run --console=plain
```

[queries-dir]: ./db/db_app/src/main/resources/queries/
[sqlite-db]: ./db/db_app/src/main/resources/sqlite/
[library-app]: ./db/db_app/src/main/java/com/codedifferently/lesson28/cli/LibraryApp.java#L26
