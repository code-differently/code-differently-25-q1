import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module.js';
import { MediaCollectionApp } from './cli/media_collection_app.js';

async function bootstrap() {
  const app = await NestFactory.createApplicationContext(AppModule);
  const cliApp = app.get(MediaCollectionApp);
  cliApp.run();
  return app.close();
}

bootstrap();
