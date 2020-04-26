import Vue from 'vue';
import Vuex from 'vuex';

import { auth } from './auth.module';
import {userServiceHost, calendarServiceHost } from '../services/server'


Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    hosts: {
      calendar: calendarServiceHost,
      user: userServiceHost
    }
  },
  mutations: {
    calendarServiceHost(state, url) {
      state.hosts.calendar = url;
    },
    userServiceHost(state, url) {
      state.hosts.user = url;
    }
  },
  modules: {
    auth
  }
});
