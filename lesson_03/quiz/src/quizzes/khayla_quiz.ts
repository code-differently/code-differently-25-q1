import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';

export class KhaylaSaundersQuiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'khaylasaunders';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [
      KhaylaSaundersQuiz.makeQuestion0(),
      KhaylaSaundersQuiz.makeQuestion1(),
      KhaylaSaundersQuiz.makeQuestion2(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'Your team is working on a shared Git repository. Which of the following is not the best practice to follow for smooth collaboration?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Always pull before pushing to avoid conflicts.'],
        [
          AnswerChoice.B,
          'Work directly on the main branch to keep the workflow simple.',
        ],
        [AnswerChoice.C, 'Use branches for separate work streams.'],
        [
          AnswerChoice.D,
          'Use Git stash to temporarily save uncommitted changes. ',
        ],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      'When should you use git rebase --skip while resolving conflicts in Git?',
      new Map<AnswerChoice, string>([
        [
          AnswerChoice.A,
          ' When you want to discard the conflicted commit during a rebase.',
        ],
        [AnswerChoice.B, 'When resolving conflicts during a merge.'],
        [
          AnswerChoice.C,
          'When you want to keep the changes from the conflicted commit.',
        ],
        [AnswerChoice.D, 'When you need to undo the last commit '],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'What languge is best to communiate with computers ',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, '0s & 1s '],
        [AnswerChoice.B, 'JavaScript'],
        [AnswerChoice.C, 'Supersets'],
        [AnswerChoice.D, 'Git'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
}
