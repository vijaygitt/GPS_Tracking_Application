package com.GPS_Tracking.Application.payloads;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

/**
 * Data Transfer Object (DTO) representing a vehicle's information.
 * It includes details such as vehicle registration number, model, purchase date, and insurance expiration date.
 */
@Getter
@Setter
@NoArgsConstructor
public class VehicleDto {

    private int vehicleId;

    // Validation constraints for registration number
    @Size(min = 10, max = 10, message = "Registration number must be of 10 characters")
    private String regNo;

    private String vehicleModel;

    // Specifies the format of the purchase date in JSON serialization
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date purchaseDate;

    // Specifies the JSON format of the insurance expiration date
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date insuranceExp;

}
