import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';

export class NiaPackquiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'niapack';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [
      NiaPackquiz.makeQuestion0(),
      NiaPackquiz.makeQuestion1(),
      NiaPackquiz.makeQuestion2(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'What is branching? Why is it important?',
      new Map<AnswerChoice, string>([
        [
          AnswerChoice.A,
          'It is when a tree grows and is important to make the sky look beautiful',
        ],
        [
          AnswerChoice.B,
          'It is when you create a seperate copy of a code and is important because it doesnt affect the main version and makes it easier to work with a team',
        ],
        [
          AnswerChoice.C,
          'It is when you delete all previous versions of your code and is important so you dont have to start from scratch',
        ],
        [
          AnswerChoice.D,
          'It is merging all changes directly into the main code and is important because it speeds up develpoment by avoiding unnecessary review or debugging steps',
        ],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      'Which programming languages can you use in VS code?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Only Python'],
        [AnswerChoice.B, 'Only JavaScript'],
        [AnswerChoice.C, 'Multiple languages like Python, JavaScript, and C++'],
        [AnswerChoice.D, 'C++'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'What is a pull request request on GitHub?',
      new Map<AnswerChoice, string>([
        [
          AnswerChoice.A,
          'A way to merge changes from one branch into another after review',
        ],
        [AnswerChoice.B, 'A command to delete a branch permanently'],
        [AnswerChoice.C, 'A method for creating a local  copy of a repository'],
        [AnswerChoice.D, 'A tool to schedule automatic repository backups'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
}
