import axios from 'axios'
import authHeader from './auth-header';
import store from '../store/index';


const BASE_QUERYSTRING_PATH = '/api/calendaritems/';


class CalendarService {
    // (C)reate  
    createNew(text, date, completed) {
        return axios.post(this.baseURL(), {
            title: text,
            date: date,
            completed: completed,
        }, {
            headers: authHeader()
        });
    }
    // (R)ead  
    getAll() {
        return axios.get(this.baseURL(), {
            headers: authHeader()
        });
    }
    // (U)pdate  
    updateForId(id, text, date, completed) {
        return axios.put(this.baseURL() + id, {
            title: text,
            date: date,
            completed: completed
        }, {
            headers: authHeader()
        });
    }
    // (D)elete  
    removeForId(id) {
        return axios.delete(this.baseURL() + id, {
            headers: authHeader()
        });
    }
    baseURL() {
        return store.state.hosts.calendar + BASE_QUERYSTRING_PATH;
    }
}

export default new CalendarService();