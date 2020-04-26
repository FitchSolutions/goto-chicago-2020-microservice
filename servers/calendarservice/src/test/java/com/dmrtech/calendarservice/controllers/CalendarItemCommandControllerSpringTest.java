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
 * Parasoft Jtest UTA: Test class for CalendarItemCommandController
 *
 * @author dferguson
 * @see CalendarItemCommandController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext // Parasoft Jtest UTA: Reset context for each test run
public class CalendarItemCommandControllerSpringTest {
    // Parasoft Jtest UTA: Component under test
    @Autowired
    CalendarItemCommandController restcontroller;

    // Parasoft Jtest UTA: Spring MVC test support class
    @Autowired
    MockMvc mockMvc;

    /**
     * Parasoft Jtest UTA: Test for calendarItem(CalendarItemRequest)
     *
     * @author dferguson
     * @see CalendarItemCommandController#calendarItem(CalendarItemRequest)
     */
    @Test(timeout = 1000)
    public void testCalendarItem() throws Throwable {
        // When
        String payload = ""; // UTA: default value
        ResultActions actions = mockMvc.perform(post("/api/calendaritems/").content(payload));


        // Then
        // actions.andExpect(status().isOk());
        // actions.andExpect(header().string("", ""));
    }

    /**
     * Parasoft Jtest UTA: Test for delete(Long)
     *
     * @author dferguson
     * @see CalendarItemCommandController#delete(Long)
     */
    @Test(timeout = 1000)
    public void testDelete() throws Throwable {
        // When
        Long id = 0L; // UTA: Configure an appropriate parameter value since the tested method depends on it
        ResultActions actions = mockMvc.perform(delete("/api/calendaritems/" + id));


        // Then
        // actions.andExpect(status().isOk());
        // actions.andExpect(header().string("", ""));
    }

    /**
     * Parasoft Jtest UTA: Test for update(CalendarItemRequest, Long)
     *
     * @author dferguson
     * @see CalendarItemCommandController#update(CalendarItemRequest, Long)
     */
    @Test(timeout = 1000)
    public void testUpdate() throws Throwable {
        // When
        Long id = 0L; // UTA: Configure an appropriate parameter value since the tested method depends on it
        String payload = ""; // UTA: default value
        ResultActions actions = mockMvc.perform(put("/api/calendaritems/" + id).content(payload));


        // Then
        // actions.andExpect(status().isOk());
        // actions.andExpect(header().string("", ""));
    }
}