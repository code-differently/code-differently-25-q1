
import { createContext, useContext, useState, ReactNode } from "react";

type Program = {
  title: string;
  description: string;
};

type ProgramContextType = {
  programs: Program[];
  addProgram: (program: Program) => void;
};

const ProgramContext = createContext<ProgramContextType | undefined>(undefined);

export const ProgramProvider = ({ children }: { children: ReactNode }) => {
  const [programs, setPrograms] = useState<Program[]>([]);

  const addProgram = (program: Program) => {
    setPrograms((prev) => [...prev, program]);
  };

  return (
    <ProgramContext.Provider value={{ programs, addProgram }}>
      {children}
    </ProgramContext.Provider>
  );
};

export const useProgramContext = () => {
  const context = useContext(ProgramContext);
  if (!context) {
    throw new Error("useProgramContext must be used within a ProgramProvider");
  }
  return context;
};
