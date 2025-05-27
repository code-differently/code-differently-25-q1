import './NewForm.scss';
import {Link} from 'react-router-dom';

import Button from '@/components/Button/Button';

export const NewFormAccepted = () => {
  return (
    <div className="container">
      <div className="card">
        <h2>Form Submitted!</h2>
        <p>Your form submission has been sent successfully.</p>
        <Link to="/">
          <Button label="Back to Home" />
        </Link>
      </div>
    </div>
  );
};
