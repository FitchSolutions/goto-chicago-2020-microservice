package com.dmrtech.calendarservice.security;


import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Parasoft Jtest UTA: Test class for AuthTokenFilter
 *
 * @author dferguson
 * @see AuthTokenFilter
 */
public class AuthTokenFilterTest {
    /**
     * Parasoft Jtest UTA: Test for doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)
     *
     * @author dferguson
     * @see AuthTokenFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)
     */
    @Test(timeout = 1000)
    public void testDoFilterInternal() throws Throwable {
        // Given
        AuthTokenFilter underTest = new AuthTokenFilter();
        JwtUtils jwtUtilsValue = mockJwtUtils();
        ReflectionTestUtils.setField(underTest, "jwtUtils", jwtUtilsValue);

        // When
        HttpServletRequest request = mockHttpServletRequest();
        HttpServletResponse response = mockHttpServletResponse();
        FilterChain filterChain = mock(FilterChain.class);
        underTest.doFilterInternal(request, response, filterChain);

        assertNotNull(response);
        String s = response.getHeader("X");
        assertNotNull(s);
        assertEquals("XYZ",s);
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of JwtUtils
     */
    private static JwtUtils mockJwtUtils() throws Throwable {
        JwtUtils jwtUtilsValue = mock(JwtUtils.class);
        String getUserNameFromJwtTokenResult = ""; // UTA: default value
        when(jwtUtilsValue.getUserNameFromJwtToken(nullable(String.class))).thenReturn(getUserNameFromJwtTokenResult);

        boolean validateJwtTokenResult = false; // UTA: default value
        when(jwtUtilsValue.validateJwtToken(nullable(String.class))).thenReturn(validateJwtTokenResult);
        return jwtUtilsValue;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of HttpServletRequest
     */
    private static HttpServletRequest mockHttpServletRequest() throws Throwable {
        HttpServletRequest request = mock(HttpServletRequest.class);
        String getHeaderResult = ""; // UTA: default value
        when(request.getHeader(nullable(String.class))).thenReturn(getHeaderResult);
        return request;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of HttpServletResponse
     */
    private static HttpServletResponse mockHttpServletResponse() throws Throwable {
        HttpServletResponse response = mock(HttpServletResponse.class);
        String getHeaderResult2 = "XYZ"; // UTA: default value
        when(response.getHeader(nullable(String.class))).thenReturn(getHeaderResult2);
        return response;
    }
}