#!/usr/bin/env node

import { randomBytes } from 'crypto';

function generateApiKey() {
  return randomBytes(32).toString('hex');
}

console.log('🔑 Generated MCP API Key:');
console.log(generateApiKey());
console.log('\n📝 Add this to both:');
console.log('  1. Your todo app .env file (MCP_API_KEY=...)');
console.log('  2. Your MCP server .env file (MCP_API_KEY=...)');
console.log('  3. Your Claude Desktop config (MCP_API_KEY: "...")');
console.log('\n🔒 Keep this key secret and secure!');
