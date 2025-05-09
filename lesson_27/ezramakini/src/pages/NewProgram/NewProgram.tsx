import './NewProgram.scss';
import {useMutation, useQueryClient} from '@tanstack/react-query';
import {useState} from 'react';
import {useNavigate} from 'react-router-dom';

interface NewProgramData {
  title: string;
  description: string;
}

const addProgram = async (data: NewProgramData): Promise<void> => {
  const response = await fetch('http://localhost:4000/programs', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  });

  if (!response.ok) {
    throw new Error('Failed to add program');
  }
};

export const NewProgram: React.FC = () => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [success, setSuccess] = useState(false);
  const navigate = useNavigate();
  const queryClient = useQueryClient();

  const {mutate, error, isPending} = useMutation({
    mutationFn: addProgram,
    onSuccess: () => {
      queryClient.invalidateQueries({queryKey: ['programs']});
      setSuccess(true);
    },
  });

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    mutate({title, description});
  };

  if (success) {
    return (
      <div className="new-program">
        <h2>Thank you!</h2>
        <p>Your program has been added.</p>
        <button onClick={() => navigate('/')}>Back to Home</button>
      </div>
    );
  }

  return (
    <div className="new-program">
      <h2>Add New Program</h2>
      {error && <div className="error">Error: {error.message}</div>}
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="title">Title:</label>
          <input
            type="text"
            id="title"
            value={title}
            onChange={e => setTitle(e.target.value)}
            required
            disabled={isPending}
          />
        </div>
        <div className="form-group">
          <label htmlFor="description">Description:</label>
          <textarea
            id="description"
            value={description}
            onChange={e => setDescription(e.target.value)}
            required
            disabled={isPending}
          />
        </div>
        <button type="submit" disabled={isPending}>
          {isPending ? 'Adding Program...' : 'Add Program'}
        </button>
      </form>
    </div>
  );
};
