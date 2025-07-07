import {Program} from '@code-differently/types';
import {useQuery} from '@tanstack/react-query';
import React from 'react';

const fetchPrograms = async (): Promise<Program[]> => {
  const response = await fetch('/api/programs'); // Replace with your actual API endpoint
  if (!response.ok) {
    throw new Error('Failed to fetch programs');
  }
  return response.json();
};

export const ProgramList: React.FC = () => {
  const {
    data: programs,
    isLoading,
    error,
  } = useQuery({queryKey: ['programs'], queryFn: fetchPrograms});

  if (isLoading) return <p>Loading...</p>;
  if (error instanceof Error) return <p>Error: {error.message}</p>;

  return (
    <div className="program-list">
      {programs?.map(program => (
        <div key={program.id} className="program-item">
          <h3>{program.title}</h3>
          <p>{program.description}</p>
        </div>
      ))}
    </div>
  );
};
