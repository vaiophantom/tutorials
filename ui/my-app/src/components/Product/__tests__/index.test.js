import { render } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import Product from '../';

it('renders Product', async () => {
 const {container} = render(<Product />, {wrapper: BrowserRouter});
 expect(container).toMatchSnapshot();
});
