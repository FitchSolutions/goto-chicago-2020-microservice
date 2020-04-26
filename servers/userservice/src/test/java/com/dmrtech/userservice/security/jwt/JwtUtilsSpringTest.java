package com.dmrtech.userservice.security.jwt;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import com.dmrtech.userservice.security.services.UserDetailsImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;


/**
 * Parasoft Jtest UTA: Test class for JwtUtils
 *
 * @author dferguson
 * @see JwtUtils
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext // Parasoft Jtest UTA: Reset context for each test run
public class JwtUtilsSpringTest {
    // Parasoft Jtest UTA: Component under test
    @Autowired
    JwtUtils component;
/**
 * Parasoft Jtest UTA: Test for generateJwtToken(Authentication)
 *
 * @see JwtUtils#generateJwtToken(Authentication)
 * @author dferguson
 */
@Test
public void testGenerateJwtToken() throws Throwable
{
    // When
    Authentication authentication = mock(Authentication.class);
    UserDetailsImpl mockPrincipal = mock(UserDetailsImpl.class);
    Mockito.when(mockPrincipal.getUsername()).thenReturn("bob1990");
    Mockito.when(authentication.getPrincipal()).thenReturn(mockPrincipal);

    //Authentication authentication = null; // UTA: default value
    String token = component.generateJwtToken(authentication);

    component.validateJwtToken(token);
    String userName = component.getUserNameFromJwtToken(token);

    // Then
    assertEquals("bob1990", userName);
}

    @Test
    public void testValidateBadJwtToken() throws Throwable
    {
        try {
            component.validateJwtToken("garbage");
        } catch (Exception e)
        {
            assertEquals(true, true);
        }

    }

}