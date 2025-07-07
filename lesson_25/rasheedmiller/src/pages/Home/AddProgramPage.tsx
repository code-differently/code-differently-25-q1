import './AddProgramPage.scss';
import React, {useState} from 'react';

export const AddProgramPage: React.FC = () => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [submitted, setSubmitted] = useState(false);

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (title && description) {
      // This is where you'd typically send the data to an API
      console.log('Program Submitted:', {title, description});
      setSubmitted(true);
      setTitle('');
      setDescription('');
    }
  };

  return (
    <article className="add-program-page">
      <section className="form-section">
        <h2>
          Add a <em className="highlight">New Program</em>
        </h2>
        <form className="program-form" onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="program-title">Program Title</label>
            <input
              id="program-title"
              type="text"
              value={title}
              onChange={e => setTitle(e.target.value)}
              required
              placeholder="Enter the program title"
            />
          </div>
          <div className="form-group">
            <label htmlFor="program-description">Description</label>
            <textarea
              id="program-description"
              value={description}
              onChange={e => setDescription(e.target.value)}
              required
              placeholder="Describe the program"
            ></textarea>
          </div>
          <button type="submit" className="submit-button">
            Add Program
          </button>
          {submitted && (
            <p className="success-message">Program submitted successfully!</p>
          )}
        </form>
      </section>
    </article>
  );
};
