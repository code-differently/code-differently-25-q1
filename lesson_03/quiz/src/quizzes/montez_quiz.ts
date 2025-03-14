import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';

export class MontezBradleyQuiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'montezbradley';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [
      MontezBradleyQuiz.makeQuestion0(),
      MontezBradleyQuiz.makeQuestion1(),
      MontezBradleyQuiz.makeQuestion2(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'What Git command is used to check the current status of a repository?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'git status'],
        [AnswerChoice.B, 'git info'],
        [AnswerChoice.C, 'git check-status'],
        [AnswerChoice.D, 'git current'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      'How would you commit your code',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'git commit -m "" '],
        [AnswerChoice.B, 'git info'],
        [AnswerChoice.C, 'git commit'],
        [AnswerChoice.D, 'git add git commit -m "Your commit message'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'How would you push your vs code main to replace your main branch in github ',
      new Map<AnswerChoice, string>([
        [
          AnswerChoice.A,
          'pull your commits to vs code, git reset --hard upstream/main, then git push --force',
        ],
        [AnswerChoice.B, 'git  reset, then git push --force'],
        [AnswerChoice.C, 'git info, then git pull, final step is git push'],
        [AnswerChoice.D, 'git push after that git reset then git pull'],
      ]),
      AnswerChoice.UNANSWERED,
    );
  }
}
