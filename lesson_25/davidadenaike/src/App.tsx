import './App.scss';
import {useState} from 'react';
import {Outlet} from 'react-router-dom';

import {Footer} from './components/footer';
import {Header} from './components/header';
import {NewProgram} from './components/newPrograms/NewProgram';
import {programsData} from './components/programs/programData';

function App() {
  const [programs, setPrograms] = useState(programsData);

  const addNewProgram = (newProgram: {title: string; description: string}) => {
    setPrograms(prev => [...prev, newProgram]);
  };

  return (
    <>
      <Header />
      <div className="main">
        <div className="content">
          <Outlet context={{addNewProgram}} /> {/* Pass the function here */}
        </div>
      </div>
      <Footer />
    </>
  );
}

export default App;
