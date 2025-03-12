import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';

export class OliviaJamesQuiz implements QuizQuestionProvider {
  getProviderName(): string {
    return 'oliviajames';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [
      OliviaJamesQuiz.makeQuestion0(),
      OliviaJamesQuiz.makeQuestion1(),
      OliviaJamesQuiz.makeQuestion2(),
    ];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'Which CSS property is used to change the font size of an element?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'text-size'],
        [AnswerChoice.B, 'font-size'],
        [AnswerChoice.C, 'size'],
        [AnswerChoice.D, 'font-weight'],
      ]),
      AnswerChoice.UNANSWERED,
    );
  }

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      'Which of the following is the correct syntax for a CSS comment??',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, '// This is a comment'],
        [AnswerChoice.B, ' /* This is a comment */'],
        [AnswerChoice.C, '# This is a comment'],
        [AnswerChoice.D, '<!-- This is a comment -->'],
      ]),
      AnswerChoice.UNANSWERED,
    );
  }

  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'Which tag is used to create an unordered list in HTML?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, '<ol>'],
        [AnswerChoice.B, '<ul>'],
        [AnswerChoice.C, '<li>'],
        [AnswerChoice.D, '<list>'],
      ]),
      AnswerChoice.UNANSWERED,
    );
  }
}
