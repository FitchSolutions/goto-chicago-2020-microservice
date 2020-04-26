package com.dmrtech.userservice.controllers;

import com.dmrtech.userservice.model.User;
import com.dmrtech.userservice.services.UserService;
import javassist.NotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public User findById(@PathVariable long id) throws NotFoundException {
        return userService.findById(id)
                .orElseThrow(()-> new NotFoundException("Calendar event not found with id: " + id));

    }

    @GetMapping("/")
    @PreAuthorize("hasAuthority('USER')")
    public Iterable<User> all() {
        return userService.findAll();
    }

}
