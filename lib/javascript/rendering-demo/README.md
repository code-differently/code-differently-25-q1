# Rendering Methods Demo

A comprehensive demonstration of three different rendering approaches in modern web development:

- **Client-Side Rendering (CSR)** - Dynamic data fetching in the browser
- **Server-Side Rendering (SSR)** - HTML generated on each request
- **Static Site Generation (SSG)** - Pre-built HTML at build time

## Features

### 🌐 CSR (Client-Side Rendering)
- Demonstrates data fetching after page load
- Shows loading states and error handling
- Interactive refetch functionality
- Real-time performance metrics

### ⚡️ SSR (Server-Side Rendering)
- Server-side data fetching with `getServerSideProps`
- Shows render timestamp for each request
- SEO-friendly pre-populated content
- Server performance metrics

### 🏗️ SSG (Static Site Generation)
- Build-time data fetching with `getStaticProps`
- Static HTML generation
- Optional ISR (Incremental Static Regeneration)
- Build timestamp tracking

### 💧 Hydration Error Demo
- Demonstrates common hydration mismatches
- Shows server vs client rendering differences
- Browser console error examples
- Best practices for preventing hydration issues

## Technology Stack

- **Framework**: Next.js 14
- **Language**: TypeScript
- **Styling**: Tailwind CSS
- **Data Source**: JSONPlaceholder API
- **Deployment**: Vercel-ready

## Getting Started

### Prerequisites
- Node.js 18+ 
- npm or yarn

### Installation

1. Clone or download this project
2. Install dependencies:
```bash
npm install
```

3. Run the development server:
```bash
npm run dev
```

4. Open [http://localhost:3000](http://localhost:3000) in your browser

### Build for Production

```bash
npm run build
npm run start
```

## Project Structure

```
├── components/
│   └── Layout.tsx          # Shared layout component
├── pages/
│   ├── _app.tsx           # Next.js app configuration
│   ├── index.tsx          # Home page with explanations
│   ├── csr.tsx            # Client-Side Rendering demo
│   ├── ssr.tsx            # Server-Side Rendering demo
│   ├── ssg.tsx            # Static Site Generation demo
│   ├── ssg-error.tsx      # SSG error handling demo
│   └── hydration-error.tsx # Hydration mismatch demo
├── styles/
│   └── globals.css        # Global styles and Tailwind
└── README.md
```

## Key Differences Demonstrated

### CSR (Client-Side Rendering)
- ✅ Fast initial page load (minimal HTML)
- ✅ Rich interactivity
- ✅ Reduced server load
- ❌ SEO challenges
- ❌ Slower perceived performance
- ❌ Loading states required

### SSR (Server-Side Rendering)
- ✅ Excellent SEO
- ✅ Fast perceived performance
- ✅ Works without JavaScript
- ❌ Higher server load
- ❌ Slower page navigation
- ❌ Complex caching

### SSG (Static Site Generation)
- ✅ Fastest loading times
- ✅ Perfect SEO
- ✅ CDN-friendly
- ✅ Lower hosting costs
- ❌ Static content only
- ❌ Rebuild required for updates
- ❌ Longer build times

## Performance Comparison

Navigate between the three examples to observe:
- **Load times**: SSG fastest, then SSR, then CSR
- **Interactivity**: CSR most interactive, SSR/SSG less so
- **SEO**: SSG/SSR excellent, CSR requires additional setup
- **Caching**: SSG easiest to cache, SSR complex, CSR variable
- **Hydration**: SSR/SSG can have hydration mismatches, CSR doesn't

## Use Cases

### When to use CSR:
- Single Page Applications (SPAs)
- Highly interactive dashboards
- Applications requiring frequent updates
- User-specific content

### When to use SSR:
- E-commerce product pages
- News websites
- Dynamic content that needs SEO
- Personalized content

### When to use SSG:
- Marketing websites
- Blogs and documentation
- Landing pages
- Content that changes infrequently

## API Used

This demo uses the [JSONPlaceholder](https://jsonplaceholder.typicode.com/) API for sample data:
- Posts: `/posts`
- Users: `/users`

## Deployment

This project is ready to deploy on Vercel:

1. Push to GitHub
2. Connect to Vercel
3. Deploy with default settings

Or deploy manually:
```bash
npm run build
npm run start
```

## Learning Resources

- [Next.js Documentation](https://nextjs.org/docs)
- [React Documentation](https://react.dev)
- [Tailwind CSS Documentation](https://tailwindcss.com/docs)

## License

MIT License - feel free to use this project for learning and demonstration purposes.
