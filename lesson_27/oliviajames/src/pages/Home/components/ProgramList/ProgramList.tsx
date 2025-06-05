import './ProgramList.scss';
import {useEffect, useState} from 'react';

import {Program} from '../Program';

export const ProgramList = () => {
  const [data, setData] = useState<any>();

  useEffect(() => {
    const fetched = async () => {
      const response = await fetch('http://localhost:4000/programs');
      const datas = await response.json();
      setData(datas);
    };
    fetched();
  }, []);

  return (
    <ul className="programs">
      {data &&
        data.map((program: any) => {
          return (
            <li>
              <Program key={program.id} title={program.title}>
                <p>{program.description}</p>
              </Program>
            </li>
          );
        })}
    </ul>
  );
};
