package com.dmrtech.calendarservice.security;


import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Parasoft Jtest UTA: Test class for UserDetailsLight
 *
 * @author dferguson
 * @see UserDetailsLight
 */
public class UserDetailsLightTest {
    /**
     * Parasoft Jtest UTA: Test for getAuthorities()
     *
     * @author dferguson
     * @see UserDetailsLight#getAuthorities()
     */
    @Test(timeout = 1000)
    public void testGetAuthorities() throws Throwable {
        // Given
        String username = ""; // UTA: default value
        UserDetailsLight underTest = new UserDetailsLight(username);

        // When
        Collection<? extends GrantedAuthority> result = underTest.getAuthorities();

        // Then
        assertNotNull(result);
        Object[] o = result.toArray();
        SimpleGrantedAuthority sga = (SimpleGrantedAuthority) o[0];
        assertEquals(1, result.size());
        assertEquals("USER", sga.getAuthority());
    }

    /**
     * Parasoft Jtest UTA: Test for getPassword()
     *
     * @author dferguson
     * @see UserDetailsLight#getPassword()
     */
    @Test(timeout = 1000)
    public void testGetPassword() throws Throwable {
        // Given
        String username = "abc"; // UTA: default value
        UserDetailsLight underTest = new UserDetailsLight(username);

        // When
        String result = underTest.getPassword();

        // Then
        assertEquals("password", result);
    }

    /**
     * Parasoft Jtest UTA: Test for getUsername()
     *
     * @author dferguson
     * @see UserDetailsLight#getUsername()
     */
    @Test(timeout = 1000)
    public void testGetUsername() throws Throwable {
        // Given
        String username = "abc"; // UTA: default value
        UserDetailsLight underTest = new UserDetailsLight(username);

        // When
        String result = underTest.getUsername();

        // Then
        assertEquals("abc", result);
    }

    /**
     * Parasoft Jtest UTA: Test for isAccountNonExpired()
     *
     * @author dferguson
     * @see UserDetailsLight#isAccountNonExpired()
     */
    @Test(timeout = 1000)
    public void testIsAccountNonExpired() throws Throwable {
        // Given
        String username = ""; // UTA: default value
        UserDetailsLight underTest = new UserDetailsLight(username);

        // When
        boolean result = underTest.isAccountNonExpired();

        // Then
        assertTrue(result);
    }

    /**
     * Parasoft Jtest UTA: Test for isAccountNonLocked()
     *
     * @author dferguson
     * @see UserDetailsLight#isAccountNonLocked()
     */
    @Test(timeout = 1000)
    public void testIsAccountNonLocked() throws Throwable {
        // Given
        String username = ""; // UTA: default value
        UserDetailsLight underTest = new UserDetailsLight(username);

        // When
        boolean result = underTest.isAccountNonLocked();

        // Then
        assertTrue(result);
    }

    /**
     * Parasoft Jtest UTA: Test for isCredentialsNonExpired()
     *
     * @author dferguson
     * @see UserDetailsLight#isCredentialsNonExpired()
     */
    @Test(timeout = 1000)
    public void testIsCredentialsNonExpired() throws Throwable {
        // Given
        String username = ""; // UTA: default value
        UserDetailsLight underTest = new UserDetailsLight(username);

        // When
        boolean result = underTest.isCredentialsNonExpired();

        // Then
        assertTrue(result);
    }

    /**
     * Parasoft Jtest UTA: Test for isEnabled()
     *
     * @author dferguson
     * @see UserDetailsLight#isEnabled()
     */
    @Test(timeout = 1000)
    public void testIsEnabled() throws Throwable {
        // Given
        String username = ""; // UTA: default value
        UserDetailsLight underTest = new UserDetailsLight(username);

        // When
        boolean result = underTest.isEnabled();

        // Then
        assertTrue(result);
    }
}