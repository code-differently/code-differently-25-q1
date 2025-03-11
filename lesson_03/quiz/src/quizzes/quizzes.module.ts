import { Module } from '@nestjs/common';
import { AnotherQuiz } from './another_quiz.js';
import { AnthonyMaysQuiz } from './anthony_mays_quiz.js';
lesson_03
import { Bryanasingletonbarnhart } from './ bryana_singleton-barnhart_quiz.js';

import { Jbeyquiz } from './jbeyquiz.js';
import { MercedesMathewsQuiz } from './mercedes_mathews_quiz.js';

export const Quizzes = Symbol.for('Quizzes');

// Add your quiz provider here.
 lesson_03
const QUIZ_PROVIDERS = [AnthonyMaysQuiz, AnotherQuiz, Bryanasingletonbarnhart];

const QUIZ_PROVIDERS = [
  AnthonyMaysQuiz,
  AnotherQuiz,
  MercedesMathewsQuiz,
  Jbeyquiz,
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
