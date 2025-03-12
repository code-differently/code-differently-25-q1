import { Module } from '@nestjs/common';
import { AnotherQuiz } from './another_quiz.js';
import { AnthonyMaysQuiz } from './anthony_mays_quiz.js';
import { MeikoStephensQuiz } from './meiko_stephens_quiz.js';
import { Jbeyquiz } from './jbeyquiz.js';
import { MercedesMathewsQuiz } from './mercedes_mathews_quiz.js';
import { DavidAdenaikeQuiz } from './david_adenaike_quiz.js';
import { RasheedMillerQuiz } from './rasheed_miller_quiz.js';

export const Quizzes = Symbol.for('Quizzes');

// Add your quiz provider here.
const QUIZ_PROVIDERS = [
  AnthonyMaysQuiz,
  AnotherQuiz, 
  MeikoStephensQuiz ,
  MercedesMathewsQuiz,
  Jbeyquiz,
  DavidAdenaikeQuiz,
  RasheedMillerQuiz,
];

@Module({
  providers: [
    ...QUIZ_PROVIDERS,
    {
      provide: Quizzes,
      useFactory: (...args) => [...args],
      inject: QUIZ_PROVIDERS,
    },
  ],
})
export class QuizzesModule {}
