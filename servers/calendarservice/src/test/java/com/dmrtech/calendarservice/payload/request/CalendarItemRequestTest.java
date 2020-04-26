package com.dmrtech.calendarservice.payload.request;


import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for CalendarItemRequest
 *
 * @author dferguson
 * @see CalendarItemRequest
 */
public class CalendarItemRequestTest {
    /**
     * Parasoft Jtest UTA: Test for getDate()
     *
     * @author dferguson
     * @see CalendarItemRequest#getDate()
     */
    @Test(timeout = 1000)
    public void testGetDate() throws Throwable {
        // Given
        CalendarItemRequest underTest = new CalendarItemRequest();
        Date d = new Date();
        underTest.setDate(d);

        // When
        Date result = underTest.getDate();

        // Then
        assertNotNull(result);
        assertEquals(d, result);
    }

    /**
     * Parasoft Jtest UTA: Test for getDetails()
     *
     * @author dferguson
     * @see CalendarItemRequest#getDetails()
     */
    @Test(timeout = 1000)
    public void testGetDetails() throws Throwable {
        // Given
        CalendarItemRequest underTest = new CalendarItemRequest();
        underTest.setDetails("details");

        // When
        String result = underTest.getDetails();

        // Then
        assertEquals("details", result);
    }

    /**
     * Parasoft Jtest UTA: Test for getId()
     *
     * @author dferguson
     * @see CalendarItemRequest#getId()
     */
    @Test(timeout = 1000)
    public void testGetId() throws Throwable {
        // Given
        CalendarItemRequest underTest = new CalendarItemRequest();
        underTest.setId(555L);

        // When
        long result = underTest.getId();

        // Then
        assertEquals(555L, result);
    }

    /**
     * Parasoft Jtest UTA: Test for getTitle()
     *
     * @author dferguson
     * @see CalendarItemRequest#getTitle()
     */
    @Test(timeout = 1000)
    public void testGetTitle() throws Throwable {
        // Given
        CalendarItemRequest underTest = new CalendarItemRequest();
        underTest.setTitle("xyz");

        // When
        String result = underTest.getTitle();

        // Then
        assertEquals("xyz", result);
    }

    /**
     * Parasoft Jtest UTA: Test for isAllDayEvent()
     *
     * @author dferguson
     * @see CalendarItemRequest#isAllDayEvent()
     */
    @Test(timeout = 1000)
    public void testIsAllDayEvent() throws Throwable {
        // Given
        CalendarItemRequest underTest = new CalendarItemRequest();
        underTest.setAllDayEvent(true);

        // When
        boolean result = underTest.isAllDayEvent();

        // Then
        assertTrue(result);
    }

}