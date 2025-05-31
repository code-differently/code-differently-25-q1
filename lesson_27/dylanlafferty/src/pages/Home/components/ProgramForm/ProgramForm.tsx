import './ProgramForm.module.css';
import {useMutation, useQueryClient} from '@tanstack/react-query';
import React from 'react';

export const ProgramForm: React.FC = () => {
  const queryClient = useQueryClient();

  const mutation = useMutation({
    mutationFn: async (program: {title: string; description: string}) => {
      const response = await fetch('http://localhost:4000/programs', {
        method: 'POST',
        body: JSON.stringify(program),
        headers: {
          'Content-Type': 'application/json',
        },
      });

      if (!response.ok) {
        throw new Error('Failed to create program');
      }

      const text = await response.text();
      return text ? JSON.parse(text) : null;
    },
    onSuccess: () => {
      queryClient.invalidateQueries({queryKey: ['programs']});
    },
  });

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const formData = new FormData(event.currentTarget);
    const program = Object.fromEntries(formData.entries()) as {
      title: string;
      description: string;
    };
    mutation.mutate(program);
    event.currentTarget.reset();
  };

  return (
    <div className="form-page">
      <div className="form-container">
        <h2>Create New Program</h2>
        <form onSubmit={handleSubmit}>
          <label>
            Title:
            <input type="text" name="title" required />
          </label>
          <label>
            Description:
            <textarea name="description" required />
          </label>
          <button type="submit" disabled={mutation.isPending}>
            {mutation.isPending ? 'Creating...' : 'Create Program'}
          </button>
          {mutation.isError && (
            <p className="error-message">
              Error:{' '}
              {(mutation.error as Error)?.message || 'Something went wrong'}
            </p>
          )}
          {mutation.isSuccess && (
            <p className="success-message">Program successfully created!</p>
          )}
        </form>
      </div>
    </div>
  );
};
