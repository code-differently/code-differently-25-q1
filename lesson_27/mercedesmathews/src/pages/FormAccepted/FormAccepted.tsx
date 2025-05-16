import './FormAccepted.scss';
import {Link} from 'react-router-dom';

import Button from '@/components/button/Button';

export const FormAccepted = () => {
  return (
    <div className="container">
      <div className="card">
        <h2>Program Submitted!</h2>
        <p>Your program submission has been sent successfully.</p>
        <Link to="/">
          <Button label="Back to Home" />
        </Link>
      </div>
    </div>
  );
};
