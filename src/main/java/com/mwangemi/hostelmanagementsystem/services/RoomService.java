package com.mwangemi.hostelmanagementsystem.services;

import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
import com.mwangemi.hostelmanagementsystem.models.Room;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public interface RoomService {
    GenericResponse listAll();

    GenericResponse save(Room room );

    GenericResponse get(Long id);

    GenericResponse deleteById(Long id);

    GenericResponse update(Long id);
}
