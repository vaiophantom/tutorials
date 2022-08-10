import { render } from "@testing-library/react";
import { BrowserRouter } from "react-router-dom";
import ProductCheckout from "../";
import CONSTANT from "../../../constants";

const mockProps = {
  data: CONSTANT.PRODUCT_CART,
};
it("renders ProductCheckout", async () => {
  const { container } = render(<ProductCheckout {...mockProps}/>, { wrapper: BrowserRouter });
  expect(container).toMatchSnapshot();
});
