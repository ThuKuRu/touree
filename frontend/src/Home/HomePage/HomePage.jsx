import React, { useState, useEffect } from "react";
import getTourList from "../../api/tourAPI";
import getLocationList from "../../api/locationAPI";
import { HomePageStyle, Image, Img } from "./index.style";
import ImageBackground from "../../img/background.png";

const HomePage = ({ setTab }) => {
  const [tourList, setTourList] = useState([]);
  const [locationList, setLocationList] = useState([]);

  const fetchData = async () => {
    const dataTour = await getTourList();
    const dataLocation = await getLocationList();
    setTourList(dataTour.data.content);
    setLocationList(dataLocation.data.content);
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
          {locationList.map((location) => (
            <Img
              key={location.id}
              src={location.image}
              alt="/"
              onClick={() => {
                setTab("tour");
              }}
            />
          ))}
        </div>
      </div>
    </HomePageStyle>
  );
};

export default HomePage;
