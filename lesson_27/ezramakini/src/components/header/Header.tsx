import './Header.scss';
import logoImg from '@/assets/logo.png';
import * as React from 'react';
import {Link} from 'react-router-dom';

export const Header: React.FC = () => {
  return (
    <header className="header">
      <div className="header-logo">
        <Link to="/">
          <img src={logoImg} alt="Code Differently Logo" />
        </Link>
      </div>
      <ul className="header-top-menu">
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/new-program">Add Program</Link>
        </li>
        <li>
          <a href="#">About</a>
        </li>
        <li>
          <a href="#">Contact</a>
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
