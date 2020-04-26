package com.dmrtech.calendarservice.services;

import com.dmrtech.calendarservice.model.CalendarItem;
import com.dmrtech.calendarservice.payload.request.CalendarItemRequest;

public interface CalendarItemService {
    CalendarItem generateFromRequest(CalendarItemRequest calendarItemRequest);
}
