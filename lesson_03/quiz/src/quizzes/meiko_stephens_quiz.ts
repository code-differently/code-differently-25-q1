import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';

export class MeikoStephensQuiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'meikostephens';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [
      MeikoStephensQuiz.makeQuestion0(),
      MeikoStephensQuiz.makeQuestion1(),
      MeikoStephensQuiz.makeQuestion2(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'What is a branch?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'A new line of code'],
        [
          AnswerChoice.B,
          'A copy of a repository that allows you make changes and merge them later',
        ],
        [AnswerChoice.C, 'A way to delete a respository and start over'],
        [AnswerChoice.D, 'A way to run code'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      'What does a syncfork do?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Updates changes from the original repository'],
        [AnswerChoice.B, 'Deletes the repositiory'],
        [AnswerChoice.C, 'Transforms the repository into a branch'],
        [AnswerChoice.D, 'Runs the code more efficiently'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'What brings the modify changes to merge into the main repositiory?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'A terminal'],
        [AnswerChoice.B, 'A branch'],
        [AnswerChoice.C, 'A syncfork'],
        [AnswerChoice.D, 'A pull request'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
}
