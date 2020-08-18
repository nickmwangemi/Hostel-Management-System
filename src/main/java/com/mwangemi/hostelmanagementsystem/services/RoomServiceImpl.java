package com.mwangemi.hostelmanagementsystem.services;

import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
import com.mwangemi.hostelmanagementsystem.models.Hostel;
import com.mwangemi.hostelmanagementsystem.models.Room;
import com.mwangemi.hostelmanagementsystem.repositories.HostelRepository;
import com.mwangemi.hostelmanagementsystem.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;
    private HostelRepository hostelRepository;

    public RoomServiceImpl(RoomRepository roomRepository, HostelRepository hostelRepository) {
        this.roomRepository = roomRepository;
        this.hostelRepository = hostelRepository;
    }

    @Autowired

    @Override
    public GenericResponse listAll() {
        List<Room> roomsList=roomRepository.findAll();
        if (roomsList.size() > 0){
            return new GenericResponse(200,"Request Successful. Fetched rooms.",roomsList);
        }
        return new GenericResponse(200,"No Data Found");
    }


    @Override
    public GenericResponse save(Room room) {
        System.out.println(room.getHostel().getId());
        Optional<Hostel> hostel = hostelRepository.findById(room.getHostel().getId());
        if (hostel.isPresent()){
            room.setHostel(hostel.get());
            Room roomToSave = roomRepository.save(room);
            return new GenericResponse(200, "Request Successful. Room record created", roomToSave);
        }
        return new GenericResponse(201, "Not Saved");
    }

    @Override
    public GenericResponse get(Long id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (roomOptional.isPresent())
            return new GenericResponse(200,"Request Successful. Room record fetched.",roomOptional);
        return new GenericResponse(201,"Request Failed! No Room details found or error");
    }

    @Override
    public GenericResponse deleteById(Long id) {
        return null;
    }

    @Override
    public GenericResponse update(Long id) {
        Optional<Room> roomToUpdate = roomRepository.findById(id);
        if (roomToUpdate.isPresent()){
            roomRepository.save(roomToUpdate.get());
            return new GenericResponse(200,"Request Successful. Room record updated",roomToUpdate);
        }
        return new GenericResponse(201, "Request Failed! Room record not updated");
    }

}
