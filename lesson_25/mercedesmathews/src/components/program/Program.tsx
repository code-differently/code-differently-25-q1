interface programProps {
  header: string;
  content: string;
}

export const Program = ({header, content}: programProps) => {
  return (
    <>
      <h3>{header}</h3>
      <p>{content}</p>
    </>
  );
};
