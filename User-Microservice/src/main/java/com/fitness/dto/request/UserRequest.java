package com.fitness.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank(message = "email should not be null")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "password should not be null")
    @Size(min=6,message = "Password should be atleast of 6 char")
    private String password;

    @NotBlank(message = "First Name should not be null")
    @Size(min=2,message = "first name should be of atleast 2 char ")
    private String firstName;
    private String lastName;
}
