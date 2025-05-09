import './AddProgram.scss';
import React, {useState} from 'react';

export const AddProgram: React.FC = () => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [status, setStatus] = useState<
    'idle' | 'submitting' | 'success' | 'error'
  >('idle');

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setStatus('submitting');

    try {
      const response = await fetch('/api/programs', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({title, description}),
      });

      if (!response.ok) throw new Error('Failed to create program');
      setStatus('success');
      setTitle('');
      setDescription('');
    } catch (err) {
      console.error(err);
      setStatus('error');
    }
  };

  return (
    <article className="add-program">
      <h2>Add a New Program</h2>
      <form onSubmit={handleSubmit}>
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
          />
        </label>
        <button type="submit" disabled={status === 'submitting'}>
          {status === 'submitting' ? 'Submitting...' : 'Add Program'}
        </button>
      </form>

      {status === 'success' && (
        <p className="success">Program added successfully!</p>
      )}
      {status === 'error' && (
        <p className="error">Something went wrong. Try again.</p>
      )}
    </article>
  );
};
