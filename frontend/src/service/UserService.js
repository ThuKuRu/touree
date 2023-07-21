import axios from "axios";
const USER_BASE_REST_API_URL = "http://localhost:8080/auth";
class UserService {
  register(user) {
    return axios.post(USER_BASE_REST_API_URL + "/signup", user);
  }
  login(user) {
    return axios.post(USER_BASE_REST_API_URL + "/login", user);
  }
}
export default new UserService();
