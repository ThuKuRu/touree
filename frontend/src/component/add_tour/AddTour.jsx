import {
  Button,
  Cascader,
  DatePicker,
  Form,
  Input,
  InputNumber,
  Radio,
  Select,
  Switch,
  TreeSelect,
} from "antd";
import { useState } from "react";
import { format, parseISO } from "date-fns";
import dayjs from "dayjs";
import { useNavigate, useParams } from "react-router-dom";
import TourService from "../../service/TourService";
import { useEffect } from "react";
const AddTour = () => {
  const navigate = useNavigate();
  const [tourName, setTourName] = useState("");
  const [rate, setRate] = useState();
  const [price, setPrice] = useState();
  const [pointOfDepature, setPointOfDeparture] = useState("");
  const [departurePoint, setDeparturePoint] = useState("");
  const [information, setInformation] = useState("");
  const [image, setImage] = useState(
    "https://wall.vn/wp-content/uploads/2019/11/hinh-anh-phong-canh-da-lat-8.jpg"
  );
  const [dateTour, setDateTour] = useState("");
  const handleDateChange = (date) => {
    const d = dayjs(date).format("YYYY-MM-DD");
    setDateTour(d);
  };
  const { id } = useParams();
  useEffect(() => {
    TourService.getTourById(id)
      .then((response) => {
        setTourName(response.data.tourName);
        setPrice(response.data.price);
        setInformation(response.data.information);
        setDateTour(response.data.dateTour);
        setDeparturePoint(response.data.departurePoint);
        setPointOfDeparture(response.data.pointOfDepature);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);
  const title = () => {
    if (id) {
      return <h2 style={{ textAlign: "center" }}>Update tour</h2>;
    } else {
      return <h2 style={{ textAlign: "center" }}>Add tour </h2>;
    }
  };
  const saveTour = (e) => {
    e.preventDefault();
    const tour = {
      tourName,
      rate,
      price,
      pointOfDepature,
      departurePoint,
      information,
      image,
      dateTour,
    };
    if (id) {
      TourService.updateTour(id, tour)
        .then((response) => {
          navigate("/tourMangage");
        })
        .catch((error) => {
          console.log(error);
        });
    } else {
      TourService.createTour(tour)
        .then((response) => {
          console.log(response.data);
        })
        .catch((error) => {
          console.log(error);
        });
      navigate("/tourMangage");
    }
  };
  return (
    <div
      style={{
        height: "500px",
        width: "500px",
        marginLeft: "550px",
        marginTop: "100px",
        border: "1px solid",
        padding: "20px",
        borderRadius: "20px",
      }}
    >
      {title()}
      <Form
        labelCol={{
          span: 6,
        }}
        wrapperCol={{
          span: 14,
        }}
      >
        <Form.Item label="Tour Name">
          <Input
            value={tourName}
            placeholder="Enter tour name"
            name="tour_name"
            onChange={(e) => setTourName(e.target.value)}
          />
        </Form.Item>
        <Form.Item label="Information">
          <Input
            value={information}
            placeholder="Enter information"
            onChange={(e) => setInformation(e.target.value)}
          />
        </Form.Item>
        <Form.Item label="Price">
          <Input
            value={price}
            placeholder="Enter price"
            onChange={(e) => setPrice(e.target.value)}
          />
        </Form.Item>
        <Form.Item label="Point Of Departure">
          <Input
            value={pointOfDepature}
            placeholder=""
            name="a"
            onChange={(e) => setPointOfDeparture(e.target.value)}
          />
        </Form.Item>
        <Form.Item label="Departure Point">
          <Input
            value={departurePoint}
            placeholder=""
            name="b"
            onChange={(e) => setDeparturePoint(e.target.value)}
          />
        </Form.Item>
        <Form.Item label="Date Tour">
          <Input
            value={dateTour}
            placeholder=""
            name="b"
            onChange={(e) => setDateTour(e.target.value)}
          />
        </Form.Item>
      </Form>
      <div style={{ display: "flex" }}>
        <Button
          danger
          ghost
          onClick={(e) => navigate("/tourMangage")}
          style={{ marginTop: "50px", marginLeft: "180px" }}
        >
          Cancel
        </Button>
        <Button
          type="primary"
          onClick={(e) => saveTour(e)}
          style={{ marginTop: "50px", marginLeft: "20px" }}
        >
         {id ? "Update tour" : "Create tour"}
        </Button>
      </div>
    </div>
  );
};
export default AddTour;
