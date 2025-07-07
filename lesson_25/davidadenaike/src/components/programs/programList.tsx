import Program from './program';
import React from 'react';

interface ProgramData {
  title: string;
  description: string;
}

interface ProgramListProps {
  programs: ProgramData[];
}

const ProgramList: React.FC<ProgramListProps> = ({programs}) => {
  return (
    <ul className="programs">
      {programs.map((program, index) => (
        <Program
          key={index}
          title={program.title}
          description={program.description}
        />
      ))}
    </ul>
  );
};

export default ProgramList;
