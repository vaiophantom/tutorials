import { useState } from "react";
import {
  Form,
  InputGroup,
  DropdownButton,
  Dropdown,
  Image,
} from "react-bootstrap";
import IMAGES from "../../assets/images";
import CONSTANT from "../../constants";

const Search = (props) => {
  const { handleSearch } = props;
  const [typeSearch, setTypeSearch] = useState(CONSTANT.TYPE_SEARCH[0]);
  const [valueSearch, setValueSearch] = useState("");

  const onChangeSearch = (e) => {
    const { value } = e.target;
    setValueSearch(value);
  };

  const onClickSearch = () => {
    handleSearch(typeSearch, valueSearch);
  };

  return (
    <>
      <InputGroup style={{ backgroundColor: "white", alignItems: "center" }}>
        <DropdownButton
          defaultValue={"asdasd"}
          variant="outline-primary"
          title={typeSearch}
        >
          {CONSTANT.TYPE_SEARCH.map((item, idx) => {
            return (
              <Dropdown.Item
                key={idx}
                onClick={() => {
                  setTypeSearch(item);
                }}
              >
                {item}
              </Dropdown.Item>
            );
          })}
        </DropdownButton>
        <Form.Control
          value={valueSearch}
          onChange={onChangeSearch}
          placeholder="Search products based on category name, product name, price, branch..."
          aria-describedby="basic-addon3"
        />
        <Image
          className=""
          onClick={onClickSearch}
          src={IMAGES.search}
          height={30}
          width={30}
        />
      </InputGroup>
    </>
  );
};
export default Search;
