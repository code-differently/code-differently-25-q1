import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';

export class KarensQuiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'karenalabi';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [
      KarensQuiz.makeQuestion0(),
      KarensQuiz.makeQuestion1(),
      KarensQuiz.makeQuestion2(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'What does GPU stand for?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Graphical Processing Unit'],
        [AnswerChoice.B, 'Gaming Processing Unit'],
        [AnswerChoice.C, 'General Preserving Unit'],
        [AnswerChoice.D, 'George P. Underwood'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      'Which of the following best describes a computer?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Karen from Spongebob'],
        [
          AnswerChoice.B,
          'A machine that automatically transforms input data into output data using pre-programmed instructions',
        ],
        [
          AnswerChoice.C,
          'A high-tech calculator that only performs basic arithmetic operations like addition and subtraction, making it useful only for solving math problems',
        ],
        [
          AnswerChoice.D,
          'A microwave with a keyboard that heats up data instead of food',
        ],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Provide the correct answer.
  }

  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'What is the motherboard?',
      new Map<AnswerChoice, string>([
        [
          AnswerChoice.A,
          'A big chip that controls how fast your computer runs.',
        ],
        [
          AnswerChoice.B,
          'The part of the computer that generates electricity to power all the other components.',
        ],
        [
          AnswerChoice.C,
          'The main circuit board of a computer that houses the CPU, memory, and other essential components.',
        ],
        [
          AnswerChoice.D,
          'The board that a mother uses to control the computer.',
        ],
      ]),
      AnswerChoice.UNANSWERED,
    );
  }
}
