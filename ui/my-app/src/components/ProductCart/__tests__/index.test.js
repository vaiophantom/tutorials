import { render } from '@testing-library/react';
import { BrowserRouter } from 'react-router-dom';
import ProductCart from '../';
import CONSTANT from '../../../constants';

const mockProps = {
    data: {...CONSTANT.PRODUCT_CART, checked: false},
    outputCheckBox: jest.fn()
}

it('renders Product Cart', async () => {
 const {container} = render(<ProductCart {...mockProps}/>, {wrapper: BrowserRouter});
 expect(container).toMatchSnapshot();
});
