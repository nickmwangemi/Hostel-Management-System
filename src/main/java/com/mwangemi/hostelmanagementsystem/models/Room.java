package com.mwangemi.hostelmanagementsystem.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private int numberOfOccupants;

    @Enumerated(EnumType.STRING)
    private Occupancy occupancy;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hostel_id", referencedColumnName = "id")
    private Hostel hostel;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tenant_id", referencedColumnName = "id")
    private Tenant tenant;


}

