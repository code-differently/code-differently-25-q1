import './Program.css';
import React from 'react';

interface programProps {
  title: string;
  description: string;
}

export const Program: React.FC<programProps> = ({title, description}) => (
  <li className="program">
    <h3>{title}</h3>
    <p>{description}</p>
  </li>
);
