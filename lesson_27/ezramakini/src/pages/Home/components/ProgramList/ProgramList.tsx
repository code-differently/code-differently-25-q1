import './ProgramList.scss';
import {Program as ProgramType} from '@code-differently/types';
import {useQuery} from '@tanstack/react-query';

import {Program} from '../Program';

const fetchPrograms = async (): Promise<ProgramType[]> => {
  const response = await fetch('http://localhost:4000/programs');
  if (!response.ok) {
    throw new Error('Failed to fetch programs');
  }
  return response.json();
};

export const ProgramList: React.FC = () => {
  const {
    data: programs,
    error,
    isLoading,
  } = useQuery({
    queryKey: ['programs'],
    queryFn: fetchPrograms,
  });

  if (isLoading) {
    return <div>Loading programs...</div>;
  }

  if (error) {
    return (
      <div className="error">
        Error: {error instanceof Error ? error.message : 'An error occurred'}
      </div>
    );
  }

  return (
    <ul className="programs">
      {programs?.map(program => (
        <Program key={program.id} title={program.title}>
          <p>{program.description}</p>
        </Program>
      ))}
    </ul>
  );
};
