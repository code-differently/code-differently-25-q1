import App from './App.tsx';
import {Home} from './pages/Home/Home.tsx';
import {QueryClient, QueryClientProvider} from '@tanstack/react-query';
import React from 'react';
import ReactDOM from 'react-dom/client';
import {RouterProvider, createBrowserRouter} from 'react-router-dom';

import './index.scss';
import { SecondPage } from './pages/SecondPage/SecondPage.tsx';

const queryClient = new QueryClient();

const router = createBrowserRouter([
  {
    path: '/',
    element: <App />,
    children: [
      {
        path: '/',
        element: <Home />,
      },
      {
        path: '/second-page',
        element: <SecondPage />,
      }
    ],
  },
]);

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <QueryClientProvider client={queryClient}>
      <RouterProvider router={router} />
    </QueryClientProvider>
  </React.StrictMode>
);
