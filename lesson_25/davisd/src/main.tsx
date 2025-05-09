import App from './App.tsx';
import {AddProgram} from './pages/Home/AddProgram';
import {addProgramAction} from './pages/Home/AddProgramAction';
import {Home} from './pages/Home/Home.tsx';
import {QueryClient, QueryClientProvider} from '@tanstack/react-query';
import React from 'react';
import ReactDOM from 'react-dom/client';
import {
  Route,
  RouterProvider,
  Routes,
  createBrowserRouter,
} from 'react-router-dom';

import './index.scss';

<Routes>
  <Route path="/" element={<Home />} />
  <Route path="/add" element={<AddProgram />} />
</Routes>;

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
        path: '/add',
        element: <AddProgram />,
        action: addProgramAction,
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
