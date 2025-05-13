function Program({ title, description }) {
  return (
    <div className="program-card">
      <h3>{title}</h3>
      <p>{description}</p>
    </div>
  );
}

export default Program;