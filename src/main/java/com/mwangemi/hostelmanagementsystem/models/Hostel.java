package com.mwangemi.hostelmanagementsystem.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hostels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hostel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String name;
    private String location;
    private Long numberOfRooms;

//    @OneToMany(mappedBy = "hostels",cascade = CascadeType.ALL)
//    private List<Room> roomList = new ArrayList<>();


}
