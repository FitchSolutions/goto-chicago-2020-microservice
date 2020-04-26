package com.dmrtech.userservice.payload.response;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Parasoft Jtest UTA: Test class for MessageResponse
 *
 * @author dferguson
 * @see MessageResponse
 */
public class MessageResponseTest {
    /**
     * Parasoft Jtest UTA: Test for getMessage()
     *
     * @author dferguson
     * @see MessageResponse#getMessage()
     */
    @Test(timeout = 1000)
    public void testGetMessage() throws Throwable {
        // Given
        String message = "xxx"; // UTA: default value
        MessageResponse underTest = new MessageResponse(message);

        // When
        String result = underTest.getMessage();

        // Then
        assertEquals("xxx", result);
    }

}