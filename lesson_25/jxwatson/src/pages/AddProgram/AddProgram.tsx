import './AddProgram.scss';

export function AddProgram() {
  return (
    <form className="add-program-form">
      <input placeholder="Title" />
      <input placeholder="Description" />
      <button type="submit">Add Program</button>
    </form>
  );
}
