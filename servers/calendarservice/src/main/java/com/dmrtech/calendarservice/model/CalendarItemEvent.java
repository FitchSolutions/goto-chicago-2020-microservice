package com.dmrtech.calendarservice.model;

public class CalendarItemEvent {

    public CalendarItemEvent() {
    }

    public CalendarItemEvent(EVENT_TYPE eventType, CalendarItem calendarItem) {
        this.eventType = eventType;
        this.calendarItem = calendarItem;
    }

    public EVENT_TYPE getEventType() {
        return eventType;
    }

    public void setEventType(EVENT_TYPE eventType) {
        this.eventType = eventType;
    }

    public CalendarItem getCalendarItem() {
        return calendarItem;
    }

    public void setCalendarItem(CalendarItem calendarItem) {
        this.calendarItem = calendarItem;
    }

    public enum EVENT_TYPE {
        CREATED,
        UPDATED,
        DELETED
    }

    private EVENT_TYPE eventType;
    private CalendarItem calendarItem;


}
