import './ProgramList.scss';
import React, {useEffect, useState} from 'react';

import {Program} from '../Program';

type ProgramData = {
  id: string;
  title: string;
  description: string;
};

export const ProgramList: React.FC = () => {
  const [programs, setPrograms] = useState<ProgramData[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  useEffect(() => {
    const fetchPrograms = async () => {
      try {
        const response = await fetch('http://localhost:4000/programs');
        if (!response.ok) {
          throw new Error('Failed to fetch programs');
        }
        const data = await response.json();
        setPrograms(data);
      } catch (err: any) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchPrograms();
  }, []);
  if (loading) return <p>Loading programs...</p>;
  if (error) return <p>Error: {error}</p>;

  return (
    <ul className="programs">
      {programs.map(program => (
        <Program key={program.id} title={program.title}>
          <p>{program.description}</p>
        </Program>
      ))}
    </ul>
  );
};
