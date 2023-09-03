package com.GPS_Tracking.Application.controllers;

import com.GPS_Tracking.Application.payloads.ApiResponse;
import com.GPS_Tracking.Application.services.DistanceTravelledCalculationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Controller class for calculating the distance traveled by a vehicle owned by a user.
 */
@RestController
@RequestMapping("/api/")
public class DistanceTravelledCalculationController {

    @Autowired
    private DistanceTravelledCalculationService distanceTravelledCalculationService;

    /**
     * Retrieves the distance traveled by a specific vehicle within a given time range.
     *
     * @param ownerId   The ID of the vehicle owner.
     * @param vehicleId The ID of the vehicle.
     * @param startTime The start time/date of the range for distance calculation (format: "yyyy-MM-dd").
     * @param endTime   The end time of the range for distance calculation (format: "yyyy-MM-dd").
     * @return A ResponseEntity containing an ApiResponse with information about the distance traveled.
     */
    @GetMapping("/owner/{ownerId}/vehicle/{vehicleId}/distanceTravelled")
    public ResponseEntity<ApiResponse> getDistanceTravelled(@PathVariable Integer ownerId,
                                                            @PathVariable Integer vehicleId,
                                                            @Valid @RequestParam("startTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startTime,
                                                            @Valid @RequestParam("endTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endTime) {
        // Calculates the distance traveled
        double distanceTravelled = this.distanceTravelledCalculationService.getDistanceTravelled(ownerId, vehicleId, startTime, endTime);

        // Creates an ApiResponse with distance and time range information
        ApiResponse apiResponse = new ApiResponse("Owner's vehicle traveled " + distanceTravelled + " km between " + startTime + " and " + endTime, true);

        // Returns a ResponseEntity with HttpStatus.FOUND
        return new ResponseEntity<>(apiResponse, HttpStatus.FOUND);
    }
}
