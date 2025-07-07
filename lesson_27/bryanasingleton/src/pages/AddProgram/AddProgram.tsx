import {useMutation, useQueryClient} from '@tanstack/react-query';
import React, {useState} from 'react';

const addProgram = async (program: {
  title: string;
  description: string;
}): Promise<{title: string; description: string}> => {
  const response = await fetch('/api/programs', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(program),
  });
  if (!response.ok) {
    throw new Error('Failed to add program');
  }
  return response.json();
};

export const AddProgram: React.FC = () => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const queryClient = useQueryClient();

  const mutation = useMutation<
    {title: string; description: string},
    Error,
    {title: string; description: string}
  >({
    mutationFn: addProgram,
    onSuccess: () => {
      queryClient.invalidateQueries({queryKey: ['programs']}); // Refresh the program list
    },
  });

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    mutation.mutate({title, description});
    setTitle('');
    setDescription('');
  };

  return (
    <div className="add-program">
      <h2>Add New Program</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Title:</label>
          <input
            type="text"
            value={title}
            onChange={e => setTitle(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Description:</label>
          <textarea
            value={description}
            onChange={e => setDescription(e.target.value)}
            required
          />
        </div>
        <button type="submit" disabled={mutation.status === 'pending'}>
          {mutation.status === 'pending' ? 'Adding...' : 'Add Program'}
        </button>
      </form>
      {mutation.isError && <p>Error: {(mutation.error as Error).message}</p>}
    </div>
  );
};
