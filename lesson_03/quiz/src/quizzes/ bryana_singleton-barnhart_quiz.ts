import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';

export class Bryanasingletonbarnhart implements QuizQuestionProvider {
  getProviderName(): string {
    return 'bryanasingletonbarnhart';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [
      Bryanasingletonbarnhart.makeQuestion0(),
      Bryanasingletonbarnhart.makeQuestion1(),
      Bryanasingletonbarnhart.makeQuestion2(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'Which component is consider the brain?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Case'],
        [AnswerChoice.B, 'Power Supply'],
        [AnswerChoice.C, 'CPU'],
        [AnswerChoice.D, 'Motherboard'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      'What does SDD stand for?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Same Day Delivery'],
        [AnswerChoice.B, 'Solid State Drive'],
        [AnswerChoice.C, 'System Design Document'],
        [AnswerChoice.D, 'Software Development Document'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'How many bits is in a byte?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, '2'],
        [AnswerChoice.B, '40'],
        [AnswerChoice.C, '1000'],
        [AnswerChoice.D, '8'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
}
