package com.fitness.service.impl;

import com.fitness.dto.request.UserRequest;
import com.fitness.dto.response.UserResponse;
import com.fitness.exception.ResourceAlreadyExistException;
import com.fitness.exception.ResourceNotFoundException;
import com.fitness.model.User;
import com.fitness.repository.UserRepository;
import com.fitness.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    @Override
    public UserResponse register(UserRequest userRequest) {

        if(userRepository.existsByEmail(userRequest.getEmail()))
            throw new ResourceAlreadyExistException("user already Exist with this email: "+ userRequest.getEmail());

        User user = modelMapper.map(userRequest,User.class);
        User savedUser = userRepository.save(user);

        return modelMapper.map(savedUser,UserResponse.class);
    }

    @Override
    public UserResponse getUserDetails(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("there is no user with this id: "+userId));
        return modelMapper.map(user,UserResponse.class);
    }

    @Override
    public boolean validateUser(String userId) {
        return userRepository.existsById(userId);
    }
}
