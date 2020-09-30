package com.mwangemi.hostelmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "allocations")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Allocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Booking booking;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @OneToOne
    private Tenant tenant;
}
