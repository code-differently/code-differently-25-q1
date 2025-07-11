import { CustomHashMap } from './HashMap';


// CRUD = Create, Read, Update, Delete


/**
 * Demo script showcasing CustomHashMap functionality
 */
function demonstrateHashMap() {
  console.log('🔥 Custom HashMap Demo');
  console.log('=====================\n');

  // 1. Basic Operations
  console.log('1. Basic Operations');
  console.log('-------------------');
  
  const map = new CustomHashMap<string, number>();
  
  // Adding items
  map.put('apple', 5);
  map.put('banana', 3);
  map.put('orange', 8);
  map.put('grape', 12);
  
  console.log('Added items: apple=5, banana=3, orange=8, grape=12');
  console.log(`Size: ${map.getSize()}`);
  
  // Getting items
  console.log(`\nGetting values:`);
  console.log(`apple: ${map.get('apple')}`);
  console.log(`banana: ${map.get('banana')}`);
  console.log(`nonexistent: ${map.get('nonexistent')}`);
  
  // Checking existence
  console.log(`\nChecking existence:`);
  console.log(`Has 'orange': ${map.has('orange')}`);
  console.log(`Has 'kiwi': ${map.has('kiwi')}`);
  
  map.printTable();

  // 2. Updating Values
  console.log('2. Updating Values');
  console.log('------------------');
  
  console.log('Updating apple from 5 to 10');
  map.put('apple', 10);
  console.log(`apple: ${map.get('apple')}`);
  map.printTable();

  // 3. Deletion
  console.log('3. Deletion Operations');
  console.log('----------------------');
  
  console.log('Deleting banana');
  const deleted = map.delete('banana');
  console.log(`Delete successful: ${deleted}`);
  console.log(`Size after deletion: ${map.getSize()}`);
  
  console.log('Trying to delete non-existent item');
  const deletedNonExistent = map.delete('kiwi');
  console.log(`Delete successful: ${deletedNonExistent}`);
  
  map.printTable();

  // 4. Testing with different data types
  console.log('4. Different Data Types');
  console.log('-----------------------');
  
  const mixedMap = new CustomHashMap<string | number, string>();
  
  mixedMap.put('stringKey', 'string value');
  mixedMap.put(42, 'number key');
  mixedMap.put('anotherString', 'another value');
  
  console.log('Mixed key types:');
  console.log(`String key 'stringKey': ${mixedMap.get('stringKey')}`);
  console.log(`Number key 42: ${mixedMap.get(42)}`);
  
  mixedMap.printTable();

  // 5. Object as values
  console.log('5. Objects as Values');
  console.log('--------------------');
  
  interface Person {
    name: string;
    age: number;
  }
  
  const personMap = new CustomHashMap<string, Person>();
  
  personMap.put('john', { name: 'John Doe', age: 30 });
  personMap.put('jane', { name: 'Jane Smith', age: 25 });
  personMap.put('bob', { name: 'Bob Johnson', age: 35 });
  
  console.log('Person objects:');
  const john = personMap.get('john');
  console.log(`John: ${john ? `${john.name}, age ${john.age}` : 'Not found'}`);
  
  personMap.printTable();

  // 6. Collision Testing
  console.log('6. Collision Testing');
  console.log('--------------------');
  
  const smallMap = new CustomHashMap<string, number>(4); // Small capacity to force collisions
  
  // Add many items to force collisions
  const items = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'];
  items.forEach((item, index) => {
    smallMap.put(item, index);
  });
  
  console.log('Added 10 items to a map with initial capacity 4:');
  smallMap.printTable();

  // 7. Iteration methods
  console.log('7. Iteration Methods');
  console.log('--------------------');
  
  console.log('All keys:', map.keys());
  console.log('All values:', map.values());
  console.log('All entries:', map.entries());

  // 8. Performance comparison
  console.log('8. Performance Comparison');
  console.log('-------------------------');
  
  const performanceTest = () => {
    const customMap = new CustomHashMap<number, string>();
    const nativeMap = new Map<number, string>();
    const numItems = 10000;
    
    // Custom HashMap performance
    console.time('CustomHashMap - Insert 10k items');
    for (let i = 0; i < numItems; i++) {
      customMap.put(i, `value${i}`);
    }
    console.timeEnd('CustomHashMap - Insert 10k items');
    
    console.time('CustomHashMap - Get 10k items');
    for (let i = 0; i < numItems; i++) {
      customMap.get(i);
    }
    console.timeEnd('CustomHashMap - Get 10k items');
    
    // Native Map performance
    console.time('Native Map - Insert 10k items');
    for (let i = 0; i < numItems; i++) {
      nativeMap.set(i, `value${i}`);
    }
    console.timeEnd('Native Map - Insert 10k items');
    
    console.time('Native Map - Get 10k items');
    for (let i = 0; i < numItems; i++) {
      nativeMap.get(i);
    }
    console.timeEnd('Native Map - Get 10k items');
    
    console.log(`\nCustom HashMap final stats:`);
    console.log(`Size: ${customMap.getSize()}`);
    console.log(`Capacity: ${customMap.getCapacity()}`);
    console.log(`Load Factor: ${customMap.getLoadFactor().toFixed(3)}`);
  };
  
  performanceTest();

  // 9. Clear operation
  console.log('\n9. Clear Operation');
  console.log('------------------');
  
  console.log(`Size before clear: ${map.getSize()}`);
  map.clear();
  console.log(`Size after clear: ${map.getSize()}`);
  console.log(`Keys after clear: ${map.keys()}`);
}

// Run the demo
demonstrateHashMap();


// input: "Application"
// output: "p"



function findFirstDuplicateCharacter(input: string) {
  for (let i = 0; i < input.length; ++i) {
    const char1 = input[i];
    for (let j = i + 1; j < input.length; ++j) {
        const char2 = input[j];
        if (char1 === char2) {
            return char2;
        }
    }
  }
  return null;
}
