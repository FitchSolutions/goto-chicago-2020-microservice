<template>
  <div class="container">
      <ul>
          <li
              v-for="user in users"
              class="user"
              :key="user.id"
            >
            <div class="view">
                <label>{{user.username}}</label> - 
                <label>{{user.email}}</label>
            </div>
          </li>
      </ul>
  </div>
  
</template>

<script>
import UserService from '../services/user.service'

export default {
  name: 'Users',
  components: {
    },
    data: function() {
        return {
            users: [],
            error: ''
        };
    },

    mounted() {
    UserService.getAll()
      .then(response => {
        this.$log.debug("Data loaded: ", response.data);
        this.users = response.data;
      })
      .catch(error => {
        this.$log.debug(error);
        this.error = "Failed to load Users";
      })
      .finally(() => (this.loading = false));
  },

  };
</script>