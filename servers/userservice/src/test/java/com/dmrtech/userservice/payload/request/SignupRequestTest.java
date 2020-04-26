package com.dmrtech.userservice.payload.request;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Parasoft Jtest UTA: Test class for SignupRequest
 *
 * @author dferguson
 * @see SignupRequest
 */
public class SignupRequestTest {
    /**
     * Parasoft Jtest UTA: Test for getEmail()
     *
     * @author dferguson
     * @see SignupRequest#getEmail()
     */
    @Test(timeout = 1000)
    public void testGetEmail() throws Throwable {
        // Given
        SignupRequest underTest = new SignupRequest();
        underTest.setEmail("abc123");

        // When
        String result = underTest.getEmail();

        // Then
        assertEquals("abc123", result);
    }

    /**
     * Parasoft Jtest UTA: Test for getPassword()
     *
     * @author dferguson
     * @see SignupRequest#getPassword()
     */
    @Test(timeout = 1000)
    public void testGetPassword() throws Throwable {
        // Given
        SignupRequest underTest = new SignupRequest();
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
     * @see SignupRequest#getUsername()
     */
    @Test(timeout = 1000)
    public void testGetUsername() throws Throwable {
        // Given
        SignupRequest underTest = new SignupRequest();
        underTest.setUsername("abc123");

        // When
        String result = underTest.getUsername();

        // Then
        assertEquals("abc123", result);
    }


}