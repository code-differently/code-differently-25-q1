import { setupClerkTestingToken } from '@clerk/testing/cypress';

describe('Authentication Flow', () => {
  beforeEach(() => {
    setupClerkTestingToken();

    cy.visit('/'); // Visit the homepage

    // Use our custom command to login with Clerk testing
    cy.clerkSignIn({
      strategy: 'email_code',
      identifier: 'testbot123+clerk_test@gmail.com', // Use a test email that Clerk recognizes
    });
  });

  it('should successfully login to the homepage', () => {
    // Verify the Todo App components are visible (adjust selector to match your app)
    cy.origin('http://localhost:3000', () => {
      cy.contains('Todo App', { timeout: 5000 }).should('be.visible');
    });
  });
});
