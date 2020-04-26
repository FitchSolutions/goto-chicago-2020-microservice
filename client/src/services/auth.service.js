import axios from 'axios';
import store from '../store/index';

const BASE_PATH = '/api/auth/';

class AuthService {
  login(user) {
    return axios
      .post(this.baseURL() + 'signin', {
        username: user.username,
        password: user.password
      })
      .then(response => {
        if (response.data.accessToken) {
          localStorage.setItem('user', JSON.stringify(response.data));
        }

        return response.data;
      });
  }

  logout() {
    localStorage.removeItem('user');
  }

  register(user) {
    return axios.post(this.baseURL() + 'signup', {
      username: user.username,
      email: user.email,
      password: user.password
    });
  }
  baseURL() {
    return store.state.hosts.user + BASE_PATH;
  }
}

export default new AuthService();
