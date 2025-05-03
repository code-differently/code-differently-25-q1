import { NestFactory } from '@nestjs/core';
import { NestExpressApplication } from '@nestjs/platform-express';
import { DocumentBuilder, SwaggerModule } from '@nestjs/swagger';
import { AppModule } from './app.module';

async function bootstrap() {
  const app = await NestFactory.create<NestExpressApplication>(AppModule);
  app.enableCors();
  app.set('trust proxy', 'loopback'); // Trust requests from the loopback address

  const config = new DocumentBuilder()
    .setTitle('Library API')
    .setDescription('An API for managing a library of media items')
    .setVersion('1.0')
    .addTag('library')
    .build();
  const documentFactory = () => SwaggerModule.createDocument(app, config);
  SwaggerModule.setup('api', app, documentFactory);

  await app.listen(3000);
}

bootstrap();
