import { NextResponse } from 'next/server';

export async function GET() {
  console.log('[DEBUG] /api/mcp/debug route called');

  return NextResponse.json({
    message: 'MCP debug route is working!',
    timestamp: new Date().toISOString(),
    env: {
      MCP_API_KEY_SET: !!process.env.MCP_API_KEY,
      MCP_DEFAULT_USER_ID: process.env.MCP_DEFAULT_USER_ID,
    },
  });
}
