package com.GPS_Tracking.Application.controllers;

import com.GPS_Tracking.Application.payloads.GpsDto;
import com.GPS_Tracking.Application.services.GpsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Controller class for managing GPS data related endpoints.
 */
@RestController
@RequestMapping("/api/")
public class GpsController {

    @Autowired
    private GpsService gpsService;

    /**
     * Creates a new GPS record for a specific vehicle.
     *
     * @param gpsDto     The GPS data to be created, provided in the request body.
     * @param vehicleId  The ID of the vehicle for which GPS data is recorded.
     * @return A ResponseEntity containing the created GpsDto and HttpStatus.CREATED.
     */
    @PostMapping("/vehicle/{vehicleId}/gps")
    public ResponseEntity<GpsDto> createGps(@Valid @RequestBody GpsDto gpsDto, @PathVariable Integer vehicleId) {
        // Create a new GPS record for the specified vehicle
        GpsDto createdGpsDto = this.gpsService.createGps(vehicleId, gpsDto);

        // Return a ResponseEntity with the created GpsDto and HttpStatus.CREATED
        return new ResponseEntity<>(createdGpsDto, HttpStatus.CREATED);
    }

    /**
     * Retrieves a list of GPS data records for a specific vehicle owned by a user.
     *
     * @param ownerId    The ID of the owner/user.
     * @param vehicleId  The ID of the vehicle for which GPS data is retrieved.
     * @return A ResponseEntity containing a list of GpsDto objects and HttpStatus.OK.
     */
    @GetMapping("/owner/{ownerId}/vehicle/{vehicleId}/gps")
    public ResponseEntity<List<GpsDto>> getGpsByVehicle(@PathVariable Integer ownerId, @PathVariable Integer vehicleId) {

        // Retrieves a list of GPS data records for the specified vehicle
        List<GpsDto> gpsDtoListByVehicle = this.gpsService.getGpsByVehicle(ownerId, vehicleId);

        // Returns a ResponseEntity with the list of GpsDto objects and HttpStatus.OK
        return new ResponseEntity<>(gpsDtoListByVehicle, HttpStatus.OK);
    }
}
