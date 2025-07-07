import { clerkSetup } from '@clerk/testing/cypress';
import { defineConfig } from 'cypress';
import { configureVisualRegression } from 'cypress-visual-regression';

export default defineConfig({
  component: {
    devServer: {
      framework: 'next',
      bundler: 'webpack',
    },
    env: {
      visualRegressionType: 'regression',
    },
    screenshotsFolder: './cypress/snapshots/actual',
    setupNodeEvents(on, config) {
      configureVisualRegression(on);
    },
  },
  e2e: {
    baseUrl: 'http://localhost:3000',
    setupNodeEvents(on, config) {
      configureVisualRegression(on);
      return clerkSetup({ config });
    },
    env: {
      visualRegressionType: 'regression',
    },
    screenshotsFolder: './cypress/snapshots/actual',
  },
});
