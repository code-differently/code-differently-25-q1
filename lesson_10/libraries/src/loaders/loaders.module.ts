import { Module } from '@nestjs/common';

import { AnanatawasLoader } from './ananatawa_loader.js';
import { AnthonyMaysLoader } from './anthony_mays_loader.js';

export const Loaders = Symbol.for('Loaders');

const LOADER_PROVIDERS = [AnthonyMaysLoader, AnanatawasLoader];


@Module({
  providers: [
    ...LOADER_PROVIDERS,
    {
      provide: Loaders,
      useFactory: (...args) => [...args],
      inject: LOADER_PROVIDERS,
    },
  ],
  exports: [Loaders],
})
export class LoadersModule {}
