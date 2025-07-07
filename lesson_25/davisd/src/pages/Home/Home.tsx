import './Home.scss';
import ProgramList from './ProgramList';
import React from 'react';

interface ProgramProps {
  title: string;
  description: string;
}

export const Home: React.FC = () => {
  const programs: ProgramProps[] = [
    {
      title: 'Swine Short Loin',
      description:
        'Swine short loin burgdoggen ball tip, shank ham hock bacon. Picanha strip steak pork, swine boudin ham meatball meatloaf leberkas sausage. Turkey beef andouille kielbasa rump pastrami biltong chislic alcatra buffalo prosciutto jowl. Pastrami chicken sirloin swine capicola landjaeger jowl boudin pork chop shankle bresaola turducken leberkas ham.',
    },
    {
      title: 'Bacon Ipsum',
      description:
        ' Swine short loin burgdoggen ball tip, shank ham hock bacon. Picanha strip steak pork, swine boudin ham meatball meatloaf leberkas sausage. Turkey beef andouille kielbasa rump pastrami biltong chislic alcatra buffalo prosciutto jowl. Pastrami chicken sirloin swine capicola landjaeger jowl boudin pork chop shankle bresaola turducken leberkas ham.',
    },
    {
      title: 'Picanha Swine Jowl',
      description:
        'Picanha swine jowl meatball boudin pastrami bresaola fatback shankle pork belly cow. Frankfurter ground round shank corned beef chuck. Jerky frankfurter fatback capicola hamburger, pork prosciutto bresaola ham porchetta rump t-bone pancetta tenderloin. Fatback ham hock prosciutto, tenderloin shoulder salami tri-tip leberkas bacon turducken chislic venison sausage frankfurter.',
    },
    {
      title: 'Kevin Chicken T-Bone',
      description:
        'Kevin chicken t-bone spare ribs shankle bacon drumstick kielbasa cow jowl doner salami chuck andouille. Rump spare ribs bresaola rankfurter shankle. Bresaola ribeye turducken, cow leberkas boudin biltong sirloin filet mignon ham pork belly shank. Tenderloin sirloin pancetta pork loin shankle venison turducken boudin. Brisket tenderloin salami ham bresaola burgdoggen.',
    },
  ];

  return (
    <article>
      <section className="hero-section">
        <div className="hero-overlay"></div>
        <div className="hero-content">
          <h2 className="hero-title">
            Together we can move the needle of{' '}
            <em className="highlight">diversity in tech.</em>
          </h2>
          <div className="hero-text">
            <span>Code Differently</span> provides hands on training and
            education through coding classes that gives participants the
            technical and cognitive skills they need to excel in
            technology-driven workplaces.
          </div>
        </div>
      </section>

      <section className="programs-section">
        <h2>
          Our <em className="highlight">Programs</em>
        </h2>
        <ProgramList programs={programs} />
      </section>
    </article>
  );
};
