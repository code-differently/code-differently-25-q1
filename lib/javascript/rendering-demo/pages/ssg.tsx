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

interface SSGPageProps {
  posts: Post[]
  users: User[]
  buildTime: string
  fetchTime: string
}

const SSGPage: React.FC<SSGPageProps> = ({ posts, users, buildTime, fetchTime }) => {
  const getUserName = (userId: number) => {
    const user = users.find(u => u.id === userId)
    return user ? user.name : 'Unknown User'
  }

  return (
    <Layout title="SSG - Static Site Generation Demo">
      <div className="px-4 py-8">
        <div className="max-w-4xl mx-auto">
          <div className="text-center mb-8">
            <span className="badge badge-ssg mb-4 inline-block">SSG</span>
            <h1 className="text-3xl font-bold text-gray-900 mb-4">
              Static Site Generation Example
            </h1>
            <p className="text-lg text-gray-600 mb-6">
              This page demonstrates SSG where data is fetched at build time.
              The content is pre-generated and served as static HTML.
            </p>
          </div>

          <div className="bg-purple-50 border border-purple-200 rounded-lg p-4 mb-8">
            <h3 className="font-semibold text-purple-800 mb-2">How SSG Works:</h3>
            <ul className="text-purple-700 space-y-1 text-sm">
              <li>• Data is fetched during the build process</li>
              <li>• Static HTML files are generated</li>
              <li>• No server-side processing on each request</li>
              <li>• Extremely fast loading and great for CDN caching</li>
            </ul>
          </div>

          <div className="flex justify-between items-center mb-6">
            <div className="text-sm text-gray-500 space-x-4">
              <span>Build fetch time: {fetchTime}</span>
              <span>Generated at: {buildTime}</span>
            </div>
            <div className="text-sm text-gray-500">
              Static content (no reload needed)
            </div>
          </div>

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
            <h3 className="font-semibold text-gray-900 mb-3">SSG Characteristics:</h3>
            <div className="grid md:grid-cols-2 gap-4 text-sm">
              <div>
                <h4 className="font-medium text-green-700 mb-2">Advantages:</h4>
                <ul className="text-gray-600 space-y-1">
                  <li>• Fastest possible loading times</li>
                  <li>• Excellent SEO performance</li>
                  <li>• CDN-friendly and scalable</li>
                  <li>• Works without JavaScript</li>
                  <li>• Lower hosting costs</li>
                </ul>
              </div>
              <div>
                <h4 className="font-medium text-red-700 mb-2">Disadvantages:</h4>
                <ul className="text-gray-600 space-y-1">
                  <li>• Not suitable for dynamic content</li>
                  <li>• Requires rebuild for content updates</li>
                  <li>• Longer build times for large sites</li>
                  <li>• Limited interactivity without client-side JS</li>
                </ul>
              </div>
            </div>
          </div>

          <div className="mt-6 bg-purple-50 border border-purple-200 rounded-lg p-4">
            <p className="text-purple-800 text-sm">
              <strong>Notice:</strong> This content was generated at build time on {buildTime}. 
              The content will remain the same until the next build, making it perfect for blogs, 
              documentation, and other content that doesn't change frequently.
            </p>
          </div>

          <div className="mt-6 bg-orange-50 border border-orange-200 rounded-lg p-4">
            <h4 className="font-semibold text-orange-800 mb-2">When to use SSG:</h4>
            <ul className="text-orange-700 text-sm space-y-1">
              <li>• Marketing pages and landing pages</li>
              <li>• Blogs and documentation sites</li>
              <li>• E-commerce product catalogs</li>
              <li>• Any content that doesn't change frequently</li>
            </ul>
          </div>
        </div>
      </div>
    </Layout>
  )
}

export const getStaticProps: GetStaticProps<SSGPageProps> = async () => {
  try {
    const startTime = Date.now()

    // Fetch data at build time
    const [postsResponse, usersResponse] = await Promise.all([
      fetch('https://jsonplaceholder.typicode.com/posts?_limit=6'),
      fetch('https://jsonplaceholder.typicode.com/users')
    ])

    if (!postsResponse.ok || !usersResponse.ok) {
      throw new Error('Failed to fetch data')
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
      },
      // Optional: regenerate the page at most once every hour
      revalidate: 3600,
    }
  } catch (error) {
    console.error('SSG Error:', error)
    
    // Return empty data if fetch fails
    return {
      props: {
        posts: [],
        users: [],
        buildTime: new Date().toLocaleString(),
        fetchTime: 'Failed to fetch',
      },
      revalidate: 60, // Retry more frequently on error
    }
  }
}

export default SSGPage
