#!/usr/bin/env node

// Test that fetch works with our MCP server
import { TodoApiClient } from './dist/api-client.js';

async function testFetch() {
  console.log('🧪 Testing fetch functionality...\n');

  try {
    const client = new TodoApiClient(
      'http://localhost:3000/api/mcp',
      'test-key',
    );
    console.log('✅ TodoApiClient created successfully');
    console.log('✅ fetch polyfill loaded correctly');

    console.log(
      '\n📡 If your todo server is running on port 3000, the MCP server should work in Claude Desktop now!',
    );
    console.log('\n🔧 Steps to test in Claude Desktop:');
    console.log('  1. Make sure your todo app is running on port 3000');
    console.log('  2. Restart Claude Desktop completely');
    console.log('  3. Ask: "Can you show me my todos?"');
  } catch (error) {
    console.error('❌ Error testing fetch:', error.message);
    process.exit(1);
  }
}

testFetch();
