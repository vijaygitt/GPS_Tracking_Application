package com.GPS_Tracking.Application.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * This exception is thrown when an owner is not found in the GPS Tracking system.
 */
@Getter
@Setter
public class OwnerNotFoundException extends RuntimeException{
    private int ownerId;

    /**
     * Constructs a new OwnerNotFoundException with the specified owner ID.
     *
     * @param ownerId The ID of the owner that was not found.
     */
    public OwnerNotFoundException(int ownerId) {
        super(String.format("Owner not found with owner id: %S",ownerId));
        this.ownerId=ownerId;
    }
}
