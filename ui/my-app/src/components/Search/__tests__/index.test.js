import { render } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import Search from '../';

it('renders Search', async () => {
 const {container} = render(<Search />, {wrapper: BrowserRouter});
 expect(container).toMatchSnapshot();
});
