import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';

export class JustinsQuiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'justin';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [
      JustinsQuiz.makeQuestion0(),
      JustinsQuiz.makeQuestion1(),
      JustinsQuiz.makeQuestion2(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'How many planets are in our solar system?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, '8'],
        [AnswerChoice.B, '9'],
        [AnswerChoice.C, '12'],
        [AnswerChoice.D, '10'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      'How many states are there in the United States?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, '53'],
        [AnswerChoice.B, '52'],
        [AnswerChoice.C, '48'],
        [AnswerChoice.D, '50'],
      ]),
      AnswerChoice.UNANSWERED,          
    ); // Replace `UNANSWERED` with the correct answer.
  }
  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'What date does Christmas fall on?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'December 25th'],
        [AnswerChoice.B, 'December 24th'],
        [AnswerChoice.C, 'December 26th'],
        [AnswerChoice.D, 'December 23rd'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
}
