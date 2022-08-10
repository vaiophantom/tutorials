import { Image, Button } from "react-bootstrap";
import CONSTANT from "../../constants";
import { useNavigate } from "react-router-dom";
import IMAGES from "../../assets/images";

const Product = (props) => {
  const { data, onAddCart } = props;
  const navigate = useNavigate();
  const onClickProduct = () => {
    navigate("/detail/" + data.id, { state: data });
  };
  const onAddToCart = async (e) => {
    try {
      if (e?.stopPropagation) e.stopPropagation();
      let listCart = JSON.parse(localStorage.getItem("cart"));
      if (listCart) {
        const objIndex = listCart.findIndex((obj) => obj.id == data.id);
        if (objIndex > -1) {
          listCart[objIndex].quantity += 1;
        } else {
          listCart.push({ ...data, quantity: 1 });
        }
        localStorage.setItem("cart", JSON.stringify(listCart));
      } else {
        localStorage.setItem(
          "cart",
          JSON.stringify([{ ...data, quantity: 1 }])
        );
      }
      onAddCart();
    } catch (error) {}
  };

  return (
    <div className="product-screen" onClick={onClickProduct}>
      <Image
        src={IMAGES.noImage}
        height={CONSTANT.IMAGE_HEIGHT}
        width={CONSTANT.IMAGE_WIDTH}
      />
      <div className="product-content">
        <p style={{ fontWeight: "bold" }}>{data.name}</p>
        <p>{data.branch}</p>
        <p>{data.price} $</p>
        <Button onClick={onAddToCart} variant="warning">
          Add To Cart
        </Button>
      </div>
    </div>
  );
};
export default Product;
