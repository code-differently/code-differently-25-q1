
import { useState } from "react";
import { Link } from "react-router-dom";
import './SecondPage.scss'

export const SecondPage = () => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (title && description) {
      setTitle('');
      setDescription('');
    }
  };

  return (
<>
  <h1 className="form-title">Program Creation Page</h1>
  <form onSubmit={handleSubmit} className="program-form">
    <input
      value={title}
      className="input-field"
      placeholder="Title"
      onChange={e => setTitle(e.target.value)}
    />
    <input
      value={description}
      className="input-field"
      placeholder="Description"
      onChange={e => setDescription(e.target.value)}
    />
    <button type="submit" className="submit-button">
      Submit Program
    </button>
    <Link to="/" className="back-button">
      Back to home page?
    </Link>
  </form>
</>
  );
};
