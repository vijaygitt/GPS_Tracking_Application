package com.GPS_Tracking.Application.services.Implementation;

import com.GPS_Tracking.Application.customservice.MappingCustomService;
import com.GPS_Tracking.Application.customservice.OwnerCustomService;
import com.GPS_Tracking.Application.entity.Owner;
import com.GPS_Tracking.Application.entity.Vehicle;
import com.GPS_Tracking.Application.exceptions.VehicleNotFoundException;
import com.GPS_Tracking.Application.exceptions.VehicleOwnerMappingNotFoundException;
import com.GPS_Tracking.Application.payloads.VehicleDto;
import com.GPS_Tracking.Application.repositories.VehicleRepo;
import com.GPS_Tracking.Application.services.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing vehicle-related operations in the GPS Tracking system.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OwnerCustomService ownerCustomService;

    @Autowired
    private MappingCustomService mappingCustomService;

    /**
     * Creates a new vehicle record based on the provided vehicle DTO.
     *
     * @param vehicleDto The vehicle DTO containing vehicle information.
     * @return The DTO of the created vehicle.
     */
    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {

        // Map the DTO to vehicle entity and save it to the repository
        Vehicle vehicle=this.modelMapper.map(vehicleDto,Vehicle.class);
        this.vehicleRepo.save(vehicle);

        // Map the saved entity back to a DTO and return it
        return this.modelMapper.map(vehicle, VehicleDto.class);
    }

    /**
     * Retrieves a list of vehicle DTOs owned by a specific owner.
     *
     * @param ownerId The ID of the owner.
     * @return A list of vehicle DTOs.
     */
    @Override
    public List<VehicleDto> getAllVehiclesByOwner(Integer ownerId) {
        //Gets the owner by ID
        Owner owner =this.ownerCustomService.getOwner(ownerId);

        // Retrieve vehicles owned by the owner and map them to DTOs
        return this.mappingCustomService.getVehiclesByOwner(owner);
    }

    /**
     * Retrieves a specific vehicle DTO owned by a specific owner.
     *
     * @param ownerId   The ID of the owner.
     * @param vehicleId The ID of the vehicle.
     * @return The DTO of the requested vehicle.
     * @throws VehicleNotFoundException if the vehicle with the given ID is not found.
     * @throws VehicleOwnerMappingNotFoundException if there is no mapping between the owner and the vehicle.
     */
    @Override
    public VehicleDto getVehicleByOwner(Integer ownerId, Integer vehicleId) {
        // Gets the owner by ID
        Owner owner =this.ownerCustomService.getOwner(ownerId);
        // Retrieves the vehicle by ID
        Vehicle vehicle=this.vehicleRepo.findById(vehicleId)
                .orElseThrow(()->new VehicleNotFoundException(vehicleId));

        // Checks if there is a mapping between the owner and the vehicle
        if(this.mappingCustomService.checkMapping(vehicle,owner)){
            return this.modelMapper.map(vehicle,VehicleDto.class);
        }
        // Throws an exception if there is no mapping
        else{
            throw new VehicleOwnerMappingNotFoundException(vehicleId,ownerId);
        }
    }

}
