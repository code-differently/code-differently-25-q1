import './Home.scss';
import React from 'react';

export const Home: React.FC = () => {
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
        <ul className="programs">
          <li className="program">
            <h3>Swine Short Loin</h3>
            <p>
              Swine short loin burgdoggen ball tip, shank ham hock bacon.
              Picanha strip steak pork, swine boudin ham meatball meatloaf
              leberkas sausage. Turkey beef andouille kielbasa rump pastrami
              biltong chislic alcatra buffalo prosciutto jowl. Pastrami chicken
              sirloin swine capicola landjaeger jowl boudin pork chop shankle
              bresaola turducken leberkas ham.
            </p>
          </li>
          <li className="program">
            <h3>Bacon Ipsum</h3>
            <p>
              Bacon ipsum dolor amet leberkas chuck biltong pork loin sirloin
              bresaola rump frankfurter. Shoulder doner strip steak chuck. Short
              ribs venison salami chuck sirloin jowl chislic cupim swine cow.
              Corned beef chuck frankfurter tenderloin venison biltong andouille
              leberkas kielbasa sausage t-bone turducken fatback. Pork picanha
              buffalo bacon tail salami meatball, jowl chislic.
            </p>
          </li>
          <li className="program">
            <h3>Picanha Swine Jowl</h3>
            <p>
              Picanha swine jowl meatball boudin pastrami bresaola fatback
              shankle pork belly cow. Frankfurter ground round shank corned beef
              chuck. Jerky frankfurter fatback capicola hamburger, pork
              prosciutto bresaola ham porchetta rump t-bone pancetta tenderloin.
              Fatback ham hock prosciutto, tenderloin shoulder salami tri-tip
              leberkas bacon turducken chislic venison sausage frankfurter.
            </p>
          </li>
          <li className="program">
            <h3>Kevin Chicken T-Bone</h3>
            <p>
              Kevin chicken t-bone spare ribs shankle bacon drumstick kielbasa
              cow jowl doner salami chuck andouille. Rump spare ribs bresaola
              frankfurter shankle. Bresaola ribeye turducken, cow leberkas
              boudin biltong sirloin filet mignon ham pork belly shank.
              Tenderloin sirloin pancetta pork loin shankle venison turducken
              boudin. Brisket tenderloin salami ham bresaola burgdoggen.
            </p>
          </li>
        </ul>
      </section>
    </article>
  );
};
