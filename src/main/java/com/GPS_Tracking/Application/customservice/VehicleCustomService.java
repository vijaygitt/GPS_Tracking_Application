package com.GPS_Tracking.Application.customservice;

import com.GPS_Tracking.Application.entity.Vehicle;

/**
 * Custom service interface for Vehicle-related operations.
 */
public interface VehicleCustomService {

    /**
     * Retrieves a Vehicle entity by its unique identifier.
     *
     * @param vehicleId The ID of the Vehicle to retrieve.
     * @return The Vehicle entity if found, otherwise throws exception.
     */
    Vehicle getVehicle(Integer vehicleId);
}
