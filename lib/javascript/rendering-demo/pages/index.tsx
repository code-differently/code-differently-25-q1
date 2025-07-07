import React from 'react'
import Link from 'next/link'
import Layout from '../components/Layout'

const HomePage: React.FC = () => {
  return (
    <Layout title="Home - Rendering Methods Demo">
      <div className="px-4 py-8">
        <div className="text-center mb-12">
          <h1 className="text-4xl font-bold text-gray-900 mb-4">
            Rendering Methods Demo
          </h1>
          <p className="text-xl text-gray-600 max-w-3xl mx-auto">
            Explore three different rendering approaches: Client-Side Rendering (CSR), 
            Server-Side Rendering (SSR), and Static Site Generation (SSG).
          </p>
        </div>

        <div className="grid md:grid-cols-3 gap-8 max-w-6xl mx-auto">
          {/* CSR Card */}
          <div className="card hover:shadow-lg transition-shadow">
            <div className="flex items-center mb-4">
              <span className="badge badge-csr mr-3">CSR</span>
              <h2 className="text-xl font-semibold text-gray-900">
                Client-Side Rendering
              </h2>
            </div>
            <p className="text-gray-600 mb-6">
              Data is fetched dynamically in the browser after the initial page load. 
              Great for interactive applications with frequently changing data.
            </p>
            <div className="space-y-3 mb-6">
              <div className="text-sm text-gray-500">
                <strong>Pros:</strong> Fast initial load, rich interactions
              </div>
              <div className="text-sm text-gray-500">
                <strong>Cons:</strong> SEO challenges, slower perceived performance
              </div>
            </div>
            <div className="flex gap-3">
              <Link href="/csr" className="btn-primary inline-block">
                View CSR Example
              </Link>
              <Link href="/csr?error=true" className="btn-secondary inline-block text-red-600">
                Test CSR Error
              </Link>
            </div>
          </div>

          {/* SSR Card */}
          <div className="card hover:shadow-lg transition-shadow">
            <div className="flex items-center mb-4">
              <span className="badge badge-ssr mr-3">SSR</span>
              <h2 className="text-xl font-semibold text-gray-900">
                Server-Side Rendering
              </h2>
            </div>
            <p className="text-gray-600 mb-6">
              HTML is generated on the server for each request. Perfect for 
              dynamic content that needs to be SEO-friendly.
            </p>
            <div className="space-y-3 mb-6">
              <div className="text-sm text-gray-500">
                <strong>Pros:</strong> SEO-friendly, fast perceived performance
              </div>
              <div className="text-sm text-gray-500">
                <strong>Cons:</strong> Higher server load, slower navigation
              </div>
            </div>
            <div className="flex gap-3">
              <Link href="/ssr" className="btn-primary inline-block">
                View SSR Example
              </Link>
              <Link href="/ssr?error=true" className="btn-secondary inline-block text-red-600">
                Test SSR Error
              </Link>
            </div>
          </div>

          {/* SSG Card */}
          <div className="card hover:shadow-lg transition-shadow">
            <div className="flex items-center mb-4">
              <span className="badge badge-ssg mr-3">SSG</span>
              <h2 className="text-xl font-semibold text-gray-900">
                Static Site Generation
              </h2>
            </div>
            <p className="text-gray-600 mb-6">
              HTML is pre-generated at build time. Ideal for content that 
              doesn't change frequently, offering the best performance.
            </p>
            <div className="space-y-3 mb-6">
              <div className="text-sm text-gray-500">
                <strong>Pros:</strong> Fastest performance, great SEO, CDN-friendly
              </div>
              <div className="text-sm text-gray-500">
                <strong>Cons:</strong> Static content, rebuild needed for updates
              </div>
            </div>
            <div className="flex gap-3">
              <Link href="/ssg" className="btn-primary inline-block">
                View SSG Example
              </Link>
              <Link href="/ssg-error" className="btn-secondary inline-block text-red-600">
                Test SSG Error
              </Link>
            </div>
          </div>
        </div>

        <div className="mt-12 text-center">
          <div className="bg-blue-50 border border-blue-200 rounded-lg p-6 max-w-4xl mx-auto mb-6">
            <h3 className="text-lg font-semibold text-blue-900 mb-2">
              Understanding the Differences
            </h3>
            <p className="text-blue-800">
              Each rendering method has its place depending on your use case. Click on each 
              example above to see how they work in practice and compare their behavior.
            </p>
          </div>
          
          <div className="bg-orange-50 border border-orange-200 rounded-lg p-6 max-w-4xl mx-auto mb-6">
            <h3 className="text-lg font-semibold text-orange-900 mb-2">
              🐛 Error Debugging Examples
            </h3>
            <p className="text-orange-800 mb-3">
              Use the "Test Error" buttons to see common errors and debugging strategies for each rendering method.
            </p>
            <div className="grid md:grid-cols-3 gap-4 text-sm">
              <div className="text-left">
                <h4 className="font-semibold text-orange-900 mb-1">CSR Errors</h4>
                <p className="text-orange-700">Network failures, CORS issues, client-side API problems</p>
              </div>
              <div className="text-left">
                <h4 className="font-semibold text-orange-900 mb-1">SSR Errors</h4>
                <p className="text-orange-700">Server-side API failures, timeout issues, environment problems</p>
              </div>
              <div className="text-left">
                <h4 className="font-semibold text-orange-900 mb-1">SSG Errors</h4>
                <p className="text-orange-700">Build-time failures, API unavailability, configuration issues</p>
              </div>
            </div>
          </div>
          
          <div className="bg-red-50 border border-red-200 rounded-lg p-6 max-w-4xl mx-auto">
            <h3 className="text-lg font-semibold text-red-900 mb-2">
              💧 Hydration Error Demo
            </h3>
            <p className="text-red-800 mb-4">
              Hydration errors occur when server-rendered HTML doesn't match what React expects on the client. 
              This is one of the most common SSR/SSG issues and will trigger Next.js error overlays.
            </p>
            <div className="flex gap-3 justify-center">
              <a href="/hydration-error" className="btn-primary inline-block">
                View Normal Hydration
              </a>
              <a href="/hydration-error?error=true" className="btn-secondary inline-block text-red-600">
                Test Hydration Error
              </a>
            </div>
            <p className="text-red-700 text-sm mt-3 text-center">
              <strong>Tip:</strong> The error version will show Next.js error overlay + console warnings!
            </p>
          </div>
        </div>
      </div>
    </Layout>
  )
}

export default HomePage
