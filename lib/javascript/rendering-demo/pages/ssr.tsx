import React from 'react'
import { GetServerSideProps } from 'next'
import { useRouter } from 'next/router'
import Layout from '../components/Layout'

interface Post {
  id: number
  title: string
  body: string
  userId: number
}

interface User {
  id: number
  name: string
  email: string
  website: string
}

interface SSRPageProps {
  posts: Post[]
  users: User[]
  renderTime: string
  fetchTime: string
  error?: string
}

const SSRPage: React.FC<SSRPageProps> = ({ posts, users, renderTime, fetchTime, error }) => {
  const getUserName = (userId: number) => {
    const user = users.find(u => u.id === userId)
    return user ? user.name : 'Unknown User'
  }

  return (
    <Layout title="SSR - Server-Side Rendering Demo">
      <div className="px-4 py-8">
        <div className="max-w-4xl mx-auto">
          <div className="text-center mb-8">
            <span className="badge badge-ssr mb-4 inline-block">SSR</span>
            <h1 className="text-3xl font-bold text-gray-900 mb-4">
              Server-Side Rendering Example
            </h1>
            <p className="text-lg text-gray-600 mb-6">
              This page demonstrates SSR where data is fetched on the server for each request.
              The HTML comes pre-populated with content.
            </p>
          </div>

          <div className="bg-blue-50 border border-blue-200 rounded-lg p-4 mb-8">
            <h3 className="font-semibold text-blue-800 mb-2">How SSR Works:</h3>
            <ul className="text-blue-700 space-y-1 text-sm">
              <li>• Server fetches data before rendering HTML</li>
              <li>• Fully populated HTML is sent to the browser</li>
              <li>• Content is immediately visible (no loading states)</li>
              <li>• Great for SEO and social media sharing</li>
            </ul>
          </div>

          <div className="flex justify-between items-center mb-6">
            <div className="text-sm text-gray-500 space-x-4">
              <span>Server fetch time: {fetchTime}</span>
              <span>Page rendered at: {renderTime}</span>
            </div>
            <button
              onClick={() => window.location.reload()}
              className="btn-secondary"
            >
              Reload Page
            </button>
          </div>

          {error && (
            <div className="bg-red-50 border border-red-200 rounded-lg p-4 mb-6">
              <div className="flex items-start">
                <div className="flex-shrink-0">
                  <span className="text-red-400 text-xl">⚠️</span>
                </div>
                <div className="ml-3">
                  <h3 className="text-sm font-medium text-red-800">SSR Error Encountered</h3>
                  <p className="text-red-700 mt-1 text-sm">Error: {error}</p>
                  
                  <div className="mt-4">
                    <h4 className="text-red-800 font-medium text-sm mb-2">Common SSR Debugging Tips:</h4>
                    <ul className="text-red-700 text-xs space-y-1">
                      <li>• Check server logs for detailed error information</li>
                      <li>• Verify API endpoints are accessible from server environment</li>
                      <li>• Ensure environment variables are properly configured</li>
                      <li>• Test getServerSideProps function in isolation</li>
                      <li>• Use try-catch blocks in getServerSideProps for error handling</li>
                      <li>• Check for network connectivity issues from server</li>
                      <li>• Verify server has proper permissions for external API calls</li>
                    </ul>
                  </div>
                  
                  <div className="mt-4 flex gap-2">
                    <button
                      onClick={() => window.location.href = '/ssr'}
                      className="text-xs bg-red-100 hover:bg-red-200 px-2 py-1 rounded text-red-800"
                    >
                      Try Normal Version
                    </button>
                    <button
                      onClick={() => window.location.reload()}
                      className="text-xs bg-red-100 hover:bg-red-200 px-2 py-1 rounded text-red-800"
                    >
                      Reload Page
                    </button>
                  </div>
                </div>
              </div>
            </div>
          )}

          <div className="grid gap-6">
            {posts.map((post) => (
              <div key={post.id} className="card">
                <div className="flex justify-between items-start mb-3">
                  <h2 className="text-xl font-semibold text-gray-900 capitalize">
                    {post.title}
                  </h2>
                  <span className="text-sm text-gray-500 bg-gray-100 px-2 py-1 rounded">
                    ID: {post.id}
                  </span>
                </div>
                <p className="text-gray-600 mb-4">{post.body}</p>
                <div className="text-sm text-gray-500">
                  <strong>Author:</strong> {getUserName(post.userId)}
                </div>
              </div>
            ))}
          </div>

          <div className="mt-8 bg-gray-50 border border-gray-200 rounded-lg p-6">
            <h3 className="font-semibold text-gray-900 mb-3">SSR Characteristics:</h3>
            <div className="grid md:grid-cols-2 gap-4 text-sm">
              <div>
                <h4 className="font-medium text-green-700 mb-2">Advantages:</h4>
                <ul className="text-gray-600 space-y-1">
                  <li>• Excellent SEO performance</li>
                  <li>• Fast perceived performance</li>
                  <li>• Works without JavaScript</li>
                  <li>• Great for dynamic content</li>
                </ul>
              </div>
              <div>
                <h4 className="font-medium text-red-700 mb-2">Disadvantages:</h4>
                <ul className="text-gray-600 space-y-1">
                  <li>• Higher server load</li>
                  <li>• Slower navigation between pages</li>
                  <li>• Complex caching strategies</li>
                  <li>• Requires server infrastructure</li>
                </ul>
              </div>
            </div>
          </div>

          <div className="mt-6 bg-green-50 border border-green-200 rounded-lg p-4">
            <p className="text-green-800 text-sm">
              <strong>Notice:</strong> This content was rendered on the server at {renderTime}. 
              If you refresh the page, you'll see a new timestamp showing it was re-rendered.
            </p>
          </div>
        </div>
      </div>
    </Layout>
  )
}

export const getServerSideProps: GetServerSideProps<SSRPageProps> = async (context) => {
  const { error: forceError } = context.query
  
  try {
    const startTime = Date.now()

    // Force error if requested
    const apiUrl = forceError === 'true' 
      ? 'https://invalid-api-endpoint.example.com/posts' 
      : 'https://jsonplaceholder.typicode.com/posts?_limit=6'

    // Fetch data on the server
    const [postsResponse, usersResponse] = await Promise.all([
      fetch(apiUrl),
      fetch('https://jsonplaceholder.typicode.com/users')
    ])

    if (!postsResponse.ok || !usersResponse.ok) {
      throw new Error('Failed to fetch data')
    }

    const posts = await postsResponse.json()
    const users = await usersResponse.json()

    const endTime = Date.now()
    const fetchTime = `${endTime - startTime}ms`
    const renderTime = new Date().toLocaleString()

    return {
      props: {
        posts,
        users,
        renderTime,
        fetchTime,
      },
    }
  } catch (error) {
    console.error('SSR Error:', error)
    
    // Return error state for demonstration
    return {
      props: {
        posts: [],
        users: [],
        renderTime: new Date().toLocaleString(),
        fetchTime: 'Failed to fetch',
        error: error instanceof Error ? error.message : 'Unknown server error occurred',
      },
    }
  }
}

export default SSRPage
