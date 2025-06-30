import React, { useState, useEffect } from 'react'
import { GetServerSideProps } from 'next'
import Layout from '../components/Layout'

interface HydrationErrorPageProps {
  serverTime: string
  forceError: boolean
}

const HydrationErrorPage: React.FC<HydrationErrorPageProps> = ({ serverTime, forceError }) => {
  const [clientTime, setClientTime] = useState<string>('')
  const [isClient, setIsClient] = useState(false)

  useEffect(() => {
    setIsClient(true)
    setClientTime(new Date().toLocaleString())
  }, [])

  // This will cause a REAL hydration mismatch if forceError is true
  const getDisplayTime = () => {
    if (forceError) {
      // This creates a real hydration error - server renders serverTime, 
      // but on client initial render (before useEffect), it will render current time
      return typeof window !== 'undefined' ? new Date().toLocaleString() : serverTime
    }
    return serverTime
  }

  // Another REAL hydration error - Math.random() will differ between server and client
  const getRandomContent = () => {
    if (forceError) {
      return `Random: ${Math.random().toFixed(4)}`
    }
    return 'Consistent Server Content'
  }

  // Real hydration error with conditional content
  const getConditionalContent = () => {
    if (forceError) {
      // This will be different on server vs client initial render
      return new Date().getTime() % 2 === 0 ? 'Even Time' : 'Odd Time'
    }
    return 'Static Content'
  }

  // EXTREME hydration error - completely different DOM structure
  const renderStructureMismatch = () => {
    if (forceError) {
      // Server renders one thing, client renders another
      return typeof window !== 'undefined' ? (
        <div>
          <p>Client Structure</p>
          <ul>
            <li>Client Item 1</li>
            <li>Client Item 2</li>
          </ul>
        </div>
      ) : (
        <div>
          <h3>Server Structure</h3>
          <span>Server content here</span>
        </div>
      )
    }
    return (
      <div>
        <p>Consistent Structure</p>
        <span>Same on server and client</span>
      </div>
    )
  }

  return (
    <Layout title="Hydration Error - SSR Demo">
      <div className="px-4 py-8">
        <div className="max-w-4xl mx-auto">
          <div className="text-center mb-8">
            <span className="badge badge-ssr mb-4 inline-block">HYDRATION ERROR</span>
            <h1 className="text-3xl font-bold text-gray-900 mb-4">
              Hydration Error Example
            </h1>
            <p className="text-lg text-gray-600 mb-6">
              This page demonstrates hydration mismatches - one of the most common SSR/SSG errors.
            </p>
          </div>

          <div className="bg-red-50 border border-red-200 rounded-lg p-4 mb-8">
            <h3 className="font-semibold text-red-800 mb-2">⚠️ What is a Hydration Error?</h3>
            <ul className="text-red-700 space-y-1 text-sm">
              <li>• Server renders HTML with one content, client expects different content</li>
              <li>• React cannot reconcile the differences during hydration</li>
              <li>• Common causes: timestamps, random values, browser-only APIs</li>
              <li>• Results in console warnings and potential broken functionality</li>
            </ul>
          </div>

          {forceError && (
            <div className="bg-yellow-50 border border-yellow-200 rounded-lg p-4 mb-6">
              <div className="flex items-start">
                <div className="flex-shrink-0">
                  <span className="text-yellow-400 text-xl">⚠️</span>
                </div>
                <div className="ml-3">
                  <h3 className="text-sm font-medium text-yellow-800">Active Hydration Mismatches Detected!</h3>
                  <p className="text-yellow-700 mt-1 text-sm">
                    <strong>Check your browser console now!</strong> You should see Next.js hydration warnings.
                  </p>
                  
                  <div className="mt-4">
                    <h4 className="text-yellow-800 font-medium text-sm mb-2">What to look for in Console:</h4>
                    <ul className="text-yellow-700 text-xs space-y-1">
                      <li>• <code className="bg-yellow-100 px-1 rounded">Warning: Text content did not match</code></li>
                      <li>• <code className="bg-yellow-100 px-1 rounded">Warning: Prop `children` did not match</code></li>
                      <li>• <code className="bg-yellow-100 px-1 rounded">Hydration failed because the initial UI does not match</code></li>
                      <li>• Red error overlay may appear in development mode</li>
                    </ul>
                  </div>
                  
                  <div className="mt-4">
                    <h4 className="text-yellow-800 font-medium text-sm mb-2">Hydration Error Debugging Tips:</h4>
                    <ul className="text-yellow-700 text-xs space-y-1">
                      <li>• Open browser DevTools Console (F12) to see detailed warnings</li>
                      <li>• Look for "Hydration failed" or "Text content did not match" messages</li>
                      <li>• Next.js will show exactly which elements have mismatches</li>
                      <li>• Use suppressHydrationWarning={true} only for unavoidable mismatches</li>
                      <li>• Use useEffect to render client-only content after hydration</li>
                      <li>• Avoid using Date.now(), Math.random() directly in render</li>
                      <li>• Use libraries like 'use-isomorphic-layout-effect' for SSR safety</li>
                      <li>• Consider dynamic imports with ssr: false for client-only components</li>
                    </ul>
                  </div>
                  
                  <div className="mt-4 flex gap-2">
                    <button
                      onClick={() => window.location.href = '/hydration-error'}
                      className="text-xs bg-yellow-100 hover:bg-yellow-200 px-2 py-1 rounded text-yellow-800"
                    >
                      Try Normal Version
                    </button>
                    <button
                      onClick={() => window.location.reload()}
                      className="text-xs bg-yellow-100 hover:bg-yellow-200 px-2 py-1 rounded text-yellow-800"
                    >
                      Reload Page
                    </button>
                  </div>
                </div>
              </div>
            </div>
          )}

          <div className="grid gap-6">
            <div className="card">
              <h2 className="text-xl font-semibold text-gray-900 mb-4">
                Real Hydration Mismatch Examples
              </h2>
              <div className="space-y-4">
                <div className="p-4 bg-gray-50 rounded border-2 border-dashed border-gray-300">
                  <div className="text-sm font-medium text-gray-600 mb-2">Time-based Mismatch:</div>
                  <div className={`font-mono text-sm ${forceError ? 'text-red-600' : 'text-green-600'}`}>
                    {getDisplayTime()}
                  </div>
                </div>
                
                <div className="p-4 bg-gray-50 rounded border-2 border-dashed border-gray-300">
                  <div className="text-sm font-medium text-gray-600 mb-2">Random Content Mismatch:</div>
                  <div className={`font-mono text-sm ${forceError ? 'text-red-600' : 'text-green-600'}`}>
                    {getRandomContent()}
                  </div>
                </div>
                
                <div className="p-4 bg-gray-50 rounded border-2 border-dashed border-gray-300">
                  <div className="text-sm font-medium text-gray-600 mb-2">Conditional Content Mismatch:</div>
                  <div className={`font-mono text-sm ${forceError ? 'text-red-600' : 'text-green-600'}`}>
                    {getConditionalContent()}
                  </div>
                </div>
                
                {forceError && (
                  <div className="p-4 bg-red-50 rounded border-2 border-red-300">
                    <div className="text-sm font-medium text-red-700 mb-2">DOM Structure Mismatch:</div>
                    <div className="text-red-600">
                      {renderStructureMismatch()}
                    </div>
                  </div>
                )}
              </div>
              
              {forceError && (
                <div className="mt-4 p-3 bg-red-50 border border-red-200 rounded">
                  <p className="text-red-800 text-sm">
                    <strong>⚠️ Active Hydration Errors Above!</strong><br/>
                    These elements will cause hydration mismatches because the server-rendered 
                    content differs from what React expects on the client's initial render.
                  </p>
                </div>
              )}
            </div>

            <div className="card">
              <h2 className="text-xl font-semibold text-gray-900 mb-4">
                Server vs Client Data
              </h2>
              <div className="space-y-3 text-sm">
                <div className="flex justify-between">
                  <span className="font-medium text-gray-600">Server Time:</span>
                  <span className="text-gray-900">{serverTime}</span>
                </div>
                <div className="flex justify-between">
                  <span className="font-medium text-gray-600">Client Time:</span>
                  <span className="text-gray-900">{clientTime || 'Loading...'}</span>
                </div>
                <div className="flex justify-between border-t pt-3">
                  <span className="font-medium text-gray-600">Display Time:</span>
                  <span className={`font-medium ${forceError ? 'text-red-600' : 'text-green-600'}`}>
                    {getDisplayTime()}
                  </span>
                </div>
              </div>
            </div>

            <div className="card">
              <h2 className="text-xl font-semibold text-gray-900 mb-4">
                Content Mismatch Example (Legacy - Fixed Version)
              </h2>
              <div className="p-4 bg-gray-50 rounded border-2 border-dashed border-gray-300">
                <div className="text-center">
                  <span className="font-medium text-green-600">
                    Properly Handled Content
                  </span>
                </div>
              </div>
              <p className="text-sm text-gray-500 mt-2">
                ☝️ This content is handled properly using useEffect to avoid hydration mismatches
              </p>
            </div>

            <div className="card">
              <h2 className="text-xl font-semibold text-gray-900 mb-4">
                Browser-Only API Example
              </h2>
              <div className="space-y-3 text-sm">
                <div className="flex justify-between">
                  <span className="font-medium text-gray-600">Window Width:</span>
                  <span className="text-gray-900">
                    {isClient ? `${window.innerWidth}px` : 'Server: Unknown'}
                  </span>
                </div>
                <div className="flex justify-between">
                  <span className="font-medium text-gray-600">User Agent:</span>
                  <span className="text-gray-900 text-xs max-w-md truncate">
                    {isClient ? navigator.userAgent : 'Server: Unknown'}
                  </span>
                </div>
              </div>
              <p className="text-sm text-gray-500 mt-3">
                ☝️ These values are only available on the client and are handled properly with useEffect
              </p>
            </div>
          </div>

          <div className="mt-8 bg-gray-50 border border-gray-200 rounded-lg p-6">
            <h3 className="font-semibold text-gray-900 mb-3">Preventing Hydration Errors:</h3>
            <div className="grid md:grid-cols-2 gap-4 text-sm">
              <div>
                <h4 className="font-medium text-blue-700 mb-2">Best Practices:</h4>
                <ul className="text-gray-600 space-y-1">
                  <li>• Use useEffect for client-only code</li>
                  <li>• Avoid timestamps in initial render</li>
                  <li>• Use consistent data between server/client</li>
                  <li>• Handle browser APIs safely</li>
                </ul>
              </div>
              <div>
                <h4 className="font-medium text-green-700 mb-2">Solutions:</h4>
                <ul className="text-gray-600 space-y-1">
                  <li>• Dynamic imports with ssr: false</li>
                  <li>• suppressHydrationWarning for edge cases</li>
                  <li>• Use isomorphic libraries</li>
                  <li>• Conditional rendering based on isClient state</li>
                </ul>
              </div>
            </div>
          </div>

          <div className="mt-6 bg-blue-50 border border-blue-200 rounded-lg p-4">
            <h4 className="font-semibold text-blue-800 mb-2">Code Example - Proper Hydration-Safe Component:</h4>
            <pre className="text-xs text-blue-700 bg-blue-100 p-3 rounded overflow-x-auto">
{`const SafeComponent = () => {
  const [isClient, setIsClient] = useState(false)
  
  useEffect(() => {
    setIsClient(true)
  }, [])
  
  if (!isClient) {
    return <div>Loading...</div>
  }
  
  return <div>{new Date().toLocaleString()}</div>
}`}
            </pre>
          </div>
        </div>
      </div>
    </Layout>
  )
}

export const getServerSideProps: GetServerSideProps<HydrationErrorPageProps> = async (context) => {
  const { error: forceError } = context.query

  return {
    props: {
      serverTime: new Date().toLocaleString(),
      forceError: forceError === 'true',
    },
  }
}

export default HydrationErrorPage
