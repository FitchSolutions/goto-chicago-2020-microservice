<template>
  <div>
    <h1 class="title">Calendar List</h1>
    <h1 class="email">{{ userEmail }}</h1>
    <section class="calendareventapp">
      <div v-if="loading">
        <h1 class="loading">Loading...</h1>
      </div>
      <div v-else>
        <header class="header">
          <input
            class="new-calendarevent"
            autofocus
            autocomplete="off"
            :placeholder="this.inputPlaceholder"
            v-model="newCalendarEvent.title"
            @keyup.enter="addCalendarEvent"
          />
          <VueDatePicker
            class="date"
            @onChange="newCalendarEventDateChanged"
            v-model="newCalendarEvent.date"
          ></VueDatePicker>
        </header>
        <section class="main" v-show="calendarevents.length" v-cloak>
          <input class="toggle-all" type="checkbox" v-model="allDone" />
          <ul class="calendarevent-list">
            <li
              v-for="calendarevent in filteredCalendarList"
              class="calendarevent"
              :key="calendarevent.id"
              :class="{
                completed: calendarevent.completed,
                editing: calendarevent == editedCalendarEvent
              }"
            >
              <div class="view">
                <input
                  class="toggle"
                  type="checkbox"
                  v-model="calendarevent.completed"
                  @change="completeCalendarEvent(calendarevent)"
                />
                <label @dblclick="editCalendarEvent(calendarevent)">{{
                  calendarevent.title
                }}</label>
                <VueDatePicker
                  class="date"
                  @onChange="calendarEventDateSelected"
                  v-model="calendarevent.date"
                  name="calendardate"
                ></VueDatePicker>
                <button
                  class="destroy"
                  @click="removeCalendarEvent(calendarevent)"
                ></button>
              </div>
              <input
                class="edit"
                type="text"
                v-model="calendarevent.title"
                v-calendarevent-focus="calendarevent == editedCalendarEvent"
                @blur="doneEdit(calendarevent)"
                @keyup.enter="doneEdit(calendarevent)"
                @keyup.esc="cancelEdit(calendarevent)"
              />
            </li>
          </ul>
        </section>
        <footer class="footer" v-show="calendarevents.length" v-cloak>
          <span class="calendarevent-count">
            <strong>{{ remaining }}</strong> {{ remaining | pluralize }} left
          </span>
          <ul class="filters">
            <li>
              <a
                href="#/all"
                @click="setVisibility('all')"
                :class="{ selected: visibility == 'all' }"
                >All</a
              >
            </li>
            <li>
              <a
                href="#/active"
                @click="setVisibility('active')"
                :class="{ selected: visibility == 'active' }"
                >Active</a
              >
            </li>
            <li>
              <a
                href="#/completed"
                @click="setVisibility('completed')"
                :class="{ selected: visibility == 'completed' }"
                >Completed</a
              >
            </li>
          </ul>
          <button
            class="clear-completed"
            @click="removeCompleted"
            v-show="calendarevents.length > remaining"
          >
            Clear completed
          </button>
        </footer>
      </div>
    </section>
    <div v-if="error" class="error" @click="handleErrorClick">
      ERROR: {{ this.error }}
    </div>
  </div>
</template>

<script>
import CalendarService from "../services/calendar.service";

// visibility filters
let filters = {
  all: function(calendarevents) {
    return calendarevents;
  },
  active: function(calendarevents) {
    return calendarevents.filter(function(calendarevent) {
      return !calendarevent.completed;
    });
  },
  completed: function(calendarevents) {
    return calendarevents.filter(function(calendarevent) {
      return calendarevent.completed;
    });
  }
};

// app Vue instance
const CalendarList = {
  name: "CalendarList",
  props: {
    activeUser: Object
  },

  // app initial state
  data: function() {
    return {
      calendarevents: [],
      newCalendarEvent: { title: "", date: new Date() },
      editedCalendarEvent: null,
      visibility: "all",
      loading: true,
      error: null
    };
  },

  mounted() {
    CalendarService.getAll()
      .then(response => {
        this.$log.debug("Data loaded: ", response.data);
        this.calendarevents = response.data;
      })
      .catch(error => {
        this.$log.debug(error);
        this.error = "Failed to load Calendar Events";
      })
      .finally(() => (this.loading = false));
  },

  // computed properties
  // http://vuejs.org/guide/computed.html
  computed: {
    filteredCalendarList: function() {
      return filters[this.visibility](this.calendarevents);
    },
    remaining: function() {
      return filters.active(this.calendarevents).length;
    },
    allDone: {
      get: function() {
        return this.remaining === 0;
      },
      set: function(value) {
        this.calendarevents.forEach(function(calendarevent) {
          calendarevent.completed = value;
        });
      }
    },
    userEmail: function() {
      return this.activeUser ? this.activeUser.email : "";
    },
    inputPlaceholder: function() {
      return this.activeUser
        ? this.activeUser.given_name + ", what event should go on the calendar?"
        : "What event should go on the calendar";
    }
  },

  filters: {
    pluralize: function(n) {
      return n === 1 ? "item" : "items";
    }
  },

  // methods that implement data logic.
  // note there's no DOM manipulation here at all.
  methods: {
    addCalendarEvent() {
      var title =
        this.newCalendarEvent.title && this.newCalendarEvent.title.trim();
      if (!title) {
        return;
      }

      var dateValue = this.newCalendarEvent.date;
      if (!dateValue) {
        return;
      }

      CalendarService.createNew(title, dateValue, false)
        .then(response => {
          this.$log.debug("New item created:", response);
          this.calendarevents.push({
            id: response.data.id,
            title: title,
            date: dateValue,
            completed: false
          });
        })
        .catch(error => {
          this.$log.debug(error);
          this.error = "Failed to add Calendar Event";
        });

      this.newCalendarEvent = { title: "", date: new Date() };
    },

    newCalendarEventDateChanged: function(newCalendarEventDate) {
      this.newCalendarEvent.date = newCalendarEventDate;
      this.addCalendarEvent();
    },

    setVisibility: function(vis) {
      this.visibility = vis;
    },

    completeCalendarEvent(calendarevent) {
      CalendarService.updateForId(
        calendarevent.id,
        calendarevent.title,
        calendarevent.date,
        calendarevent.completed
      )
        .then(response => {
          this.$log.info("Item updated:", response.data);
        })
        .catch(error => {
          this.$log.debug(error);
          calendarevent.completed = !calendarevent.completed;
          this.error = "Failed to update calendar event";
        });
    },

    removeCalendarEvent: function(calendarevent) {
        CalendarService.removeForId(calendarevent.id)
        .then(() => {
          this.$log.debug("Item removed:", calendarevent);
          this.calendarevents.splice(
            this.calendarevents.indexOf(calendarevent),
            1
          );
        })
        .catch(error => {
          this.$log.debug(error);
          this.error = "Failed to remove calendarevent";
        });
    },

    editCalendarEvent: function(calendarevent) {
      this.beforeEditCache = calendarevent;
      this.editedCalendarEvent = calendarevent;
    },

    doneEdit: function(calendarevent) {
      if (!this.editedCalendarEvent) {
        return;
      }
      this.$log.info("Item updated:", calendarevent);
      CalendarService.updateForId(
        calendarevent.id,
        calendarevent.title.trim(),
        calendarevent.date,
        calendarevent.completed
      )
        .then(response => {
          this.$log.info("Item updated:", response.data);
          this.editedCalendarEvent = null;
          calendarevent.title = calendarevent.title.trim();
        })
        .catch(error => {
          this.$log.debug(error);
          this.cancelEdit(calendarevent);
          this.error = "Failed to update calendarevent";
        });

      if (!calendarevent.title) {
        this.removeCalendarEvent(calendarevent);
      }
    },

    cancelEdit: function(calendarevent) {
      this.editedCalendarEvent = null;
      calendarevent.title = this.beforeEditCache.title;
    },

    calendarEventDateOpened: function(calendarEvent) {
        this.editCalendarEvent(calendarEvent)
    },
    calendarEventDateSelected: function() {
      this.saveAll();
    },
    removeCompleted: function() {
      this.calendarevents = filters.active(this.calendarevents);
    },

    handleErrorClick: function() {
      this.error = null;
    },
    saveAll: function() {
        this.calendarevents.forEach(calendarEvent=>{
            this.editedCalendarEvent = calendarEvent;
            this.doneEdit(calendarEvent);
        })
    }

  },

  // a custom directive to wait for the DOM to be updated
  // before focusing on the input field.
  // http://vuejs.org/guide/custom-directive.html
  directives: {
    "calendarevent-focus": function(el, binding) {
      if (binding.value) {
        el.focus();
      }
    }
  }
};

export default CalendarList;
</script>

<style>
[v-cloak] {
  display: none;
}
</style>
