import { useEffect, useState } from "react";
import ProductCart from "../../components/ProductCart";
import { Button, Form } from "react-bootstrap";
import Header from "../../components/Header";
import { useNavigate } from "react-router-dom";
import { currencyFormat } from "../../utils/helper";

const ShoppingCart = () => {
  const [listProducts, setListProducts] = useState([]);
  const [checked, setChecked] = useState(false);
  const [total_payment, setTotal_payment] = useState(0);
  const navigate = useNavigate();

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
      const hasAllSelected = listProducts.some(
        (item) => item.checked === false
      );
      setChecked(!hasAllSelected);
      const total = listProducts.reduce((prev, current) => prev + (current.price*current.quantity), 0);
      setTotal_payment(total)
    }
  }, [listProducts]);

  const onSelectAll = (e) => {
    setChecked(e.target.checked);
    const newListProducts = listProducts.map((item) => {
      return { ...item, checked: e.target.checked };
    });
    setListProducts(newListProducts);
  };

  const outputCheckBox = (data) => {
    if (data?.id) {
      const index = listProducts.findIndex((item) => item.id === data.id);
      listProducts[index].checked = data.checked;
      setListProducts([...listProducts]);
    }
  };

  const deleteItem = () => {
    const newList = listProducts.filter((item) => item.checked == false);
    localStorage.setItem("cart", JSON.stringify(newList));
    setListProducts(newList);
  };

  const onPayment = () => {
    navigate("/checkout");
  };
  const handleSearch = (type, value) => {};

  return (
    <div className="shopping-cart-screen">
      <Header handleSearch={handleSearch}/>
      <div className="shopping-cart-body">
        <div className="shopping-cart-label">
          <div style={{ flex: 3, display: "flex", flexDirection: "row" }}>
            <Form.Check
              checked={checked}
              onChange={onSelectAll}
              style={{ marginRight: 20 }}
              type="checkbox"
              id="select_all"
            ></Form.Check>
            <p>Product</p>
          </div>
          <div style={{ flex: 1 }}>Price</div>
          <div style={{ flex: 1 }}>Quantity</div>
          <div style={{ flex: 1 }}>Total Price</div>
        </div>
        <div className="shopping-cart-product">
          {listProducts.map((item) => {
            return <ProductCart data={item} outputCheckBox={outputCheckBox} />;
          })}
        </div>
      </div>
      <div className="shopping-cart-footer">
        <Button onClick={deleteItem} variant="warning" style={{ flex: 1 }}>
          Delete
        </Button>
        <div style={{ flex: 5, marginRight: 20, textAlign: "end" }}>
          <p style={{fontWeight:"bold"}}>Total Payment: {currencyFormat(total_payment)} $</p>
        </div>
        <Button
          disabled={listProducts.length == 0}
          onClick={onPayment}
          variant="warning"
          style={{ flex: 2 }}
        >
          Checkout
        </Button>
      </div>
    </div>
  );
};
export default ShoppingCart;
