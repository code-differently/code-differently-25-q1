import { CustomHashMap } from './HashMap';

/**
 * Simple test suite for CustomHashMap
 */
function runTests() {
  console.log('🧪 Running CustomHashMap Tests');
  console.log('===============================\n');

  let testsPassed = 0;
  let testsTotal = 0;

  function test(name: string, testFn: () => boolean) {
    testsTotal++;
    try {
      const result = testFn();
      if (result) {
        console.log(`✅ ${name}`);
        testsPassed++;
      } else {
        console.log(`❌ ${name}`);
      }
    } catch (error) {
      console.log(`❌ ${name} - Error: ${error}`);
    }
  }

  // Test basic operations
  test('Basic put and get', () => {
    const map = new CustomHashMap<string, number>();
    map.put('key1', 100);
    return map.get('key1') === 100;
  });

  test('Get non-existent key returns undefined', () => {
    const map = new CustomHashMap<string, number>();
    return map.get('nonexistent') === undefined;
  });

  test('Update existing key', () => {
    const map = new CustomHashMap<string, number>();
    map.put('key1', 100);
    map.put('key1', 200);
    return map.get('key1') === 200 && map.getSize() === 1;
  });

  test('Has method works correctly', () => {
    const map = new CustomHashMap<string, number>();
    map.put('key1', 100);
    return map.has('key1') && !map.has('key2');
  });

  test('Delete works correctly', () => {
    const map = new CustomHashMap<string, number>();
    map.put('key1', 100);
    map.put('key2', 200);
    const deleted = map.delete('key1');
    return deleted && !map.has('key1') && map.has('key2') && map.getSize() === 1;
  });

  test('Delete non-existent key returns false', () => {
    const map = new CustomHashMap<string, number>();
    return !map.delete('nonexistent');
  });

  test('Clear works correctly', () => {
    const map = new CustomHashMap<string, number>();
    map.put('key1', 100);
    map.put('key2', 200);
    map.clear();
    return map.getSize() === 0 && !map.has('key1') && !map.has('key2');
  });

  test('Keys method returns all keys', () => {
    const map = new CustomHashMap<string, number>();
    map.put('a', 1);
    map.put('b', 2);
    map.put('c', 3);
    const keys = map.keys();
    return keys.length === 3 && keys.includes('a') && keys.includes('b') && keys.includes('c');
  });

  test('Values method returns all values', () => {
    const map = new CustomHashMap<string, number>();
    map.put('a', 1);
    map.put('b', 2);
    map.put('c', 3);
    const values = map.values();
    return values.length === 3 && values.includes(1) && values.includes(2) && values.includes(3);
  });

  test('Entries method returns all key-value pairs', () => {
    const map = new CustomHashMap<string, number>();
    map.put('a', 1);
    map.put('b', 2);
    const entries = map.entries();
    return entries.length === 2 && 
           entries.some(([k, v]) => k === 'a' && v === 1) &&
           entries.some(([k, v]) => k === 'b' && v === 2);
  });

  test('Handle collisions correctly', () => {
    const map = new CustomHashMap<string, number>(2); // Small capacity to force collisions
    map.put('a', 1);
    map.put('b', 2);
    map.put('c', 3);
    map.put('d', 4);
    return map.get('a') === 1 && map.get('b') === 2 && map.get('c') === 3 && map.get('d') === 4;
  });

  test('Auto-resize when load factor exceeds threshold', () => {
    const map = new CustomHashMap<number, string>(4);
    const initialCapacity = map.getCapacity();
    
    // Add enough items to trigger resize
    for (let i = 0; i < 10; i++) {
      map.put(i, `value${i}`);
    }
    
    return map.getCapacity() > initialCapacity && map.getSize() === 10;
  });

  test('Works with different key types', () => {
    const map = new CustomHashMap<string | number, string>();
    map.put('stringKey', 'value1');
    map.put(42, 'value2');
    return map.get('stringKey') === 'value1' && map.get(42) === 'value2';
  });

  test('Works with object values', () => {
    const map = new CustomHashMap<string, { name: string; age: number }>();
    const person = { name: 'John', age: 30 };
    map.put('john', person);
    const retrieved = map.get('john');
    return retrieved !== undefined && retrieved.name === 'John' && retrieved.age === 30;
  });

  // Print results
  console.log(`\n📊 Test Results: ${testsPassed}/${testsTotal} tests passed`);
  
  if (testsPassed === testsTotal) {
    console.log('🎉 All tests passed!');
  } else {
    console.log(`❌ ${testsTotal - testsPassed} tests failed`);
  }
}

// Run tests
runTests();
