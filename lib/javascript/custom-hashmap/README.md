# Custom HashMap Implementation

A TypeScript implementation of a HashMap data structure using separate chaining for collision resolution.

## Features

- **Generic Implementation**: Supports any key-value types
- **Collision Resolution**: Uses separate chaining with linked lists
- **Dynamic Resizing**: Automatically resizes when load factor exceeds 0.75
- **Comprehensive API**: Full set of operations (put, get, delete, has, clear, etc.)
- **Type Safety**: Full TypeScript support with type checking
- **Performance Monitoring**: Built-in methods to check size, capacity, and load factor

## Installation

```bash
npm install
```

## Usage

### Basic Operations

```typescript
import { CustomHashMap } from './src/HashMap';

// Create a new HashMap
const map = new CustomHashMap<string, number>();

// Add key-value pairs
map.put('apple', 5);
map.put('banana', 3);
map.put('orange', 8);

// Get values
const appleCount = map.get('apple'); // 5
const grapeCount = map.get('grape'); // undefined

// Check if key exists
const hasApple = map.has('apple'); // true
const hasGrape = map.has('grape'); // false

// Update existing key
map.put('apple', 10); // Updates existing value

// Delete a key
const deleted = map.delete('banana'); // true
const deletedAgain = map.delete('banana'); // false

// Get size
const size = map.getSize(); // 2
```

### Working with Different Data Types

```typescript
// String keys with object values
interface Person {
  name: string;
  age: number;
}

const people = new CustomHashMap<string, Person>();
people.put('john', { name: 'John Doe', age: 30 });
people.put('jane', { name: 'Jane Smith', age: 25 });

// Mixed key types
const mixed = new CustomHashMap<string | number, string>();
mixed.put('stringKey', 'value1');
mixed.put(42, 'value2');
```

### Iteration Methods

```typescript
const map = new CustomHashMap<string, number>();
map.put('a', 1);
map.put('b', 2);
map.put('c', 3);

// Get all keys
const keys = map.keys(); // ['a', 'b', 'c']

// Get all values
const values = map.values(); // [1, 2, 3]

// Get all entries
const entries = map.entries(); // [['a', 1], ['b', 2], ['c', 3]]
```

### Monitoring Performance

```typescript
const map = new CustomHashMap<string, number>();

// Check current statistics
console.log('Size:', map.getSize());
console.log('Capacity:', map.getCapacity());
console.log('Load Factor:', map.getLoadFactor());

// Print internal structure for debugging
map.printTable();
```

## API Reference

### Constructor

- `new CustomHashMap<K, V>(initialCapacity?: number)`: Creates a new HashMap with optional initial capacity (default: 16)

### Methods

- `put(key: K, value: V): void`: Insert or update a key-value pair
- `get(key: K): V | undefined`: Get value by key
- `has(key: K): boolean`: Check if key exists
- `delete(key: K): boolean`: Remove a key-value pair, returns true if successful
- `clear(): void`: Remove all entries
- `keys(): K[]`: Get array of all keys
- `values(): V[]`: Get array of all values
- `entries(): [K, V][]`: Get array of all key-value pairs
- `getSize(): number`: Get current number of entries
- `getCapacity(): number`: Get current bucket array size
- `getLoadFactor(): number`: Get current load factor (size/capacity)
- `printTable(): void`: Print internal structure for debugging

## Running the Examples

### Demo Script
```bash
npm run dev
# or
npm start
```

### Test Suite
```bash
npm test
```

### Build Project
```bash
npm run build
```

## Implementation Details

### Hash Function
Uses the djb2 algorithm for string hashing, which provides good distribution and minimal collisions.

### Collision Resolution
Implements separate chaining using linked lists. When multiple keys hash to the same bucket, they are stored in a linked list at that bucket.

### Load Factor Management
Automatically resizes the hash table when the load factor exceeds 0.75 to maintain good performance. Resizing doubles the capacity and rehashes all existing entries.

### Time Complexity
- **Average Case**: O(1) for put, get, delete operations
- **Worst Case**: O(n) when all keys hash to the same bucket
- **Space Complexity**: O(n) where n is the number of key-value pairs

## Files Structure

```
src/
├── HashMap.ts     # Main HashMap implementation
├── index.ts       # Export file
├── demo.ts        # Comprehensive demo script
└── test.ts        # Test suite
```

## License

MIT
