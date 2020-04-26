package com.dmrtech.calendarservice.security;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.core.Authentication;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for JwtUtils
 *
 * @see JwtUtils
 * @author dferguson
 */
public class JwtUtilsTest
{
/**
 * Parasoft Jtest UTA: Test for generateJwtToken(Authentication)
 *
 * @see JwtUtils#generateJwtToken(Authentication)
 * @author dferguson
 */
/* @Test
public void testGenerateJwtToken() throws Throwable
{
    // Given
    JwtUtils underTest = new JwtUtils();

    // When
    Authentication authentication = mock(Authentication.class);
    UserDetailsImpl mockPrincipal = mock(UserDetailsImpl.class);
    Mockito.when(mockPrincipal.getUsername()).thenReturn("bob1990");
    Mockito.when(authentication.getPrincipal()).thenReturn(mockPrincipal);

    String result = underTest.generateJwtToken(authentication);

    // Then
    // assertEquals("", result);
}*/
}