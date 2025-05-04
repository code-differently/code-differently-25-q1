// import './program.scss';
import React from 'react';
import { ProgramList} from '../components/ProgramList';

interface ProgramProps {
  title: string;
  description: string;
}


export const Programs: React.FC<ProgramProps> = ({ title, description }) => (
  <li className="program">
    <h3>{title}</h3>
    <p>{description}</p>
  </li>
);