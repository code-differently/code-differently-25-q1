import './ProgramList.scss';
import {useEffect, useState} from 'react';

import {Program} from '../Program';

// Define the shape of my program data
interface ProgramData {
  title: string;
  description: string;
}

export const ProgramList: React.FC = () => {
  const [programs, setPrograms] = useState<ProgramData[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Replacing this with a real API call
    fetch('/api/programs')
      .then(response => {
        if (!response.ok) {
          throw new Error('Failed to fetch programs');
        }
        return response.json();
      })
      .then(data => {
        setPrograms(data);
        setLoading(false);
      })
      .catch(error => {
        console.error('Error fetching program data:', error);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <p>Loading programs...</p>;
  }

  return (
    <ul className="programs">
      {programs.map((program, index) => (
        <Program key={index} title={program.title}>
          <p>{program.description}</p>
        </Program>
      ))}
    </ul>
  );
};
