// This file defines the router paths.
import App from './App.tsx';
import {Home} from './pages/Home/Home.tsx';
import AcceptedForm from './pages/acceptedForm/acceptedForm.tsx';
import {NewProgram} from './pages/newProgram/newProgram.tsx';
import {QueryClient, QueryClientProvider} from '@tanstack/react-query';
import React from 'react';
import ReactDOM from 'react-dom/client';
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
        path: '/new-program',
        element: <NewProgram />,
      },
      {
        path: '/accepted-form',
        element: <AcceptedForm />,
      },
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
