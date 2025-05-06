import { useProgramContext } from "../contexts/ProgramContext";
import { Program } from "./Program";

export const ProgramList = () => {
  const { programs } = useProgramContext();

  return (
    <div className="program-list">
      {programs.map((program, idx) => (
        <Program
          key={idx}
          title={program.title}
          description={program.description}
        />
      ))}
    </div>
  );
};
