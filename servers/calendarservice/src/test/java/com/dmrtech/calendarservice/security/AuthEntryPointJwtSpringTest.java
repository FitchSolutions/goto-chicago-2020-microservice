package com.dmrtech.calendarservice.security;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Parasoft Jtest UTA: Test class for AuthEntryPointJwt
 *
 * @author dferguson
 * @see AuthEntryPointJwt
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext // Parasoft Jtest UTA: Reset context for each test run
public class AuthEntryPointJwtSpringTest {
    // Parasoft Jtest UTA: Component under test
    @Autowired
    AuthEntryPointJwt component;

    /**
     * Parasoft Jtest UTA: Test for commence(HttpServletRequest, HttpServletResponse, AuthenticationException)
     *
     * @author dferguson
     * @see AuthEntryPointJwt#commence(HttpServletRequest, HttpServletResponse, AuthenticationException)
     */
    @Test(timeout = 1000)
    public void testCommence() throws Throwable {
        // When
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        AuthenticationException authException = mockAuthenticationException();
        component.commence(request, response, authException);

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of AuthenticationException
     */
    private static AuthenticationException mockAuthenticationException() throws Throwable {
        AuthenticationException authException = mock(AuthenticationException.class);
        String getMessageResult = ""; // UTA: default value
        when(authException.getMessage()).thenReturn(getMessageResult);
        return authException;
    }
}