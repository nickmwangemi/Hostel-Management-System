package com.mwangemi.hostelmanagementsystem.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

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

    @Enumerated(EnumType.STRING)
    private Occupancy occupancy;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hostel_id", referencedColumnName = "id")
    private Hostel hostel;


}

