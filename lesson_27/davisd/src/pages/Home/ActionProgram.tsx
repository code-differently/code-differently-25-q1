import {redirect} from 'react-router-dom';

export async function addProgramAction({request}: {request: Request}) {
  const formData = await request.formData();
  const title = formData.get('title');
  const description = formData.get('description');

  if (typeof title !== 'string' || typeof description !== 'string') {
    throw new Error('Invalid form input');
  }

  await fetch('/api/programs', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify({title, description}),
  });

  return redirect('/');
}
