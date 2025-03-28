import { Module } from '@nestjs/common';
import { DylanLaffertysLoader } from './dylan_lafferty_loaders.js';

import { AnthonyMaysLoader } from './anthony_mays_loader.js';
import { JustinEklundLoader } from './justin_eklund_loader.js';


export const Loaders = Symbol.for('Loaders');

const LOADER_PROVIDERS = [AnthonyMaysLoader, DylanLaffertysLoader,JustinEklundLoader];

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
// got assistance from ai and copilot aswell as Meiko ,Mercedes and Dillon