package com.GPS_Tracking.Application.repositories;

import com.GPS_Tracking.Application.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for managing owner data in the GPS Tracking system.
 */
public interface OwnerRepo extends JpaRepository<Owner,Integer> {


}
