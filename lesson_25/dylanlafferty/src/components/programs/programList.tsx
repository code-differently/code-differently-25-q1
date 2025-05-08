import React from "react";
import Program from "./program";

interface ProgramData {
    title: string;
    description: string;
}

interface ProgramListProps {
    programs: ProgramData[];
}

const ProgramList: React.FC<ProgramListProps> = ({ programs }) => {
    return (
        <ul className="programs">
            {programs.map((program, index) => (
                <Program
                    key={index}
                    title={program.title}
                    description={program.description}
                />
            ))}
        </ul>
    )
}

export default ProgramList