import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';

export class DavisDQuiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'davisdarius';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [
      DavisDQuiz.makeQuestion0(),
      DavisDQuiz.makeQuestion1(),
      DavisDQuiz.makeQuestion2(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'What should you not be doing during a Tech Talk?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Talk Amongst Friends'],
        [AnswerChoice.B, 'Take Notes'],
        [AnswerChoice.C, 'Ask speaker questions'],
        [AnswerChoice.D, 'Be attentive'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      '3 Levels of Tech Talk',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Push, Pull, Punch'],
        [AnswerChoice.B, 'Pay, Listen, Persuade'],
        [AnswerChoice.C, 'Purpose, Prep, Show-up'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Provide an answer.
  }

  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'During Tech Talks should you be marketing yourself to secure a job?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'No'],
        [AnswerChoice.B, 'Yes'],
        [AnswerChoice.C, 'Maybe'],
        [AnswerChoice.D, 'IDK'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Provide an answer.
  }
}
