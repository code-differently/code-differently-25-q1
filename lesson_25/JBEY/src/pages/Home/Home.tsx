// This is the home page of the application.
// This is the very first thing you see when you open the browser.
import './Home.scss';
import React from 'react';
import {Link} from 'react-router-dom';

import Button from '../../components/button/button';
import {ProgramList} from '../../components/programList/ProgramList';

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
        <ProgramList />
        <Link to="/new-program">
          <Button label="New Program" />
        </Link>
      </section>
    </article>
  );
};
