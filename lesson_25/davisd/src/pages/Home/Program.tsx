import React from 'react';

interface ProgramProps {
  title: string;
  description: string;
}

const Program: React.FC<ProgramProps> = ({title, description}) => {
  return (
    <>
      <h3>{title}</h3>
      <p>{description}</p>
    </>
  );
};

export default Program;
