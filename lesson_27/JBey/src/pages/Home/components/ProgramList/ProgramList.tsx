import './ProgramList.scss';
import {useEffect, useState} from 'react';

import {Program} from '../Program';

type ProgramData = {
  title: string;
  description: string;
};

export const ProgramList: React.FC = () => {
  const [programs, setPrograms] = useState<ProgramData[]>([]);

  useEffect(() => {
    fetch('http://localhost:4000/programs')
      .then(response => {
        if (response.ok) {
          return response.json();
        } else {
          return Promise.reject(new Error('Failed to load data'));
        }
      })
      .then(data => {
        setPrograms(data);
      })
      .catch(error => {
        console.error("Couldn't load data", error);
      });
  }, []);

  return (
    <>
      <ul className="programs">
        {programs.map((program, index) => (
          <li key={index} className="program">
            <Program title={program.title}>
              <p>{program.description}</p>
            </Program>
          </li>
        ))}
      </ul>
    </>
  );
};
