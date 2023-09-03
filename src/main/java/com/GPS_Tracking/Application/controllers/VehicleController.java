package com.GPS_Tracking.Application.controllers;

import com.GPS_Tracking.Application.payloads.VehicleDto;
import com.GPS_Tracking.Application.services.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Controller class for managing vehicle-related endpoints.
 */
@RestController
@RequestMapping("/api/")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;


    /**
     * Creates a new vehicle record.
     *
     * @param vehicleDto The vehicle data to be created, provided in the request body.
     * @return A ResponseEntity containing the created VehicleDto and HttpStatus.CREATED.
     */
    @PostMapping("/vehicles/")
    public ResponseEntity<VehicleDto> createVehicle(@Valid @RequestBody VehicleDto vehicleDto){
        // Creates a new vehicle record
        VehicleDto createdVehicleDto = this.vehicleService.createVehicle(vehicleDto);

        // Returns a ResponseEntity with the created VehicleDto and HttpStatus.CREATED
        return new ResponseEntity<>(createdVehicleDto, HttpStatus.CREATED);
    }

    /**
     * Retrieves a list of all vehicles owned by a specific owner.
     *
     * @param ownerId The ID of the owner/user.
     * @return A ResponseEntity containing a list of VehicleDto objects and HttpStatus.OK.
     */
    @GetMapping("owner/{ownerId}/vehicles")
    public ResponseEntity<List<VehicleDto>> getAllVehiclesByOwner(@PathVariable Integer ownerId){
        // Retrieves a list of vehicles owned by the specified owner
        List<VehicleDto> vehicleDtoList = this.vehicleService.getAllVehiclesByOwner(ownerId);

        // Returns a ResponseEntity with the list of VehicleDto objects and HttpStatus.OK
        return new ResponseEntity<>(vehicleDtoList,HttpStatus.OK);

    }

    /**
     * Retrieves a specific vehicle owned by an owner.
     *
     * @param ownerId   The ID of the owner/user.
     * @param vehicleId The ID of the vehicle to be retrieved.
     * @return A ResponseEntity containing the requested VehicleDto and HttpStatus.OK.
     */
    @GetMapping("owner/{ownerId}/vehicles/{vehicleId}")
    public ResponseEntity<VehicleDto> getVehicleByOwner(@PathVariable Integer ownerId, @PathVariable Integer vehicleId){
        // Retrieves the specified vehicle owned by the specified owner
        VehicleDto gotVehicleDto = this.vehicleService.getVehicleByOwner(ownerId,vehicleId);

        // Returns a ResponseEntity with the requested VehicleDto and HttpStatus.OK
        return new ResponseEntity<>(gotVehicleDto,HttpStatus.OK);

    }

}