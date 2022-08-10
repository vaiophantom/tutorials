import { useLocation } from "react-router-dom";
import { Image, Button } from "react-bootstrap";
import CONSTANT from "../../constants";
import Header from "../../components/Header";
import { useState } from "react";

const Detail = () => {
  const [quantity, setQuantity] = useState(1);
  const { state } = useLocation();

  const addToCart = () => {
    let listCart = JSON.parse(localStorage.getItem("cart"));
    if (listCart) {
      const objIndex = listCart.findIndex((obj) => obj.id == state.id);
      if (objIndex > -1) {
        listCart[objIndex].quantity += quantity;
      } else {
        listCart.push({ ...state, quantity: quantity });
      }
      localStorage.setItem("cart", JSON.stringify(listCart));
    } else {
      localStorage.setItem("cart", JSON.stringify([{ ...state, quantity: quantity }]));
    }
  };
  const decrement = () => {
    setQuantity((prev) => (prev > 1 ? prev - 1 : 1));
  };
  const increment = () => {
    setQuantity((prev) => prev + 1);
  };

  return (
    <div className="detail-screen">
      <Header />
      <div className="detail-body">
        <Image
          className="detail-image"
          src={state.img}
          height={500}
          width={500}
        />
        <div className="detail-content">
          <p style={{ fontWeight: "bold" }}>Name: {state.name}</p>
          <p>Description: {state.description}</p>
          <p>Price: {state.price} $</p>
          <div
            className="detail-color"
            style={{ backgroundColor: state.color, marginBottom: "15px" }}
          ></div>
          <div className="detail-quantity">
            <button onClick={decrement}>&mdash;</button>
            <input className="detail-quantity-input" type="text" value={quantity} readonly />
            <button onClick={increment}>&#xff0b;</button>
          </div>
          <Button onClick={addToCart} variant="warning">
            Add To Cart
          </Button>
        </div>
      </div>
    </div>
  );
};
export default Detail;
