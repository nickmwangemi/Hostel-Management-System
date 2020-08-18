//package com.mwangemi.hostelmanagementsystem.bootstrap;
//
//import com.mwangemi.hostelmanagementsystem.models.*;
//import com.mwangemi.hostelmanagementsystem.repositories.HostelRepository;
//import com.mwangemi.hostelmanagementsystem.repositories.RoomRepository;
//import com.mwangemi.hostelmanagementsystem.repositories.TenantRepository;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//
//
//@Component
//public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
//
//    private HostelRepository hostelRepository;
//    private TenantRepository tenantRepository;
//    private RoomRepository roomRepository;
//
//    public DevBootstrap(HostelRepository hostelRepository, TenantRepository tenantRepository, RoomRepository roomRepository) {
//        this.hostelRepository = hostelRepository;
//        this.tenantRepository = tenantRepository;
//        this.roomRepository = roomRepository;
//    }
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        initData();
//    }
//
//    private void initData(){
//
//        // Jogoo Road
//        Hostel jogooRoad = new Hostel("Jogoo Road", "Jogoo Road", (long) 200,);
//        // Wilsonview
//        Hostel wilsonview = new Hostel("Wilsonview","Langata Road", (long) 250);
//        // Ruaraka
//        Hostel ruaraka = new Hostel("Ruaraka", "Thika Road", (long) 400);
//        // Parklands
//        Hostel parklands = new Hostel("Parklands", "Parklands", (long) 500);
//
//        hostelRepository.save(jogooRoad);
//        hostelRepository.save(wilsonview);
//        hostelRepository.save(ruaraka);
//        hostelRepository.save(parklands);
//
//        // Room 12
//        Room room = new Room();
//        room.setRoomType(RoomType.SINGLE);
//        room.setNumberOfOccupants(1);
//        room.setOccupancy(Occupancy.OCCUPIED);
//        room.setBookingStatus(BookingStatus.APPROVED);
//        room.setHostel(jogooRoad);
//
//        // Room 13
//        Room room13 = new Room();
//        room13.setRoomType(RoomType.DOUBLE);
//        room13.setNumberOfOccupants(2);
//        room13.setOccupancy(Occupancy.OCCUPIED);
//        room13.setBookingStatus(BookingStatus.APPROVED);
//        room13.setHostel(jogooRoad);
//
//        // Room 14
//        Room room14 = new Room();
//        room14.setRoomType(RoomType.SINGLE);
//        room14.setNumberOfOccupants(1);
//        room14.setOccupancy(Occupancy.OCCUPIED);
//        room14.setBookingStatus(BookingStatus.APPROVED);
//        room14.setHostel(jogooRoad);
//
//        roomRepository.save(room);
//        roomRepository.save(room13);
//        roomRepository.save(room14);
//
//        // Tenant 1
//        Tenant tenant = new Tenant();
//        tenant.setFullName("Nick Mwangemi");
//        tenant.setEmail("nick@gmail.com");
//        tenant.setMobileNumber("0987654");
//        tenant.setRoom(room);
//
//
//        // Tenant 2
//        Tenant tenant2 = new Tenant();
//        tenant2.setFullName("John doe");
//        tenant2.setEmail("john@gmail.com");
//        tenant2.setMobileNumber("56789");
//        tenant2.setRoom(room13);
//
//
//        // Tenant 3
//        Tenant tenant3 = new Tenant();
//        tenant3.setFullName("John doe");
//        tenant3.setEmail("john@gmail.com");
//        tenant3.setMobileNumber("123456");
//        tenant3.setRoom(room14);
//
//        tenantRepository.save(tenant);
//        tenantRepository.save(tenant2);
//        tenantRepository.save(tenant3);
//
//
//
//    }
//
//
//}
