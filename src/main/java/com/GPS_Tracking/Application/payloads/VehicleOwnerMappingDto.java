package com.GPS_Tracking.Application.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) representing a mapping between a vehicle and an owner.
 * It includes the mapping ID, vehicle ID, and owner ID.
 */
@Setter
@Getter
@NoArgsConstructor
public class VehicleOwnerMappingDto {

    int mappingId;

    int vehicleId;

    int ownerId;
}
