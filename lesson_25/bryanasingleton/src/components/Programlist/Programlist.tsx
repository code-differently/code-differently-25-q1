import './Programlist.css';
import React from 'react';

const programs = [
  {
    title: 'Swine Short Loin',
    description:
      'Swine short loin burgdoggen ball tip, shank ham hock bacon. Picanha strip steak pork, swine boudin ham meatball meatloaf leberkas sausage.',
  },
  {
    title: 'Bacon Ipsum',
    description:
      'Bacon ipsum dolor amet leberkas chuck biltong pork loin sirloin bresaola rump frankfurter. Shoulder doner strip steak chuck.',
  },
  {
    title: 'Picanha Swine Jowl',
    description:
      'Picanha swine jowl meatball boudin pastrami bresaola fatback shankle pork belly cow. Frankfurter ground round shank corned beef chuck.',
  },
  {
    title: 'Kevin Chicken T-Bone',
    description:
      'Kevin chicken t-bone spare ribs shankle bacon drumstick kielbasa cow jowl doner salami chuck andouille.',
  },
];

const Program: React.FC<{title: string; description: string}> = ({
  title,
  description,
}) => {
  return (
    <li className="program">
      <h3>{title}</h3>
      <p>{description}</p>
    </li>
  );
};

const ProgramList: React.FC = () => {
  return (
    <section className="programs-section">
      <h2>
        Our <em className="highlight">Programs</em>
      </h2>
      <ul className="programs">
        {programs.map((program, index) => (
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
