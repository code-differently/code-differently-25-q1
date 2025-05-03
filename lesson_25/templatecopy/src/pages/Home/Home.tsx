import './Home.scss';
import React from 'react';
import {Link} from 'react-router-dom';

import HeroSection from '../../components/Program/Herosection';
import ProgramLists from '@/components/Program/ProgramLists';

export const Home: React.FC = () => {
  return (
    <article>
      <HeroSection />
      <ProgramLists />
      <Link
        to="/add-program"
        className="add-program-button"
      >
        Add a New Program
      </Link>
      <section className="programs-section"></section>
    </article>
  );
};
