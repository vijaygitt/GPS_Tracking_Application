package com.GPS_Tracking.Application.customservice.Implementation;

import com.GPS_Tracking.Application.customservice.VehicleCustomService;
import com.GPS_Tracking.Application.entity.Vehicle;
import com.GPS_Tracking.Application.exceptions.VehicleNotFoundException;
import com.GPS_Tracking.Application.repositories.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the custom service interface for vehicle-related operations.
 */
@Service
public class VehicleCustomServiceImpl implements VehicleCustomService {

    @Autowired
    private VehicleRepo vehicleRepo;

    /**
     * Retrieves a vehicle by its unique id.
     *
     * @param vehicleId The unique identifier of the vehicle.
     * @return The Vehicle entity if found, or throws a VehicleNotFoundException if not found.
     * @throws VehicleNotFoundException If the vehicle with the specified ID is not found.
     */
    @Override
    public Vehicle getVehicle(Integer vehicleId) {
        return this.vehicleRepo.findById(vehicleId)
                .orElseThrow(() -> new VehicleNotFoundException(vehicleId));
    }
}
