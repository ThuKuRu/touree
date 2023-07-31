import React, { Fragment, useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { useFormik } from "formik";
import LocationService from "../../service/LocationService";
import TourService from "../../service/TourService";
import TourCard from "../../component/MultipleItems/TourCard";
import TopNav from "../../Home/Layout/TopNav/TopNav";
import Footer from "../../Home/Layout/Footer/Footer";
import "./locationDetail.css";
import TourLocationService from "../../service/TourLocationService";
const LocationDetail = () => {
  const { id } = useParams();
  const [location, setLocation] = useState("");
  const [tours, setTours] = useState([]);
  const getDataFromApi = async () => {
    try {
      const response = await LocationService.getById(id);
      const response2 = await TourLocationService.getAllToursByLocationId(id);
      console.log(response2);
      setTours(response2.data);
      setLocation(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    getDataFromApi();
  }, []);
  console.log(tours);
  const listTours = () => {
    return tours?.map((item, index) => {
      return (
        <Fragment key={item.id}>
          <TourCard tour={item} />
        </Fragment>
      );
    });
  };
  const formik = useFormik({
    initialValues: {
      searchTerm: "",
    },
    onSubmit: (values) => {},
  });
  const [showSideBar, setShowSideBar] = useState(false);
  return (
    <>
      <TopNav />
      <div
        className={
          "sidebar drop-shadow-lg rounded-r-2xl mt-20" +
          (showSideBar ? " open" : "")
        }
      >
        <button
          type="button"
          className=" sidebar-show-button absolute text-blue-700 border border-blue-700  focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-full text-sm p-2.5 text-center inline-flex items-center dark:border-blue-500 dark:text-blue-500 dark:hover:text-white dark:focus:ring-blue-800 bg-white"
          onClick={() => {
            setShowSideBar(!showSideBar);
          }}
        >
          {showSideBar ? (
            <svg
              className="w-5 h-4 mr-2"
              viewBox="0 0 10 24"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={1}
                d="M11 19l-7-7 7-7m8 14l-7-7 7-7"
              />
            </svg>
          ) : (
            <svg
              className="w-5 h-4 mr-2"
              viewBox="0 0 10 24"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={1}
                d="M13 5l7 7-7 7M5 5l7 7-7 7"
              />
            </svg>
          )}
        </button>
        <ul className="nav-list">
          <li>
            <form onSubmit={formik.handleSubmit}>
              <input
                type="text"
                name="searchTerm"
                onChange={formik.handleChange}
                placeholder="Search Course"
                className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 
            rounded leading-3 focus:outline-none focus:border-gray-500"
              />
            </form>
            <span className="tooltip">Search</span>
          </li>
          <div className="container-checkbox relative"></div>
        </ul>
      </div>

      <section className="home-section mt-20">
        <div className="mt-16">
          <div className="flex">
            <div className="flex-1 flex-col">
              <p
                style={{ fontSize: "30px", marginLeft: "50px" }}
                className="font-bold center mt-14 text-blue-500"
              >
                {location.locationName}
              </p>
              <p
                style={{ fontSize: "20px", marginLeft: "50px" }}
                className="mt-4"
              >
                {location.information}
              </p>
            </div>
            <div className="flex-1 w-1 mt-16">
              <img
                src={location.image}
                alt=""
                style={{ height: "500px", width: "600px", marginLeft: "30px " }}
              />
            </div>
          </div>
        </div>
        <div className="cards">{listTours()}</div>
      </section>
      <Footer />
    </>
  );
};

export default LocationDetail;
