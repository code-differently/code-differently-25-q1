import { Module } from '@nestjs/common';

import { AnthonyMaysLoader } from './anthony_mays_loader.js';
import { MontezBLoader } from './montez_b_loader.js';


export const Loaders = Symbol.for('Loaders');

const LOADER_PROVIDERS = [AnthonyMaysLoader, MontezBLoader];



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
