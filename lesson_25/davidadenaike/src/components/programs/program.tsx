import './program.css';
import React from 'react';

interface ProgramProps {
  title: string;
  description: string;
}

const Program: React.FC<ProgramProps> = ({title, description}) => {
  return (
    <li className="program">
      <h3>{title}</h3>
      <p>{description}</p>
    </li>
  );
};

export default Program;
