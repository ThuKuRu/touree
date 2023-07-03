import React, { useState, useEffect } from "react";
import getTourList from "../../api/tourAPI";
import { HomePageStyle, Image, Img } from "./index.style";
import ImageBackground from "../../img/background.png";

const HomePage = () => {
  const [tourList, setTourList] = useState([]);

  const fetchData = async () => {
    const data = await getTourList();
    setTourList(data.data.content);
  };

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <HomePageStyle>
      <div>
        <Image src={ImageBackground} alt="/" />
      </div>
      <div className="location">
        <p>Địa điểm</p>
      </div>
      <div className="locationSpecific">
        <div className="address">
          {tourList.map((tour) => (
            <Img src={require("../../img/" + tour.image)} alt="/" />
          ))}
        </div>
      </div>
    </HomePageStyle>
  );
};

export default HomePage;
