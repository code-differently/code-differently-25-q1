# Todo MCP Server Deployment Guide

## Quick Start

1. **Build the server**:
   ```bash
   cd mcp-server
   npm install
   npm run build
   ```

2. **Configure environment**:
   ```bash
   cp .env.example .env
   # Edit .env with your configuration
   ```

3. **Test the server**:
   ```bash
   node test.mjs
   ```

## MCP Client Configuration

### Claude Desktop

Add this to your Claude Desktop configuration (`~/Library/Application Support/Claude/claude_desktop_config.json` on macOS):

```json
{
  "mcpServers": {
    "todo-mcp-server": {
      "command": "node",
      "args": ["/path/to/your/mcp-server/dist/index.js"],
      "env": {
        "TODO_API_BASE_URL": "http://localhost:3000/api"
      }
    }
  }
}
```

### Other MCP Clients

For other MCP-compatible clients, use the stdio transport with:
- **Command**: `node`
- **Args**: `["/path/to/mcp-server/dist/index.js"]`
- **Environment**: Set `TODO_API_BASE_URL` to your API base URL

## Environment Variables

| Variable            | Description                         | Default                     | Required |
| ------------------- | ----------------------------------- | --------------------------- | -------- |
| `TODO_API_BASE_URL` | Base URL of the Todo API            | `http://localhost:3000/api` | Yes      |
| `CLERK_SECRET_KEY`  | Clerk secret key for authentication | -                           | Optional |

## Usage Examples

Once configured with an MCP client, you can use these tools:

### Get All Todos
```
Can you show me all my todos?
```

### Create a Todo
```
Create a new todo: "Learn about MCP servers"
```

### Update a Todo
```
Update todo ID 1 to mark it as completed
```

### Get Statistics
```
Show me my todo statistics
```

## Troubleshooting

### Common Issues

1. **Module not found errors**:
   - Ensure you've run `npm run build`
   - Check that the path in your MCP client config is correct

2. **API connection errors**:
   - Verify the Todo app is running on the correct port
   - Check the `TODO_API_BASE_URL` environment variable
   - Ensure the API endpoints are accessible

3. **Authentication errors**:
   - For production use, configure proper authentication
   - Set the `CLERK_SECRET_KEY` if using Clerk authentication

### Debug Mode

Run the server in development mode to see detailed logs:
```bash
npm run dev
```

## Security Considerations

⚠️ **Important**: This MCP server is currently configured for development use. For production deployment:

1. **Authentication**: Implement proper API authentication
2. **HTTPS**: Use HTTPS for API communication
3. **Rate Limiting**: Implement rate limiting to prevent abuse
4. **Input Validation**: Add additional input validation and sanitization
5. **Error Handling**: Avoid exposing sensitive information in error messages

## API Compatibility

This MCP server is designed to work with the Todo app's REST API:

- `GET /api/todos` - Get all todos
- `POST /api/todos` - Create a new todo
- `PATCH /api/todos/{id}` - Update a todo
- `DELETE /api/todos/{id}` - Delete a todo

Ensure your Todo app implements these endpoints for full compatibility.
