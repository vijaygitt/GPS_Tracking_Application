package com.GPS_Tracking.Application.services.Implementation;

import com.GPS_Tracking.Application.customservice.OwnerCustomService;
import com.GPS_Tracking.Application.customservice.VehicleCustomService;
import com.GPS_Tracking.Application.entity.Owner;
import com.GPS_Tracking.Application.entity.Vehicle;
import com.GPS_Tracking.Application.entity.VehicleOwnerMapping;
import com.GPS_Tracking.Application.exceptions.VehicleOwnerMappingAlreadyExistsException;
import com.GPS_Tracking.Application.payloads.VehicleOwnerMappingDto;
import com.GPS_Tracking.Application.repositories.VehicleOwnerMappingRepo;
import com.GPS_Tracking.Application.services.VehicleOwnerMappingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for managing vehicle-to-owner mappings in the GPS Tracking system.
 */
@Service
public class VehicleOwnerMappingServiceImpl implements VehicleOwnerMappingService {

    @Autowired
    VehicleOwnerMappingRepo vehicleOwnerMappingRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    OwnerCustomService ownerCustomService;

    @Autowired
    VehicleCustomService vehicleCustomService;

    /**
     * Creates a new vehicle-to-owner mapping if it does not already exist.
     * Throws an exception if the mapping between the specified owner and vehicle already exists.
     *
     * @param vehicleOwnerMappingDto The DTO containing the mapping details to be created.
     * @return A VehicleOwnerMappingDto representing the newly created mapping.
     * @throws VehicleOwnerMappingAlreadyExistsException If the mapping already exists.
     */
    @Override
    public VehicleOwnerMappingDto createVehicleOwnerMapping(VehicleOwnerMappingDto vehicleOwnerMappingDto) {

        int ownerId=vehicleOwnerMappingDto.getOwnerId();
        int vehicleId=vehicleOwnerMappingDto.getVehicleId();
        Owner owner=this.ownerCustomService.getOwner(ownerId);
        Vehicle vehicle=this.vehicleCustomService.getVehicle(vehicleId);
        if(this.vehicleOwnerMappingRepo.existsByVehicleAndOwner(vehicle,owner)){
            throw new VehicleOwnerMappingAlreadyExistsException(vehicleId,ownerId);
        }
        else {
            VehicleOwnerMapping vehicleOwnerMapping = this.modelMapper.map(vehicleOwnerMappingDto, VehicleOwnerMapping.class);
            vehicleOwnerMapping.setOwner(owner);
            vehicleOwnerMapping.setVehicle(vehicle);
            this.vehicleOwnerMappingRepo.save(vehicleOwnerMapping);
            return this.modelMapper.map(vehicleOwnerMapping, VehicleOwnerMappingDto.class);
        }
    }
}
