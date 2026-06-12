package com.fitness.controller;

import com.fitness.dto.request.UserRequest;
import com.fitness.dto.response.UserResponse;
import com.fitness.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody @Valid UserRequest userRequest){

        return new ResponseEntity<UserResponse>(userService.register(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserDetails(@PathVariable @Valid String userId){

        return new ResponseEntity<>(userService.getUserDetails(userId),HttpStatus.OK);
    }

    @GetMapping("/{userId}/validate")
    public ResponseEntity<Boolean> validateUser(@PathVariable String userId) {
        return new ResponseEntity<>(userService.validateUser(userId), HttpStatus.OK);
    }
}
