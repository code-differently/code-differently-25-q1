import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';

export class DylanLaffertyQuiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'dylanlafferty';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [
      DylanLaffertyQuiz.makeQuestion0(),
      DylanLaffertyQuiz.makeQuestion1(),
      DylanLaffertyQuiz.makeQuestion2(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'What is the Power supply unit most compared to when comparing it to a human body?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Heart'],
        [AnswerChoice.B, 'Arm'],
        [AnswerChoice.C, 'Leg'],
        [AnswerChoice.D, 'Brain'],
      ]),
      AnswerChoice.UNANSWERED,
    );
  }
  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      'What is the full name of CPU?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Central Place Unit'],
        [AnswerChoice.B, 'Certified Processing Unit'],
        [AnswerChoice.C, 'Central Processing Unit'],
        [AnswerChoice.D, 'Configured Procerdale Unicode'],
      ]),
      AnswerChoice.UNANSWERED,
    );
  }

  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'What is used to keep Short term memory in a computer?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Hard Drive'],
        [AnswerChoice.B, 'SSD'],
        [AnswerChoice.C, 'GPU'],
        [AnswerChoice.D, 'RAM'],
      ]),
      AnswerChoice.UNANSWERED,
    );
  }
}
