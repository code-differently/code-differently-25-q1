import React, { useState } from 'react';
  import './AddProgram.scss'; // if using a separate SCSS file

export const AddProgram: React.FC = () => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    alert(`Program Submitted:\n\nTitle: ${title}\nDescription: ${description}`);

    setTitle('');
    setDescription('');
  };

  return (
    <section className="add-program-section">
      <h2>Add Your Own Program!</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="title">Your Title</label><br />
          <input
            type="text"
            id="title"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            required
          /><br /><br />
        </div>
        <div>
          <label htmlFor="description">Your Description</label><br />
          <textarea
            id="description"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            required
          /><br /><br />
        </div>
        <button type="submit">Submit</button>
      </form>
    </section>
  );
};
