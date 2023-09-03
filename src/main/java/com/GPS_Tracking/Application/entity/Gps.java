package com.GPS_Tracking.Application.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Entity class representing GPS data records.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Gps {

    /**
     * The unique identifier for this GPS record.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gpsId;

    /**
     * The latitude coordinate of the GPS location.
     */
    @Column(nullable = false)
    private double latitude;

    /**
     * The longitude coordinate of the GPS location.
     */
    @Column(nullable = false)
    private double longitude;

    /**
     * The timestamp when this GPS data was recorded.
     */
    private Date timestamp;

    /**
     * The vehicle associated with this GPS record.
     */
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}