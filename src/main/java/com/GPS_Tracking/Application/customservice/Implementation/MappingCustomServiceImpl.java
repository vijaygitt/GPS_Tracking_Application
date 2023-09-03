package com.GPS_Tracking.Application.customservice.Implementation;

import com.GPS_Tracking.Application.customservice.MappingCustomService;
import com.GPS_Tracking.Application.entity.Owner;
import com.GPS_Tracking.Application.entity.Vehicle;
import com.GPS_Tracking.Application.entity.VehicleOwnerMapping;
import com.GPS_Tracking.Application.payloads.VehicleDto;
import com.GPS_Tracking.Application.repositories.VehicleOwnerMappingRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the custom service interface for vehicle-owner mapping operations.
 */
@Service
public class MappingCustomServiceImpl implements MappingCustomService {

    @Autowired
    private VehicleOwnerMappingRepo vehicleOwnerMappingRepo;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Retrieves a list of vehicles associated with a specific owner.
     *
     * @param owner The Owner entity for which vehicles are retrieved.
     * @return A list of VehicleDto objects representing vehicles owned by the specified owner.
     */
    @Override
    public List<VehicleDto> getVehiclesByOwner(Owner owner) {
        // Retrieves the list of vehicle-owner mappings for the given owner
        List<VehicleOwnerMapping> listOfMappings = this.vehicleOwnerMappingRepo.findByOwner(owner);

        // Extracts the list of vehicles from the mappings
        List<Vehicle> listOfVehiclesByUser = listOfMappings.stream()
                .map(VehicleOwnerMapping::getVehicle)
                .toList();

        // Maps the retrieved vehicles to VehicleDto objects
        return listOfVehiclesByUser.stream()
                .map(vehicle -> this.modelMapper.map(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

    /**
     * Checks if a mapping exists between a vehicle and an owner.
     *
     * @param vehicle The Vehicle entity.
     * @param owner   The Owner entity.
     * @return `true` if a mapping exists; otherwise, `false`.
     */
    @Override
    public Boolean checkMapping(Vehicle vehicle, Owner owner) {
        return this.vehicleOwnerMappingRepo.existsByVehicleAndOwner(vehicle, owner);
    }
}
