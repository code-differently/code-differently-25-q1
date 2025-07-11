import { createTodoRepository } from '@/repositories';
import { authenticateApiKey } from '@/util/mcp-auth';
import { NextResponse } from 'next/server';

const todoRepository = createTodoRepository();

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
