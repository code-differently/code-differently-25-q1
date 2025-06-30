import React from 'react'
import { GetStaticProps } from 'next'
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

interface SSGErrorPageProps {
  posts: Post[]
  users: User[]
  buildTime: string
  fetchTime: string
  error: string
}

const SSGErrorPage: React.FC<SSGErrorPageProps> = ({ posts, users, buildTime, fetchTime, error }) => {
  const getUserName = (userId: number) => {
    const user = users.find(u => u.id === userId)
    return user ? user.name : 'Unknown User'
  }

  return (
    <Layout title="SSG Error - Static Site Generation Demo">
      <div className="px-4 py-8">
        <div className="max-w-4xl mx-auto">
          <div className="text-center mb-8">
            <span className="badge badge-ssg mb-4 inline-block">SSG ERROR</span>
            <h1 className="text-3xl font-bold text-gray-900 mb-4">
              Static Site Generation Error Example
            </h1>
            <p className="text-lg text-gray-600 mb-6">
              This page demonstrates what happens when SSG encounters an error during build time.
            </p>
          </div>

          <div className="bg-purple-50 border border-purple-200 rounded-lg p-4 mb-8">
            <h3 className="font-semibold text-purple-800 mb-2">SSG Error Simulation:</h3>
            <ul className="text-purple-700 space-y-1 text-sm">
              <li>• This page was built with a simulated API failure</li>
              <li>• In production, this would cause the build to fail completely</li>
              <li>• Error handling in getStaticProps is crucial</li>
              <li>• Consider using ISR for more resilient static generation</li>
            </ul>
          </div>

          <div className="flex justify-between items-center mb-6">
            <div className="text-sm text-gray-500 space-x-4">
              <span>Build fetch time: {fetchTime}</span>
              <span>Generated at: {buildTime}</span>
            </div>
            <div className="text-sm text-red-600">
              Build Error Encountered
            </div>
          </div>

          <div className="bg-red-50 border border-red-200 rounded-lg p-4 mb-6">
            <div className="flex items-start">
              <div className="flex-shrink-0">
                <span className="text-red-400 text-xl">⚠️</span>
              </div>
              <div className="ml-3">
                <h3 className="text-sm font-medium text-red-800">SSG Build Error Encountered</h3>
                <p className="text-red-700 mt-1 text-sm">Error: {error}</p>
                
                <div className="mt-4">
                  <h4 className="text-red-800 font-medium text-sm mb-2">Common SSG Debugging Tips:</h4>
                  <ul className="text-red-700 text-xs space-y-1">
                    <li>• Check build logs for detailed error information</li>
                    <li>• Verify API endpoints are accessible during build time</li>
                    <li>• Ensure all environment variables are available at build time</li>
                    <li>• Test getStaticProps function in development mode</li>
                    <li>• Use fallback pages for dynamic routes that might fail</li>
                    <li>• Implement proper error handling in getStaticProps</li>
                    <li>• Consider using ISR (Incremental Static Regeneration) for resilience</li>
                  </ul>
                </div>
                
                <div className="mt-4 bg-yellow-50 border border-yellow-200 rounded p-2">
                  <p className="text-yellow-800 text-xs">
                    <strong>Note:</strong> In a real SSG error, the build would fail and this page wouldn't exist. 
                    This demo shows what error handling might look like during development or with ISR fallbacks.
                  </p>
                </div>
                
                <div className="mt-4 flex gap-2">
                  <button
                    onClick={() => window.location.href = '/ssg'}
                    className="text-xs bg-red-100 hover:bg-red-200 px-2 py-1 rounded text-red-800"
                  >
                    Try Normal Version
                  </button>
                  <button
                    onClick={() => window.location.href = '/'}
                    className="text-xs bg-red-100 hover:bg-red-200 px-2 py-1 rounded text-red-800"
                  >
                    Back to Home
                  </button>
                </div>
              </div>
            </div>
          </div>

          {posts.length > 0 ? (
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
          ) : (
            <div className="text-center py-12">
              <div className="text-gray-400 text-6xl mb-4">📋</div>
              <h3 className="text-lg font-medium text-gray-900 mb-2">No Content Available</h3>
              <p className="text-gray-500">The build failed to fetch content due to the simulated error.</p>
            </div>
          )}

          <div className="mt-8 bg-gray-50 border border-gray-200 rounded-lg p-6">
            <h3 className="font-semibold text-gray-900 mb-3">SSG Error Recovery Strategies:</h3>
            <div className="grid md:grid-cols-2 gap-4 text-sm">
              <div>
                <h4 className="font-medium text-blue-700 mb-2">Prevention:</h4>
                <ul className="text-gray-600 space-y-1">
                  <li>• Use try-catch in getStaticProps</li>
                  <li>• Provide fallback data</li>
                  <li>• Test builds in CI/CD pipelines</li>
                  <li>• Monitor external API dependencies</li>
                </ul>
              </div>
              <div>
                <h4 className="font-medium text-green-700 mb-2">Recovery:</h4>
                <ul className="text-gray-600 space-y-1">
                  <li>• Implement ISR for automatic retries</li>
                  <li>• Use custom error pages (404/500)</li>
                  <li>• Cache successful builds as backups</li>
                  <li>• Graceful degradation to static content</li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </Layout>
  )
}

export const getStaticProps: GetStaticProps<SSGErrorPageProps> = async () => {
  try {
    const startTime = Date.now()

    // Intentionally use a failing endpoint to demonstrate SSG error handling
    const [postsResponse, usersResponse] = await Promise.all([
      fetch('https://invalid-api-endpoint.example.com/posts'),
      fetch('https://jsonplaceholder.typicode.com/users')
    ])

    if (!postsResponse.ok || !usersResponse.ok) {
      throw new Error('Failed to fetch data from API endpoints')
    }

    const posts = await postsResponse.json()
    const users = await usersResponse.json()

    const endTime = Date.now()
    const fetchTime = `${endTime - startTime}ms`
    const buildTime = new Date().toLocaleString()

    return {
      props: {
        posts,
        users,
        buildTime,
        fetchTime,
        error: '',
      },
      revalidate: 3600,
    }
  } catch (error) {
    console.error('SSG Error:', error)
    
    // Return error state with empty data - this is what makes SSG resilient
    return {
      props: {
        posts: [],
        users: [],
        buildTime: new Date().toLocaleString(),
        fetchTime: 'Build failed',
        error: error instanceof Error ? error.message : 'Unknown build error occurred',
      },
      revalidate: 60, // Retry more frequently on error
    }
  }
}

export default SSGErrorPage
