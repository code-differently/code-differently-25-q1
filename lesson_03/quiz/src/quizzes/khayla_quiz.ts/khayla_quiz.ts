import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';

export class khayla_quiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'khayla_quiz';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [khayla_saundersquiz.makeQuestion0(), khayla_quiz.makeQuestion1()];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'Your team is working on a shared Git repository. Which of the following is not the best practices to follow for smooth collaboration?',
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
      'What is the capital of the United States?',
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
