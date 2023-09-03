package com.GPS_Tracking.Application.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 *Exception thrown when a mapping between an owner and a vehicle already exists in the GPS Tracking system.
 *This is thrown only to check duplicate mapping
 * */
@Getter
@Setter
public class VehicleOwnerMappingAlreadyExistsException extends RuntimeException {
    private int vehicleId;
    private int ownerId;

    /**
     * Constructs a new VehicleOwnerMappingAlreadyExistsException with the specified vehicle and owner IDs.
     *
     * @param vehicleId The ID of the vehicle in the existing mapping.
     * @param ownerId   The ID of the owner in the existing mapping.
     */
    public VehicleOwnerMappingAlreadyExistsException(int vehicleId, int ownerId) {
        super(String.format("Mapping between ownerid : %S and vehicleid : %S already exists",ownerId,vehicleId));
        this.ownerId=ownerId;
        this.vehicleId=vehicleId;
    }
}
