import './Home.scss';
import React from 'react';
import {programsData} from '../../components/programs/programData';
import ProgramList from '../../components/programs/programList';

//Imports Link from our React Router
import { Link } from "react-router-dom";

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
          <ProgramList programs={programsData} />

        </ul>
      </section>

      <Link className = "program-link" to="/new-program">Adds a new Program</Link>
    </article>
  );
};
