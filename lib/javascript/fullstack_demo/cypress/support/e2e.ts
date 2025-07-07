/// <reference types="cypress" />
import { addClerkCommands } from '@clerk/testing/cypress';
import './commands';

// Cypress-specific imports
import 'cypress-visual-regression';
import { addCompareSnapshotCommand } from 'cypress-visual-regression/dist/command';

// Add visual regression testing command
addCompareSnapshotCommand();

// Add Clerk commands for testing
addClerkCommands({ Cypress, cy });

// This ensures TypeScript understands Cypress commands
declare global {
  namespace Cypress {
    interface Chainable {
      // Add any custom command types here
    }
  }
}
