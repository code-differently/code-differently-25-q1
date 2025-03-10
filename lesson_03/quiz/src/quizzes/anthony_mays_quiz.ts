import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';

export class AnthonyMaysQuiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'anthonymays';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [AnthonyMaysQuiz.makeQuestion0(), AnthonyMaysQuiz.makeQuestion1()];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'What is a multiple choice question?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'A question about agency'],
        [AnswerChoice.B, 'The hardest kind of quiz question there is'],
        [
          AnswerChoice.C,
          'A question that can be answered using one or more provided choices',
        ],
        [AnswerChoice.D, 'Whatever you want it to be!'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion1(): QuizQuestion {
    return new QuizQuestion(
      1,
      'What is a computer?',
      'A machine that automatically transforms input into output.',
    ); // Provide an answer.
  }
}
