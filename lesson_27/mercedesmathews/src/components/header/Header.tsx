import './Header.scss';
import logoImg from '@/assets/logo.png';
import * as React from 'react';
import {Link} from 'react-router-dom';

export const Header: React.FC = () => {
  return (
    <header className="header">
      <div className="header-logo">
        <a href="/">
          <img src={logoImg} alt="Code Differently Logo" />
        </a>
      </div>
      <ul className="header-top-menu">
        <li>
          <a href="/">Home</a>
        </li>
        <li>
          <a href="#">About</a>
        </li>
        <li>
          <a href="#">Contact</a>
        </li>
        <li>
          <Link to="/add-program">Add Programs</Link>
        </li>
      </ul>
      <div className="header-cta">
        <a className="sign-up-button" href="#">
          Sign Up
        </a>
      </div>
    </header>
  );
};
