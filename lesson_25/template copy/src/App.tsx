import './App.scss';
import {Outlet} from 'react-router-dom';
import {Program} from './components/Program';
import {Footer} from './components/footer';
import {Header} from './components/header';

function App() {
  return (
    <>
      <Header />
      <div className="main">
        <div className="content">
          <Outlet />
        </div>
        <Program />
      </div>
      
      <Footer />
    </>
  );
}

export default App;
