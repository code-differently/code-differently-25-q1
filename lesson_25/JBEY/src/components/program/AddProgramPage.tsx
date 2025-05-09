// AddProgramPage.tsx
import React, {useState} from 'react';

const AddProgramPage: React.FC = () => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [submitted, setSubmitted] = useState(false);

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    // You would usually send this data to a server or context here
    console.log('New Program:', {title, description});
    setSubmitted(true);
    setTitle('');
    setDescription('');
  };

  return (
    <div className="add-program-page">
      <h2>Add New Program</h2>
      {submitted && <p style={{color: 'green'}}>Program submitted!</p>}
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="title">Title:</label>
          <br />
          <input
            id="title"
            type="text"
            value={title}
            onChange={e => setTitle(e.target.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="description">Description:</label>
          <br />
          <textarea
            id="description"
            value={description}
            onChange={e => setDescription(e.target.value)}
            required
          />
        </div>
        <button type="submit">Add Program</button>
      </form>
    </div>
  );
};

export default AddProgramPage;
