package com.GPS_Tracking.Application.services.Implementation;

import com.GPS_Tracking.Application.customservice.GpsCustomService;
import com.GPS_Tracking.Application.customservice.MappingCustomService;
import com.GPS_Tracking.Application.customservice.OwnerCustomService;
import com.GPS_Tracking.Application.customservice.VehicleCustomService;
import com.GPS_Tracking.Application.entity.Owner;
import com.GPS_Tracking.Application.entity.Vehicle;
import com.GPS_Tracking.Application.exceptions.VehicleOwnerMappingNotFoundException;
import com.GPS_Tracking.Application.payloads.GpsDto;
import com.GPS_Tracking.Application.services.DistanceTravelledCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Service responsible for calculating the distance traveled by a vehicle
 * based on its GPS coordinates within a specified time range.
 */
@Service
public class DistanceTravelledCalculationServiceImpl implements DistanceTravelledCalculationService {

    @Autowired
    GpsCustomService gpsCustomService;

    @Autowired
    OwnerCustomService ownerCustomService;

    @Autowired
    VehicleCustomService vehicleCustomService;

    @Autowired
    MappingCustomService mappingCustomService;

    /**
     * Calculates the distance traveled by a vehicle within a specified time range.
     *
     * @param ownerId    The ID of the owner.
     * @param vehicleId  The ID of the vehicle.
     * @param startTime  The start time for calculating distance.
     * @param endTime    The end time for calculating distance.
     * @return The total distance traveled by the vehicle (in kilometers).
     * @throws VehicleOwnerMappingNotFoundException Thrown if the vehicle is not mapped to the owner.
     */
    @Override
    public double getDistanceTravelled(Integer ownerId,Integer vehicleId, Date startTime, Date endTime) {
        Owner owner=this.ownerCustomService.getOwner(ownerId);
        Vehicle vehicle=this.vehicleCustomService.getVehicle(vehicleId);
        if(this.mappingCustomService.checkMapping(vehicle,owner)) {
            List<GpsDto> gpsDtoList = this.gpsCustomService.getGpsByVehicleAndTimestampBetween(vehicle, startTime, endTime);
            double distanceTravelled = 0;
            for (int i = 0; i < gpsDtoList.size() - 1; i++) {
                double lat1 = gpsDtoList.get(i).getLatitude();
                double long1 = gpsDtoList.get(i).getLongitude();
                double lat2 = gpsDtoList.get(i + 1).getLatitude();
                double long2 = gpsDtoList.get(i + 1).getLongitude();

                distanceTravelled += getDistanceBetweenTwoCoordinates(lat1, long1, lat2, long2);
            }
            return distanceTravelled;
        }
        else {
            throw new VehicleOwnerMappingNotFoundException(vehicleId,ownerId);
        }
    }

    /**
     * Calculates the distance (in kilometers) between two sets of GPS coordinates.
     *
     * @param lat1 The latitude of the first coordinate.
     * @param long1 The longitude of the first coordinate.
     * @param lat2 The latitude of the second coordinate.
     * @param long2 The longitude of the second coordinate.
     * @return The distance between the two coordinates in kilometers.
     */
    private double getDistanceBetweenTwoCoordinates(double lat1, double long1, double lat2, double long2) {

        double dLat=Math.toRadians(lat2-lat1);
        double dLong=Math.toRadians(long2-long1);

        double a=Math.sin(dLat/2)*Math.sin(dLat/2)+
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                Math.sin(dLong / 2) * Math.sin(dLong / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double EARTH_RADIUS = 6371;

        return EARTH_RADIUS * c;
    }
}
