package com.mwangemi.hostelmanagementsystem.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tenants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tenant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String fullName;
    private String email;
    private String mobileNumber;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "room_id", referencedColumnName = "id")
//    private Room room;
}
