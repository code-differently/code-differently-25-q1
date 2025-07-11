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

  return process.env.MCP_DEFAULT_USER_ID || 'mcp-user';
}

/**
 * Delete a todo for MCP client
 */
export async function DELETE(
  request: Request,
  { params }: { params: Promise<{ id: string }> },
) {
  const userId = authenticateApiKey(request);

  if (!userId) {
    return new Response('Unauthorized - Invalid API Key', { status: 401 });
  }

  const { id } = await params;

  try {
    await todoRepository.delete(Number(id), userId);
    return new Response('No content', { status: 200 });
  } catch (error) {
    console.error('Error deleting todo:', error);
    return new Response('Internal Server Error', { status: 500 });
  }
}

/**
 * Update a todo for MCP client
 */
export async function PATCH(request: Request) {
  const userId = authenticateApiKey(request);

  if (!userId) {
    return new Response('Unauthorized - Invalid API Key', { status: 401 });
  }

  const todo = await request.json();

  try {
    const updatedTodo = await todoRepository.patch(todo, userId);
    return NextResponse.json(updatedTodo);
  } catch (error) {
    console.error('Error updating todo:', error);
    return new Response('Internal Server Error', { status: 500 });
  }
}
