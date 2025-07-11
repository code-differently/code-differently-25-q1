/**
 * A node in the hash table that stores key-value pairs
 */
class HashNode<K, V> {
  constructor(
    public key: K,
    public value: V,
    public next: HashNode<K, V> | null = null
  ) {}
}

/**
 * Custom HashMap implementation using separate chaining for collision resolution
 */
export class CustomHashMap<K, V> {
  private buckets: (HashNode<K, V> | null)[];
  private size: number;
  private capacity: number;
  private readonly loadFactorThreshold: number = 0.75;

  constructor(initialCapacity: number = 16) {
    this.capacity = Math.max(initialCapacity, 4);
    this.buckets = new Array(this.capacity).fill(null);
    this.size = 0;
  }

  /**
   * Simple hash function using djb2 algorithm
   */
  private hash(key: K): number {
    const keyStr = String(key);
    let hash = 5381;
    
    for (let i = 0; i < keyStr.length; i++) {
      hash = ((hash << 5) + hash) + keyStr.charCodeAt(i);
    }

    return Math.abs(hash) % this.capacity;
  }

  /**
   * Resize the hash table when load factor exceeds threshold
   */
  private resize(): void {
    const oldBuckets = this.buckets;
    this.capacity *= 2;
    this.buckets = new Array(this.capacity).fill(null);
    this.size = 0;

    // Rehash all existing entries
    for (const head of oldBuckets) {
      let current = head;
      while (current) {
        this.put(current.key, current.value);
        current = current.next;
      }
    }
  }

  /**
   * Insert or update a key-value pair
   */
  put(key: K, value: V): void {
    // Check if we need to resize
    if (this.size >= this.capacity * this.loadFactorThreshold) {
      this.resize();
    }

    const index = this.hash(key);
    let head = this.buckets[index];

    // If bucket is empty, create new node
    if (!head) {
      this.buckets[index] = new HashNode(key, value);
      this.size++;
      return;
    }

    // Search for existing key or find end of chain
    let current = head;
    while (current) {
      if (current.key === key) {
        // Update existing key
        current.value = value;
        return;
      }
      if (!current.next) {
        break;
      }
      current = current.next;
    }

    // Add new node at end of chain
    current.next = new HashNode(key, value);
    this.size++;
  }

  /**
   * Get value by key
   */
  get(key: K): V | undefined {
    const index = this.hash(key);
    let current = this.buckets[index];

    while (current) {
      if (current.key === key) {
        return current.value;
      }
      current = current.next;
    }

    return undefined;
  }

  /**
   * Check if key exists
   */
  has(key: K): boolean {
    return this.get(key) !== undefined;
  }

  /**
   * Remove a key-value pair
   */
  delete(key: K): boolean {
    const index = this.hash(key);
    let head = this.buckets[index];

    if (!head) {
      return false;
    }

    // If head node is the target
    if (head.key === key) {
      this.buckets[index] = head.next;
      this.size--;
      return true;
    }

    // Search for target in chain
    let current = head;
    while (current.next) {
      if (current.next.key === key) {
        current.next = current.next.next;
        this.size--;
        return true;
      }
      current = current.next;
    }

    return false;
  }

  /**
   * Clear all entries
   */
  clear(): void {
    this.buckets.fill(null);
    this.size = 0;
  }

  /**
   * Get all keys
   */
  keys(): K[] {
    const keys: K[] = [];
    for (const head of this.buckets) {
      let current = head;
      while (current) {
        keys.push(current.key);
        current = current.next;
      }
    }
    return keys;
  }

  /**
   * Get all values
   */
  values(): V[] {
    const values: V[] = [];
    for (const head of this.buckets) {
      let current = head;
      while (current) {
        values.push(current.value);
        current = current.next;
      }
    }
    return values;
  }

  /**
   * Get all key-value pairs
   */
  entries(): [K, V][] {
    const entries: [K, V][] = [];
    for (const head of this.buckets) {
      let current = head;
      while (current) {
        entries.push([current.key, current.value]);
        current = current.next;
      }
    }
    return entries;
  }

  /**
   * Get current size
   */
  getSize(): number {
    return this.size;
  }

  /**
   * Get current capacity
   */
  getCapacity(): number {
    return this.capacity;
  }

  /**
   * Get current load factor
   */
  getLoadFactor(): number {
    return this.size / this.capacity;
  }

  /**
   * Print the hash table structure for debugging
   */
  printTable(): void {
    console.log(`\n=== HashMap Structure (Size: ${this.size}, Capacity: ${this.capacity}) ===`);
    for (let i = 0; i < this.capacity; i++) {
      const chain: string[] = [];
      let current = this.buckets[i];
      
      while (current) {
        chain.push(`${current.key}:${current.value}`);
        current = current.next;
      }
      
      if (chain.length > 0) {
        console.log(`Bucket ${i}: ${chain.join(' -> ')}`);
      }
    }
    console.log(`Load Factor: ${this.getLoadFactor().toFixed(3)}\n`);
  }
}
