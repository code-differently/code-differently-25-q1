import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';

export class AnotherQuiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'anotherone';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [AnotherQuiz.makeQuestion0(), AnotherQuiz.makeQuestion1()];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'Where in the world is Carmen Sandiego?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Botzwana'],
        [AnswerChoice.B, 'Nigeria'],
        [AnswerChoice.C, 'Brazil'],
        [AnswerChoice.D, 'France'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      'What is the capital of the United States?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Sacramento'],
        [AnswerChoice.B, 'Washington D.C.'],
        [AnswerChoice.C, 'Austin'],
        [AnswerChoice.D, 'Saratoga'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
}
