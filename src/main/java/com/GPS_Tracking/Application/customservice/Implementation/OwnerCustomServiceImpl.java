package com.GPS_Tracking.Application.customservice.Implementation;

import com.GPS_Tracking.Application.customservice.OwnerCustomService;
import com.GPS_Tracking.Application.entity.Owner;
import com.GPS_Tracking.Application.exceptions.OwnerNotFoundException;
import com.GPS_Tracking.Application.repositories.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of the custom service interface for owner-related operations.
 */
@Service
public class OwnerCustomServiceImpl implements OwnerCustomService {

    @Autowired
    private OwnerRepo ownerRepo;

    /**
     * Retrieves owner by their id
     *
     * @param ownerId The unique identifier of the owner.
     * @return The Owner entity if found, or throws an OwnerNotFoundException if not found.
     * @throws OwnerNotFoundException If the owner with the specified ID is not found.
     */
    @Override
    public Owner getOwner(Integer ownerId) {

        return this.ownerRepo.findById(ownerId).orElseThrow(() -> new OwnerNotFoundException(ownerId));
    }
}
