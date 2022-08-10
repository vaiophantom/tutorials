import { render } from '@testing-library/react';
import { BrowserRouter, useLocation } from 'react-router-dom';
import Detail from '../';

it('renders Detail', async () => {
 const {container} = render(<Detail />, {wrapper: BrowserRouter});
 expect(container).toMatchSnapshot();
});
