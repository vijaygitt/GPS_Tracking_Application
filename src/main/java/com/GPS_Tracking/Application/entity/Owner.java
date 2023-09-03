package com.GPS_Tracking.Application.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an owner in the GPS tracking system.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ownerId;

    @Column(name = "owner_name", nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String licenseNumber;

    private String address;

    private String phoneNo;

    private String email;

    @OneToMany(mappedBy = "owner")
    List<VehicleOwnerMapping> ownedVehicles=new ArrayList<>();


}
