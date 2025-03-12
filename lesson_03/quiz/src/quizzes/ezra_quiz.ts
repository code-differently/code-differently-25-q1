import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
} from 'codedifferently-instructional';

export class EzraQuiz {
  getProviderName() {
    return 'ezraquiz';
  }

  makeQuizQuestions() {
    return [
      EzraQuiz.makeQuestion0(),
      EzraQuiz.makeQuestion1(),
      EzraQuiz.makeQuestion2(),
    ];
  }

  static makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
      0,
      'What is the most played video game in the world?',
      new Map([
        [AnswerChoice.A, 'GTA V'],
        [AnswerChoice.B, 'Call of Duty'],
        [AnswerChoice.C, 'World of Warcraft'],
        [AnswerChoice.D, 'MineCraft'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  static makeQuestion1() {
    return new MultipleChoiceQuizQuestion(
      1,
      'What is the top tourist destination in the world?',
      new Map([
        [AnswerChoice.A, 'China'],
        [AnswerChoice.B, 'France'],
        [AnswerChoice.C, 'Italy'],
        [AnswerChoice.D, 'Brazil'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  static makeQuestion2() {
    return new MultipleChoiceQuizQuestion(
      2,
      'What country has the largest number of ocean borders?',
      new Map([
        [AnswerChoice.A, 'Canada'],
        [AnswerChoice.B, 'India'],
        [AnswerChoice.C, 'Australia'],
        [AnswerChoice.D, 'United Kingdom'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
}
