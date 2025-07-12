// This is an inferface for ProgramList. ProgramList will import this interface
// and use it to define the type of the props that it will pass to Program.

interface ProgramStuff {
  top: string;
  bottom: string;
}

export const Program = ({top, bottom}: ProgramStuff) => {
  return (
    <>
      <h3>{top}</h3>
      <p>{bottom}</p>
    </>
  );
};
