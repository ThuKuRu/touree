import { Button, Table } from "antd";
import { Header } from "antd/es/layout/layout";
import Link from "antd/es/typography/Link";
import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import TopNav from "../../Home/Layout/TopNav/TopNav";
import LocationService from "../../service/LocationService";

const LocationManager = () => {
  const [locations, setLocations] = useState([]);
  const [totalPages, setTotalPages] = useState(1);
  const navigate = useNavigate();
  const fetchData = async () => {
    try {
      const response = await LocationService.getAllLocation();
      setTotalPages(response.data.numberOfElements);
      setLocations(response.data.content);
    } catch (error) {
      console.log(error);
    }
  };
  useEffect(() => {
    fetchData();
  }, []);
  const deleteLocation = (location) => {
    LocationService.deleteLocation(location.key)
      .then((response) => {
        fetchData();
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const columns = [
    {
      title: "Name",
      key: "action",
      render: (location) => (
        <Link to={`/locations/${location.key}`} target="_blank">
          {location.locationname}
        </Link>
      ),
    },
    {
      title: "Image",
      dataIndex: "image",
      key: "image",
      render: (text) => (
        <img
          src={text}
          alt="Avatar"
          style={{ width: "2000px", height: "200px",borderRadius:"5px" }}
        />
      ),
    },
    {
      title: "Information",
      dataIndex: "information",
      key: "information",
    },
    {
      title: "Action",
      key: "action",
      render: (location) => (
        <>
          <Button
            type="primary"
            ghost
            style={{ marginRight: "10px", marginBottom: "10px" }}
            onClick={() => navigate(`/editTour/${location.key}`, console.log(location))}
          >
            Update
          </Button>
          <Button type="primary" danger ghost onClick={()=>deleteLocation(location)}>
            Delete
          </Button>
        </>
      ),
    },
  ];
  const data = locations.map((item) => ({
    key: item.id,
    locationname: item.locationName,
    information: item.information,
    image: item.image,
  }));
  return (
    <>
      <div
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <div
          style={{
            marginTop: "100px",
            border: "1px solid gray",
            borderRadius: "15px",
            padding: "20px",
            height: "auto",
            width: "100%",
            marginBottom: "20px",
            overflowX: "auto",
          }}
        >
          <Button type="primary" onClick={() => navigate("/addTour")}>
            Create tour
          </Button>
          <Table
            columns={columns}
            dataSource={data}
            
            pagination={{
              pageSize: 5,
              total: totalPages,
              onChange: (page) => {},
            }}
            loading={false}
          />
        </div>
      </div>
    </>
  );
};

export default LocationManager;
