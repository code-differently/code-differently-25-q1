/**
 * Simple API key authentication for MCP
 */
export function authenticateApiKey(request: Request): string | null {
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
