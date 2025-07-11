#!/usr/bin/env node

import dotenv from 'dotenv';
import { TodoApiClient } from './dist/api-client.js';

dotenv.config();

async function testApiConnection() {
  console.log('🧪 Testing MCP API Connection...\n');

  const apiBaseUrl =
    process.env.TODO_API_BASE_URL || 'http://localhost:3000/api/mcp';
  const apiKey = process.env.MCP_API_KEY;

  console.log(`📡 API Base URL: ${apiBaseUrl}`);
  console.log(`🔑 API Key configured: ${apiKey ? 'Yes' : 'No'}`);

  if (!apiKey) {
    console.log(
      '❌ No API key found. Please set MCP_API_KEY in your .env file',
    );
    console.log('💡 Run: node generate-api-key.mjs to generate one');
    return;
  }

  const client = new TodoApiClient(apiBaseUrl, apiKey);

  try {
    console.log('\n🔍 Testing GET /todos...');
    const todos = await client.getTodos();
    console.log(`✅ Success! Retrieved ${todos.length} todos:`, todos);

    console.log('\n🔍 Testing POST /todos...');
    const newTodoId = await client.createTodo(
      'Test todo from MCP client',
      false,
    );
    console.log(`✅ Success! Created todo with ID: ${newTodoId}`);

    console.log('\n🔍 Testing GET /todos again...');
    const updatedTodos = await client.getTodos();
    console.log(`✅ Success! Now have ${updatedTodos.length} todos`);

    console.log(
      '\n🎉 All tests passed! Your MCP server should work with Claude Desktop.',
    );
  } catch (error) {
    console.error('\n❌ Connection test failed:', error.message);
    console.log('\n🔧 Troubleshooting steps:');
    console.log('1. Make sure your todo app is running: npm run dev');
    console.log('2. Check that the API key matches in both .env files');
    console.log('3. Verify the API URL is correct');
    console.log('4. Check the server logs for more details');
  }
}

testApiConnection();
