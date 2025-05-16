import React, { useState } from 'react';
import './NewProgramPage.css';

export const NewProgramPage: React.FC = () => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [success, setSuccess] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setSuccess(false);
    setError(null);

    const newProgram = { title, description };

    try {
      const response = await fetch('http://localhost:4000/programs', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(newProgram),
      });

      if (!response.ok) {
        throw new Error('Failed to add program');
      }

      setSuccess(true);
      setTitle('');
      setDescription('');
    } catch (err: any) {
      setError(err.message);
    }
  };

  return (
    <article className="new-program-page">
      <h2>Add a <em className="highlight">New Program</em></h2>
      <form onSubmit={handleSubmit} className="program-form">
        <label>
          Title:
          <input
            type="text"
            value={title}
            onChange={e => setTitle(e.target.value)}
            required
          />
        </label>

        <label>
          Description:
          <textarea
            value={description}
            onChange={e => setDescription(e.target.value)}
            required
          ></textarea>
        </label>

        <button type="submit">Add Program</button>

        {success && <p className="success-message">Program added successfully!</p>}
        {error && <p className="error-message">Error: {error}</p>}
      </form>
    </article>
  )};