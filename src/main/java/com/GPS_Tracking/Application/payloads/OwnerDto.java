package com.GPS_Tracking.Application.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Data Transfer Object (DTO) representing an owner's information.
 * It includes details such as owner name, license number, address, phone number, and email.
 */
@Getter
@Setter
@NoArgsConstructor
public class OwnerDto {

    private int ownerId;

    // Validation constraints for owner name
    @NotEmpty
    @Pattern(regexp="^[a-zA-Z]+", message = "Name can contain alphabets only")
    private String ownerName;

    // Validation constraints for license number
    @Size(min = 16,max=16,message = "License Number must be of 16 characters")
    private String licenseNumber;

    private String address;

    // Validation constraints for phone number
    @Pattern(regexp = "^\\d+", message = "Phone number can contain only digits")
    @Size(min = 10,max = 10,message = "Phone number must be of 10 digits")
    private String phoneNo;

    // Validation constraints for email
    @Email(message = "Invalid email address")
    private String email;
}
