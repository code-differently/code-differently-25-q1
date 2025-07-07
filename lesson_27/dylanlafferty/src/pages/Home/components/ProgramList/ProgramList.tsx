import './ProgramList.scss';
import {Program as ProgramType} from '@code-differently/types';
import {useQuery} from '@tanstack/react-query';
import React from 'react';

import {Program} from '../Program';

const fetchPrograms = async (): Promise<ProgramType[]> => {
  const response = await fetch('http://localhost:4000/programs');
  if (!response.ok) {
    throw new Error('Failed to fetch programs');
  }

  return response.json();
};

export const ProgramList: React.FC = () => {
  const {data, isLoading, error} = useQuery<ProgramType[]>({
    queryKey: ['programs'],
    queryFn: fetchPrograms,
  });

  if (isLoading) {
    return <div>Loading...</div>;
  }

  if (error instanceof Error) {
    return <div>Error: {error.message}</div>;
  }

  return (
    <ul className="programs">
      {data?.map((program: ProgramType) => (
        <Program key={program.id} title={program.title}>
          <p>{program.description}</p>
        </Program>
      ))}
    </ul>
  );
};
