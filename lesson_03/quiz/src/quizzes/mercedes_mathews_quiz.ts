import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';

export class MercedesMathewsQuiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'mercedesmathews';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [
      MercedesMathewsQuiz.makeQuestion0(),
      MercedesMathewsQuiz.makeQuestion1(),
      MercedesMathewsQuiz.makeQuestion2(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'Which HTML tag is used for a secondary header?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, '<h1>'],
        [AnswerChoice.B, '<h2>'],
        [AnswerChoice.C, '<h3>'],
        [AnswerChoice.D, '<h4>'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      'Which HTML tag makes text bold?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, '<strong>'],
        [AnswerChoice.B, '<b>'],
        [AnswerChoice.C, 'Both of the above'],
        [AnswerChoice.D, 'Neither of the above'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'Which HTML tag is not a void element and needs a closing tag?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, '<img>'],
        [AnswerChoice.B, '<br>'],
        [AnswerChoice.C, '<link>'],
        [AnswerChoice.D, '<a>'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
}
