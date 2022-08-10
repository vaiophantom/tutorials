import { render } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import Header from '../';

it('renders Header', async () => {
 const {container} = render(<Header />, {wrapper: BrowserRouter});
 expect(container).toMatchSnapshot();
});
