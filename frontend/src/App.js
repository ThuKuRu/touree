import {
  createBrowserRouter,
  RouterProvider,
  Route,
  Link,
} from "react-router-dom";
import TourManager from "./pages/tourManagement/TourManager";
import Home from "./Home/Home";
import AddTour from "./component/add_tour/AddTour";

import TourDetail from "./pages/tourDetail/TourDetail";
import Manage from "./pages/manage/Manage";
import AddUpdateLocation from "./component/add_update_location/AddUpdateLocation";
import "./index.css";
const App = () => {
  const router = createBrowserRouter([
    {
      path: "/",
      element: <Home />,
    },

    {
      path: "addTour",
      element: <AddTour />,
    },
    {
      path: "editTour/:id",
      element: <AddTour />,
    },
    {
      path: "tours/:id",
      element: <TourDetail />,
    },
    {
      path: "manage",
      element: <Manage />,
    },
    {
      path: "addLocation",
      element: <AddUpdateLocation />,
    },
  ]);
  return <RouterProvider router={router} />;
};

export default App;
