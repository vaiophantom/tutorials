import { render } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import NoPage from '../';

it('renders Checkout', async () => {
 const {container} = render(<NoPage />, {wrapper: BrowserRouter});
 expect(container).toMatchSnapshot();
});
