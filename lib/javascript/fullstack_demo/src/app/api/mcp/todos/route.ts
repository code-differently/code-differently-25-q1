import { createTodoRepository } from '@/repositories';
import { authenticateApiKey } from '@/util/mcp-auth';
import { NextResponse } from 'next/server';

const todoRepository = createTodoRepository();

/**
 * Retrieve all todos for MCP client
 */
export async function GET(request: Request) {
  console.log('[MCP API] GET /api/mcp/todos called');

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
