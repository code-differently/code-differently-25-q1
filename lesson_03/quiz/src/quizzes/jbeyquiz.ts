import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
} from 'codedifferently-instructional';
export class Jbeyquiz {
  getProviderName() {
    return 'computerparts';
  }
  makeQuizQuestions() {
    return [
      Jbeyquiz.makeQuestion0(),
      Jbeyquiz.makeQuestion1(),
      Jbeyquiz.makeQuestion2(),
    ];
  }
  static makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
      0,
      'What is RAM?',
      new Map([
        [AnswerChoice.A, 'Robotic Automated Mechanism'],
        [
          AnswerChoice.B,
          'A type of storage device that holds all of your files',
        ],
        [
          AnswerChoice.C,
          'Special software that controls your computers internet connection',
        ],
        [AnswerChoice.D, 'Random Access Memory'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
  static makeQuestion1() {
    return new MultipleChoiceQuizQuestion(
      1,
      'What is a GPU?',
      new Map([
        [
          AnswerChoice.A,
          'A powerful cooling fan that keeps your computer from overheating',
        ],
        [AnswerChoice.B, 'A special type of harddrive'],
        [
          AnswerChoice.C,
          'A special type of processor primarily designed to handleand accelerate the rendering of images, video, and animations.',
        ],
        [
          AnswerChoice.D,
          'A keyboard that controls the movement of your mouse on screen',
        ],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
  static makeQuestion2() {
    return new MultipleChoiceQuizQuestion(
      2,
      'What is an SSD?',
      new Map([
        [AnswerChoice.A, 'A type of RAM that stores data permanently'],
        [
          AnswerChoice.B,
          'A storage device used in computers and other electronic devices',
        ],
        [
          AnswerChoice.C,
          'A type of USB cable that connects your computer to the internet',
        ],
        [
          AnswerChoice.D,
          'A type of screen that displays the contents of your computers memory',
        ],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
}
