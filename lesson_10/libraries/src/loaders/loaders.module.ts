import { Module } from '@nestjs/common';

import { AnthonyMaysLoader } from './anthony_mays_loader.js';
import { ChanelHuttLoader } from './chanel_hutt_loader.js';
import { DavidAdenaikeLoader } from './david_adenaike_loader.js';
import { DavisDLoader } from './davis_d_loader.js';
import { DylanLaffertysLoader } from './dylan_lafferty_loaders.js';
import { MercedesMathewsLoader } from './mercedes_mathews_loader.js';
import { MontezBLoader } from './montez_b_loaders.js';
export const Loaders = Symbol.for('Loaders');

const LOADER_PROVIDERS = [
  AnthonyMaysLoader,
  DylanLaffertysLoader,
  DavisDLoader,
  ChanelHuttLoader,
  MercedesMathewsLoader,
  DavidAdenaikeLoader,
  MontezBLoader
];

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
