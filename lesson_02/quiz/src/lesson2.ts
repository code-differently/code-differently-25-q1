import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizPrinter,
  QuizQuestion,
} from "codedifferently-instructional";

export class Lesson2 {
  run(): void {
    const quizQuestions = Lesson2.makeQuizQuestions();
    if (!quizQuestions) throw new Error("Quiz questions cannot be null");
    const printer = new QuizPrinter();
    printer.printQuiz(quizQuestions);
  }

  static makeQuizQuestions(): QuizQuestion[] {
    return [
      Lesson2.makeQuestion0(),
      Lesson2.makeQuestion1(),
      Lesson2.makeQuestion2(),
      Lesson2.makeQuestion3(),
      Lesson2.makeQuestion4(),
      Lesson2.makeQuestion5(),
      Lesson2.makeQuestion6(),
      Lesson2.makeQuestion7(),
      Lesson2.makeQuestion8(),
      Lesson2.makeQuestion9(),
      Lesson2.makeQuestion10(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      "What is the main purpose of version control?",
      new Map([
        [AnswerChoice.A, "To make backups of files"],
        [AnswerChoice.B, "To keep a record of changes over time"],
        [AnswerChoice.C, "To delete unnecessary files"],
        [AnswerChoice.D, "To run code more efficiently"],
      ]),
      AnswerChoice.B, // Replace `UNANSWERED` with the correct answer.
    );
  }

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      "What is a fork in Git?",
      new Map([
        [
          AnswerChoice.A,
          "A duplicate copy of a repository that you own and modify",
        ],
        [AnswerChoice.B, "A temporary backup of the code"],
        [AnswerChoice.C, "A tool for merging branches"],
        [AnswerChoice.D, "A way to delete a repository"],
      ]),
      AnswerChoice.A, // Replace `UNANSWERED` with the correct answer.
    );
  }

  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      "Which of the following is NOT part of the basic Git workflow?",
      new Map([
        [AnswerChoice.A, "Pull the latest changes"],
        [AnswerChoice.B, "Commit changes locally"],
        [AnswerChoice.C, "Push changes to the server"],
        [AnswerChoice.D, "Write code directly in GitHub"],
      ]),
      AnswerChoice.D, // Replace `UNANSWERED` with the correct answer.
    );
  }

  private static makeQuestion3(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      3,
      "What command is used to combine changes from different branches?",
      new Map([
        [AnswerChoice.A, "git commit"],
        [AnswerChoice.B, "git merge"],
        [AnswerChoice.C, "git branch"],
        [AnswerChoice.D, "git pull"],
      ]),
      AnswerChoice.B, // Replace `UNANSWERED` with the correct answer.
    );
  }

  private static makeQuestion4(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      4,
      "Which IDE is being used in the class?",
      new Map([
        [AnswerChoice.A, "Eclipse"],
        [AnswerChoice.B, "IntelliJ IDEA"],
        [AnswerChoice.C, "NetBeans"],
        [AnswerChoice.D, "VS Code"],
      ]),
      AnswerChoice.D, // Replace `UNANSWERED` with the correct answer.
    );
  }

  private static makeQuestion5(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      5,
      "What feature allows developers to work from the same pre-configured environment in VS Code?",
      new Map([
        [AnswerChoice.A, "Extensions"],
        [AnswerChoice.B, "Debugger"],
        [AnswerChoice.C, "Dev Containers"],
        [AnswerChoice.D, "Source Control"],
      ]),
      AnswerChoice.C, // Replace `UNANSWERED` with the correct answer.
    );
  }

  private static makeQuestion6(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      6,
      "What is NOT a reason for using an IDE?",
      new Map([
        [AnswerChoice.A, "Editing and refactoring code"],
        [AnswerChoice.B, "Browsing code"],
        [AnswerChoice.C, "Playing music"],
        [AnswerChoice.D, "Managing source control"],
      ]),
      AnswerChoice.C, // Replace `UNANSWERED` with the correct answer.
    );
  }

  private static makeQuestion7(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      7,
      "What is the command to list files in the current directory?",
      new Map([
        [AnswerChoice.A, "pwd"],
        [AnswerChoice.B, "ls"],
        [AnswerChoice.C, "cd"],
        [AnswerChoice.D, "mkdir"],
      ]),
      AnswerChoice.B, // Replace `UNANSWERED` with the correct answer.
    );
  }

  private static makeQuestion8(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      8,
      "Which command is used to change directories in the terminal?",
      new Map([
        [AnswerChoice.A, "pwd"],
        [AnswerChoice.B, "ls"],
        [AnswerChoice.C, "cd"],
        [AnswerChoice.D, "mkdir"],
      ]),
      AnswerChoice.C, // Replace `UNANSWERED` with the correct answer.
    );
  }

  private static makeQuestion9(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      9,
      "What does the command `chmod` do?",
      new Map([
        [AnswerChoice.A, "Change file or directory permissions"],
        [AnswerChoice.B, "List files in a directory"],
        [AnswerChoice.C, "Remove a file or directory"],
        [AnswerChoice.D, "Copy a file or directory"],
      ]),
      AnswerChoice.A, // Replace `UNANSWERED` with the correct answer.
    );
  }

  private static makeQuestion10(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      10,
      "What is the shortcut for getting to the Mac terminal?",
      new Map([
        [AnswerChoice.A, "⌘ + Shift + T"],
        [AnswerChoice.B, '⌘ + Spacebar, then type "terminal"'],
        [AnswerChoice.C, "⌘ + Q"],
        [AnswerChoice.D, '⌘ + S, then type "terminal"'],
      ]),
      AnswerChoice.B, // Replace `UNANSWERED` with the correct answer.
    );
  }
}

if (!process.env.JEST_WORKER_ID) {
  new Lesson2().run();
}
