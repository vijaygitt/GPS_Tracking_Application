package com.GPS_Tracking.Application.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * Exception thrown when a mapping between a vehicle and an owner is not found in the GPS Tracking system.
 */
@Getter
@Setter
public class VehicleOwnerMappingNotFoundException extends RuntimeException{

    private int fieldValue;

    private int vehicleId;
    private int ownerId;

    /**
     * Constructs a new VehicleOwnerMappingNotFoundException with the specified ID.
     *
     * @param fieldValue The ID of the vehicle and owner mapping that was not found.
     */
    public VehicleOwnerMappingNotFoundException(int fieldValue) {
        super(String.format("Vehicle and Owner mapping not found with ID: %S",fieldValue));
        this.fieldValue = fieldValue;
    }

    /**
     * Constructs a new VehicleOwnerMappingNotFoundException with the specified vehicle and owner IDs.
     *
     * @param vehicleId The ID of the vehicle involved in the mapping.
     * @param ownerId   The ID of the owner involved in the mapping.
     */
    public VehicleOwnerMappingNotFoundException(int vehicleId,int ownerId) {
        super(String.format("Mapping not found with vehicle id : %s and owner id : %s",vehicleId,ownerId));
        this.vehicleId = vehicleId;
        this.ownerId   = ownerId;
    }
}
