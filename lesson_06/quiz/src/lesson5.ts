import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizPrinter,
  QuizQuestion,
} from "codedifferently-instructional";

export class Lesson5 {
  run(): void {
    const quizQuestions = Lesson5.makeQuizQuestions();
    if (!quizQuestions) throw new Error("Quiz questions cannot be null");
    const printer = new QuizPrinter();
    printer.printQuiz(quizQuestions);
  }

  static makeQuizQuestions(): QuizQuestion[] {
    return [
      Lesson5.makeQuestion0(),
      Lesson5.makeQuestion1(),
      Lesson5.makeQuestion2(),
      Lesson5.makeQuestion3(),
      Lesson5.makeQuestion4(),
      Lesson5.makeQuestion5(),
      Lesson5.makeQuestion6(),
      Lesson5.makeQuestion7(),
      Lesson5.makeQuestion8(),
      Lesson5.makeQuestion9(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      "What is the purpose of the <h1> tag in HTML?",
      new Map([
        [AnswerChoice.A, "To create a hyperlink"],
        [AnswerChoice.B, "To define the most important heading"],
        [AnswerChoice.C, "To insert an image"],
        [AnswerChoice.D, "To create a paragraph"],
      ]),
      AnswerChoice.B,
    );
  }

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      "Which attribute is used to specify alternative text for an image in HTML?",
      new Map([
        [AnswerChoice.A, "title"],
        [AnswerChoice.B, "src"],
        [AnswerChoice.C, "alt"],
        [AnswerChoice.D, "href"],
      ]),
      AnswerChoice.C,
    );
  }

  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      "Which HTML tag is used to create a hyperlink?",
      new Map([
        [AnswerChoice.A, "<p>"],
        [AnswerChoice.B, "<a>"],
        [AnswerChoice.C, "<div>"],
        [AnswerChoice.D, "<link>"],
      ]),
      AnswerChoice.B,
    );
  }

  private static makeQuestion3(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      3,
      "Which of the following is a semantic HTML tag?",
      new Map([
        [AnswerChoice.A, "<div>"],
        [AnswerChoice.B, "<article>"],
        [AnswerChoice.C, "<span>"],
        [AnswerChoice.D, "<br>"],
      ]),
      AnswerChoice.B,
    );
  }

  private static makeQuestion4(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      4,
      "What does CSS stand for?",
      new Map([
        [AnswerChoice.A, "Creative Style Sheets"],
        [AnswerChoice.B, "Cascading Style Sheets"],
        [AnswerChoice.C, "Computer Style Sheets"],
        [AnswerChoice.D, "Cascading System Sheets"],
      ]),
      AnswerChoice.B,
    );
  }

  private static makeQuestion5(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      5,
      "Which CSS property is used to change the text color?",
      new Map([
        [AnswerChoice.A, "font-color"],
        [AnswerChoice.B, "color"],
        [AnswerChoice.C, "text-color"],
        [AnswerChoice.D, "background-color"],
      ]),
      AnswerChoice.B,
    );
  }

  private static makeQuestion6(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      6,
      "How do you add a comment in CSS?",
      new Map([
        [AnswerChoice.A, "// this is a comment"],
        [AnswerChoice.B, "# this is a comment"],
        [AnswerChoice.C, "/* this is a comment */"],
        [AnswerChoice.D, "<!-- this is a comment -->"],
      ]),
      AnswerChoice.C,
    );
  }

  private static makeQuestion7(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      7,
      "Which CSS property controls the size of text?",
      new Map([
        [AnswerChoice.A, "font-style"],
        [AnswerChoice.B, "font-size"],
        [AnswerChoice.C, "text-size"],
        [AnswerChoice.D, "text-style"],
      ]),
      AnswerChoice.B,
    );
  }

  private static makeQuestion8(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      8,
      "What is the default display value for `<div>` in CSS?",
      new Map([
        [AnswerChoice.A, "inline"],
        [AnswerChoice.B, "block"],
        [AnswerChoice.C, "inline-block"],
        [AnswerChoice.D, "none"],
      ]),
      AnswerChoice.B,
    );
  }

  private static makeQuestion9(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      9,
      "How do you link an external CSS file to an HTML document?",
      new Map([
        [AnswerChoice.A, "<link rel='stylesheet' href='styles.css'>"],
        [AnswerChoice.B, "<style href='styles.css'>"],
        [AnswerChoice.C, "<stylesheet link='styles.css'>"],
        [AnswerChoice.D, "<css href='styles.css'>"],
      ]),
      AnswerChoice.A,
    );
  }
}

if (!process.env.JEST_WORKER_ID) {
  new Lesson5().run();
}
