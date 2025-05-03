import { Outlet } from 'react-router-dom';

function App() {
  return (
    <main>
      {/* Optional: add nav or layout elements here */}
      <Outlet /> {/* This renders the page that matches the current route */}
    </main>
  );
}

export default App;