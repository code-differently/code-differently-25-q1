# Authentication Setup for Claude Desktop

## Quick Setup Guide

### 1. Configure Your Todo App

Add these environment variables to your todo app's `.env` file:

```bash
# Add to /lib/javascript/fullstack_demo/.env
MCP_API_KEY=your-secret-mcp-api-key-here
MCP_DEFAULT_USER_ID=your-user-id-here
```

**Generate a secure API key:**
```bash
# Generate a random API key
node -e "console.log(require('crypto').randomBytes(32).toString('hex'))"
```

### 2. Configure MCP Server

Create/update the MCP server's `.env` file:

```bash
# /lib/javascript/fullstack_demo/mcp-server/.env
TODO_API_BASE_URL=http://localhost:3000/api/mcp
MCP_API_KEY=your-secret-mcp-api-key-here
```

**Use the same API key in both files!**

### 3. Configure Claude Desktop

Update your Claude Desktop config file:

**Location:** `~/Library/Application Support/Claude/claude_desktop_config.json` (macOS)

```json
{
  "mcpServers": {
    "todo-mcp-server": {
      "command": "node",
      "args": ["/full/path/to/your/mcp-server/dist/index.js"],
      "env": {
        "TODO_API_BASE_URL": "http://localhost:3000/api/mcp",
        "MCP_API_KEY": "your-secret-mcp-api-key-here"
      }
    }
  }
}
```

### 4. Build and Test

1. **Start your todo app:**
   ```bash
   cd /lib/javascript/fullstack_demo
   npm run dev
   ```

2. **Build the MCP server:**
   ```bash
   cd /lib/javascript/fullstack_demo/mcp-server
   npm run build
   ```

3. **Restart Claude Desktop** to pick up the new configuration

### 5. Test Authentication

In Claude Desktop, try:
```
Can you show me my todos?
```

If authentication works, you should see your todos or an empty list.

## Troubleshooting

### "Unauthorized - Invalid API Key"
- Check that the API key is the same in both `.env` files
- Ensure the MCP server environment variables are set correctly
- Restart Claude Desktop after config changes

### "Cannot connect to API"
- Verify your todo app is running on the correct port
- Check that the `TODO_API_BASE_URL` points to the MCP endpoints (`/api/mcp`)
- Ensure firewalls aren't blocking the connection

### "User not found" errors
- Set `MCP_DEFAULT_USER_ID` to a valid user ID from your system
- For development, you can use any string like "test-user"

## Security Notes

⚠️ **Important for Production:**

1. **Keep API keys secret** - Never commit them to version control
2. **Use environment variables** - Don't hardcode keys in your config
3. **Rotate keys regularly** - Generate new API keys periodically
4. **Limit scope** - Consider implementing user-specific API keys
5. **Use HTTPS** - In production, always use HTTPS for API communication

## Alternative: User-Specific Authentication

For multiple users, you can extend the authentication to map API keys to specific users:

```typescript
// In your API route
const userKeyMap = {
  'api-key-1': 'user-1',
  'api-key-2': 'user-2',
  // etc.
};

function authenticateApiKey(request: Request): string | null {
  const apiKey = request.headers.get('X-API-Key');
  return userKeyMap[apiKey] || null;
}
```

This allows each Claude Desktop user to have their own API key and access their own todos.
