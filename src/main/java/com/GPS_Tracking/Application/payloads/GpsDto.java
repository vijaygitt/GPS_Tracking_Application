package com.GPS_Tracking.Application.payloads;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Data Transfer Object (DTO) representing GPS location data.
 * It contains information about latitude, longitude, and timestamp.
 */
@Getter
@Setter
@NoArgsConstructor
public class GpsDto {

    private int gpsID;

    // Latitude validation constraints
    @DecimalMin(value="-90.0", message = "Latitude must be between -90 to +90 degrees")
    @DecimalMax(value="90.0", message = "Latitude must be between -90 to +90 degrees")
    private double latitude;

    //longitude validation constraints
    @DecimalMin(value="-180.0", message = "Longitude must be between -180 to +1800 degrees")
    @DecimalMax(value="180.0", message = "Longitude must be between -180 to +180 degrees")
    private double longitude;

    private Date timestamp;

}
