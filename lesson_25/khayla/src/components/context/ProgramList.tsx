import { ProgramContext } from "./ProgramContext";
import { ProgramList } from "./ProgramList";

export const ProgramList = () => {
  const { programs } = ProgramContext();

  return (
    <div className="program-list">
      {programs.map((program, idx) => (
        <ProgramList
          key={idx}
          title={program.title}
          description={program.description}
        />
      ))}
    </div> 
  );
};
