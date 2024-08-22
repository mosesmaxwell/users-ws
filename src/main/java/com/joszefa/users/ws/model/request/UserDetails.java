package com.joszefa.users.ws.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDetails {
    @NotBlank(message = "Username cannot be null")
    private String username;
    @NotBlank(message = "Password cannot be null")
    @Size(min = 8, max = 16, message = "Password must be 8 to 16 characters")
    private String password;
    @NotBlank(message = "Firstname cannot be null")
    private String firstName;
    @NotBlank(message = "Lastname cannot be null")
    private String lastName;
    @NotBlank(message = "Email cannot be null")
    @Email
    private String email;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
