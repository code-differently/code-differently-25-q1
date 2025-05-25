import './AddProgram.css';
import React, {useState} from 'react';
import {useNavigate} from 'react-router-dom';

export const AddProgram: React.FC = () => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [submitted, setSubmitted] = useState(false);
  const navigate = useNavigate();

  const handleSubmit = (event: React.FormEvent) => {
    event.preventDefault();
    if (title && description) {
      console.log('New Program:', {title, description});
      setSubmitted(true);
      setTitle('');
      setDescription('');
    }
  };

  return (
    <section className="new-program-section">
      <h2>
        Add a <em className="highlight">New Program</em>
      </h2>

      <form onSubmit={handleSubmit} className="new-program-form">
        <label>
          Title:
          <input
            type="text"
            value={title}
            placeholder="Enter program title"
            onChange={e => setTitle(e.target.value)}
            required
          />
        </label>

        <label>
          Description:
          <textarea
            value={description}
            placeholder="Enter program description"
            onChange={e => setDescription(e.target.value)}
            required
          />
        </label>

        <button type="submit">Submit</button>

        {submitted && (
          <p className="success-msg">Program submitted successfully!</p>
        )}
      </form>
    </section>
  );
};
