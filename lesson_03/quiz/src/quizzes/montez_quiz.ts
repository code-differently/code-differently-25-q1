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
      'What command is used to save all changes and create a commit in Git?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'git status'],
        [AnswerChoice.B, 'git info'],
        [AnswerChoice.C, 'git check-status'],
        [AnswerChoice.D, 'git add git commit -m "Your commit message'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'What Git command is used to check the current status of a repository',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'git status'],
        [AnswerChoice.B, 'git  verify'],
        [AnswerChoice.C, 'git info'],
        [AnswerChoice.D, 'git check-status'],
      ]),
      AnswerChoice.UNANSWERED,
    ); 
  }

}
