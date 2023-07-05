import {
  createBrowserRouter,
  RouterProvider,
  Route,
  Link,
} from "react-router-dom";
import TourManager from "./pages/tourManagement/TourManager";
import Home from "./Home/Home";
import AddTour from "./component/add_tour/AddTour";
import EditTour from "./component/edit_tour/EditTour";

const App = () => {
  const router = createBrowserRouter([
    {
      path: "/",
      element: <Home/>
    },
    {
      path: "tourMangage",
      element: <TourManager/>,
    },
    {
      path: "addTour",
      element: <AddTour/>
    },
    {
      path: "editTour/:id",
      element: <AddTour/>
    }
  ]);
  return (
    <RouterProvider router={router} />
  );
};

export default App;
