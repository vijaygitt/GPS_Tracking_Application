package com.GPS_Tracking.Application.repositories;

import com.GPS_Tracking.Application.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for managing vehicle data in the GPS Tracking system.
 */
public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {
}
