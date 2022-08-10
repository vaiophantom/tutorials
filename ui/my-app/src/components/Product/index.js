import { Image } from "react-bootstrap";
import CONSTANT from "../../constants";
import { useNavigate } from "react-router-dom";
import IMAGES from "../../assets/images";

const Product = (props) => {
  const { data } = props;
  const navigate = useNavigate();
  const onClickProduct = () => {
    navigate("/detail/" + data.id, {state: data});
  };

  return (
    <div className="product-screen" onClick={onClickProduct}>
      <Image
        src={IMAGES.noImage}
        height={CONSTANT.IMAGE_HEIGHT}
        width={CONSTANT.IMAGE_WIDTH}
      />
      <div className="product-content">
        <p style={{fontWeight:"bold"}}>{data.name}</p>
        <p>{data.branch}</p>
        <p>{data.price} $</p>
      </div>
    </div>
  );
};
export default Product;
