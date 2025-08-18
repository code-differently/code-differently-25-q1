import {useState} from 'react';

export default function Create() {
  const [formData, setFormData] = useState<{
    title: string;
    description: string;
  }>({
    title: '',
    description: '',
  });

  const [mess, setMess] = useState('');

  const handleSubmit = async (e: any) => {
    e.preventDefault();
    const response = await fetch('http://localhost:4000/programs', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData),
    });
    if (response.ok) {
      setMess('success');
    } else {
      setMess('error');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <label htmlFor="title">Program Title</label>
      <input
        id="title"
        onChange={e =>
          setFormData(prev => ({
            ...prev,
            title: e.target.value,
          }))
        }
      />
      <label htmlFor="desc">Program Description</label>
      <input
        id="desc"
        onChange={e =>
          setFormData(prev => ({
            ...prev,
            description: e.target.value,
          }))
        }
      />{' '}
      <button>Submit</button>
      {mess}
    </form>
  );
}
