import { Module } from '@nestjs/common';
import { QuizzesModule } from './quizzes/quizzes.module.js';

@Module({
  imports: [QuizzesModule],
})
export class AppModule {}
