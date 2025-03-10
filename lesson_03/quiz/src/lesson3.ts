import { INestApplicationContext } from '@nestjs/common';
import { NestFactory } from '@nestjs/core';
import { QuizPrinter, QuizQuestion } from 'codedifferently-instructional';
import { AppModule } from './app.module.js';
import { Quizzes } from './quizzes/quizzes.module.js';

async function bootstrap() {
  const app = await NestFactory.createApplicationContext(AppModule);
  run(app);
  return app.close();
}

function run(app: INestApplicationContext) {
  const quizzes = app.get(Quizzes);

  for (const quiz of quizzes) {
    console.log('\nQuestions by ' + quiz.getProviderName() + ':');
    printQuiz(quiz.makeQuizQuestions());
  }
}

function printQuiz(quizQuestions: Iterable<QuizQuestion>) {
  const printer = new QuizPrinter();
  printer.printQuiz(quizQuestions);
}

bootstrap();
