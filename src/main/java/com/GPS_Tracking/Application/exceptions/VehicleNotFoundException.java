package com.GPS_Tracking.Application.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * Exception thrown when a vehicle is not found in the GPS Tracking system.
 */
@Getter
@Setter
public class VehicleNotFoundException extends RuntimeException{

    private String resourceName;
    private String field2Name;
    private int fieldValue;
    private int field2Value;

    /**
     * Constructs a new VehicleNotFoundException with the specified vehicle ID.
     *
     * @param fieldValue The ID of the vehicle that was not found.
     */
    public VehicleNotFoundException(int fieldValue) {
        super(String.format("Vehicle not found with the vehicle id: %S",fieldValue));
        this.fieldValue = fieldValue;
    }

    /**
     * Constructs a new VehicleNotFoundException for an owner.
     *
     * @param resourceName String owner for helping construct the message
     * @param field2Name   string owner id for helping construct the message.
     * @param field2Value  The ID of owner/user.
     * @param fieldValue   The ID of the vehicle not found.
     */
    public VehicleNotFoundException(String resourceName,String field2Name,int field2Value, int fieldValue) {
        super(String.format("%S with %S :%S does not have vehicle with vehicle id:%s",resourceName,field2Name,field2Value,fieldValue));
        this.fieldValue = fieldValue;
        this.resourceName=resourceName;
        this.field2Name=field2Name;
        this.field2Value=field2Value;
    }

}
