package com.mwangemi.hostelmanagementsystem.services;

import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
import com.mwangemi.hostelmanagementsystem.models.Hostel;
import com.mwangemi.hostelmanagementsystem.models.Room;
import com.mwangemi.hostelmanagementsystem.models.Tenant;
import com.mwangemi.hostelmanagementsystem.repositories.HostelRepository;
import com.mwangemi.hostelmanagementsystem.repositories.RoomRepository;
import com.mwangemi.hostelmanagementsystem.repositories.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;
    private HostelRepository hostelRepository;
    private TenantRepository tenantRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository, HostelRepository hostelRepository, TenantRepository tenantRepository) {
        this.roomRepository = roomRepository;
        this.hostelRepository = hostelRepository;
        this.tenantRepository = tenantRepository;
    }

    @Override
    public GenericResponse save(Room room) {
        Optional<Hostel> hostel = hostelRepository.findById(room.getHostel().getId());
        if (hostel.isPresent()){
            room.setHostel(hostel.get());
            Room roomToSave = roomRepository.save(room);
            return new GenericResponse(200, "Request Successful. Room record created", roomToSave);
        }
        return new GenericResponse(400, "Not Saved");
    }

    @Override
    public GenericResponse listAll() {
        List<Room> roomsList=roomRepository.findAll();
        if (roomsList.size() > 0){
            return new GenericResponse(200,"Request Successful. Fetched rooms.",roomsList);
        }
        return new GenericResponse(400,"No Data Found");
    }

    @Override
    public GenericResponse get(Long id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isPresent())
            return new GenericResponse(200,"Request Successful. Room record fetched.",roomOptional);
        return new GenericResponse(400,"Request Failed! No Room details found or error");
    }

    @Override
    public GenericResponse update(Long id, Room room) {
        Optional<Room> roomToUpdate = roomRepository.findById(id);
        Optional<Hostel> hostel = hostelRepository.findById(room.getHostel().getId());

        if (roomToUpdate.isPresent() ){
            roomToUpdate.get().setRoomType(room.getRoomType());
            roomToUpdate.get().setOccupancy(room.getOccupancy());
            roomToUpdate.get().setHostel(hostel.get());

            Room updated = roomRepository.save(roomToUpdate.get());
            return new GenericResponse(200,"Request Successful. Room record updated",updated);
        }
        return new GenericResponse(400, "Request Failed! Room record not updated");
    }

    @Override
    public GenericResponse deleteById(Long id) {
        Optional<Room> roomToDelete = roomRepository.findById(id);
        if(roomToDelete.isPresent()){
            roomRepository.delete(roomToDelete.get());
            return new GenericResponse(200, "Request Successful. Room record deleted.");
        }
        return new GenericResponse(400, "Request Failed! Room record not deleted.");
    }
}
