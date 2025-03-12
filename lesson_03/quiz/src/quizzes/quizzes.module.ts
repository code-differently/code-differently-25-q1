import { Module } from '@nestjs/common';
import { Bryanasingletonbarnhart } from './ bryana_singleton-barnhart_quiz.js';
import { AnotherQuiz } from './another_quiz.js';
import { AnthonyMaysQuiz } from './anthony_mays_quiz.js';
import { JasonWatsonQuiz } from './jason_watson_quiz.js';
import { MeikoStephensQuiz } from './meiko_stephens_quiz.js';
import { DavidAdenaikeQuiz } from './david_adenaike_quiz.js';
import { EzraQuiz } from './ezra_quiz.js';
import { Jbeyquiz } from './jbeyquiz.js';
import { KhaylaSaundersQuiz } from './khayla_quiz.js';
import { MercedesMathewsQuiz } from './mercedes_mathews_quiz.js';
import { RasheedMillerQuiz } from './rasheed_miller_quiz.js';

export const Quizzes = Symbol.for('Quizzes');

// Add your quiz provider here.

const QUIZ_PROVIDERS = [
  AnthonyMaysQuiz,
  AnotherQuiz,
  MeikoStephensQuiz,
  MercedesMathewsQuiz,
  Jbeyquiz,
  Bryanasingletonbarnhart,
  EzraQuiz,
  DavidAdenaikeQuiz,
  KhaylaSaundersQuiz,
  RasheedMillerQuiz,
  JasonWatsonQuiz,
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
