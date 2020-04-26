package com.dmrtech.calendarservice.services;

import com.dmrtech.calendarservice.model.CalendarItem;
import com.dmrtech.calendarservice.payload.request.CalendarItemRequest;
import org.springframework.stereotype.Service;

@Service
public class CalendarItemServiceImpl implements CalendarItemService {

    @Override
    public CalendarItem generateFromRequest(CalendarItemRequest calendarItemRequest) {
        CalendarItem calendarItem = new CalendarItem(calendarItemRequest.getDate(), calendarItemRequest.isAllDayEvent(), calendarItemRequest.getTitle(), calendarItemRequest.getDetails());
        calendarItem.setId(calendarItemRequest.getId());
        return calendarItem;
    }
}
