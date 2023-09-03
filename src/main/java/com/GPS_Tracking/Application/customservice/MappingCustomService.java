package com.GPS_Tracking.Application.customservice;

import com.GPS_Tracking.Application.entity.Owner;
import com.GPS_Tracking.Application.entity.Vehicle;
import com.GPS_Tracking.Application.payloads.VehicleDto;

import java.util.List;

/**
 * Custom service interface for vehicle owner mapping-related operations.
 */
public interface MappingCustomService {

    /**
     * Retrieves a list of VehicleDto objects associated with a specific Owner.
     *
     * @param owner The Owner entity for which to retrieve vehicles.
     * @return A list of VehicleDto objects associated with the owner.
     */
    List<VehicleDto> getVehiclesByOwner(Owner owner);

    /**
     * Checks if a mapping exists between a specific Vehicle and Owner.
     *
     * @param vehicle The Vehicle entity to check.
     * @param owner   The Owner entity to check.
     * @return True if a mapping exists, otherwise false.
     */
    Boolean checkMapping(Vehicle vehicle, Owner owner);
}
