package com.dmrtech.userservice.security.services;

import com.dmrtech.userservice.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class UserDetailsImplTest {

    UserDetailsImpl classUnderTest;

    @BeforeEach
    void beforeEach() {
        classUnderTest = new UserDetailsImpl(123L, "my_username", "email@test.com", "password");
    }

    @Test
    void build() {
        UserDetailsImpl testObject = UserDetailsImpl.build(new User(
                "test_user",
                "email@testing.com",
                "test_password"));
        assertThat(testObject.getUsername(), is(equalTo("test_user")));
        assertThat(testObject.getEmail(), is(equalTo("email@testing.com")));
        assertThat(testObject.getPassword(), is(equalTo("test_password")));
    }

    @Test
    void getAuthoritiesShouldAlwaysEqualUser() {
        assertThat(classUnderTest.getAuthorities().iterator().next().getAuthority(), is(equalTo("USER")));
    }

    @Test
    void getId() {
        assertThat(classUnderTest.getId(),is(equalTo(123L)));
    }

    @Test
    void getEmail() {
        assertThat(classUnderTest.getEmail(),is(equalTo("email@test.com")));
    }

    @Test
    void getPassword() {
        assertThat(classUnderTest.getPassword(),is(equalTo("password")));
    }

    @Test
    void getUsername() {
        assertThat(classUnderTest.getUsername(),is(equalTo("my_username")));
    }

    @Test
    void isAccountNonExpired() {
        assertThat(classUnderTest.isAccountNonExpired(),is(equalTo(true)));
    }

    @Test
    void isAccountNonLocked() {
        assertThat(classUnderTest.isAccountNonLocked(),is(equalTo(true)));
    }

    @Test
    void isCredentialsNonExpired() {
        assertThat(classUnderTest.isCredentialsNonExpired(),is(equalTo(true)));
    }

    @Test
    void isEnabled() {
        assertThat(classUnderTest.isEnabled(),is(equalTo(true)));
    }

    @Test
    void testEqualsShouldBeEqualWhenSameParamsCreateSecondObject() {
        UserDetailsImpl secondInstance = new UserDetailsImpl(123L, "my_username", "email@test.com", "password");
        assertThat(classUnderTest.equals(secondInstance), is(true));
    }

    @Test
    void testEqualsShouldNotBeEqualWhenIdIsDifferent() {
        UserDetailsImpl secondInstance = new UserDetailsImpl(321L, "my_username", "email@test.com", "password");
        assertThat(classUnderTest.equals(secondInstance), is(false));
    }

    @Test
    void testEqualsIfTheSameObject() {
        assertThat(classUnderTest.equals(classUnderTest), is(true));
    }

    @Test
    void testEqualsHandlingOfNull() {
        assertThat(classUnderTest.equals(null), is(false));
    }
}