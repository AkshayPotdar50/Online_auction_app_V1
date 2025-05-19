package com.example.auction.app.ver1;
import com.example.auction.app.ver1.model.Role;
import com.example.auction.app.ver1.model.User;
import com.example.auction.app.ver1.repository.UserRepository;
import com.example.auction.app.ver1.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    void setUp() {

        user = new User(); // ✅ correct
        user.setId(1L);
        user.setName("Akshay");
        user.setEmail("akshay@mail.com");
        user.setPassword("secret123");
        user.setRole(Role.BUYER);
        user.setProducts(Collections.emptyList());
        user.setBids(Collections.emptyList());
        user.setPayments(Collections.emptyList());
    }

    @Test
    void testCreateUser() {
        when(userRepository.save(any(User.class))).thenReturn(user);

        User saved = userService.createUser(user);

        assertEquals("Akshay", saved.getName());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testGetUserById() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> result = userService.getUserById(1L);

        assertTrue(result.isPresent());
        assertEquals("akshay@mail.com", result.get().getEmail());
    }

    @Test
    void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(List.of(user));

        List<User> users = userService.getAllUsers();

        assertEquals(1, users.size());
        assertEquals("Akshay", users.get(0).getName());
    }

    @Test
    void testUpdateUser() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User updatedUser = new User(1L, "Akshay Updated", "akshay_new@mail.com", "newpass", Role.BUYER,
                Collections.emptyList(), Collections.emptyList(), Collections.emptyList());

        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        User result = userService.updateUser(1L, updatedUser);

        assertEquals("Akshay Updated", result.getName());
    }


    @Test
    void testDeleteUser() {
        userService.deleteUser(1L);
        verify(userRepository, times(1)).deleteById(1L);
    }


}

