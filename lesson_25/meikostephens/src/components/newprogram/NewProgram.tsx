import './NewProgram.css';
import React from 'react';

export const NewProgram: React.FC = () => {
  return (
    <div className="new-program">
      <h2 className="new-program-title">Add a New Program</h2>
      <form className="new-program-form">
        <div className="form-group">
          <label htmlFor="program-name">Title</label>
          <input type="text" id="program-name" required />
        </div>
        <div className="form-group">
          <label htmlFor="program-description">Description</label>
          <textarea id="program-description" required></textarea>
        </div>
        <button type="submit" className="submit-button">Submit</button>
      </form>
    </div>
  );
}

export default NewProgram;