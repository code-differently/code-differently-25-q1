import {
    AnswerChoice,
    MultipleChoiceQuizQuestion,
    QuizQuestion,
    QuizQuestionProvider,
} from 'codedifferently-instructional';

export class JasonWatsonQuiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'jasonwatson';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [
      JasonWatsonQuiz.makeQuestion0(),
      JasonWatsonQuiz.makeQuestion1(),
      JasonWatsonQuiz.makeQuestion2(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'How much MB of memory is equal to 1GB of RAM',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, '500MB'],
        [AnswerChoice.B, '1024MB'],
        [AnswerChoice.C, '2048MB'],
        [AnswerChoice.D, '1000MB'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      'What is Visual Studio Code primarily used for',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Graphic Design'],
        [AnswerChoice.B, 'Word Processing'],
        [AnswerChoice.C, 'Code Editing'],
        [AnswerChoice.D, 'Video Prodection'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }

  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'What file is commonly used to provide instructions or documenttation in a GitHub repository',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'README.md'],
        [AnswerChoice.B, 'INSTRUCTIONS.txt'],
        [AnswerChoice.C, 'GUIDE.pdf'],
        [AnswerChoice.D, 'DOCS.docx'],
      ]),
      AnswerChoice.UNANSWERED,
    ); // Replace `UNANSWERED` with the correct answer.
  }
}
