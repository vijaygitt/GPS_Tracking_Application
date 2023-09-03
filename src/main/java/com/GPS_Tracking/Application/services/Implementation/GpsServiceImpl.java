package com.GPS_Tracking.Application.services.Implementation;

import com.GPS_Tracking.Application.customservice.MappingCustomService;
import com.GPS_Tracking.Application.customservice.OwnerCustomService;
import com.GPS_Tracking.Application.customservice.VehicleCustomService;
import com.GPS_Tracking.Application.entity.Gps;
import com.GPS_Tracking.Application.entity.Owner;
import com.GPS_Tracking.Application.entity.Vehicle;
import com.GPS_Tracking.Application.exceptions.VehicleOwnerMappingNotFoundException;
import com.GPS_Tracking.Application.payloads.GpsDto;
import com.GPS_Tracking.Application.repositories.GpsRepo;
import com.GPS_Tracking.Application.services.GpsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing GPS data-related operations in the GPS Tracking system.
 */
@Service
public class GpsServiceImpl implements GpsService {

    @Autowired
    private GpsRepo gpsRepo;

    @Autowired
    private VehicleCustomService vehicleCustomService;

    @Autowired
    private OwnerCustomService ownerCustomService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MappingCustomService mappingCustomService;

    /**
     * Creates a new GPS record for a specific vehicle.
     *
     * @param vehicleId The ID of the vehicle for which the GPS record is created.
     * @param gpsDto    The GPS data to be created, provided in the request.
     * @return A GpsDto representing the newly created GPS record.
     */
    @Override
    public GpsDto createGps(Integer vehicleId, GpsDto gpsDto) {

        // Gets the vehicle and map GPS data to create a new GPS record
        Vehicle vehicle = this.vehicleCustomService.getVehicle(vehicleId);
        Gps gps = this.modelMapper.map(gpsDto, Gps.class);
        gps.setVehicle(vehicle);
        gps.setTimestamp(new Date());

        // Saves the GPS record
        this.gpsRepo.save(gps);

        return this.modelMapper.map(gps, GpsDto.class);
    }

    /**
     * Retrieves a list of GPS data records for a specific vehicle owned by a user.
     *
     * @param ownerId   The ID of the owner/user.
     * @param vehicleId The ID of the vehicle for which GPS data is retrieved.
     * @return A list of GpsDto objects representing the GPS data records.
     * @throws VehicleOwnerMappingNotFoundException If the owner does not have mapping to the specified vehicle.
     */
    @Override
    public List<GpsDto> getGpsByVehicle(Integer ownerId, Integer vehicleId) {

        // Gets the owner and vehicle to check the mapping
        Owner owner = this.ownerCustomService.getOwner(ownerId);
        Vehicle vehicle = this.vehicleCustomService.getVehicle(vehicleId);

        // Checks if the owner has mapping to the vehicle
        if (this.mappingCustomService.checkMapping(vehicle, owner)) {

            List<Gps> listOfGpsDataByVehicle = this.gpsRepo.findByVehicle(vehicle);

            // Maps GPS data to DTOs and return
            return listOfGpsDataByVehicle.stream()
                    .map(gps -> this.modelMapper.map(gps, GpsDto.class))
                    .collect(Collectors.toList());
        } else {
            // If there's no mapping, throws an exception
            throw new VehicleOwnerMappingNotFoundException(vehicleId, ownerId);
        }
    }
}
