package com.fitness.service;

import com.fitness.dto.request.UserRequest;
import com.fitness.dto.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;

public interface UserService {

    UserResponse register(@Valid UserRequest userRequest);

    UserResponse getUserDetails(@Valid String userId);

    boolean validateUser(String userId);
}
