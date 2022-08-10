import { render } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import Checkout from '../';

it('renders Checkout', async () => {
 const {container} = render(<Checkout />, {wrapper: BrowserRouter});
 expect(container).toMatchSnapshot();
});
