package com.joszefa.users.ws.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateUserDetails {
    @NotBlank(message = "Firstname cannot be null")
    private String firstName;
    @NotBlank(message = "Lastname cannot be null")
    private String lastName;

    public @NotBlank(message = "Firstname cannot be null") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "Firstname cannot be null") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank(message = "Lastname cannot be null") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "Lastname cannot be null") String lastName) {
        this.lastName = lastName;
    }
}
