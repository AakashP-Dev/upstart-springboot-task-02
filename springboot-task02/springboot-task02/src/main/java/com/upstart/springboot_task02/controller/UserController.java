package com.upstart.springboot_task02.controller;

import com.upstart.springboot_task02.dto.UserRequestDto;
import com.upstart.springboot_task02.dto.UserResponseDto;
import com.upstart.springboot_task02.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public UserResponseDto addUser(@Valid @RequestBody UserRequestDto request) {
        return userService.createUser(request);
    }
}