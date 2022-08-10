import { InputGroup, Form, Button } from "react-bootstrap";
import Header from "../../components/Header";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import ProductCheckout from "../../components/ProductCheckout";
import { currencyFormat } from "../../utils/helper";
import { addToCart } from "../../utils/fetch";

const SUCCESS_MESS = "Your order was success !";

const Checkout = () => {
  const [listProducts, setListProducts] = useState([]);
  const navigate = useNavigate();
  const [total_payment, setTotal_payment] = useState(0);
  const [address, setAddress] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");

  useEffect(() => {
    let listCart = JSON.parse(localStorage.getItem("cart"));
    if (listCart) {
      listCart = listCart.map((item) => {
        return { checked: false, ...item };
      });
      setListProducts(listCart);
    }
  }, []);

  useEffect(() => {
    if (listProducts.length > 0) {
      const total = listProducts.reduce(
        (prev, current) => prev + current.price * current.quantity,
        0
      );
      setTotal_payment(total);
    }
  }, [listProducts]);

  const onOrder = async () => {
    const body = {
      productIds: listProducts.map((item) => item.id),
      totalPrice: total_payment,
      productQuantity: listProducts.length,
    };
    console.log(body);

    try {
      const res = await addToCart(body);
      if (res) {
        clearCart();
        navigate("/", { state: { message: SUCCESS_MESS } });
      }
    } catch (error) {
      console.log(error.message);
    }
  };
  const clearCart = () => {
    localStorage.removeItem("cart");
  };

  const onChangeAddress = (e) => {
    const { value } = e.target;
    setAddress(value);
  };

  const onChangePhone = (e) => {
    const { value } = e.target;
    setPhoneNumber(value);
  };
  const handleSearch = (type, value) => {};

  return (
    <div className="checkout-screen">
      <Header handleSearch={handleSearch} />
      <div className="checkout-body">
        <div style={{ flex: 1 }}>
          <Form.Label htmlFor="address">Address</Form.Label>
          <InputGroup hasValidation className="mb-3">
            <Form.Control
              required
              value={address}
              onChange={onChangeAddress}
              id="address"
              isInvalid={!address}
            />

            <Form.Control.Feedback type="invalid">
              Please fill a address.
            </Form.Control.Feedback>
          </InputGroup>

          <Form.Label htmlFor="phone-number">Phone Number</Form.Label>
          <InputGroup className="mb-3">
            <Form.Control
              isInvalid={!phoneNumber}
              value={phoneNumber}
              onChange={onChangePhone}
              type="tel"
              id="phone-number"
            />
            <Form.Control.Feedback type="invalid">
              Please fill a phone number.
            </Form.Control.Feedback>
          </InputGroup>

          <Form.Label htmlFor="">Payment Method</Form.Label>
          <InputGroup className="mb-3">
            <Form.Select aria-label="Default select example">
              <option value="1">Pay by cash</option>
              <option value="2" disabled>
                Pay online
              </option>
            </Form.Select>
          </InputGroup>
        </div>
        <div
          style={{
            flex: 1,
            paddingLeft: "40px",
            marginLeft: "40px",
            borderLeft: "1px solid rgb(237, 237, 237)",
          }}
        >
          <ul>
            {listProducts &&
              listProducts.map((item) => {
                return (
                  <li>
                    <ProductCheckout data={item} />
                  </li>
                );
              })}
          </ul>
        </div>
      </div>
      <div className="checkout-footer">
        <p style={{ fontWeight: "bold" }}>
          total price: {currencyFormat(total_payment)} $
        </p>
        <Button
          disabled={!address || !phoneNumber}
          type="submit"
          onClick={onOrder}
          variant="warning"
          style={{ margin: "20px" }}
        >
          Place to order
        </Button>
      </div>
    </div>
  );
};
export default Checkout;
