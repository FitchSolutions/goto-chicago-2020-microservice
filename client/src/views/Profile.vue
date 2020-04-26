<template>
  <div class="container">
    <header class="jumbotron">
      <h3>
        <strong>{{currentUser.username}}</strong> Profile
      </h3>
    </header>
    <p>
      <strong>Token:</strong>
      {{currentUser.accessToken.substring(0, 20)}} ... {{currentUser.accessToken.substr(currentUser.accessToken.length - 20)}}
    </p>
    <p>
      <strong>Id:</strong>
      {{currentUser.id}}
    </p>
    <p>
      <strong>Email:</strong>
      {{currentUser.email}}
    </p>
    <p>
      <strong>Calendar Service URL:</strong>
      <input
              class="new-calendarevent"
              autofocus
              autocomplete="off"
              v-model="hosts.calendar"
              @keyup.enter="setCalendarServiceHost"
            />
      </p>
<p>
      <strong>User Service URL:</strong>
      <input
              class="new-calendarevent"
              autofocus
              autocomplete="off"
              v-model="hosts.user"
              @keyup.enter="setUserServiceHost"
            />
      </p>
  </div>
</template>

<script>
export default {
  name: 'Profile',
  data: function() {
    return {
      hosts : { 
        calendar: this.$store.state.hosts.calendar,
        user: this.$store.state.hosts.user
      }
    }
  },
  computed: {
    calendarServiceHost() {
      return this.$store.state.hosts.calendar;
    },
    userServiceHost() {
      return this.$store.state.hosts.user;
    },
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  mounted() {
    if (!this.currentUser) {
      this.$router.push('/login');
    }
  },
  methods: {
    setCalendarServiceHost() {
      this.$store.commit('calendarServiceHost', this.hosts.calendar);
    },
    setUserServiceHost() {
      this.$store.commit('userServiceHost', this.hosts.user);
    }
  }
};
</script>