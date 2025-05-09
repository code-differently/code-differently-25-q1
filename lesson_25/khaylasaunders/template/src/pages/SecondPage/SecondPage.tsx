
import { useProgramContext } from "@/contexts/ProgramContext";
import { useState } from "react";
import { Link } from "react-router-dom";
import './SecondPage.scss'

export const SecondPage = () => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const {addProgram} = useProgramContext();

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (title && description) {
      addProgram({title, description});
      setTitle('');
      setDescription('');
    }
  };

  return (
    <>
      <h1 style={{textAlign: 'center'}}>Program Creation Page</h1>
      <form onSubmit={handleSubmit}>
        <input
          value={title}
          className="inputField"
          onChange={e => setTitle(e.target.value)}
        />
        <input
          value={description}
          className="inputField"
          onChange={e => setDescription(e.target.value)}
        />
        <button>Submit Program</button>
        <Link to="/">
        <button>Back to home page?</button>
        </Link>
      </form>
    </>
  );
};
