import { render } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import ShoppingCart from '../';

it('renders Detail', async () => {
 const {container} = render(<ShoppingCart />, {wrapper: BrowserRouter});
 expect(container).toMatchSnapshot();
});
