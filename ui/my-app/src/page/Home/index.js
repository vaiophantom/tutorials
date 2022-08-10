import { useEffect, useRef, useState } from "react";
import { Pagination, Modal, Button } from "react-bootstrap";
import Product from "../../components/Product";
import Header from "../../components/Header";
import CONSTANT from "../../constants";
import { useLocation } from "react-router-dom";
import { searchProduct, postMock } from "../../utils/fetch";
import { API_PATH } from "../../api/apiPath";

const LIMIT_PRODUCT = 20;
const Home = () => {
  const [allProducts, setAllProducts] = useState([]);
  const [products, setProducts] = useState([]);
  const [page, setPage] = useState(0);
  const { state } = useLocation();

  const [message, setMessage] = useState("");

  useEffect(() => {
    const getProducts = async () => {
      try {
        let newProducts = await searchProduct();
        setAllProducts(newProducts);
      } catch (error) {
        console.log("error", error);
        setMessage(error.message);
      }
    };
    getProducts();
  }, []);

  useEffect(() => {
    if (allProducts.length > 0) {
      const productsRender = allProducts.slice(
        page * LIMIT_PRODUCT,
        (page + 1) * LIMIT_PRODUCT
      );
      setProducts((prev) => [...prev, ...productsRender]);
    }
  }, [page, allProducts]);

  useEffect(() => {
    if (state?.message) {
      setMessage(state?.message);
    }
  }, [state]);

  useEffect(() => {
    if (message !== "") {
      setTimeout(() => {
        setMessage("");
      }, 3000);
    }
  }, [message]);

  const handleSearch = async (type, value) => {
    try {
      console.log({ [type]: value });
      const newProducts = await searchProduct({ [type]: value });
      setProducts(newProducts);
    } catch (error) {
      console.log("error", error);
      setMessage(error.message);
    }
  };

  const onClickNext = () => {
    setPage((prev) => prev + 1);
  };

  const onHideModal = () => {
    setMessage("");
  };

  return (
    <div className="screen">
      <Header handleSearch={handleSearch} />
      <div className="body">
        {products.length > 0 ? (
          products.map((item, idx) => {
            return (
              <Product
                key={idx}
                data={item}
                onAddCart={() => setMessage("add to cart success !")}
              />
            );
          })
        ) : (
          <p>not found any products</p>
        )}
      </div>
      {products.length >= LIMIT_PRODUCT && (
        <div className="footer">
          <Pagination>
            <Pagination.Next onClick={onClickNext} />
          </Pagination>
        </div>
      )}
      <Modal show={!!message} onHide={onHideModal}>
        <Modal.Header closeButton>
          <Modal.Title>Notification</Modal.Title>
        </Modal.Header>
        <Modal.Body>{message}</Modal.Body>
      </Modal>
    </div>
  );
};
export default Home;
