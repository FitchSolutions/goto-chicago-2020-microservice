package com.dmrtech.calendarservice.services;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import com.dmrtech.calendarservice.model.CalendarItem;
import com.dmrtech.calendarservice.model.CalendarItemEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;


/**
 * Parasoft Jtest UTA: Test class for CalendarItemEventConsumer
 *
 * @author dferguson
 * @see CalendarItemEventConsumer
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext // Parasoft Jtest UTA: Reset context for each test run
public class CalendarItemEventConsumerSpringTest {
    // Parasoft Jtest UTA: Component under test
    @Autowired
    CalendarItemEventConsumer service;

    /**
     * Parasoft Jtest UTA: Test for calendarItemEventListener(CalendarItemEvent)
     *
     * @author dferguson
     * @see CalendarItemEventConsumer#calendarItemEventListener(CalendarItemEvent)
     */
    @Test
    public void testCalendarItemEventListener() throws Throwable {
        // When
        CalendarItemEvent calendarItemEvent = new CalendarItemEvent();
        calendarItemEvent.setEventType(CalendarItemEvent.EVENT_TYPE.CREATED);
        CalendarItem calendarItem = new CalendarItem();
        calendarItem.setId(777L);
        calendarItemEvent.setCalendarItem(calendarItem);

        service.calendarItemEventListener(calendarItemEvent);

    }
}