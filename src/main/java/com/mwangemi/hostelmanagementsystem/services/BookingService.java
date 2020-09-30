package com.mwangemi.hostelmanagementsystem.services;

import com.mwangemi.hostelmanagementsystem.models.Booking;
import com.mwangemi.hostelmanagementsystem.models.GenericResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@Transactional
public interface BookingService {
    GenericResponse save(Booking booking) throws IOException;

    GenericResponse listAll();

    GenericResponse get(Long id);

    GenericResponse update(Long id, Booking booking);

    GenericResponse deleteById(Long id);

}
