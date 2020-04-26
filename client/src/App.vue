<template>
  <div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <a href class="navbar-brand" @click.prevent>DMR Technology</a>
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <router-link to="/home" class="nav-link">
            <font-awesome-icon icon="home" />Home
          </router-link>
        </li>
        <li class="nav-item">
          <router-link v-if="currentUser" to="/users" class="nav-link">Users</router-link>
        </li>
      </div>

      <div v-if="!currentUser" class="navbar-nav ml-auto">
        <li class="nav-item">
          <router-link to="/register" class="nav-link">
            <font-awesome-icon icon="user-plus" />Sign Up
          </router-link>
        </li>
        <li class="nav-item">
          <router-link to="/login" class="nav-link">
            <font-awesome-icon icon="sign-in-alt" />Login
          </router-link>
        </li>
      </div>

      <div class="navbar-nav ml-auto">
        <li class="nav-item">
          <router-link to="/settings" class="nav-link">
            <font-awesome-icon icon="hammer" />Settings
          </router-link>
        </li>
      </div>
      <div v-if="currentUser" class="navbar-nav ml-auto">
        <li class="nav-item">
          <router-link to="/profile" class="nav-link">
            <font-awesome-icon icon="user" />
            {{ currentUser.username }}
          </router-link>
        </li>
        <li class="nav-item">
          <a class="nav-link" href @click.prevent="logOut">
            <font-awesome-icon icon="sign-out-alt" />Logout
          </a>
        </li>
      </div>
    </nav>

    <div class="container">
      <router-view />
    </div>

    <footer class="info">
      <p>DMR Technology Calendar for GOTO Chicago</p>
    </footer>
  </div>
</template>

<script>

  // app Vue instance
  const app = {
    name: 'app',
    // app initial state
    data: () => {
      return {
      }
    },      
    computed: {
      currentUser() {
        return this.$store.state.auth.user;
      },
    },
    methods: {
      logOut() {
        this.$store.dispatch('auth/logout');
        this.$router.push('/login');
      }
    }

  }

  export default app;
</script>

<style>
  [v-cloak] { display: none; }
</style>