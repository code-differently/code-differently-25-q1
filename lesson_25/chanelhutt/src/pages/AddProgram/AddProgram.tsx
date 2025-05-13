import React, {useState} from 'react';
import './AddProgram.scss';


const AddProgramComponent: React.FC = () => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    console.log('Submitted Program:', {title, description});
    setTitle('');
    setDescription('');
  };

  return (
    <section className="add-program">
      <h2>Add a New Program</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="title">Program Title</label>
          <input
            id="title"
            type="text"
            value={title}
            onChange={e => setTitle(e.target.value)}
            required
          />
        </div>

        <div>
          <label htmlFor="description">Program Description</label>
          <textarea
            id="description"
            value={description}
            onChange={e => setDescription(e.target.value)}
            required
          ></textarea>
        </div>

        <button type="submit">Add Program</button>
      </form>
    </section>
  );
};

export default AddProgramComponent;
