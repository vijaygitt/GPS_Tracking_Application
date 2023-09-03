package com.GPS_Tracking.Application.services;

import com.GPS_Tracking.Application.payloads.VehicleOwnerMappingDto;

/**
 * Service interface for managing vehicle-to-owner mappings in the GPS Tracking system.
 */
public interface VehicleOwnerMappingService {

    /**
     * Creates a new vehicle-to-owner mapping.
     *
     * @param vehicleOwnerMappingDto The DTO containing the mapping details to be created.
     * @return A VehicleOwnerMappingDto representing the newly created mapping.
     */
    VehicleOwnerMappingDto createVehicleOwnerMapping(VehicleOwnerMappingDto vehicleOwnerMappingDto);

}
