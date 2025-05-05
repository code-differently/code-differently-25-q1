import Program from './Program';

function ProgramList() {
  const programs = [
    {
      title: '1000 Kids Coding',
      description: 'A program to introduce students to computing and programming.'
    },
    {
      title: 'Return Ready',
      description: 'Helping adults reinvent their skills for the workforce.'
    }
  ];

  return (
    <div className="programs">
      {programs.map((p, index) => (
        <Program key={index} title={p.title} description={p.description} />
      ))}
    </div>
  );
}

export default ProgramList;