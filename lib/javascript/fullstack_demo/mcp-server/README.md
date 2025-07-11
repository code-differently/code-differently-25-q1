# Todo MCP Server

A Model Context Protocol (MCP) server that provides tools for interacting with the Todo application API.

## Features

This MCP server provides the following tools:

- **get_todos**: Retrieve all todos for the authenticated user
- **create_todo**: Create a new todo item
- **update_todo**: Update an existing todo item (text and/or completion status)
- **delete_todo**: Delete a todo item
- **toggle_todo**: Toggle the completion status of a todo item
- **get_todo_stats**: Get statistics about todos (total, completed, pending, completion rate)

## Setup

1. Install dependencies:
   ```bash
   npm install
   ```

2. Copy the environment file and configure it:
   ```bash
   cp .env.example .env
   ```

3. Update the `.env` file with your configuration:
   ```
   TODO_API_BASE_URL=http://localhost:3000/api
   CLERK_SECRET_KEY=your_clerk_secret_key_here
   ```

## Development

Build the project:
```bash
npm run build
```

Run in development mode:
```bash
npm run dev
```

Run the compiled server:
```bash
npm start
```

## Usage

This MCP server is designed to be used with MCP-compatible clients. The server communicates via stdio.

### Tool Examples

1. **Get all todos**:
   ```json
   {
     "name": "get_todos",
     "arguments": {}
   }
   ```

2. **Create a new todo**:
   ```json
   {
     "name": "create_todo",
     "arguments": {
       "text": "Learn about MCP servers",
       "completed": false
     }
   }
   ```

3. **Update a todo**:
   ```json
   {
     "name": "update_todo",
     "arguments": {
       "id": 1,
       "text": "Updated todo text",
       "completed": true
     }
   }
   ```

4. **Delete a todo**:
   ```json
   {
     "name": "delete_todo",
     "arguments": {
       "id": 1
     }
   }
   ```

5. **Toggle todo completion**:
   ```json
   {
     "name": "toggle_todo",
     "arguments": {
       "id": 1
     }
   }
   ```

6. **Get todo statistics**:
   ```json
   {
     "name": "get_todo_stats",
     "arguments": {}
   }
   ```

## Authentication

The MCP server interacts with the Todo API, which uses Clerk for authentication. In a production setup, you would need to handle authentication properly by either:

1. Using API keys or service accounts
2. Implementing session-based authentication
3. Using OAuth flows

Currently, the server assumes the API is accessible without authentication for demonstration purposes.

## API Integration

The server communicates with the Todo app's REST API endpoints:

- `GET /api/todos` - Get all todos
- `POST /api/todos` - Create a new todo
- `PATCH /api/todos/{id}` - Update a todo
- `DELETE /api/todos/{id}` - Delete a todo

## Error Handling

The server includes comprehensive error handling for:
- API request failures
- Network issues
- Invalid todo IDs
- Malformed requests

All errors are returned as structured responses with descriptive messages.

## Troubleshooting

### "fetch is not defined" Error

If you see `fetch is not defined` errors in Claude Desktop, this means you're running an older version of Node.js. The MCP server now includes a `node-fetch` polyfill to fix this.

**Solution:**
1. Rebuild the MCP server: `npm run build`
2. Restart Claude Desktop completely
3. The error should be resolved

### Other Common Issues

- Ensure all dependencies are correctly installed
- Check your `.env` configuration
- Verify the Todo API is running and accessible

## Contributing

1. Make your changes
2. Run `npm run build` to ensure compilation
3. Test with your MCP client
4. Submit a pull request
