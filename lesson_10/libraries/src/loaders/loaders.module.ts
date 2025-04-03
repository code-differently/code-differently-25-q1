import { Module } from '@nestjs/common';
import { AnthonyMaysLoader } from './anthony_mays_loader.js';
import { BryanaSingletonBarnhartLoader } from './bryana_singleton_barnhart_loader.js';
import { ChanelHuttLoader } from './chanel_hutt_loader.js';
import { DavidAdenaikeLoader } from './david_adenaike_loader.js';
import { DavisDLoader } from './davis_d_loader.js';
import { DylanLaffertysLoader } from './dylan_lafferty_loaders.js';
import { NiaPackLoader } from './nia_pack_loader.js';
import { JBeyLoader } from './JBey_loader.js';
import { KarenAlabiLoader } from './karen_alabi_loader.js';
import { MercedesMathewsLoader } from './mercedes_mathews_loader.js';
import { RasheedMillerLoader } from './rasheed_miller_loader.js';
import { MontezBLoader } from './montez_b_loaders.js';
import { JasonWatsonLoader } from './jason_watson_loader.js';
import { OliviaJamesLoader } from './olivia_james_loader.js';

export const Loaders = Symbol.for('Loaders');

const LOADER_PROVIDERS = [
  AnthonyMaysLoader,
  NiaPackLoader,
  BryanaSingletonBarnhartLoader,
  DylanLaffertysLoader,
  DavisDLoader,
  ChanelHuttLoader,
  JBeyLoader,
  MercedesMathewsLoader,
  JasonWatsonLoader,
  KarenAlabiLoader,
  RasheedMillerLoader,
  DavidAdenaikeLoader,
  MontezBLoader,
  OliviaJamesLoader
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
