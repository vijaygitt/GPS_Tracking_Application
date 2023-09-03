package com.GPS_Tracking.Application.services;

import com.GPS_Tracking.Application.payloads.VehicleDto;

import java.util.List;

/**
 * Service interface for managing vehicle-related operations in the GPS Tracking system.
 */
public interface VehicleService {

    /**
     * Creates a new vehicle record based on the provided vehicle DTO.
     *
     * @param vehicleDto The vehicle DTO containing vehicle information.
     * @return The DTO of the created vehicle.
     */
    VehicleDto createVehicle(VehicleDto vehicleDto);

    /**
     * Retrieves a list of vehicle DTOs owned by a specific owner.
     *
     * @param ownerId The ID of the owner.
     * @return A list of vehicle DTOs.
     */
    List<VehicleDto> getAllVehiclesByOwner(Integer ownerId);

    /**
     * Retrieves a specific vehicle DTO owned by a specific owner.
     *
     * @param ownerId   The ID of the owner.
     * @param vehicleId The ID of the vehicle.
     * @return The DTO of the requested vehicle.
     */
    VehicleDto getVehicleByOwner(Integer ownerId, Integer vehicleId);
}
