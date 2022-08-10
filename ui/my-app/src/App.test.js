import { render } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import App from './App';

it('renders App', async () => {
 const {container} = render(<App />, {wrapper: BrowserRouter});
 expect(container).toMatchSnapshot();
});
