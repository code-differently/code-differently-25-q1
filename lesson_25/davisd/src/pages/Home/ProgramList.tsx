import React from 'react';
import Program from './Program';

interface ProgramProps {
  title: string;
  description: string;
}

interface ProgramListProps {
  programs: ProgramProps[];
}

const ProgramList: React.FC<ProgramListProps> = ({ programs }) => {
  return (
    <ul className="programs">
      {programs.map((program, index) => (
        <li key={index} className="program">
          <Program title={program.title} 
          description={program.description} />
        </li>
      ))}
    </ul>
  );
};

export default ProgramList;
