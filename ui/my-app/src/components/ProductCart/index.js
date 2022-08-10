import CONSTANT from "../../constants";
import { Image, Form } from "react-bootstrap";
import { useEffect, useState } from "react";
import { currencyFormat } from "../../utils/helper";

const ProductCart = (props) => {
  const { data, outputCheckBox } = props;
  const { checked } = data;
  const [check, setCheck] = useState(false);

  useEffect(() => {
    setCheck(checked);
  }, [checked]);

  const onChangeCheckBox = (e) => {
    setCheck(e.target.checked);
    outputCheckBox({ ...data, checked: e.target.checked });
  };
  return (
    <div className="product-cart-screen">
      <div
        style={{
          flex: 3,
          display: "flex",
          flexDirection: "row",
          alignItems: "center",
        }}
      >
        <Form.Check
          onChange={onChangeCheckBox}
          checked={check}
          style={{ marginRight: 20 }}
          type="checkbox"
          id={data.id}
        ></Form.Check>
        <Image
          style={{ marginRight: 20 }}
          src={data.img}
          height={100}
          width={100}
        />
        <p>{data.description}</p>
      </div>
      <div style={{ flex: 1 }}>
        <p>{data.price} $ </p>
      </div>
      <div style={{ flex: 1 }}>
        <p>{data.quantity}</p>
      </div>
      <div style={{ flex: 1 }}>
        <p>{currencyFormat(data.price * data.quantity)} $</p>
      </div>
    </div>
  );
};
export default ProductCart;
