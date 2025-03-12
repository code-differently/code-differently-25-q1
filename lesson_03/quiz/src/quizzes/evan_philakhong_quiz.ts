import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';

export class EvanPhilakhongQuiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'evanphilakhong';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [
      EvanPhilakhongQuiz.makeQuestion0(),
      EvanPhilakhongQuiz.makeQuestion1(),
      EvanPhilakhongQuiz.makeQuestion2(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'What is a CPU?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Computer Power Unit'],
        [AnswerChoice.B, 'Complex Processing Unit'],
        [AnswerChoice.C, 'Central Processing Unit'],
        [AnswerChoice.D, 'Coding Processor Unit'],
      ]),
      AnswerChoice.UNANSWERED, // replace UNANSWERED with correct answer
    );
  }

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      'What is a GPU?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Graphics Processing Unit'],
        [AnswerChoice.B, 'Gaming Power Unit'],
        [AnswerChoice.C, 'Graphical Programming Unit'],
        [AnswerChoice.D, 'Gaming Processor Unit'],
      ]),
      AnswerChoice.UNANSWERED, // replace UNANSWERED with correct answer
    );
  }

  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'What is a PSU?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Programming Super Unit'],
        [AnswerChoice.B, 'Power Supply Unit'],
        [AnswerChoice.C, 'Power Supplier Unit'],
        [AnswerChoice.D, 'Power Storing Unit'],
      ]),
      AnswerChoice.UNANSWERED, // repleace UNANSWERED with correct answer
    );
  }
}
