package com.upstart.springboot_task02.service;

import com.upstart.springboot_task02.dto.UserRequestDto;
import com.upstart.springboot_task02.dto.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private int counter = 1;

    public UserResponseDto createUser(UserRequestDto request) {
        int newId = counter++;
        String replyMessage = "Hello " + request.getName() + ", this API is working perfectly!";

        return new UserResponseDto(newId, request.getName(), request.getEmail(), replyMessage);
    }
}