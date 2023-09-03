package com.GPS_Tracking.Application.repositories;

import com.GPS_Tracking.Application.entity.Gps;
import com.GPS_Tracking.Application.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Repository for managing GPS data records in the GPS Tracking system.
 */
public interface GpsRepo extends JpaRepository<Gps,Long> {

    /**
     * Retrieves a list of GPS data records for a specific vehicle.
     *
     * @param vehicle The vehicle for which GPS data is retrieved.
     * @return A list of GPS data records associated with the specified vehicle.
     */
    List<Gps> findByVehicle(Vehicle vehicle);

    /**
     * Retrieves a list of GPS data records for a specific vehicle within a specified timestamp range.
     *
     * @param vehicle   The vehicle for which GPS data is retrieved.
     * @param startTime The start timestamp of the range.
     * @param endTime   The end timestamp of the range.
     * @return A list of GPS data records associated with the specified vehicle and timestamp range.
     */
    List<Gps> findByVehicleAndTimestampBetween(Vehicle vehicle,Date startTime, Date endTime);
}
