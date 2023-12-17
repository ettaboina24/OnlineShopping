package com.capg.onlineshopping;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.never;

import static org.mockito.Mockito.times;

import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;
 
import java.util.ArrayList;

import java.util.List;
 
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
 
import com.capg.onlineshopping.entity.User;

import com.capg.onlineshopping.exceptions.InvalidEmailException;

import com.capg.onlineshopping.exceptions.InvalidPasswordException;

import com.capg.onlineshopping.exceptions.UserAlreadyExistSException;

import com.capg.onlineshopping.exceptions.UserNotFoundException;

import com.capg.onlineshopping.repository.UserRepository;

import com.capg.onlineshopping.service.UserServiceImpl;
 
public class UserServiceImplTest {

	@InjectMocks

    private UserServiceImpl userService;

    @Mock

    private UserRepository userRepository;

    @BeforeEach

    void setUp() {

        MockitoAnnotations.initMocks(this);

    }

    @Test

    void testAddUser() throws UserAlreadyExistSException, InvalidEmailException, InvalidPasswordException {

        // Mocking user

        User mockUser = new User();

        mockUser.setEmail("test@example.com");

        mockUser.setPassword("Test@123");

        // Mocking repository calls

        when(userRepository.findByEmail("test@example.com")).thenReturn(null);

        when(userRepository.save(mockUser)).thenReturn(mockUser);

        // Actual test

        User resultUser = userService.addUser(mockUser);

        // Assertions

        assertNotNull(resultUser);

        assertEquals("test@example.com", resultUser.getEmail());

        assertEquals("Test@123", resultUser.getPassword());

        verify(userRepository, times(1)).findByEmail("test@example.com");

        verify(userRepository, times(1)).save(mockUser);

    }

    @Test

    void testAddUserWithEmailAlreadyExists() {

        // Mocking user

        User mockUser = new User();

        mockUser.setEmail("test@example.com");

        mockUser.setPassword("Test@123");

        // Mocking repository calls

        when(userRepository.findByEmail("test@example.com")).thenReturn(mockUser);

        // Actual test and assertions

        assertThrows(UserAlreadyExistSException.class, () -> {

            userService.addUser(mockUser);

        });

        verify(userRepository, times(1)).findByEmail("test@example.com");

        verify(userRepository, never()).save(mockUser);

    }

 
 


    @Test

    void testUserLoginWithEmailNotFound() {

        // Mocking repository calls

        when(userRepository.findByEmail("nonexistent@example.com")).thenReturn(null);

        // Actual test and assertions

        assertThrows(InvalidEmailException.class, () -> {

            userService.userLogin("nonexistent@example.com", "Test@123");

        });

        verify(userRepository, times(1)).findByEmail("nonexistent@example.com");

    }

    @Test

    void testUserLoginWithInvalidPassword() {

        // Mocking user

        User mockUser = new User();

        mockUser.setEmail("test@example.com");

        mockUser.setPassword("Test@123");

        // Mocking repository calls

        when(userRepository.findByEmail("test@example.com")).thenReturn(mockUser);

        // Actual test and assertions

        assertThrows(InvalidPasswordException.class, () -> {

            userService.userLogin("test@example.com", "InvalidPassword");

        });

        verify(userRepository, times(1)).findByEmail("test@example.com");

    }

    // Add more test cases for userLogin method as needed

    @Test

    void testFetchUsers() {

        // Mocking user data

        User user1 = new User();

        user1.setUserId(1);

        User user2 = new User();

        user2.setUserId(2);

        List<User> userList = new ArrayList<>();

        userList.add(user1);

        userList.add(user2);

        // Mocking repository calls

        when(userRepository.findAll()).thenReturn(userList);

        // Actual test

        List<User> result = userService.fetchUsers();

        // Assertions

        assertNotNull(result);

        assertEquals(2, result.size());

        verify(userRepository, times(1)).findAll();

    }
 
}
