import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';

export class DavidAdenaikeQuiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'davidadenaike';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [
      DavidAdenaikeQuiz.makeQuestion0(),
      DavidAdenaikeQuiz.makeQuestion1(),
      DavidAdenaikeQuiz.makeQuestion2(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'What does RAM stand for?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Rabbit, Abandon, Machinery'],
        [AnswerChoice.B, 'Race, Abbey, Magazine'],
        [AnswerChoice.C, 'Racism, Able, Magnetic'],
        [AnswerChoice.D, 'Random, Access Memory'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      'What does CPU stand for?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Central, Processing, Unit'],
        [AnswerChoice.B, 'Cabin, Pace, Umbrella'],
        [AnswerChoice.C, 'Cable, Pack, Unanimous'],
        [AnswerChoice.D, 'Cage, Pain, Uncle'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'What does GPU stand for?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Galaxy, Palace, Unpleasant'],
        [AnswerChoice.B, 'Graphics, Processing, Unit'],
        [AnswerChoice.C, 'Gallon, Panic, Unrest'],
        [AnswerChoice.D, 'Game, Parachute, Union'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
}
