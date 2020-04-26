package com.dmrtech.calendarservice.model;


import org.junit.Test;

import static org.junit.Assert.assertNotNull;


/**
 * Parasoft Jtest UTA: Test class for CalendarItemEvent
 *
 * @author dferguson
 * @see CalendarItemEvent
 */
public class CalendarItemEventTest {
    /**
     * Parasoft Jtest UTA: Test for getCalendarItem()
     *
     * @author dferguson
     * @see CalendarItemEvent#getCalendarItem()
     */
    @Test
    public void testGetCalendarItem() throws Throwable {
        // Given
        CalendarItemEvent underTest = new CalendarItemEvent();
        CalendarItem ci = new CalendarItem();
        underTest.setCalendarItem(ci);

        // When
        CalendarItem result = underTest.getCalendarItem();

        // Then
        assertNotNull(result);
    }
}