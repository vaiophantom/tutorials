import Home from "./page/Home";
import { Routes, Route } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import NoPage from "./page/NoPage";
import Detail from "./page/Detail";
import Checkout from "./page/Checkout";
import './App.css';
import ShoppingCart from "./page/ShoppingCart";


function App() {
  return (
    <div className="App">
       <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/detail/:id" element={<Detail />} />
        <Route path="/shoppingCart" element={<ShoppingCart />} />
        <Route path="/checkout" element={<Checkout />} />
        <Route path="*" element={<NoPage />} />

      </Routes>
    </div>
  );
}

export default App;
