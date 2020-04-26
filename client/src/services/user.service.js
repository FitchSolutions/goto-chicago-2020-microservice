import axios from 'axios';
import authHeader from './auth-header';
import store from '../store/index';

const BASE_PATH = '/api/users/';

class UserService {
  getAll() {
    return axios.get(this.baseURL(), {
        headers: authHeader()
    });
  }
  baseURL() {
    return store.state.hosts.user + BASE_PATH;
  }
}

export default new UserService();
