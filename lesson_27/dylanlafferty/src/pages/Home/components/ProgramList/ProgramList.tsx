import './ProgramList.scss';

import {Program} from '../Program';
<<<<<<< HEAD

import { useQuery } from '@tanstack/react-query';
import axios from 'axios';
import { Program as ProgramType} from '@code-differently/types';

const fetchPrograms = async (): Promise<ProgramType[]> => {
  const response = await axios.get('/api/programs');
  return response.data;
}

const usePrograms = () => {
  
}

export const ProgramList: React.FC = () => {
  return (
    <ul className="programs">
      <Program title="Swine Short Loin">
        <p>
          Swine short loin burgdoggen ball tip, shank ham hock bacon. Picanha
          strip steak pork, swine boudin ham meatball meatloaf leberkas sausage.
          Turkey beef andouille kielbasa rump pastrami biltong chislic alcatra
          buffalo prosciutto jowl. Pastrami chicken sirloin swine capicola
          landjaeger jowl boudin pork chop shankle bresaola turducken leberkas
          ham.
        </p>
      </Program>
      <Program title="Bacon Ipsum">
        <p>
          Bacon ipsum dolor amet leberkas chuck biltong pork loin sirloin
          bresaola rump frankfurter. Shoulder doner strip steak chuck. Short
          ribs venison salami chuck sirloin jowl chislic cupim swine cow. Corned
          beef chuck frankfurter tenderloin venison biltong andouille leberkas
          kielbasa sausage t-bone turducken fatback. Pork picanha buffalo bacon
          tail salami meatball, jowl chislic.
        </p>
      </Program>
      <Program title="Picanha Swine Jowl">
        <p>
          Picanha swine jowl meatball boudin pastrami bresaola fatback shankle
          pork belly cow. Frankfurter ground round shank corned beef chuck.
          Jerky frankfurter fatback capicola hamburger, pork prosciutto bresaola
          ham porchetta rump t-bone pancetta tenderloin. Fatback ham hock
          prosciutto, tenderloin shoulder salami tri-tip leberkas bacon
          turducken chislic venison sausage frankfurter.
        </p>
      </Program>
      <Program title="Kevin Chicken T-Bone">
        <p>
          Kevin chicken t-bone spare ribs shankle bacon drumstick kielbasa cow
          jowl doner salami chuck andouille. Rump spare ribs bresaola
          frankfurter shankle. Bresaola ribeye turducken, cow leberkas boudin
          biltong sirloin filet mignon ham pork belly shank. Tenderloin sirloin
          pancetta pork loin shankle venison turducken boudin. Brisket
          tenderloin salami ham bresaola burgdoggen.
        </p>
      </Program>
    </ul>
  );
};
=======
import {Program as ProgramType} from '@code-differently/types';
import { useQuery } from '@tanstack/react-query';
import React from 'react';


const fetchPrograms = async (): Promise<ProgramType[]> => {
  const response = await fetch('http://localhost:4000/programs');
  if(!response.ok) {
    throw new Error('Failed to fetch programs');
  }

  return response.json();
}

export const ProgramList: React.FC = () => {
  const { data, isLoading, error } = useQuery<ProgramType[]>({
    queryKey: ['programs'],
    queryFn: fetchPrograms,
  });

  if (isLoading) {
    return <div>Loading...</div>;
  }

  if(error instanceof Error) {
    return <div>Error: {error.message}</div>;
  }

  return (
    <ul className="programs">
      {data?.map((program: ProgramType) => (
        <Program key={program.id} title={program.title}>
          <p>{program.description}</p>
        </Program>
      ))}
    </ul>
  )
}
>>>>>>> 9a8ee5e (feat: Implement feature that GET a list of programs from api)
