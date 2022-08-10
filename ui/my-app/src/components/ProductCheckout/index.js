import { currencyFormat } from "../../utils/helper";

const ProductCheckout = (props) => {
  const { data } = props;

  return (
    <div className="product-checkout-screen">
      <div style={{fontWeight:"bold"}}>{data.name}</div>
      <div>{currencyFormat(data.price * data.quantity)} $</div>
    </div>
  );
};
export default ProductCheckout;
