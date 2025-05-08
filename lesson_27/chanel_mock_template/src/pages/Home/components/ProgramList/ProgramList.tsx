import './ProgramList.scss';
import { useEffect, useState } from 'react';
import { Program } from '../Program';

interface ProgramData {
  id: string;
  title: string;
  description: string;
}

export const ProgramList: React.FC = () => {
  const [programs, setPrograms] = useState<ProgramData[]>([]);

  useEffect(() => {
    fetch("http://localhost:3001/programs")
      .then(response => response.json())
      .then(data => {
        setPrograms(data.programs);
      })
      .catch(error => {
        console.error("Error fetching programs:", error);
      });
  }, []);

  return (
    <ul className="programs">
      {programs.map((program) => (
        <Program key={program.id} title={program.title}>
          <p>{program.description}</p>
        </Program>
      ))}
    </ul>
  );
};
