package com.GPS_Tracking.Application.customservice;

import com.GPS_Tracking.Application.entity.Owner;

/**
 * Custom service interface for retrieving Owner entities.
 */
public interface OwnerCustomService {

    /**
     * Retrieves an Owner entity by its unique identifier.
     *
     * @param ownerId The ID of the owner to retrieve.
     * @return The Owner entity if found, otherwise throws exception.
     */
    Owner getOwner(Integer ownerId);
}

