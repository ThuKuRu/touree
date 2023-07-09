import axios from "axios";
const LOCATION_BASE_REST_API_URL = "http://localhost:8080/location";
class LocationService {
  getAllLocation() {
    return axios.get(LOCATION_BASE_REST_API_URL + "/getlocationpage");
    
  }
  deleteLocation(locationId) {
    return axios.delete(LOCATION_BASE_REST_API_URL + "/deletelocation/" + locationId);
  }
  
}
export default new LocationService();
