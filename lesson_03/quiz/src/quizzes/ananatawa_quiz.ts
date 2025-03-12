import {
    AnswerChoice,
    MultipleChoiceQuizQuestion,
    QuizQuestion,
    QuizQuestionProvider,
} from 'codedifferently-instructional';

export class AnanatawaQuiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'awatanana';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [
      AnanatawaQuiz.makeQuestion0(),
      AnanatawaQuiz.makeQuestion1(),
      AnanatawaQuiz.makeQuestion2(),
      AnanatawaQuiz.makeQuestion3(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'What is a pull request?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A,'When someone asks to add their changes to the main project.'],
        [AnswerChoice.B,'A personal copy of someone elses project that you can make changes to.'],
        [AnswerChoice.C,'A toolbox where you can write, commit, and push code.'],
        [AnswerChoice.D, 'A request to pull the plug on a project.'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      'What does the command git status do?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Make a new git repository'],
        [AnswerChoice.B, 'Checks the status of your repository'],
        [AnswerChoice.C, 'Stage a file for commit'],
        [AnswerChoice.D, 'List all branches in the repository'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'What does the command git pull origin do?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Push the latest changes from the remote repo.'],
        [AnswerChoice.B, 'Pull the latest changes from the remote repo.'],
        [AnswerChoice.C, 'Display the definition for Git.'],
        [AnswerChoice.D, 'Stage a file for commit.'],
     ]),
        AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion3(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      3,
      'What was the first homework assignment that Mr. Mays assigned Cohort 25.1?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Make an account on GitHub.com'],
        [AnswerChoice.B, 'Convert a Markdown file into HTML.'],
        [AnswerChoice.C, 'Create a personal README and submit via GitHub.'],
        [AnswerChoice.D,'Create a personal README and push to Github via VS Code.'],
      ]),
        AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
}
