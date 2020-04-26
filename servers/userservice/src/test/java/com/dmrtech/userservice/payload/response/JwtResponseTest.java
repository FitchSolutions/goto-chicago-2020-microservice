package com.dmrtech.userservice.payload.response;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Parasoft Jtest UTA: Test class for JwtResponse
 *
 * @author dferguson
 * @see JwtResponse
 */
public class JwtResponseTest {
    /**
     * Parasoft Jtest UTA: Test for getAccessToken()
     *
     * @author dferguson
     * @see JwtResponse#getAccessToken()
     */
    @Test(timeout = 1000)
    public void testGetAccessToken() throws Throwable {
        // Given
        String accessToken = "xxx"; // UTA: default value
        Long id = 0L; // UTA: default value
        String username = "yyy"; // UTA: default value
        String email = "zzz"; // UTA: default value
        JwtResponse underTest = new JwtResponse(accessToken, id, username, email);

        // When
        String result = underTest.getAccessToken();

        // Then
        assertEquals("xxx", result);
    }

    /**
     * Parasoft Jtest UTA: Test for getEmail()
     *
     * @author dferguson
     * @see JwtResponse#getEmail()
     */
    @Test(timeout = 1000)
    public void testGetEmail() throws Throwable {
        // Given
        String accessToken = ""; // UTA: default value
        Long id = 0L; // UTA: default value
        String username = ""; // UTA: default value
        String email = "xxx"; // UTA: default value
        JwtResponse underTest = new JwtResponse(accessToken, id, username, email);

        // When
        String result = underTest.getEmail();

        // Then
        assertEquals("xxx", result);
    }

    /**
     * Parasoft Jtest UTA: Test for getId()
     *
     * @author dferguson
     * @see JwtResponse#getId()
     */
    @Test(timeout = 1000)
    public void testGetId() throws Throwable {
        // Given
        String accessToken = ""; // UTA: default value
        Long id = 55L; // UTA: default value
        String username = ""; // UTA: default value
        String email = ""; // UTA: default value
        JwtResponse underTest = new JwtResponse(accessToken, id, username, email);

        // When
        Long result = underTest.getId();

        // Then
        assertEquals(55L, result.longValue());
    }

    /**
     * Parasoft Jtest UTA: Test for getTokenType()
     *
     * @author dferguson
     * @see JwtResponse#getTokenType()
     */
    @Test(timeout = 1000)
    public void testGetTokenType() throws Throwable {
        // Given
        String accessToken = ""; // UTA: default value
        Long id = 0L; // UTA: default value
        String username = ""; // UTA: default value
        String email = ""; // UTA: default value
        JwtResponse underTest = new JwtResponse(accessToken, id, username, email);

        // When
        String result = underTest.getTokenType();

        // Then
        assertEquals("Bearer", result);
    }

    /**
     * Parasoft Jtest UTA: Test for getUsername()
     *
     * @author dferguson
     * @see JwtResponse#getUsername()
     */
    @Test(timeout = 1000)
    public void testGetUsername() throws Throwable {
        // Given
        String accessToken = ""; // UTA: default value
        Long id = 0L; // UTA: default value
        String username = "xxx"; // UTA: default value
        String email = ""; // UTA: default value
        JwtResponse underTest = new JwtResponse(accessToken, id, username, email);

        // When
        String result = underTest.getUsername();

        // Then
        assertEquals("xxx", result);
    }

}