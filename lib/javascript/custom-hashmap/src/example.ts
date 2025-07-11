import { CustomHashMap } from './HashMap';

/**
 * Simple example demonstrating basic HashMap usage
 */
console.log('🚀 Custom HashMap Quick Example\n');

// Create a new HashMap
const inventory = new CustomHashMap<string, number>();

// Add some items
console.log('Adding items to inventory...');
inventory.put('apples', 50);
inventory.put('bananas', 30);
inventory.put('oranges', 25);
inventory.put('grapes', 40);

console.log(`Total items in inventory: ${inventory.getSize()}`);

// Check stock levels
console.log('\nChecking stock levels:');
console.log(`Apples: ${inventory.get('apples')}`);
console.log(`Bananas: ${inventory.get('bananas')}`);
console.log(`Mangoes: ${inventory.get('mangoes') || 'Out of stock'}`);

// Update stock
console.log('\nUpdating apple stock...');
inventory.put('apples', 75);
console.log(`New apple stock: ${inventory.get('apples')}`);

// Remove an item
console.log('\nRemoving bananas from inventory...');
inventory.delete('bananas');
console.log(`Bananas in stock: ${inventory.has('bananas') ? 'Yes' : 'No'}`);

// List all items
console.log('\nCurrent inventory:');
const items = inventory.entries();
items.forEach(([item, quantity]) => {
  console.log(`  ${item}: ${quantity}`);
});

console.log(`\nFinal inventory size: ${inventory.getSize()}`);
console.log(`Load factor: ${inventory.getLoadFactor().toFixed(3)}`);
