package com.dmrtech.calendarservice;


import com.dmrtech.calendarservice.security.AuthTokenFilter;
import org.junit.Test;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


/**
 * Parasoft Jtest UTA: Test class for WebSecurityConfig
 *
 * @author dferguson
 * @see WebSecurityConfig
 */
public class WebSecurityConfigTest {
    /**
     * Parasoft Jtest UTA: Test for authenticationJwtTokenFilter()
     *
     * @author dferguson
     * @see WebSecurityConfig#authenticationJwtTokenFilter()
     */
    @Test(timeout = 1000)
    public void testAuthenticationJwtTokenFilter() throws Throwable {
        // Given
        WebSecurityConfig underTest = new WebSecurityConfig();

        // When
        AuthTokenFilter result = underTest.authenticationJwtTokenFilter();

        // Then
        assertNotNull(result);
    }

    /**
     * Parasoft Jtest UTA: Test for configure(AuthenticationManagerBuilder)
     *
     * @author dferguson
     * @see WebSecurityConfig#configure(AuthenticationManagerBuilder)
     */
    @Test(timeout = 1000)
    public void testConfigure() throws Throwable {
        // Given
        WebSecurityConfig underTest = new WebSecurityConfig();

        // When
        AuthenticationManagerBuilder authenticationManagerBuilder = mockAuthenticationManagerBuilder();
        underTest.configure(authenticationManagerBuilder);

    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of AuthenticationManagerBuilder
     */
    private static AuthenticationManagerBuilder mockAuthenticationManagerBuilder() throws Throwable {
        AuthenticationManagerBuilder authenticationManagerBuilder = mock(AuthenticationManagerBuilder.class);
        DaoAuthenticationConfigurer userDetailsServiceResult = mock(DaoAuthenticationConfigurer.class);
        doReturn(userDetailsServiceResult).when(authenticationManagerBuilder).userDetailsService((UserDetailsService) any());
        return authenticationManagerBuilder;
    }

    /**
     * Parasoft Jtest UTA: Test for configure(HttpSecurity)
     *
     * @author dferguson
     * @see WebSecurityConfig#configure(HttpSecurity)
     */
    @Test(timeout = 1000)
    public void testConfigure2() throws Throwable {
        // Given
        WebSecurityConfig underTest = new WebSecurityConfig();

        // When
        ObjectPostProcessor<Object> objectPostProcessor = mock(ObjectPostProcessor.class);
        AuthenticationManagerBuilder authenticationBuilder = mock(AuthenticationManagerBuilder.class);
        Map<Class<?>, Object> sharedObjects = new HashMap<Class<?>, Object>(); // UTA: default value
        HttpSecurity http = new HttpSecurity(objectPostProcessor, authenticationBuilder, sharedObjects);
        underTest.configure(http);

    }

    /**
     * Parasoft Jtest UTA: Test for passwordEncoder()
     *
     * @author dferguson
     * @see WebSecurityConfig#passwordEncoder()
     */
    @Test(timeout = 1000)
    public void testPasswordEncoder() throws Throwable {
        // Given
        WebSecurityConfig underTest = new WebSecurityConfig();

        // When
        PasswordEncoder result = underTest.passwordEncoder();

        // Then
        assertNotNull(result);
    }
}