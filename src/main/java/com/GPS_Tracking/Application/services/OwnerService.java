package com.GPS_Tracking.Application.services;

import com.GPS_Tracking.Application.payloads.OwnerDto;
/**
 * Service interface for managing owner-related operations in the GPS Tracking application.
 * Provides methods to create and retrieve owner information.
 */
public interface OwnerService {

    /**
     * Creates a new owner with the provided information.
     *
     * @param ownerDto The DTO containing owner information to be created.
     * @return The DTO of the created owner.
     */
    OwnerDto createOwner(OwnerDto ownerDto);
}
