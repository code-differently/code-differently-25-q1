import './Button.scss';

type ButtonProps = {
  label: string;
  onClick?: () => void;
  type?: 'button' | 'submit' | 'reset';
  className?: string;
};

const Button = ({
  label,
  onClick,
  type = 'submit', // ← change default to 'submit'
  className = '',
}: ButtonProps) => {
  return (
    <button type={type} onClick={onClick} className={`button ${className}`}>
      {label}
    </button>
  );
};

export default Button;
