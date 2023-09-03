package com.GPS_Tracking.Application.services;

import java.util.Date;

/**
 * Service interface for calculating the distance traveled by a vehicle in the GPS Tracking application.
 * This service provides methods to calculate the distance traveled by a vehicle between two specified timestamps.
 */
public interface DistanceTravelledCalculationService {

    /**
     * Calculates the distance traveled by a vehicle within a specified time frame.
     *
     * @param ownerId    The unique identifier of the vehicle owner.
     * @param vehicleId  The unique identifier of the vehicle.
     * @param startTime  The starting timestamp for calculating the distance traveled.
     * @param endTime    The ending timestamp for calculating the distance traveled.
     * @return The distance traveled by the vehicle in kilometers.
     */
    double getDistanceTravelled(Integer ownerId, Integer vehicleId, Date startTime, Date endTime);
}
