// This is the page that the button leads to when you click on it.
// It is the form page.
import './newProgram.scss';
import {useState} from 'react';
import {useNavigate} from 'react-router-dom';

import Button from '@/components/button/button';

export const NewProgram = () => {
  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');
  const navigate = useNavigate();

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    console.log('Submitted:', {title, content});
    setTitle('');
    setContent('');
    navigate('/accepted-form');
  };

  return (
    <div className="container">
      <div className="back">
        <h1>Add new program here:</h1>
        <form onSubmit={handleSubmit} className="form">
          <label>
            Program name:
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
