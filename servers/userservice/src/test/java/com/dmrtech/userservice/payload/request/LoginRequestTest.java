package com.dmrtech.userservice.payload.request;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Parasoft Jtest UTA: Test class for LoginRequest
 *
 * @author dferguson
 * @see LoginRequest
 */
public class LoginRequestTest {
    /**
     * Parasoft Jtest UTA: Test for getPassword()
     *
     * @author dferguson
     * @see LoginRequest#getPassword()
     */
    @Test(timeout = 1000)
    public void testGetPassword() throws Throwable {
        // Given
        LoginRequest underTest = new LoginRequest();
        underTest.setPassword("abc123");

        // When
        String result = underTest.getPassword();

        // Then
        assertEquals("abc123", result);
    }

    /**
     * Parasoft Jtest UTA: Test for getUsername()
     *
     * @author dferguson
     * @see LoginRequest#getUsername()
     */
    @Test(timeout = 1000)
    public void testGetUsername() throws Throwable {
        // Given
        LoginRequest underTest = new LoginRequest();
        underTest.setUsername("abc123");

        // When
        String result = underTest.getUsername();

        // Then
        assertEquals("abc123", result);
    }


}