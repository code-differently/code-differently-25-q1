import './ProgramList.scss';
import {Program as ProgramType} from '@code-differently/types';
import React, {useEffect, useState} from 'react';

import {Program} from '../Program';

export const ProgramList: React.FC = () => {
  const [programs, setPrograms] = useState<ProgramType[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    const fetchPrograms = async () => {
      try {
        const response = await fetch('http://localhost:4000/programs');
        if (!response.ok) throw new Error('Failed to fetch programs');
        const data = await response.json();
        setPrograms(data);
      } catch (err) {
        console.error(err);
        setError('Unable to load programs');
      } finally {
        setLoading(false);
      }
    };

    fetchPrograms();
  }, []);

  if (loading) return <p>Loading programs...</p>;
  if (error) return <p>{error}</p>;

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
