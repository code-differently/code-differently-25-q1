import React, { useState, useEffect } from 'react'
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

const CSRPage: React.FC = () => {
  const router = useRouter()
  const { error: forceError } = router.query
  
  const [posts, setPosts] = useState<Post[]>([])
  const [users, setUsers] = useState<User[]>([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState<string | null>(null)
  const [fetchTime, setFetchTime] = useState<string>('')

  useEffect(() => {
    const fetchData = async () => {
      try {
        setLoading(true)
        const startTime = Date.now()
        
        // Simulate API calls to demonstrate CSR
        const apiUrl = forceError === 'true' 
          ? 'https://invalid-api-endpoint.example.com/posts' 
          : 'https://jsonplaceholder.typicode.com/posts?_limit=6'
        
        const [postsResponse, usersResponse] = await Promise.all([
          fetch(apiUrl),
          fetch('https://jsonplaceholder.typicode.com/users')
        ])

        if (!postsResponse.ok || !usersResponse.ok) {
          throw new Error('Failed to fetch data')
        }

        const postsData = await postsResponse.json()
        const usersData = await usersResponse.json()

        setPosts(postsData)
        setUsers(usersData)
        
        const endTime = Date.now()
        setFetchTime(`${endTime - startTime}ms`)
      } catch (err) {
        setError(err instanceof Error ? err.message : 'An error occurred')
      } finally {
        setLoading(false)
      }
    }

    fetchData()
  }, [])

  const getUserName = (userId: number) => {
    const user = users.find(u => u.id === userId)
    return user ? user.name : 'Unknown User'
  }

  const refetchData = () => {
    setPosts([])
    setUsers([])
    setError(null)
    setFetchTime('')
    
    // Re-trigger the useEffect
    const fetchData = async () => {
      try {
        setLoading(true)
        const startTime = Date.now()
        
        const [postsResponse, usersResponse] = await Promise.all([
          fetch('https://jsonplaceholder.typicode.com/posts?_limit=6'),
          fetch('https://jsonplaceholder.typicode.com/users')
        ])

        if (!postsResponse.ok || !usersResponse.ok) {
          throw new Error('Failed to fetch data')
        }

        const postsData = await postsResponse.json()
        const usersData = await usersResponse.json()

        setPosts(postsData)
        setUsers(usersData)
        
        const endTime = Date.now()
        setFetchTime(`${endTime - startTime}ms`)
      } catch (err) {
        setError(err instanceof Error ? err.message : 'An error occurred')
      } finally {
        setLoading(false)
      }
    }

    fetchData()
  }

  return (
    <Layout title="CSR - Client-Side Rendering Demo">
      <div className="px-4 py-8">
        <div className="max-w-4xl mx-auto">
          <div className="text-center mb-8">
            <span className="badge badge-csr mb-4 inline-block">CSR</span>
            <h1 className="text-3xl font-bold text-gray-900 mb-4">
              Client-Side Rendering Example
            </h1>
            <p className="text-lg text-gray-600 mb-6">
              This page demonstrates CSR where data is fetched after the initial page load.
              Notice how the content appears after a loading state.
            </p>
          </div>

          <div className="bg-yellow-50 border border-yellow-200 rounded-lg p-4 mb-8">
            <h3 className="font-semibold text-yellow-800 mb-2">How CSR Works:</h3>
            <ul className="text-yellow-700 space-y-1 text-sm">
              <li>• Initial HTML is minimal and loads quickly</li>
              <li>• JavaScript runs in the browser to fetch data</li>
              <li>• Content is rendered after data is received</li>
              <li>• Users see loading states during data fetching</li>
            </ul>
          </div>

          <div className="flex justify-between items-center mb-6">
            <div className="text-sm text-gray-500">
              {fetchTime && `Fetch time: ${fetchTime}`}
              {loading && 'Fetching data...'}
            </div>
            <button
              onClick={refetchData}
              disabled={loading}
              className="btn-secondary disabled:opacity-50"
            >
              {loading ? 'Loading...' : 'Refetch Data'}
            </button>
          </div>

          {error && (
            <div className="bg-red-50 border border-red-200 rounded-lg p-4 mb-6">
              <div className="flex items-start">
                <div className="flex-shrink-0">
                  <span className="text-red-400 text-xl">⚠️</span>
                </div>
                <div className="ml-3">
                  <h3 className="text-sm font-medium text-red-800">CSR Error Encountered</h3>
                  <p className="text-red-700 mt-1 text-sm">Error: {error}</p>
                  
                  <div className="mt-4">
                    <h4 className="text-red-800 font-medium text-sm mb-2">Common CSR Debugging Tips:</h4>
                    <ul className="text-red-700 text-xs space-y-1">
                      <li>• Check browser console (F12) for detailed error messages</li>
                      <li>• Verify API endpoints are reachable and CORS is configured</li>
                      <li>• Use React DevTools to inspect component state and props</li>
                      <li>• Add error boundaries to catch and handle JavaScript errors</li>
                      <li>• Test with network throttling to simulate slow connections</li>
                      <li>• Implement retry logic for failed requests</li>
                    </ul>
                  </div>
                  
                  <div className="mt-4 flex gap-2">
                    <button
                      onClick={() => window.location.href = '/csr'}
                      className="text-xs bg-red-100 hover:bg-red-200 px-2 py-1 rounded text-red-800"
                    >
                      Try Normal Version
                    </button>
                    <button
                      onClick={refetchData}
                      className="text-xs bg-red-100 hover:bg-red-200 px-2 py-1 rounded text-red-800"
                    >
                      Retry Request
                    </button>
                  </div>
                </div>
              </div>
            </div>
          )}

          {loading ? (
            <div className="flex justify-center items-center py-12">
              <div className="loading-spinner"></div>
              <span className="ml-3 text-gray-600">Loading posts...</span>
            </div>
          ) : (
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
          )}

          <div className="mt-8 bg-gray-50 border border-gray-200 rounded-lg p-6">
            <h3 className="font-semibold text-gray-900 mb-3">CSR Characteristics:</h3>
            <div className="grid md:grid-cols-2 gap-4 text-sm">
              <div>
                <h4 className="font-medium text-green-700 mb-2">Advantages:</h4>
                <ul className="text-gray-600 space-y-1">
                  <li>• Fast initial page load</li>
                  <li>• Rich, interactive user experience</li>
                  <li>• Reduced server load</li>
                  <li>• Great for SPAs</li>
                </ul>
              </div>
              <div>
                <h4 className="font-medium text-red-700 mb-2">Disadvantages:</h4>
                <ul className="text-gray-600 space-y-1">
                  <li>• Poor SEO without additional setup</li>
                  <li>• Slower perceived performance</li>
                  <li>• Requires JavaScript enabled</li>
                  <li>• Larger bundle sizes</li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </Layout>
  )
}

export default CSRPage
