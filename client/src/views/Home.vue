<template>
  <div class="container">
    <CalendarList />
  </div>
  
</template>

<script>
import CalendarList from '../components/CalendarList';

export default {
  name: 'Home',
  components: {
      CalendarList
    }
  };
</script>
