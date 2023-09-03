package com.GPS_Tracking.Application.controllers;

import com.GPS_Tracking.Application.payloads.VehicleOwnerMappingDto;
import com.GPS_Tracking.Application.services.VehicleOwnerMappingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Controller class for managing vehicle-owner mapping related endpoints.
 */
@RestController
@RequestMapping("/api/vehicleOwnerMappings")
public class VehicleOwnerMappingController {

    @Autowired
    private VehicleOwnerMappingService vehicleOwnerMappingService;

    /**
     * Creates a new mapping between a vehicle and an owner.
     *
     * @param vehicleOwnerMappingDto The mapping data to be created, provided in the request body.
     * @return A ResponseEntity containing the created VehicleOwnerMappingDto and HttpStatus.CREATED.
     */
    @PostMapping("/")
    public ResponseEntity<VehicleOwnerMappingDto> createMapping(@Valid @RequestBody VehicleOwnerMappingDto vehicleOwnerMappingDto) {
        // Create a new mapping between a vehicle and an owner
        VehicleOwnerMappingDto createdVehicleOwnerMappingDto = this.vehicleOwnerMappingService.createVehicleOwnerMapping(vehicleOwnerMappingDto);

        // Return a ResponseEntity with the created VehicleOwnerMappingDto and HttpStatus.CREATED
        return new ResponseEntity<>(createdVehicleOwnerMappingDto, HttpStatus.CREATED);
    }
}
