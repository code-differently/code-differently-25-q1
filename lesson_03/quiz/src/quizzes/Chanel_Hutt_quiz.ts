import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  MultipleQuestionnaireProvider,
  QuizQuestion,
} from 'codedifferently-instructional';

export class ChanelHuttQuiz implements MultipleQuestionnaireProvider {
  getProviderName(): string {
    return 'multiplequestionnaire';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [ChanelHuttQuiz.makeQuestion0(), ChanelHuttQuiz.makeQuestion1()];
  }

  private static makeQuestion0(): MultipleQuestionnaire {
    return new MultipleChoiceQuizQuestion(
      0,
      'When do you commit your code?',
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

  private static makeQuestion0(): MultipleQuestionnaire {
    return new MultipleChoiceQuizQuestion(
      1,
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

  private static makeQuestion0(): MultipleQuestionnaire {
    return new MultipleChoiceQuizQuestion(
      2,
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
}
