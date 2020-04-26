package com.dmrtech.calendarservice.repository;


import com.dmrtech.calendarservice.model.CalendarItem;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CalendarItemRepository extends PagingAndSortingRepository<CalendarItem, Long> {

}