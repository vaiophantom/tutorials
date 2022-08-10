import { render } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import Home from '../';

it('renders Checkout', async () => {
 const {container} = render(<Home />, {wrapper: BrowserRouter});
 expect(container).toMatchSnapshot();
});
