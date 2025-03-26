import { Module } from '@nestjs/common';
import { CliModule } from './cli/cli.module.js';

@Module({
  imports: [CliModule],
})
export class AppModule {}
