package com.dmrtech.userservice.controllers;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.dmrtech.userservice.model.User;
import com.dmrtech.userservice.security.jwt.JwtUtils;
import com.dmrtech.userservice.security.services.UserDetailsImpl;
import com.dmrtech.userservice.services.UserService;
import com.dmrtech.userservice.services.UserService.UserCreationStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


/**
 * Parasoft Jtest UTA: Test class for AuthController
 *
 * @author dferguson
 * @see AuthController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext // Parasoft Jtest UTA: Reset context for each test run
public class AuthControllerSpringTest {
    // Parasoft Jtest UTA: Component under test
    @Autowired
    AuthController restcontroller;

    // Parasoft Jtest UTA: Spring MVC test support class
    @Autowired
    MockMvc mockMvc;

    // Parasoft Jtest UTA: Dependency generated for autowired field "authenticationManager" in AuthController
    @MockBean
    AuthenticationManager authenticationManager;

    // Parasoft Jtest UTA: Dependency generated for autowired field "encoder" in AuthController
    @MockBean
    PasswordEncoder passwordEncoder;

    // Parasoft Jtest UTA: Dependency generated for autowired field "jwtUtils" in AuthController
    @MockBean
    JwtUtils jwtUtils;

    // Parasoft Jtest UTA: Dependency generated for autowired field "userService" in AuthController
    @MockBean
    UserService userService;

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of Authentication
     */
    private static Authentication mockAuthentication() throws Throwable {
        Authentication authenticateResult = mock(Authentication.class);
        UserDetailsImpl getPrincipalResult = mock(UserDetailsImpl.class);
        when(authenticateResult.getPrincipal()).thenReturn(getPrincipalResult);
        return authenticateResult;
    }

    /**
     * Parasoft Jtest UTA: Helper method to configure mock of AuthenticationManager
     */
    private void setupAuthenticationManager() throws Throwable {
        Authentication authenticateResult = mockAuthentication();
        when(authenticationManager.authenticate(nullable(Authentication.class))).thenReturn(authenticateResult);
    }

    /**
     * Parasoft Jtest UTA: Helper method to configure mock of JwtUtils
     */
    private void setupJwtUtils() throws Throwable {
        String generateJwtTokenResult = ""; // UTA: default value
        when(jwtUtils.generateJwtToken(nullable(Authentication.class))).thenReturn(generateJwtTokenResult);
    }

    /**
     * Parasoft Jtest UTA: Test for registerUser(SignupRequest)
     *
     * @author dferguson
     * @see AuthController#registerUser(SignupRequest)
     */
    @Test(timeout = 1000)
    public void testRegisterUser() throws Throwable {
        // When
        setupPasswordEncoder();
        setupUserService();
        String payload = ""; // UTA: default value
        ResultActions actions = mockMvc.perform(post("/api/auth/signup").content(payload));


        // Then
        // actions.andExpect(status().isOk());
        // actions.andExpect(header().string("", ""));
        // String response = ""; // UTA: Configure the expected response value
        // actions.andExpect(content().string(response));
    }

    /**
     * Parasoft Jtest UTA: Helper method to configure mock of PasswordEncoder
     */
    private void setupPasswordEncoder() throws Throwable {
        String encodeResult = ""; // UTA: default value
        when(passwordEncoder.encode(nullable(CharSequence.class))).thenReturn(encodeResult);
    }

    /**
     * Parasoft Jtest UTA: Helper method to configure mock of UserService
     */
    private void setupUserService() throws Throwable {
        UserCreationStatus createUserResult = UserCreationStatus.NOT_CREATED_DUPLICATE_EMAIL; // UTA: default value
        when(userService.createUser(nullable(User.class))).thenReturn(createUserResult);
    }


}