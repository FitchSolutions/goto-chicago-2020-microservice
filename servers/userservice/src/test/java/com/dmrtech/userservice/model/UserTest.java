package com.dmrtech.userservice.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Parasoft Jtest UTA: Test class for User
 *
 * @see User
 * @author dferguson
 */
public class UserTest
{
/**
 * Parasoft Jtest UTA: Test for setId(Long)
 *
 * @see User#setId(Long)
 * @author dferguson
 */
@Test
public void testSetId() throws Throwable
{
    // Given
    User underTest = new User();

    // When
    Long id = 0L; // UTA: default value
    underTest.setId(id);
    Long retVal = underTest.getId();
    assertEquals(id, retVal);

}

    /**
     * Parasoft Jtest UTA: Test for setUsername(String)
     *
     * @author dferguson
     * @see User#setUsername(String)
     */
    @Test
    public void testSetUsername() throws Throwable {
        // Given
        User underTest = new User();

        // When
        String username = ""; // UTA: default value
        underTest.setUsername(username);
        String retVal = underTest.getUsername();
        assertEquals(username, retVal);

    }

    /**
     * Parasoft Jtest UTA: Test for setEmail(String)
     *
     * @author dferguson
     * @see User#setEmail(String)
     */
    @Test
    public void testSetEmail() throws Throwable {
        // Given
        User underTest = new User();

        // When
        String email = ""; // UTA: default value
        underTest.setEmail(email);
        String retVal = underTest.getEmail();
        assertEquals(email, retVal);

    }

    /**
     * Parasoft Jtest UTA: Test for setPassword(String)
     *
     * @author dferguson
     * @see User#setPassword(String)
     */
    @Test
    public void testSetPassword() throws Throwable {
        // Given
        User underTest = new User();

        // When
        String password = ""; // UTA: default value
        underTest.setPassword(password);
        String retVal = underTest.getPassword();
        assertEquals(password, retVal);

    }

}