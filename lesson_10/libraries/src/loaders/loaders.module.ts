import { Module } from '@nestjs/common';

import { AnthonyMaysLoader } from './anthony_mays_loader.js';
import { JBeyLoader } from './JBey_loader.js';

export const Loaders = Symbol.for('Loaders');

const LOADER_PROVIDERS = [AnthonyMaysLoader, JBeyLoader];

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
