package com.dmrtech.calendarservice.controllers;


import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


/**
 * Parasoft Jtest UTA: Test class for CalendarItemQueryController
 *
 * @author dferguson
 * @see CalendarItemQueryController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext // Parasoft Jtest UTA: Reset context for each test run
public class CalendarItemQueryControllerSpringTest {
    // Parasoft Jtest UTA: Component under test
    @Autowired
    CalendarItemQueryController restcontroller;

    // Parasoft Jtest UTA: Spring MVC test support class
    @Autowired
    MockMvc mockMvc;

    /**
     * Parasoft Jtest UTA: Test for all()
     *
     * @author dferguson
     * @see CalendarItemQueryController#all()
     */
    @Test(timeout = 1000)
    public void testAll() throws Throwable {
        // When
        ResultActions actions = mockMvc.perform(get("/api/calendaritems/"));


        // Then
        // actions.andExpect(status().isOk());
        // actions.andExpect(header().string("", ""));
    }

    /**
     * Parasoft Jtest UTA: Test for findCalendarEventById(long)
     *
     * @author dferguson
     * @see CalendarItemQueryController#findCalendarEventById(long)
     */
    @Test(timeout = 1000)
    public void testFindCalendarEventById() throws Throwable {
        // When
        long id = 0L; // UTA: Configure an appropriate parameter value since the tested method depends on it
        ResultActions actions = mockMvc.perform(get("/api/calendaritems/" + id));


        // Then
        // actions.andExpect(status().isOk());
        // actions.andExpect(header().string("", ""));
    }
}