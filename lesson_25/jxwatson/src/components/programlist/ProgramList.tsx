import './ProgramList.scss';
import React from 'react';

import Program from '../program/Program';
import { Link } from 'react-router-dom';

interface Program {
  id: number;
  title: string;
  description: string;
}

interface ProgramListProps {
  programs: Program[];
}

const ProgramList: React.FC<ProgramListProps> = ({programs}) => {
  return (
    <ul className="programs">
      {programs.map(program => (
        <Program
          key={program.id}
          title={program.title}
          description={program.description}
        />
      ))}
      <Link to="add-program" className="add-program-button">
        Add Program
      </Link>
    </ul>
   
  );
};

export default ProgramList;
