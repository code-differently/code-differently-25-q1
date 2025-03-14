import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';

export class ChanelHuttQuiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'chanelhutt';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [
      ChanelHuttQuiz.makeQuestion0(),
      ChanelHuttQuiz.makeQuestion1(),
      ChanelHuttQuiz.makeQuestion2(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'Which one is not a purpose for git commit?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'To save changes to your local repository'],
        [
          AnswerChoice.B,
          'To provide a clear, descriptive message for the changes made',
        ],
        [AnswerChoice.C, 'To clear the terminal and re-type the command'],
        [AnswerChoice.D, 'Keeps track of changes made to your code'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      'Which answer best fits the command git push?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'To move the code to the trash'],
        [
          AnswerChoice.B,
          'To transfer files from the local repository to remote repository hosting services',
        ],
        [AnswerChoice.C, 'To add comments to the code'],
        [AnswerChoice.D, 'To merge several branches into one branch'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'Which command is used to update the yourlocal repository with changes from your remote repository?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'git fetch upstream'],
        [AnswerChoice.B, 'git pull'],
        [AnswerChoice.C, 'git commit'],
        [AnswerChoice.D, 'git checkout main'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
}
