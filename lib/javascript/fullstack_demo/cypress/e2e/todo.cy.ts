import { setupClerkTestingToken } from '@clerk/testing/cypress';

describe('Todo App Functionality', () => {
  beforeEach(() => {
    setupClerkTestingToken();

    cy.visit('/'); // Visit the homepage

    // Use our custom command to login with Clerk testing
    cy.clerkSignIn({
      strategy: 'email_code',
      identifier: 'testbot123+clerk_test@gmail.com', // Use a test email that Clerk recognizes
    });
  });

  it('should allow adding a new todo item', () => {
    cy.origin('http://localhost:3000', () => {
      // Create a unique todo item
      const todoText = `Test Todo ${Date.now()}`;

      // Find the input field and type the text
      cy.get('input[placeholder*="Add"]').type(todoText);

      // Submit the form (either by clicking a button or pressing Enter)
      cy.get('form').submit();
      // Or use this if the form doesn't have a submit button: cy.get('input').type('{enter}');

      // Verify the new todo appeared in the list
      cy.contains(todoText).should('be.visible');
    });
  });

  it('should allow marking a todo item as completed', () => {
    cy.origin('http://localhost:3000', () => {
      // First, ensure there is at least one todo item to mark as completed
      cy.get('.todo').last().as('lastTodo');

      // Click the checkbox or toggle button to mark it as completed
      cy.get('@lastTodo').find('input[type="checkbox"]').check();

      // Verify the todo item is marked as completed (adjust selector as needed)
      cy.get('@lastTodo').find('input[type="checkbox"]').should('be.checked');
    });
  });
});
