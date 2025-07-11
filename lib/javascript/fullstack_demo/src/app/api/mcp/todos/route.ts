import { createTodoRepository } from '@/repositories';
import { NextResponse } from 'next/server';

const todoRepository = createTodoRepository();

// Simple API key authentication for MCP
function authenticateApiKey(request: Request): string | null {
  const apiKey =
    request.headers.get('X-API-Key') ||
    request.headers.get('Authorization')?.replace('Bearer ', '');
  const validApiKey = process.env.MCP_API_KEY;

  if (!validApiKey || !apiKey || apiKey !== validApiKey) {
    return null;
  }

  // For demo purposes, return a default user ID
  // In production, you might map API keys to specific users
  return process.env.MCP_DEFAULT_USER_ID || 'mcp-user';
}

/**
 * Retrieve all todos for MCP client
 */
export async function GET(request: Request) {
  console.log('[MCP API] GET /api/mcp/todos called');
  console.log(
    '[MCP API] Headers:',
    Object.fromEntries(request.headers.entries()),
  );

  const userId = authenticateApiKey(request);

  if (!userId) {
    console.log('[MCP API] Authentication failed');
    return new Response('Unauthorized - Invalid API Key', { status: 401 });
  }

  console.log(`[MCP API] Authenticated as user: ${userId}`);

  try {
    const todos = await todoRepository.getAll(userId);
    console.log(`[MCP API] Retrieved ${todos?.length || 0} todos`);
    return NextResponse.json(todos || []);
  } catch (error) {
    console.error('[MCP API] Error fetching todos:', error);
    return new Response('Internal Server Error', { status: 500 });
  }
}

/**
 * Create a new todo for MCP client
 */
export async function POST(request: Request) {
  console.log('[MCP API] POST /api/mcp/todos called');

  const userId = authenticateApiKey(request);

  if (!userId) {
    console.log('[MCP API] Authentication failed');
    return new Response('Unauthorized - Invalid API Key', { status: 401 });
  }

  const todo = await request.json();
  console.log(`[MCP API] Creating todo for user ${userId}:`, todo);

  try {
    const id = await todoRepository.create(todo, userId);
    return NextResponse.json(id);
  } catch (error) {
    console.error('Error creating todo:', error);
    return new Response('Internal Server Error', { status: 500 });
  }
}
