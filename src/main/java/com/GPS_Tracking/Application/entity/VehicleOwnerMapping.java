package com.GPS_Tracking.Application.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a mapping between an owner and a vehicle in the GPS tracking system.
 * Each mapping associates an owner with a specific vehicle they own.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class VehicleOwnerMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mappingId;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}
