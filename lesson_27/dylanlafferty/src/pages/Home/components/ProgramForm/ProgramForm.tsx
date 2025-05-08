import React from "react"
import { useMutation, useQueryClient } from "@tanstack/react-query"


export const ProgramForm: React.FC = () => {

const queryClient = useQueryClient();

const mutation = useMutation({
    mutationFn: async (program: { title: string; description: string }) => {
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
      return response.json(); 
    },
    onSuccess: () => {
      
      queryClient.invalidateQueries({ queryKey: ['programs'] });
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
    <form onSubmit={handleSubmit}>
      <h2>Create New Program</h2>
      <label>
        Title:
        <input type="text" name="title" required />
      </label>
      <br />
      <label>
        Description:
        <textarea name="description" required />
      </label>
      <br />
      <button type="submit" disabled={mutation.isPending}>
        {mutation.isPending ? 'Creating...' : 'Create Program'}
      </button>
      {mutation.isError && (
        <p style={{ color: 'red' }}>Error: {mutation.error.message}</p>
      )}
      {mutation.isSuccess && <p>Program successfully created!</p>}
    </form>
  );
};

