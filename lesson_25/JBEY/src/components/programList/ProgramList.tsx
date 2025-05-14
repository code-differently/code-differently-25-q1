// This is a simple program component that takes in two strings from Program.tsx and displays them.
import './ProgramList.scss';

import {Program} from '../program/Program';

export const ProgramList = () => {
  const programs = [
    {
      top: 'Swine Short Loin',
      bottom: `Swine short loin burgdoggen ball tip, shank ham hock bacon.
      Picanha strip steak pork, swine boudin ham meatball meatloaf
      leberkas sausage. Turkey beef andouille kielbasa rump pastrami
      biltong chislic alcatra buffalo prosciutto jowl. Pastrami chicken
      sirloin swine capicola landjaeger jowl boudin pork chop shankle
      bresaola turducken leberkas ham.`,
    },
    {
      top: 'Bacon Ipsum',
      bottom: `Bacon ipsum dolor amet leberkas chuck biltong pork loin sirloin
      bresaola rump frankfurter. Shoulder doner strip steak chuck. Short
      ribs venison salami chuck sirloin jowl chislic cupim swine cow.
      Corned beef chuck frankfurter tenderloin venison biltong andouille
      leberkas kielbasa sausage t-bone turducken fatback. Pork picanha
      buffalo bacon tail salami meatball, jowl chislic.`,
    },
    {
      top: 'Picanha Swine Jowl',
      bottom: `Picanha swine jowl meatball boudin pastrami bresaola fatback
      shankle pork belly cow. Frankfurter ground round shank corned beef
      chuck. Jerky frankfurter fatback capicola hamburger, pork
      prosciutto bresaola ham porchetta rump t-bone pancetta tenderloin.
      Fatback ham hock prosciutto, tenderloin shoulder salami tri-tip
      leberkas bacon turducken chislic venison sausage frankfurter.`,
    },
    {
      top: 'Kevin Chicken T-Bone',
      bottom: `Kevin chicken t-bone spare ribs shankle bacon drumstick kielbasa
      cow jowl doner salami chuck andouille. Rump spare ribs bresaola
      frankfurter shankle. Bresaola ribeye turducken, cow leberkas
      boudin biltong sirloin filet mignon ham pork belly shank.
      Tenderloin sirloin pancetta pork loin shankle venison turducken
      boudin. Brisket tenderloin salami ham bresaola burgdoggen.`,
    },
  ];

  return (
    <>
      <ul className="programs">
        {programs.map((program, index) => (
          <Program key={index} top={program.top} bottom={program.bottom} />
        ))}
      </ul>
    </>
  );
};

export default ProgramList;
