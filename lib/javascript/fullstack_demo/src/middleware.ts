import { clerkMiddleware, createRouteMatcher } from '@clerk/nextjs/server';
import { NextResponse } from 'next/server';
import { v4 as uuidv4 } from 'uuid';

const CORRELATION_ID_HEADER = 'x-correlation-id';
const isProtectedRoute = createRouteMatcher(['/(.*)']);
const isMcpApiRoute = createRouteMatcher(['/api/mcp/(.*)']);

export default clerkMiddleware(async (auth, req) => {
  const correlationId = uuidv4();
  req.headers.set(CORRELATION_ID_HEADER, correlationId);

  // Skip Clerk protection for MCP API routes (they have their own API key auth)
  if (isProtectedRoute(req) && !isMcpApiRoute(req)) {
    await auth.protect();
  }

  const response = NextResponse.next();
  response.headers.set(CORRELATION_ID_HEADER, correlationId);
  return response;
});

export const config = {
  matcher: [
    // Skip Next.js internals and all static files, unless found in search params
    '/((?!_next|[^?]*\\.(?:html?|css|js(?!on)|jpe?g|webp|png|gif|svg|ttf|woff2?|ico|csv|docx?|xlsx?|zip|webmanifest)).*)',
    // Always run for API routes
    '/(api|trpc)(.*)',
  ],
};
