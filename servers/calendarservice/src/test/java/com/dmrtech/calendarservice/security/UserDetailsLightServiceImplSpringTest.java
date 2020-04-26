package com.dmrtech.calendarservice.security;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;


/**
 * Parasoft Jtest UTA: Test class for UserDetailsLightServiceImpl
 *
 * @author dferguson
 * @see UserDetailsLightServiceImpl
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext // Parasoft Jtest UTA: Reset context for each test run
public class UserDetailsLightServiceImplSpringTest {
    // Parasoft Jtest UTA: Component under test
    @Autowired
    UserDetailsLightServiceImpl service;

    /**
     * Parasoft Jtest UTA: Test for loadUserByUsername(String)
     *
     * @author dferguson
     * @see UserDetailsLightServiceImpl#loadUserByUsername(String)
     */
    @Test(timeout = 1000)
    public void testLoadUserByUsername() throws Throwable {
        // When
        String s = ""; // UTA: default value
        UserDetails result = service.loadUserByUsername(s);

        // Then
        // assertNotNull(result);
    }
}