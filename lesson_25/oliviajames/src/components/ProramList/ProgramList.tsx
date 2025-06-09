import Program from "../Program"
import './ProgramList.scss';

export default function ProgramList({programs}: {programs: {title: string, description: string}[]}){
    return(
        <>
            <ul className="programs">
                {programs.map((program) => {
                    return <Program title={program.title} description={program.description}/>
                })}
            </ul>
        </>
    )
}