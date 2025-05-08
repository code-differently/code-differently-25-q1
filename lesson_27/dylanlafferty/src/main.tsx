import App from './App.tsx';
import {Home} from './pages/Home/Home.tsx';
import {ProgramForm} from './pages/Home/components/ProgramForm/ProgramForm.tsx';
import {QueryClient, QueryClientProvider} from '@tanstack/react-query';
import ReactDOM from 'react-dom/client';
<<<<<<< HEAD
=======
import React from 'react';
>>>>>>> 9a8ee5e (feat: Implement feature that GET a list of programs from api)
import {RouterProvider, createBrowserRouter} from 'react-router-dom';

import './index.scss';

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
        path: '/programs',
        element: <ProgramForm />,
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
