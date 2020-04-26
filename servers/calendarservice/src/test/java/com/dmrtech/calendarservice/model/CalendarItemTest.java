package com.dmrtech.calendarservice.model;


import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for CalendarItem
 *
 * @author dferguson
 * @see CalendarItem
 */
public class CalendarItemTest {
    /**
     * Parasoft Jtest UTA: Test for getDate()
     *
     * @author dferguson
     * @see CalendarItem#getDate()
     */
    @Test
    public void testGetDate() throws Throwable {
        // Given
        CalendarItem underTest = new CalendarItem();
        Date d = new Date();
        underTest.setDate(d);

        // When
        Date result = underTest.getDate();

        // Then
        assertNotNull(result);
        assertEquals(d, result);
    }

    /**
     * Parasoft Jtest UTA: Test for getID()
     *
     * @author dferguson
     * @see CalendarItem#getID()
     */
    @Test
    public void testGetID() throws Throwable {
        // Given
        CalendarItem underTest = new CalendarItem();
        underTest.setId(444L);

        // When
        long result = underTest.getID();

        // Then
        assertEquals(444L, result);
    }

    /**
     * Parasoft Jtest UTA: Test for getDetails()
     *
     * @author dferguson
     * @see CalendarItem#getDetails()
     */
    @Test(timeout = 1000)
    public void testGetDetails() throws Throwable {
        // Given
        CalendarItem underTest = new CalendarItem();
        underTest.setDetails("test string");

        // When
        String result = underTest.getDetails();

        // Then
        assertEquals("test string", result);
    }

    /**
     * Parasoft Jtest UTA: Test for getTitle()
     *
     * @author dferguson
     * @see CalendarItem#getTitle()
     */
    @Test(timeout = 1000)
    public void testGetTitle() throws Throwable {
        // Given
        CalendarItem underTest = new CalendarItem();
        underTest.setTitle("title");

        // When
        String result = underTest.getTitle();

        // Then
        assertEquals("title", result);
    }

    /**
     * Parasoft Jtest UTA: Test for isAllDayEvent()
     *
     * @author dferguson
     * @see CalendarItem#isAllDayEvent()
     */
    @Test(timeout = 1000)
    public void testIsAllDayEvent() throws Throwable {
        // Given
        CalendarItem underTest = new CalendarItem();
        underTest.setAllDayEvent(true);

        // When
        boolean result = underTest.isAllDayEvent();

        // Then
        assertTrue(result);
    }

}