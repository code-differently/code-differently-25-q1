import './Home.scss';
import React from 'react';

import {ProgramList} from '@/components/programlist/ProgramList';
import { Link } from 'react-router-dom';

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
      <ProgramList />
      <Link className="program-link"to="/new-program">Add a new Program</Link>
    </article>
  );
};
