package com.mwangemi.hostelmanagementsystem.services;

import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
import com.mwangemi.hostelmanagementsystem.models.Room;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface RoomService {
    GenericResponse save(Room room);

    GenericResponse listAll();

    GenericResponse get(Long id);

    GenericResponse update(Long id, Room room);

    GenericResponse deleteById(Long id);
}
