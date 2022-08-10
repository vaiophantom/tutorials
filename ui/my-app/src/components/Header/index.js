import IMAGES from "../../assets/images";
import { Image, Badge } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import Search from "../Search";
import { useState } from "react";

const Header = (props) => {
  const [badge, setBadge] = useState(0);
  const { handleSearch } = props;
  const navigate = useNavigate();

  const onClickCart = () => {
    navigate("/shoppingCart");
  };
  const onClickLogo = () => {
    navigate("/");
  };
  return (
    <div className="header">
      <Image
        className="logo"
        onClick={onClickLogo}
        src={IMAGES.logo}
        height={100}
        width={200}
      />
      <div className="search">
        <Search handleSearch={handleSearch} />
      </div>
      <Image
        onClick={onClickCart}
        className="cart"
        src={IMAGES.cart}
        height={40}
        width={40}
      />
      {badge > 0 && <Badge bg="danger">{badge}</Badge>}
    </div>
  );
};
export default Header;
