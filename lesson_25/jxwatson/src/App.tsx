import './App.scss';
import {Outlet} from 'react-router-dom';

import {Footer} from './components/footer';
import {Header} from './components/header';
import { programs } from './components/program/programData';

function App() {
  return (
    <>
      <Header />
      <div className="main">
        <div className="content">
          <Outlet context={{ program: programs }} />
        </div>
      </div>
      <Footer />
    </>
  );
}

export default App;
