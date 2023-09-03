package com.GPS_Tracking.Application.customservice;

import com.GPS_Tracking.Application.entity.Vehicle;
import com.GPS_Tracking.Application.payloads.GpsDto;

import java.util.Date;
import java.util.List;

/**
 * Custom service interface for GPS-related operations.
 */
public interface GpsCustomService {

    /**
     * Retrieves a list of GpsDto objects for a specific Vehicle within a specified timestamp range.
     *
     * @param vehicle   The Vehicle entity for which GPS data is retrieved.
     * @param startTime The start timestamp for the data retrieval range.
     * @param endTime   The end timestamp for the data retrieval range.
     * @return A list of GpsDto objects for the specified Vehicle and timestamp range.
     */
    List<GpsDto> getGpsByVehicleAndTimestampBetween(Vehicle vehicle, Date startTime, Date endTime);
}

