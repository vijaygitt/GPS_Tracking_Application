package com.GPS_Tracking.Application.repositories;

import com.GPS_Tracking.Application.entity.Owner;
import com.GPS_Tracking.Application.entity.Vehicle;
import com.GPS_Tracking.Application.entity.VehicleOwnerMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repository for managing vehicle-to-owner mapping data in the GPS Tracking system.
 */
public interface VehicleOwnerMappingRepo extends JpaRepository<VehicleOwnerMapping,Integer> {

    /**
     * Retrieves a list of vehicle-to-owner mapping records for a specific owner.
     *
     * @param owner The owner for whom mapping records are retrieved.
     * @return A list of VehicleOwnerMapping entity.
     */
    List<VehicleOwnerMapping> findByOwner(Owner owner);

    /**
     * Checks if a mapping between a vehicle and an owner exists.
     *
     * @param vehicle The vehicle to check.
     * @param owner   The owner to check.
     * @return `true` if the mapping exists, `false` otherwise.
     */
    boolean existsByVehicleAndOwner(Vehicle vehicle,Owner owner);

}
