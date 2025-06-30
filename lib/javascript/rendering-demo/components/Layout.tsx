import React from 'react'
import Link from 'next/link'
import Head from 'next/head'

interface LayoutProps {
  children: React.ReactNode
  title?: string
}

const Layout: React.FC<LayoutProps> = ({ children, title = 'Rendering Methods Demo' }) => {
  return (
    <>
      <Head>
        <title>{title}</title>
        <meta name="description" content="Demo showcasing CSR, SSR, and SSG rendering methods" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" href="/favicon.ico" />
      </Head>
      
      <div className="min-h-screen bg-gray-50">
        <nav className="bg-white shadow-sm border-b">
          <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
            <div className="flex justify-between items-center h-16">
              <div className="flex-shrink-0">
                <Link href="/" className="text-xl font-bold text-blue-600">
                  Rendering Demo
                </Link>
              </div>
              <div className="hidden md:block">
                <div className="ml-10 flex items-baseline space-x-4">
                  <Link href="/" className="nav-link">
                    Home
                  </Link>
                  <Link href="/csr" className="nav-link">
                    CSR
                  </Link>
                  <Link href="/ssr" className="nav-link">
                    SSR
                  </Link>
                  <Link href="/ssg" className="nav-link">
                    SSG
                  </Link>
                  <Link href="/hydration-error" className="nav-link">
                    Hydration
                  </Link>
                </div>
              </div>
            </div>
          </div>
        </nav>

        <main className="max-w-7xl mx-auto py-6 sm:px-6 lg:px-8">
          {children}
        </main>

        <footer className="bg-white border-t mt-auto">
          <div className="max-w-7xl mx-auto py-4 px-4 sm:px-6 lg:px-8">
            <p className="text-center text-sm text-gray-500">
              Demo showcasing different rendering methods: CSR, SSR, and SSG
            </p>
          </div>
        </footer>
      </div>

      <style jsx>{`
        .nav-link {
          @apply text-gray-500 hover:text-gray-900 px-3 py-2 rounded-md text-sm font-medium transition-colors;
        }
        .nav-link:hover {
          @apply bg-gray-100;
        }
      `}</style>
    </>
  )
}

export default Layout
