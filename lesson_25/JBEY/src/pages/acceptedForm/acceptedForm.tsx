// This is the page that is displayed when the user submits a program.
import './acceptedForm.scss';
import {Link} from 'react-router-dom';

import Button from '@/components/button/button';

export const AcceptedForm = () => {
  return (
    <div className="container">
      <div className="card">
        <h2>Program Submitted!</h2>
        <p>Your program has been submitted. Congratulations!</p>
        <Link to="/">
          <Button label="Home" />
        </Link>
      </div>
    </div>
  );
};
export default AcceptedForm;
