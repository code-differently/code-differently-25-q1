import {Header} from './Header';
import {render} from '@testing-library/react';
import {MemoryRouter} from 'react-router-dom';

describe('Header', () => {
  it('should render the Header component', () => {
    // Act
    render(
      <MemoryRouter>
        <Header />
      </MemoryRouter>
    );
  });
});
