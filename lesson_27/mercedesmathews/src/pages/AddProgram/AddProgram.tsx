import './AddProgram.scss';
import {useState} from 'react';
import {useNavigate} from 'react-router-dom';

import Button from '@/components/button/Button';

export const AddProgram = () => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    const newProgram = {title, description};

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

      console.log('Submitted:', {title, description});
      setTitle('');
      setDescription('');
      navigate('/form-accepted');
    } catch (error) {
      console.error('Error adding program:', error);
    }
  };

  return (
    <div className="container">
      <div className="card">
        <h1>Add a new program:</h1>
        <form onSubmit={handleSubmit} className="form">
          <label>
            Title:
            <input
              id="title"
              type="text"
              value={title}
              onChange={e => setTitle(e.target.value)}
              required
            />
          </label>
          <label>
            Description:
            <textarea
              id="content"
              value={description}
              onChange={e => setDescription(e.target.value)}
              required
            />
          </label>
          <Button label="Submit" type="submit" />
        </form>
      </div>
    </div>
  );
};
