import {Program} from './Program';
import React from 'react';

const programs = [
  {
    title: 'Swine Short Loin',
    description:
      'Swine short loin burgdoggen ball tip, shank ham hock bacon...',
  },
  {
    title: 'Bacon Ipsum',
    description: 'Bacon ipsum dolor amet leberkas chuck biltong pork loin...',
  },
  {
    title: 'Picanha Swine Jowl',
    description: 'Picanha swine jowl meatball boudin pastrami bresaola...',
  },
  {
    title: 'Kevin Chicken T-Bone',
    description: 'Kevin chicken t-bone spare ribs shankle bacon drumstick...',
  },
];

export const ProgramList: React.FC = () => {
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
