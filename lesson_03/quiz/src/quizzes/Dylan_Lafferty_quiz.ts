  import {
  AnswerChoice,
  MultipleChoiceQuizQuestion,
  QuizQuestion,
  QuizQuestionProvider,
} from 'codedifferently-instructional';
  
  
  getProviderName(): string {
    return 'dylanlafferty';
  }

  makeQuizQuestions(): QuizQuestion[] {
    return [DylanLaffertyQuiz.makeQuestion0(), DylanLaffertyQuiz.makeQuestion0()];
  }

  private static makeQuestion0(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      0,
      'What is the next upcoming holiday?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'St. Patricks Day'],
        [AnswerChoice.B, 'Valentines Day'],
        [AnswerChoice.C, 'Halloween'],
        [AnswerChoice.D, '4th of July'],
      ]),
      AnswerChoice.UNANSWERED,
    );

  private static makeQuestion1(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      1,
      'What food is traditionally eaten on St Patricks Day?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Tacos'],
        [AnswerChoice.B, 'Pizza'],
        [AnswerChoice.C, 'Corned Beef and Cabbage'],
        [AnswerChoice.D, 'Lasagna'],
      ]),
      AnswerChoice.UNANSWERED,
    );
  }

  private static makeQuestion2(): QuizQuestion {
    return new MultipleChoiceQuizQuestion(
      2,
      'What is the mascot of St Patricks Day?',
      new Map<AnswerChoice, string>([
        [AnswerChoice.A, 'Bunny'],
        [AnswerChoice.B, 'St. Nicholas'],
        [AnswerChoice.C, 'Turkey'],
        [AnswerChoice.D, 'Leprechaun'],
      ]),
      AnswerChoice.UNANSWERED,
    );
  }
