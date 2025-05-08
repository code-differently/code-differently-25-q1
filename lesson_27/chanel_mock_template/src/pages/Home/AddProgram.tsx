import './AddProgram.scss';
import './AddProgram.scss';
import React, { useState } from 'react';
import {useNavigate} from 'react-router-dom';

export const AddProgram: React.FC = () => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();

    if (!title || !description) {
      setError('Both fields are required.');
      return;
    }

    try {
      const response = await fetch('http://localhost:3001/programs', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          program: {title, description},
        }),
      });

      if (!response.ok) {
        throw new Error('Failed to add program.');
      }

      navigate('/');
    } catch (err) {
      console.error(err);
      setError('There was a problem submitting the form.');
    }
  };

  return (
    <div className="add-program-container">
      <h2>Add a New Program</h2>
      <form className="add-program-form" onSubmit={handleSubmit}>
        {error && <p className="error">{error}</p>}
        <div>
          <label htmlFor="title">Program Title</label>
          <input
            type="text"
            id="title"
            value={title}
            onChange={e => setTitle(e.target.value)}
          />
        </div>

        <div>
          <label htmlFor="description">Description</label>
          <textarea
            id="description"
            value={description}
            onChange={e => setDescription(e.target.value)}
            className="program-input"
            placeholder="Enter program description"
          />
        </div>

         <button type="submit" className="submit-button">Add Program</button>
      </form>
    </div>
  );
};