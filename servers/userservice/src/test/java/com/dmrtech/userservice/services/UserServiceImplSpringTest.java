package com.dmrtech.userservice.services;


import com.dmrtech.userservice.model.User;
import com.dmrtech.userservice.repository.UserRepository;
import com.dmrtech.userservice.services.UserService.UserCreationStatus;
import org.assertj.core.util.IterableUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

import static java.time.Duration.ofMillis;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.*;


/**
 * Parasoft Jtest UTA: Test class for UserServiceImpl
 *
 * @author mjones
 * @see UserServiceImpl
 */
@DirtiesContext // Parasoft Jtest UTA: Reset context for each test run
public class UserServiceImplSpringTest {

    // Parasoft Jtest UTA: Dependency generated for autowired field "userRepository" in UserServiceImpl
    @MockBean
    UserRepository userRepository;

    /**
     * Parasoft Jtest UTA: Test for findById(long)
     *
     * @author mjones
     * @see UserServiceImpl#findById(long)
     */
    @Test
    public void testFindByIdFindsCorrectObject() throws Throwable {
        assertTimeoutPreemptively(ofMillis(1000), () -> {
            // Given
            UserServiceImpl underTest = new UserServiceImpl();
            UserRepository userRepositoryValue = mockUserRepository();
            ReflectionTestUtils.setField(underTest, "userRepository", userRepositoryValue);

            // When
            long idExistsInMock = 1L;
            Optional<User> result = underTest.findById(idExistsInMock);

            // Then
            assertThat(result.isPresent(), is(equalTo(true)));
        });
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of UserRepository
     */
    private static UserRepository mockUserRepository() throws Throwable {
        UserRepository userRepositoryValue = mock(UserRepository.class);
        User user = mockUser();
        Optional<User> findByIdResult = Optional.of(user);
        doReturn(findByIdResult).when(userRepositoryValue).findById(nullable(Long.class));
        return userRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Test for createUser(User)
     *
     * @author mjones
     * @see UserServiceImpl#createUser(User)
     */
    @ParameterizedTest
    @MethodSource("testCreateUser_Parameters")
    public void testCreateUser(Boolean emailExists, Boolean usernameExists, UserCreationStatus expectedStatus) throws Throwable {
        assertTimeoutPreemptively(ofMillis(1000), () -> {
            // Given
            UserServiceImpl underTest = new UserServiceImpl();

            UserRepository userRepositoryValue = mockUserRepositoryForCreateUser(emailExists, usernameExists);
            ReflectionTestUtils.setField(underTest, "userRepository", userRepositoryValue);

            // When
            User user = mockUser();
            UserCreationStatus result = underTest.createUser(user);

            // Then
            assertThat(result,is(equalTo(expectedStatus)));
        });
    }

    // Parasoft Jtest UTA: Initialize test parameters
    @SuppressWarnings("unused")
    private static Stream<Arguments> testCreateUser_Parameters() throws Throwable {
        // Parasoft Jtest UTA: No automatically parameterizable values are available. Add parameters to the test and provide values in the array below, e.g. 'Arguments.of( 4, "str", null )'
        return Stream.of(
                Arguments.arguments(false,false,UserCreationStatus.USER_CREATED),
                Arguments.arguments(true,false,UserCreationStatus.NOT_CREATED_DUPLICATE_EMAIL),
                Arguments.arguments(false,true,UserCreationStatus.NOT_CREATED_DUPLICATE_USERNAME)
        );
    }


    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of UserRepository
     * @param existsByEmailResult
     * @param existsByUsernameResult
     */
    private static UserRepository mockUserRepositoryForCreateUser(Boolean existsByEmailResult, Boolean existsByUsernameResult) throws Throwable {
        UserRepository userRepositoryValue = mock(UserRepository.class);
        when(userRepositoryValue.existsByEmail(nullable(String.class))).thenReturn(existsByEmailResult);
        when(userRepositoryValue.existsByUsername(nullable(String.class))).thenReturn(existsByUsernameResult);
        User user = mockUser();
        doReturn(user).when(userRepositoryValue).save(any());

        return userRepositoryValue;
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of User
     */
    private static User mockUser() throws Throwable {
        User user = mock(User.class);
        String getEmailResult = "testuser1@user.com"; // UTA: default value
        when(user.getEmail()).thenReturn(getEmailResult);

        String getUsernameResult = "testuser1"; // UTA: default value
        when(user.getUsername()).thenReturn(getUsernameResult);

        when(user.getId()).thenReturn(1L);

        return user;
    }

    /**
     * Parasoft Jtest UTA: Test for findAll()
     *
     * @author mjones
     * @see UserServiceImpl#findAll()
     */
    @Test
    public void testFindAll() throws Throwable {
        assertTimeoutPreemptively(ofMillis(1000), () -> {
            // Given
            UserServiceImpl underTest = new UserServiceImpl();
            int numUsers = 10;
            UserRepository userRepositoryValue = mockUserRepositoryForFindAll(10);
            ReflectionTestUtils.setField(underTest, "userRepository", userRepositoryValue);

            // When
            Iterable<User> result = underTest.findAll();

            // Then
            assertThat(IterableUtil.sizeOf(result), is(equalTo(numUsers)));
        });
    }

    /**
     * Parasoft Jtest UTA: Helper method to generate and configure mock of UserRepository
     */
    private static UserRepository mockUserRepositoryForFindAll(int numUsers) throws Throwable {
        UserRepository userRepositoryValue = mock(UserRepository.class);
        ArrayList<User> findAllResult = new ArrayList<User>();
        for (int i=0; i<numUsers; i++) {
            findAllResult.add(mockUser());
        }
        doReturn(findAllResult).when(userRepositoryValue).findAll();
        return userRepositoryValue;
    }

}