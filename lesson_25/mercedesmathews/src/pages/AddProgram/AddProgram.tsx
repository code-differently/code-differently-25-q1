import './AddProgram.scss';
import {useState} from 'react';
import {useNavigate} from 'react-router-dom';

import Button from '@/components/Button/Button';

export const AddProgram = () => {
  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');
  const navigate = useNavigate();

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    console.log('Submitted:', {title, content});
    setTitle('');
    setContent('');
    navigate('/form-accepted');
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
              value={content}
              onChange={e => setContent(e.target.value)}
              required
            />
          </label>
          <Button label="Submit" type="submit" />
        </form>
      </div>
    </div>
  );
};
