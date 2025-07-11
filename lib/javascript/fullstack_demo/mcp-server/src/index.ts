#!/usr/bin/env node

import { Server } from '@modelcontextprotocol/sdk/server/index.js';
import { StdioServerTransport } from '@modelcontextprotocol/sdk/server/stdio.js';
import {
  CallToolRequest,
  CallToolRequestSchema,
  ListToolsRequestSchema,
} from '@modelcontextprotocol/sdk/types.js';
import dotenv from 'dotenv';
import { TodoApiClient } from './api-client.js';
import { CreateTodoRequest, Todo, UpdateTodoRequest } from './types/todo.js';

// Load environment variables
dotenv.config();

class TodoMCPServer {
  private server: Server;
  private apiClient: TodoApiClient;

  constructor() {
    const apiBaseUrl =
      process.env.TODO_API_BASE_URL || 'http://localhost:3000/api/mcp';
    const apiKey = process.env.MCP_API_KEY;

    this.apiClient = new TodoApiClient(apiBaseUrl, apiKey);

    this.server = new Server(
      {
        name: 'todo-mcp-server',
        version: '1.0.0',
      },
      {
        capabilities: {
          tools: {},
        },
      },
    );

    this.setupToolHandlers();
    this.setupErrorHandling();
  }

  private setupErrorHandling(): void {
    this.server.onerror = (error: Error) => {
      console.debug('[MCP Error]', error);
    };

    process.on('SIGINT', async () => {
      await this.server.close();
      process.exit(0);
    });
  }

  private setupToolHandlers(): void {
    this.server.setRequestHandler(ListToolsRequestSchema, async () => {
      return {
        tools: [
          {
            name: 'get_todos',
            description: 'Retrieve all todos for the authenticated user',
            inputSchema: {
              type: 'object',
              properties: {},
              required: [],
            },
          },
          {
            name: 'create_todo',
            description: 'Create a new todo item',
            inputSchema: {
              type: 'object',
              properties: {
                text: {
                  type: 'string',
                  description: 'The text content of the todo item',
                },
                completed: {
                  type: 'boolean',
                  description: 'Whether the todo is completed (default: false)',
                  default: false,
                },
              },
              required: ['text'],
            },
          },
          {
            name: 'update_todo',
            description: 'Update an existing todo item',
            inputSchema: {
              type: 'object',
              properties: {
                id: {
                  type: 'number',
                  description: 'The ID of the todo to update',
                },
                text: {
                  type: 'string',
                  description: 'The new text content of the todo item',
                },
                completed: {
                  type: 'boolean',
                  description: 'Whether the todo is completed',
                },
              },
              required: ['id'],
            },
          },
          {
            name: 'delete_todo',
            description: 'Delete a todo item',
            inputSchema: {
              type: 'object',
              properties: {
                id: {
                  type: 'number',
                  description: 'The ID of the todo to delete',
                },
              },
              required: ['id'],
            },
          },
          {
            name: 'toggle_todo',
            description: 'Toggle the completion status of a todo item',
            inputSchema: {
              type: 'object',
              properties: {
                id: {
                  type: 'number',
                  description: 'The ID of the todo to toggle',
                },
              },
              required: ['id'],
            },
          },
          {
            name: 'get_todo_stats',
            description:
              'Get statistics about todos (total, completed, pending)',
            inputSchema: {
              type: 'object',
              properties: {},
              required: [],
            },
          },
        ],
      };
    });

    this.server.setRequestHandler(
      CallToolRequestSchema,
      async (request: CallToolRequest) => {
        const { name, arguments: args } = request.params;

        try {
          switch (name) {
            case 'get_todos':
              return await this.getTodos();

            case 'create_todo':
              if (!args || typeof args !== 'object' || !('text' in args)) {
                throw new Error('Missing required parameter: text');
              }
              return await this.createTodo(
                args as unknown as CreateTodoRequest,
              );

            case 'update_todo':
              if (!args || typeof args !== 'object' || !('id' in args)) {
                throw new Error('Missing required parameter: id');
              }
              return await this.updateTodo(
                args as unknown as UpdateTodoRequest,
              );

            case 'delete_todo':
              if (!args || typeof args !== 'object' || !('id' in args)) {
                throw new Error('Missing required parameter: id');
              }
              return await this.deleteTodo(args.id as number);

            case 'toggle_todo':
              if (!args || typeof args !== 'object' || !('id' in args)) {
                throw new Error('Missing required parameter: id');
              }
              return await this.toggleTodo(args.id as number);

            case 'get_todo_stats':
              return await this.getTodoStats();

            default:
              throw new Error(`Unknown tool: ${name}`);
          }
        } catch (error) {
          return {
            content: [
              {
                type: 'text',
                text: `Error: ${error instanceof Error ? error.message : String(error)}`,
              },
            ],
            isError: true,
          };
        }
      },
    );
  }

  private async getTodos() {
    console.debug('[MCP] Getting todos...');
    const todos = await this.apiClient.getTodos();
    console.debug(`[MCP] Retrieved ${todos.length} todos`);

    return {
      content: [
        {
          type: 'text',
          text: JSON.stringify(todos, null, 2),
        },
      ],
    };
  }

  private async createTodo(args: CreateTodoRequest) {
    console.debug(`[MCP] Creating todo: "${args.text}"`);
    const result = await this.apiClient.createTodo(args.text, args.completed);
    console.debug(`[MCP] Todo created with ID: ${result}`);

    return {
      content: [
        {
          type: 'text',
          text: `Todo created successfully with ID: ${result}`,
        },
      ],
    };
  }

  private async updateTodo(args: UpdateTodoRequest) {
    const updates: Partial<Omit<Todo, 'id'>> = {};

    if (args.text !== undefined) {
      updates.text = args.text;
    }

    if (args.completed !== undefined) {
      updates.completed = args.completed;
    }

    const result = await this.apiClient.updateTodo(args.id, updates);

    return {
      content: [
        {
          type: 'text',
          text: `Todo updated successfully: ${JSON.stringify(result, null, 2)}`,
        },
      ],
    };
  }

  private async deleteTodo(id: number) {
    await this.apiClient.deleteTodo(id);

    return {
      content: [
        {
          type: 'text',
          text: `Todo with ID ${id} deleted successfully`,
        },
      ],
    };
  }

  private async toggleTodo(id: number) {
    const result = await this.apiClient.toggleTodo(id);

    return {
      content: [
        {
          type: 'text',
          text: `Todo toggled successfully: ${JSON.stringify(result, null, 2)}`,
        },
      ],
    };
  }

  private async getTodoStats() {
    const stats = await this.apiClient.getTodoStats();

    return {
      content: [
        {
          type: 'text',
          text: JSON.stringify(stats, null, 2),
        },
      ],
    };
  }

  async run(): Promise<void> {
    const transport = new StdioServerTransport();
    await this.server.connect(transport);
    console.log('Todo MCP server running on stdio');
    console.debug(
      `API Base URL: ${process.env.TODO_API_BASE_URL || 'http://localhost:3000/api/mcp'}`,
    );
    console.debug(
      `API Key configured: ${process.env.MCP_API_KEY ? 'Yes' : 'No'}`,
    );
  }
}

const server = new TodoMCPServer();
server.run().catch(console.error);
