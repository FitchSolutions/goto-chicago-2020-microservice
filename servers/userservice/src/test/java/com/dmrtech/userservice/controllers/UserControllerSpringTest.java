package com.dmrtech.userservice.controllers;


import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


/**
 * Parasoft Jtest UTA: Test class for UserController
 *
 * @author dferguson
 * @see UserController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext // Parasoft Jtest UTA: Reset context for each test run
public class UserControllerSpringTest {
    // Parasoft Jtest UTA: Component under test
    @Autowired
    UserController restcontroller;

    // Parasoft Jtest UTA: Spring MVC test support class
    @Autowired
    MockMvc mockMvc;
/**
 * Parasoft Jtest UTA: Test for findById(long)
 *
 * @see UserController#findById(long)
 * @author dferguson
 */
@Test(timeout=1000)
public void testFindById() throws Throwable
{
    // When
    long id = 0L; // UTA: Configure an appropriate parameter value since the tested method depends on it
    ResultActions actions = mockMvc.perform(get("/api/users/" + id));


    // Then
    // actions.andExpect(status().isOk());
    // actions.andExpect(header().string("", ""));
}
}