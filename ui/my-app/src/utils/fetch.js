const BASE_URL = "http://10.27.85.132:8800/";
const MOCK_API = "https://62eb3500ad295463259a232a.mockapi.io/products";
const mockData = {
  status: {
    code: "000000",

    message: "Success",
  },

  data: [
    {
      createdDatetime: 2022080110105,

      createdBy: 1,

      updatedDatetime: null,

      updatedBy: null,

      status: true,

      id: 3,

      name: "530i",

      description: "petrol car",

      price: 10.0,

      color: "Black",
    },

    {
      createdDatetime: 2022080110107,

      createdBy: 1,

      updatedDatetime: null,

      updatedBy: null,

      status: true,

      id: 4,

      name: "530e",

      description: "electric car",

      price: 10.0,

      color: "Black",
    },

    {
      createdDatetime: 2022080110110,

      createdBy: 1,

      updatedDatetime: null,

      updatedBy: null,

      status: true,

      id: 5,

      name: "750Li",

      description: "luxury car",

      price: 10.0,

      color: "Black",
    },
  ],

  pagination: {
    pageCount: 0,

    pageSize: 0,

    currentPage: 0,

    recordCount: 3,

    sortOrder: null,
  },
};
export const post = async (url = "", body = {}) => {
  try {
    let response = await fetch(BASE_URL + url, {
      method: "POST",
      body: JSON.stringify(body),
    });
    response = response.json();
    if (response?.data.length > 0) return response?.data;
    else {
      throw new Error("cannot get products right now, please comback later !");
    }
  } catch (error) {
    throw new Error("cannot get products right now, please comback later !");
  }
};

export const postMock = async () => {
  let res = await fetch(MOCK_API);
  res = res.json();
  return res;
};
