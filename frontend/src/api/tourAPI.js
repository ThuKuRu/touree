import api from "./api";

const getTourList = async () => {
  const match = await api({
    method: "GET",
    url: "/getAllTourPageable",
  });
  return match;
};

export default getTourList;
