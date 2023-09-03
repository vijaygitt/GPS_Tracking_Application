package com.GPS_Tracking.Application.customservice.Implementation;

import com.GPS_Tracking.Application.customservice.GpsCustomService;
import com.GPS_Tracking.Application.entity.Gps;
import com.GPS_Tracking.Application.entity.Vehicle;
import com.GPS_Tracking.Application.payloads.GpsDto;
import com.GPS_Tracking.Application.repositories.GpsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the custom service interface for GPS-related operations.
 */
@Service
public class GpsCustomServiceImpl implements GpsCustomService {

    @Autowired
    private GpsRepo gpsRepo;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Retrieves a list of GPS data records for a specific vehicle within a given timestamp range.
     *
     * @param vehicle   The Vehicle entity for which GPS data is retrieved.
     * @param startTime The start timestamp for the range.
     * @param endTime   The end timestamp for the range.
     * @return A list of GpsDto objects representing GPS data records within the specified range.
     */
    @Override
    public List<GpsDto> getGpsByVehicleAndTimestampBetween(Vehicle vehicle, Date startTime, Date endTime) {
        // Retrieves GPS records within the specified timestamp range for the given vehicle
        List<Gps> gpsByTimeStamp = this.gpsRepo.findByVehicleAndTimestampBetween(vehicle, startTime, endTime);

        // Maps the retrieved GPS records to GpsDto objects
        return gpsByTimeStamp.stream().map(gps -> this.modelMapper.map(gps, GpsDto.class)).collect(Collectors.toList());
    }
}
