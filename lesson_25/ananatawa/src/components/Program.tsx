type ProgramProps = {
  title: string;
  description: string;
};

function Program({ title, description }: ProgramProps) {
  return (
    <div className="program-card">
      <h3>{title}</h3>
      <p>{description}</p>
    </div>
  );
}

export default Program;
