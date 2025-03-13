import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';

export class JeremiahWingQuiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'jeremiahwing';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [
      JeremiahWingQuiz.makeQuestion0(),
      JeremiahWingQuiz.makeQuestion1(),
      JeremiahWingQuiz.makeQuestion2(),
      JeremiahWingQuiz.makeQuestion3(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'What does the SRC element stand for?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Source'],
        [AnswerChoice.B, 'Script'],
        [AnswerChoice.C, 'Style'],
        [AnswerChoice.D, 'Section'],
      ]),
      AnswerChoice.UNANSWERED,
    );
  }

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      'What does the git fetch command do?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Downloads objects and refs from another repository'],
        [AnswerChoice.B, 'Merges changes from another branch'],
        [AnswerChoice.C, 'Commits changes to the local repository'],
        [AnswerChoice.D, 'Deletes a branch from the repository'],
      ]),
      AnswerChoice.UNANSWERED,
    );
  }

  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'What does the git pull command do?',
      new Map<AnswerChoice, string>([
        [
          AnswerChoice.A,
          'Fetches from and integrates with another repository or a local branch',
        ],
        [AnswerChoice.B, 'Merges changes from another branch'],
        [AnswerChoice.C, 'Commits changes to the local repository'],
        [AnswerChoice.D, 'Deletes a branch from the repository'],
      ]),
      AnswerChoice.UNANSWERED,
    );
  }

  private static makeQuestion3(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      3,
      'What does the git push command do?',
      new Map<AnswerChoice, string>([
        [
          AnswerChoice.A,
          'Uploads local repository content to a remote repository',
        ],
        [AnswerChoice.B, 'Merges changes from another branch'],
        [AnswerChoice.C, 'Commits changes to the local repository'],
        [AnswerChoice.D, 'Downloads objects and refs from another repository'],
      ]),
      AnswerChoice.UNANSWERED,
    );
  }
}