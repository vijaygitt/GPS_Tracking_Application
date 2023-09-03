package com.GPS_Tracking.Application.services.Implementation;

import com.GPS_Tracking.Application.entity.Owner;
import com.GPS_Tracking.Application.payloads.OwnerDto;
import com.GPS_Tracking.Application.repositories.OwnerRepo;
import com.GPS_Tracking.Application.services.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service responsible for managing owner-related operations.
 */
@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepo ownerRepo;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Creates a new owner with the provided information.
     *
     * @param ownerDto The DTO containing owner information.
     * @return The DTO of the created owner.
     */
    @Override
    public OwnerDto createOwner(OwnerDto ownerDto) {
        Owner owner=this.modelMapper.map(ownerDto,Owner.class);
        this.ownerRepo.save(owner);
        return this.modelMapper.map(owner,OwnerDto.class);
    }

}
