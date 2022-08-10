import Header from "../../components/Header";

const NoPage = () => {
  const handleSearch = (type, value) => {};
  return (
    <div>
      <Header handleSearch={handleSearch} />
      <div className="body">NoPage</div>
    </div>
  );
};
export default NoPage;
