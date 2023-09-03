package com.GPS_Tracking.Application.services;

import com.GPS_Tracking.Application.payloads.GpsDto;

import java.util.List;

/**
 * Service interface for managing GPS data-related operations in the GPS Tracking system.
 */
public interface GpsService {

    /**
     * Creates a new GPS record for a specific vehicle.
     *
     * @param vehicleId The ID of the vehicle for which GPS data is recorded.
     * @param gpsDto    The GPS data to be created, provided in the request body.
     * @return The DTO of the created GPS data.
     */
    GpsDto createGps(Integer vehicleId, GpsDto gpsDto);

    /**
     * Retrieves a list of GPS data records for a specific vehicle owned by a user.
     *
     * @param ownerId   The ID of the owner/user.
     * @param vehicleId The ID of the vehicle for which GPS data is retrieved.
     * @return A list of GPS data DTOs.
     */
    List<GpsDto> getGpsByVehicle(Integer ownerId, Integer vehicleId);
}
