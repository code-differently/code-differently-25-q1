import Program from './Programs';
import React from 'react';
import { programs } from './ProgramData';


const ProgramList: React.FC = () => {
  return (
    <section className="programs-section">
      <h2>
        Our <em className="highlight">Programs</em>
      </h2>
      <ul className="programs">
        {programs.map((program: { title: string; description: string; }, index: React.Key | null | undefined) => (
          <Program
            key={index}
            title={program.title}
            description={program.description}
          />
        ))}
      </ul>
    </section>
  );
};

export default ProgramList;
