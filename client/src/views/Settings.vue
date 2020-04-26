<template>
  <div class="container">
    <header class="jumbotron">
      <h3>
        Application Settings
      </h3>
    </header>
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
  name: 'Settings',
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