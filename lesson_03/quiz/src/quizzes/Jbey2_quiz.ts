import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';
export class JBey2Quiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'JBey1', 'test';
  }
  makeQuizQuestions() {
    return [
      JBey2Quiz.makeQuestion0(),
      JBey2Quiz.makeQuestion1(),
      JBey2Quiz.makeQuestion2(),
    ];
  }
  static makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
      0,
      'What is Polymorphism?',
      new Map([
        [AnswerChoice.A, 'The ability to write code in multiple languages at the same time'],
        [
          AnswerChoice.B,
          'The ability of a variable to change its data type at runtime depending on the value assigned to it',
        ],
        [
          AnswerChoice.C,
          'The ability of an object to take on many forms, typically through method overriding',
        ],
        [AnswerChoice.D, 'The ability of a class to inherit from multiple parents simultaneously'],
      ]),
      AnswerChoice.C,
    ); // Replace `UNANSWERED` with the correct answer.
  }
  static makeQuestion1() {
    return new MultipleChoiceQuizQuestion(
      1,
      'What is Node.JS?',
      new Map([
        [
          AnswerChoice.A,
          'Node.JS is a programming language used for both writing both front-end and back-end code',
        ],
        [AnswerChoice.B, 'Node.JS is a framework for JavaScript, like Angular or React, but for servers'],
        [
          AnswerChoice.C,
          'Node.js is a web server application, similar to Apache or Nginx',
        ],
        [
          AnswerChoice.D,
          'Node.js is an open-source, cross-platform JavaScript runtime environment that executes JavaScript code outside of a web browser',
        ],
      ]),
      AnswerChoice.D,
    ); // Replace `UNANSWERED` with the correct answer.
  }
  static makeQuestion2() {
    return new MultipleChoiceQuizQuestion(
      2,
      'What is API?',
      new Map([
        [AnswerChoice.A, 'API is a set of defined rules and protocols that allows two software applications to communicate and exchange data with each other'],
        [
          AnswerChoice.B,
          'An API is a database that stores information for applications to use',
        ],
        [
          AnswerChoice.C,
          'An API is a user interface for developers, like a button you click',
        ],
        [
          AnswerChoice.D,
          'An API is a software library or SDK that developers add to their code',
        ],
      ]),
      AnswerChoice.A,
    ); // Replace `UNANSWERED` with the correct answer.
  }
}
