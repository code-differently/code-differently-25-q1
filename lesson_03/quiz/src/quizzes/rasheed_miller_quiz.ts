import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
} from 'codedifferently-instructional';
export class RasheedMillerQuiz {
  getProviderName() {
    return 'rmill';
  }
  makeQuizQuestions() {
    return [
      RasheedMillerQuiz.makeQuestion0(),
      RasheedMillerQuiz.makeQuestion1(),
      RasheedMillerQuiz.makeQuestion2(),
    ];
  }
  static makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
      0,
      'What command is used to navigate to a different directory in the terminal?',
      new Map([
        [AnswerChoice.A, 'cd'],
        [AnswerChoice.B,'ls'],
        [AnswerChoice.C,'mkdir'],
        [AnswerChoice.D, 'rm'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
  static makeQuestion1() {
    return new MultipleChoiceQuizQuestion(
      1,
      'What is GitHub mainly used for?',
      new Map([
        [AnswerChoice.A,'Playing Games'],
        [AnswerChoice.B, 'Sharing and managing code'],
        [AnswerChoice.C,'Watching Videos'],
        [AnswerChoice.D,'Sending Emails'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
  static makeQuestion2() {
    return new MultipleChoiceQuizQuestion(
      2,
      'What is the primary purpose of the "Inspect" tool in a web browser?',
      new Map([
        [AnswerChoice.A, 'Edit website code temporarily'],
        [AnswerChoice.B, 'Download videos'],
        [AnswerChoice.C, 'Change website themes'],
        [AnswerChoice.D,'Install Apps'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
}
