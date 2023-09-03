package com.GPS_Tracking.Application.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Represents a vehicle in the GPS tracking system.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    @Column(name="Registration_Number", nullable = false, unique = true)
    private String regNo;

    @Column(name="Vehicle_Model", nullable = false)
    private String vehicleModel;

    private Date purchaseDate;

    private Date insuranceExp;

    @OneToMany(mappedBy = "vehicle")
    private List<Gps> listOfGpsLocationData=new ArrayList<>();

    @OneToMany(mappedBy = "vehicle")
    private List<VehicleOwnerMapping> vehicleOwners= new ArrayList<>();

}
